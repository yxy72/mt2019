package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SuperButton extends View {
    public SuperButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAlpha(240);

    }
    private static float SCREEN_11=72;
    private Bitmap move = BitmapFactory.decodeResource(getResources(), R.drawable.move_none);
    private Bitmap move_up = BitmapFactory.decodeResource(getResources(), R.drawable.move_up);
    private Bitmap move_down = BitmapFactory.decodeResource(getResources(), R.drawable.move_down);
    private Bitmap move_left = BitmapFactory.decodeResource(getResources(), R.drawable.move_left);
    private Bitmap move_right = BitmapFactory.decodeResource(getResources(), R.drawable.move_right);
    private Bitmap move_none = BitmapFactory.decodeResource(getResources(), R.drawable.move_none);
    private Paint paint;

    public Bitmap transform(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = 4*SCREEN_11/width;
        float scaleHeight = 4*SCREEN_11/height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(transform(move), 0, 0, paint);
    }
    public void setScreenHeight(int ScreenHeight) {
        SuperButton.SCREEN_11 = ScreenHeight / 11.0f;
    }
    public void setDirection(int x) {
        switch (x) {
            case (1): move = move_up;invalidate();break;
            case (2): move = move_down;invalidate();break;
            case (3): move = move_left;invalidate();break;
            case (4): move = move_right;invalidate();break;
            case (5): move = move_none;invalidate();break;
        }

    }
}