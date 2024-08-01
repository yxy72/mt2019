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

public class AllShop extends View {
    public AllShop(Context context, AttributeSet attrs) {
        super(context, attrs);
        abilityUp[0]=4;abilityUp[1]=4;abilityUp[2]=800;
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }
    private static int ScreenHeight;
    private static float SCREEN_11 = 72;
    private Paint paint;
    private int abilityUp[] = new int[3];

    private int ShopNeedGold = 25;
    private Bitmap shopStore = BitmapFactory.decodeResource(getResources(), R.drawable.shop_store);
    private Bitmap shopKind = shopStore;
    private Bitmap shopStore_11 = BitmapFactory.decodeResource(getResources(), R.drawable.shop_store_11f);

    private Bitmap smithy = BitmapFactory.decodeResource(getResources(), R.drawable.smithy);

    private String kind ="";

    private Bitmap setBitmap(Bitmap bitmap,float WIDHT,float HEIGHT){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = WIDHT*ScreenHeight/11.0f/width;
        float scaleHeight = HEIGHT*ScreenHeight/11.0f/height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {
        switch (kind){
            case ("shop"):
                canvas.drawBitmap(setBitmap(shopKind,11,9), 0, 0, paint);
                paint.setTextSize(0.45f*(float)ScreenHeight/11.0f);
                canvas.drawText("如果你拥有"+ShopNeedGold+"金币，就可以增强你的能力。", 1.2f* SCREEN_11, 2* SCREEN_11, paint);
                break;
            case("smithy"):
                canvas.drawBitmap(setBitmap(smithy,11,9), 0 * SCREEN_11, 0 * SCREEN_11, paint);
                break;
        }




    }
    public static void setScreenHeight(int ScreenHeight){
            AllShop.ScreenHeight = ScreenHeight;SCREEN_11 = ScreenHeight/11.0f;
        }
    public void setShopNeedGold(){ShopNeedGold+=5;invalidate();}
    public int getShopNeedMoney(){ return ShopNeedGold;}
    public void setShopKind(String ShopKind){ kind = ShopKind;}
    public void setShopFloor(int floorNumber){
        switch (floorNumber){
            case(3):shopKind = shopStore;
                break;
            case(11):shopKind = shopStore_11;
                break;
        }
    }
    public int[] getAbilityUp(){
        return abilityUp;
    }
    public void setAbilityUp(int[] abilityUp){
        this.abilityUp = abilityUp;
    }
}