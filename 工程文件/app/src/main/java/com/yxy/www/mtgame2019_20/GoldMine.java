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

public class GoldMine extends View {
    public GoldMine(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);

    }
    private static float SCREEN_11;

    public float hasHowMuch = 0;
    public float createSpeed = 0.4f;
    public int goldMax = 80;
    private Paint paint;


    Bitmap fightProcess = BitmapFactory.decodeResource(getResources(),R.drawable.goldmine1);


    private Bitmap setBitmap(Bitmap bitmap,float WIDHT,float HEIGHT){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = WIDHT*SCREEN_11/width;
        float scaleHeight = HEIGHT*SCREEN_11/height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {

        paint.setTextSize(0.4f*SCREEN_11);
        canvas.drawBitmap(setBitmap(fightProcess, 10, 6), 0 * SCREEN_11, 0 * SCREEN_11, paint);
        canvas.drawText("金矿 Lv1", 1 * SCREEN_11, 1.5f * SCREEN_11, paint);
        canvas.drawText("当前速度："+String.valueOf((int)(60*createSpeed))+"金币/分钟 ; 最大容量："+String.valueOf(goldMax), 1 * SCREEN_11, 2.1f * SCREEN_11, paint);

        paint.setTextSize(0.6f*SCREEN_11);
        if(hasHowMuch < goldMax) {
            canvas.drawText("当前储量：" + String.valueOf((int) hasHowMuch), 1 * SCREEN_11, 3.5f * SCREEN_11, paint);
        }
        else {
            canvas.drawText( "当前储量："+String.valueOf((int)hasHowMuch)+"（已满）", 1 * SCREEN_11, 3.5f * SCREEN_11, paint);

        }




    }
    public static void setScreenHeight(int ScreenHeight){
            GoldMine.SCREEN_11 = ScreenHeight/11.0F;
        }

    public float getHasHowMuch(){return hasHowMuch;}
    public int getGoldMax(){return goldMax;}
    public float getCreateSpeed(){return createSpeed;}

    public void setCreateSpeed(float speed){createSpeed = speed;}
    public void setGoldMax(int goldMax){this.goldMax = goldMax ;}
    public void setHasHowMuch(float hasHowMuch){this.hasHowMuch = hasHowMuch;}
}