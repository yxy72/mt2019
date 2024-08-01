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

public class Player extends View {
    private static float SCREEN_11;
    private Paint paint;
    private String face = "up";

    Bitmap u = BitmapFactory.decodeResource(getResources(),R.drawable.u);
    Bitmap d = BitmapFactory.decodeResource(getResources(),R.drawable.d);
    Bitmap l = BitmapFactory.decodeResource(getResources(),R.drawable.l);
    Bitmap r = BitmapFactory.decodeResource(getResources(),R.drawable.r);


    public Bitmap getBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = SCREEN_11 / (float) width;
        float scaleHeight = SCREEN_11 / (float) height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public Player(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {

        switch (face){
            case "u":
                canvas.drawBitmap(getBitmap(u),0,0,paint);
                break;
            case "d":
                canvas.drawBitmap(getBitmap(d),0,0,paint);
                break;
            case "l":
                canvas.drawBitmap(getBitmap(l),0,0,paint);
                break;
            case "r":
                canvas.drawBitmap(getBitmap(r),0,0,paint);
                break;

        }

    }
    public static void setScreenHeight(int ScreenHeight){
        Player.SCREEN_11 = ScreenHeight/11.0F;
    }
    public void setFace(String x){
        face = x;
    }
}