package com.yxy.www.mtgame2019_20;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class doorFlash extends View {
    public doorFlash(Context context, AttributeSet attrs){
        super(context,attrs);
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                bitmap = Null;
            }
        }

        paint = new Paint();
    }
    private int ScreenHeight;
    float AREA_y_ratio = (float) 1/11.0f;
    int x,y;

    Bitmap dy2 = BitmapFactory.decodeResource(getResources(),R.drawable.door_y2);
    Bitmap dy3 = BitmapFactory.decodeResource(getResources(),R.drawable.door_y3);
    Bitmap dy4 = BitmapFactory.decodeResource(getResources(),R.drawable.door_y4);

    Bitmap db2 = BitmapFactory.decodeResource(getResources(),R.drawable.door_b2);
    Bitmap db3 = BitmapFactory.decodeResource(getResources(),R.drawable.door_b3);
    Bitmap db4 = BitmapFactory.decodeResource(getResources(),R.drawable.door_b4);

    Bitmap dr2 = BitmapFactory.decodeResource(getResources(),R.drawable.door_r2);
    Bitmap dr3 = BitmapFactory.decodeResource(getResources(),R.drawable.door_r3);
    Bitmap dr4 = BitmapFactory.decodeResource(getResources(),R.drawable.door_r4);

    Bitmap de2 = BitmapFactory.decodeResource(getResources(),R.drawable.door_event2);
    Bitmap de3 = BitmapFactory.decodeResource(getResources(),R.drawable.door_event3);
    Bitmap de4 = BitmapFactory.decodeResource(getResources(),R.drawable.door_event4png);

    Bitmap dz2 = BitmapFactory.decodeResource(getResources(),R.drawable.door_zhalan2);
    Bitmap dz3 = BitmapFactory.decodeResource(getResources(),R.drawable.door_zhalan3);
    Bitmap dz4 = BitmapFactory.decodeResource(getResources(),R.drawable.door_zhalan4);

    Bitmap wall1 = BitmapFactory.decodeResource(getResources(),R.drawable.wall2);
    Bitmap wall2 = BitmapFactory.decodeResource(getResources(),R.drawable.wall2_2);
    Bitmap wall3 = BitmapFactory.decodeResource(getResources(),R.drawable.wall2_3);

    Bitmap floor = BitmapFactory.decodeResource(getResources(),R.drawable.floor);
    Bitmap bitmap;

    Bitmap Null = BitmapFactory.decodeResource(getResources(),R.drawable.png);


    private Paint paint;


    public Bitmap getbitmap(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = (float)ScreenHeight/11.0f/(float)width+0.01f;
        float scaleHeight = (float)ScreenHeight/11.0f/(float)height+0.01f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }

    public void setDoorFlash1(int i,int j,String event){
        this.x = i;
        this.y = j;
        switch (event){
            case("dy"):bitmap= dy2;break;
            case("db"):bitmap= db2;break;
            case("dr"):bitmap= dr2;break;
            case("de1"):
            case("de2"):bitmap= de2;break;
            case("dz"):bitmap= dz2;break;
            case("wallE"):bitmap= wall2;break;

        }
    }
    public void setDoorFlash2(int i,int j,String event){
        this.x = i;
        this.y = j;
        switch (event){
            case("dy"):bitmap= dy3;break;
            case("db"):bitmap= db3;break;
            case("dr"):bitmap= dr3;break;
            case("de1"):bitmap= de3;break;
            case("de2"):bitmap= de3;break;
            case("dz"):bitmap= dz3;break;
            case("wallE"):bitmap= wall3;break;

        }
    }
    public void setDoorFlash3(int i,int j,String event){
        this.x = i;
        this.y = j;
        switch (event){
            case("dy"):bitmap= dy4;break;
            case("db"):bitmap= db4;break;
            case("dr"):bitmap= dr4;break;
            case("de1"):bitmap= de4;break;
            case("de2"):bitmap= de4;break;
            case("dz"):bitmap= dz4;break;
            case("wallE"):bitmap= Null;break;

        }
    }
    public void setDoorFlashClose(String event){
        switch (event){
            case("dy"):bitmap= Null;break;
            case("db"):bitmap= Null;break;
            case("dr"):bitmap= Null;break;
            case("de1"):bitmap= Null;break;
            case("de2"):bitmap= Null;break;
            case("dz"):bitmap= Null;break;
            case("wallE"):bitmap= Null;break;

        }
    }
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(getbitmap(bitmap), x * AREA_y_ratio * ScreenHeight, y * AREA_y_ratio * ScreenHeight, paint);
    }
    public void setScreenHeight(int ScreenHeight){
        this.ScreenHeight = ScreenHeight;
    }

}
