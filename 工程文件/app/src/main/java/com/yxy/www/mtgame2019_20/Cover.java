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

public class Cover extends View {
    private static float SCREEN_11 = 72;
    private Paint paint;

    private Bitmap cover1 = BitmapFactory.decodeResource(getResources(),R.drawable.coverbackground2);

    private boolean coverFlag = false;


    public Cover(Context context, AttributeSet attrs) {
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
        if (coverFlag)
            canvas.drawBitmap(getbitmap(cover1,11,11),0, 0, paint);
    }
    public static void setScreenHeight(int ScreenHeight) {
        Cover.SCREEN_11 = ScreenHeight/11.0f;
    }



    public void setCoverFlag(boolean coverFlag){
        this.coverFlag = coverFlag;
    }

}


