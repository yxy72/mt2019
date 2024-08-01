package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.yxy.www.mtgame2019_20.R;

public class BackGround extends View {
    private static float SCREEN_11 = 72;
    private Bitmap background_null = BitmapFactory.decodeResource(getResources(),R.drawable.background);
    private Bitmap background_goldmine = BitmapFactory.decodeResource(getResources(),R.drawable.background_goldmine);
    private Paint paint;


    private boolean isGoldMine;


    public BackGround(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    private static Bitmap getbitmap(Bitmap bitmap,int w,int h){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = w*SCREEN_11/(float)width;
        float scaleHeight = h*SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
        if (isGoldMine)
            canvas.drawBitmap(getbitmap(background_goldmine, 18, 11), 0, 0, paint);
        else
            canvas.drawBitmap(getbitmap(background_null, 18, 11), 0, 0, paint);
    }
    public static void setScreenHeight(int ScreenHeight) {
        BackGround.SCREEN_11 = ScreenHeight/11.0f;
    }

    public void setFloorKind(int x){
        switch (x){
            case (1):isGoldMine = false;break;
            case (2):isGoldMine = true;break;
        }
        invalidate();
    }

//
//    public void setKind(String kind){
//        if(kind.equals("floor")){isCover = false;}
//        else if(kind.equals("cover")){isCover = true;}
//    }

}


