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

public class ToolsBag extends View {
    private static float SCREEN_11;
    private Paint paint;
    Bitmap bgd = BitmapFactory.decodeResource(getResources(), R.drawable.tbgd);
    Bitmap gloveno = BitmapFactory.decodeResource(getResources(), R.drawable.gno);
    Bitmap szjno = BitmapFactory.decodeResource(getResources(), R.drawable.sno);
    Bitmap pqgno = BitmapFactory.decodeResource(getResources(), R.drawable.pqgno);
    Bitmap bdhzno = BitmapFactory.decodeResource(getResources(), R.drawable.bdhzno);
    Bitmap kysno = BitmapFactory.decodeResource(getResources(), R.drawable.kysno);
    Bitmap ssno = BitmapFactory.decodeResource(getResources(), R.drawable.ssno);
    Bitmap tlbno = BitmapFactory.decodeResource(getResources(), R.drawable.tlbno);

    Bitmap glove = BitmapFactory.decodeResource(getResources(), R.drawable.glove);
    Bitmap szj = BitmapFactory.decodeResource(getResources(), R.drawable.szj);
    Bitmap pqg = BitmapFactory.decodeResource(getResources(), R.drawable.wall_break);



    private boolean[] own = new boolean[3];
    private Bitmap setBitmap(Bitmap bitmap,float w,float h){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = w*SCREEN_11/(float)width;
        float scaleHeight = h*SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }

    public ToolsBag(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(setBitmap(bgd,4.75f,2.75f),0,0,paint);
        if(own[0])
            canvas.drawBitmap(setBitmap(glove,1,1),0.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        else
            canvas.drawBitmap(setBitmap(gloveno,1,1),0.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        if(own[1])
            canvas.drawBitmap(setBitmap(szj,1,1),1.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        else
            canvas.drawBitmap(setBitmap(szjno,1,1),1.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        if(own[2])
            canvas.drawBitmap(setBitmap(pqg,1,1),2.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        else
            canvas.drawBitmap(setBitmap(pqgno,1,1),2.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        canvas.drawBitmap(setBitmap(bdhzno,1,1),3.25f*SCREEN_11,0.5f*SCREEN_11,paint);
        canvas.drawBitmap(setBitmap(kysno,1,1),0.25f*SCREEN_11,1.5f*SCREEN_11,paint);
        canvas.drawBitmap(setBitmap(ssno,1,1),1.25f*SCREEN_11,1.5f*SCREEN_11,paint);
        canvas.drawBitmap(setBitmap(tlbno,1,1),2.25f*SCREEN_11,1.5f*SCREEN_11,paint);


    }
    public static void setScreenHeight(int ScreenHeight){
        ToolsBag.SCREEN_11 = ScreenHeight/11.0F;
    }
    public void setOwn(boolean[] own){
        this.own = own;
    }
    public void setOwn(int sort,boolean own){
        this.own[sort] = own;
    }

    public boolean getIfOwn(int sort){
        return own[sort];
    }
}