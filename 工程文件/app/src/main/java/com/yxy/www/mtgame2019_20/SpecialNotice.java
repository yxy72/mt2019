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

public class SpecialNotice extends View {
    private static float SCREEN_11;
    Bitmap glove = BitmapFactory.decodeResource(getResources(), R.drawable.glove_sm);
    Bitmap pqg = BitmapFactory.decodeResource(getResources(), R.drawable.pqg_sm);
    Bitmap szj = BitmapFactory.decodeResource(getResources(), R.drawable.szj_sm);
    Bitmap move = BitmapFactory.decodeResource(getResources(), R.drawable.instr);

    private Paint paint;
    private String noticeKind = "";


    public SpecialNotice(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        switch (noticeKind){
            case "glove":
                canvas.drawBitmap(setImage(glove,11,9),0,0,paint);

                break;
            case "pqg":
                canvas.drawBitmap(setImage(pqg,11,9),0,0,paint);

                break;
            case "szj":
                canvas.drawBitmap(setImage(szj,11,9),0,0,paint);
                break;
            case "instr":
                canvas.drawBitmap(setImage(move,11,9),0,0,paint);
                break;
        }


    }
    public static void setScreenHeight(int ScreenHeight){
        SpecialNotice.SCREEN_11 = ScreenHeight/11.0F;
    }
    public void setKind(String kind){
        noticeKind = kind;
    }
}