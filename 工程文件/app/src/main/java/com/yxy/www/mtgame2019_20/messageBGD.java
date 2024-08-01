package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class messageBGD extends View {
    private static float SCREEN_11 = 72;
    private Bitmap handbookBGD,fcBGD;
    private Paint paint;
    private boolean setFC = false;


    public messageBGD(Context context, AttributeSet attrs) {
        super(context, attrs);
        handbookBGD = BitmapFactory.decodeResource(getResources(),R.drawable.handbook_bg);
        fcBGD = BitmapFactory.decodeResource(getResources(),R.drawable.fc_bg);

        paint = new Paint();
    }

    private static Bitmap setImage(Bitmap bitmap,float w,float h){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = w * SCREEN_11/(float)width;
        float scaleHeight = h * SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
        if(!setFC)
            canvas.drawBitmap(setImage(handbookBGD, 15, 8.5f), 0, 0, paint);
        else
            canvas.drawBitmap(setImage(fcBGD, 11.5f, 9), 0, 0, paint);

    }
    public static void setScreenHeight(int ScreenHeight) {
        messageBGD.SCREEN_11 = ScreenHeight/11.0f;
    }
    public void setSetFC(boolean a)
    {
        setFC = a;
    }
}


