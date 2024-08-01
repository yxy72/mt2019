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

public class Menu extends View {
    private static float SCREEN_11;
    private static Paint paint;

    private Bitmap menu = BitmapFactory.decodeResource(getResources(), R.drawable.menu);
    private boolean music = true;
    private boolean sound = true;
    private boolean process = true;
    private boolean test = false;



    private Bitmap setBitmap(Bitmap bitmap, float w, float h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = w * SCREEN_11 / (float) width;
        float scaleHeight = h * SCREEN_11 / (float) height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public Menu(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(setBitmap(menu, 11, 9), 0, 0, paint);
        if (!music)
            canvas.drawText("打开音乐", 4.3f * SCREEN_11, 3.1f * SCREEN_11, paint);
        else
            canvas.drawText("关闭音乐", 4.3f * SCREEN_11, 3.1f * SCREEN_11, paint);
        if (!sound)
            canvas.drawText("打开音效", 4.3f * SCREEN_11, 1.7f * SCREEN_11, paint);
        else
            canvas.drawText("关闭音效", 4.3f * SCREEN_11, 1.7f * SCREEN_11, paint);
        if (!process)
            canvas.drawText("显示战斗过程", 3.7f * SCREEN_11, 4.6f * SCREEN_11, paint);
        else
            canvas.drawText("隐藏战斗过程", 3.7f * SCREEN_11, 4.6f * SCREEN_11, paint);
        if(test)
            canvas.drawText("测试", 9.8f * SCREEN_11, 8.6f * SCREEN_11, paint);


    }

    public static void setScreenHeight(int ScreenHeight) {
        Menu.SCREEN_11 = ScreenHeight / 11.0F;
        Menu.paint.setTextSize(0.55f*SCREEN_11);
    }

    public boolean getCase(int x) {
        switch (x) {
            case 0:
                return sound;
            case 1:
                return music;
            case 2:
                return process;
        }
        return false;
    }
    public void setCase(int x, boolean Case){
        switch (x){
            case 0:
                sound = Case;break;
            case 1:
                music = Case;break;
            case 2:
                process = Case;break;
            case 3:
                test = Case;break;
        }
    }
}