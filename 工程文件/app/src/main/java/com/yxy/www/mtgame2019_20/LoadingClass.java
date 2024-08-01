package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.yxy.www.mtgame2019_20.R;

public class LoadingClass extends View {
    public LoadingClass(Context context, AttributeSet attrs){
        super(context,attrs);


        message[0]= "合理地利用金币做正确的事情才是最重要的。";
        message[1]= "优秀的玩家总能在消耗最少的情况下得到最多的资源。";
        message[2]= "一旦拥有足够金币，去商店提升能力才最划算。";
        message[3]= "通关的最佳路径可不止一条。";
        message[4]= "适当分析一下提升攻击和防御对怪物伤害的影响。";


    }
    private int ScreenHeight;
    private float SCREEN_11 = 72;
    private String[] message = new String[5];
    private Paint paint = new Paint();
    String Message = "";
    Bitmap l0 = BitmapFactory.decodeResource(getResources(),R.drawable.loading0);
    Bitmap l1 = BitmapFactory.decodeResource(getResources(),R.drawable.loading1);
    Bitmap l2 = BitmapFactory.decodeResource(getResources(),R.drawable.loading2);
    Bitmap l3 = BitmapFactory.decodeResource(getResources(),R.drawable.loading3);
    Bitmap l4 = BitmapFactory.decodeResource(getResources(),R.drawable.loading4);
    Bitmap l5 = BitmapFactory.decodeResource(getResources(),R.drawable.loading5);
    Bitmap l6 = BitmapFactory.decodeResource(getResources(),R.drawable.loading6);

    Bitmap Loading = l0;



    public Bitmap getbitmap(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = 8 * SCREEN_11/(float)width;;
        float scaleHeight = 2f * SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
        paint.setTextSize(0.45f*SCREEN_11);
        paint.setColor(Color.WHITE);
        canvas.drawBitmap(getbitmap(Loading),0,0,paint);
        canvas.drawText(Message,  SCREEN_11,2.5f*SCREEN_11, paint);

    }

    public void setScreenHeight(int ScreenHeight){
        this.ScreenHeight = ScreenHeight;SCREEN_11 = ScreenHeight/11.0f;
    }
    public void setLoadingX(int x){
        switch (x){
            case (0):Loading = l0;break;
            case (1):Loading = l1;break;
            case (2):Loading = l2;break;
            case (3):Loading = l3;break;
            case (4):Loading = l4;break;
            case (5):Loading = l5;break;
            case (6):Loading = l6;break;
        }
        invalidate();
    }
    public void setMessage(int x ){
        Message = message[x];invalidate();
    }


}
