package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ToolsTouch extends View {
    private boolean goldmine = false;
    private static float SCREEN_11;
    private int setProcess;
    Bitmap goldmine_tool = BitmapFactory.decodeResource(getResources(), R.drawable.goldminr_tool);
    private Paint paint;

    public Bitmap getBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = SCREEN_11 / (float) width;
        float scaleHeight = SCREEN_11 / (float) height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public ToolsTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        if (goldmine) {
            canvas.drawBitmap(getBitmap(goldmine_tool),1*SCREEN_11,1*SCREEN_11,paint);
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            if(setProcess != 100)
                paint.setTextSize(0.45f * SCREEN_11);
            else
                paint.setTextSize(0.35f * SCREEN_11);

            canvas.drawText(String.valueOf(setProcess) + "%", 1.15f * SCREEN_11, 1.75f * SCREEN_11, paint);
        }

    }
    public static void setScreenHeight(int ScreenHeight){
        ToolsTouch.SCREEN_11 = ScreenHeight/11.0F;
    }
    public void setIconGoldMine(boolean Switch){
        goldmine = Switch;
    }
    public void setSetProcess(int x){
        setProcess = x;
        invalidate();
    }
}