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

import com.yxy.www.mtgame2019_20.R;

public class AllMerchantShop extends View {

    private boolean isKey = false;

    public AllMerchantShop(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }
    private static float SCREEN_11 = 72;
    private Paint paint;


    private Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.merchant_store_1);
    private Bitmap keyshop = BitmapFactory.decodeResource(getResources(), R.drawable.keyshop);

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
        if(isKey)
            canvas.drawBitmap(setBitmap(keyshop,11,9), 0,0, paint);
        else
            canvas.drawBitmap(setBitmap(background,11,9), 0,0, paint);

    }
    public static void setScreenHeight(int ScreenHeight){
            AllMerchantShop.SCREEN_11 = (ScreenHeight/11.0f);
    }
    public void setKey(boolean x){
        isKey = x;
    }
    public boolean getIfKey(){
        return isKey;
    }
}