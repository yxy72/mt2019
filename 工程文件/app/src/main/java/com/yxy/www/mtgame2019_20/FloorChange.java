package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class FloorChange extends ScrollView {
    private static float SCREEN_11 = 72;
    private Bitmap floorChange = BitmapFactory.decodeResource(getResources(),R.drawable.floor_change);
    private Bitmap have = BitmapFactory.decodeResource(getResources(),R.drawable.floor_change_2);
    private Bitmap haveNot = BitmapFactory.decodeResource(getResources(),R.drawable.floor_change_3);
    private boolean haveReach[] = new boolean[31];

    public float startY = 0;
    public float nowY = 0;
    public float moveY = 0;


    private Paint paint;

    public FloorChange(Context context,AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.rgb(132,60,12));
        paint.setAntiAlias(true);
        for(int i=0;i<31;i++)
            haveReach[i] = false;

    }

    private Bitmap setBitmap(Bitmap bitmap,float x,float y){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = x*SCREEN_11/(float)width;
        float scaleHeight = y*SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
//        canvas.drawBitmap(setBitmap(floorChange,11.5f,9),0, 0 , paint);
        paint.setTextSize(0.5f*SCREEN_11);
        for(int i=0;i<3;i++){
            for(int j=0;j<10;j++){
                if(haveReach[i+3*j+1])
                    canvas.drawBitmap(setBitmap(have,2.5f,1), (1.5f+i*3) * SCREEN_11, (j*1.35f) * SCREEN_11+ moveY + startY, paint);
                else
                    canvas.drawBitmap(setBitmap(haveNot,2.5f,1), (1.5f+i*3) * SCREEN_11, (j*1.35f) * SCREEN_11+ moveY + startY, paint);


                if(i+3*j+1>=10) {
                    canvas.drawText(String.valueOf(i + 3 * j + 1), (1.5f + i * 3 + 0.98f) * SCREEN_11, (j * 1.35f + 0.65f) * SCREEN_11+ moveY + startY, paint);
                }
                else{
                    canvas.drawText(String.valueOf(i + 3 * j + 1), (1.5f + i * 3 + 1.12f) * SCREEN_11, (j * 1.35f + 0.65f) * SCREEN_11+ moveY + startY, paint);

                }
            }
        }



    }
    public static void setScreenHeight(int ScreenHeight) {
        FloorChange.SCREEN_11 = ScreenHeight/11.0f;
    }
    public void setMoveY(float y){
        this.moveY = y;
    }
    public void setHasReach(int floor,boolean reach){
        haveReach[floor] = reach;
    }

    public boolean[] getHaveReach() {
        return haveReach;
    }
    public boolean getHaveReach(int floor) {
        return haveReach[floor];
    }
}


