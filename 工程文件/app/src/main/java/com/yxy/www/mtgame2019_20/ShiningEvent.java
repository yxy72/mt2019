package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.net.PasswordAuthentication;

public class ShiningEvent extends View {


    public ShiningEvent(Context context, AttributeSet attrs){
        super(context,attrs);

        for(int i=0;i<11;i++){
            for(int j = 0;j<11;j++){
                bitmap[i][j] = Null;
            }
        }
        paint = new Paint();
    }
    private static float SCREEN_11;
    private Bitmap bitmap[][] = new Bitmap[11][11];
    private String event[][] = new String[11][11];
    private Paint paint;

    private boolean M21 = false;
    public boolean start_m21 = false;

    Bitmap m1 = BitmapFactory.decodeResource(getResources(),R.drawable.m_1);
    Bitmap m1_ = BitmapFactory.decodeResource(getResources(),R.drawable.m_1_new);
    Bitmap m2 = BitmapFactory.decodeResource(getResources(),R.drawable.m_2);
    Bitmap m2_ = BitmapFactory.decodeResource(getResources(),R.drawable.m_2_new);
    Bitmap m3 = BitmapFactory.decodeResource(getResources(),R.drawable.m3);
    Bitmap m3_ = BitmapFactory.decodeResource(getResources(),R.drawable.m3_new);
    Bitmap m4 = BitmapFactory.decodeResource(getResources(),R.drawable.m4);
    Bitmap m4_ = BitmapFactory.decodeResource(getResources(),R.drawable.m4_new);
    Bitmap m5 = BitmapFactory.decodeResource(getResources(),R.drawable.m5);
    Bitmap m5_ = BitmapFactory.decodeResource(getResources(),R.drawable.m5_new);
    Bitmap m6 = BitmapFactory.decodeResource(getResources(),R.drawable.m6);
    Bitmap m6_ = BitmapFactory.decodeResource(getResources(),R.drawable.m6_new);
    Bitmap m7 = BitmapFactory.decodeResource(getResources(),R.drawable.m7);
    Bitmap m7_ = BitmapFactory.decodeResource(getResources(),R.drawable.m7_new);
    Bitmap m8 = BitmapFactory.decodeResource(getResources(),R.drawable.m8);
    Bitmap m8_ = BitmapFactory.decodeResource(getResources(),R.drawable.m8_new);
    Bitmap m9 = BitmapFactory.decodeResource(getResources(),R.drawable.m9);
    Bitmap m9_ = BitmapFactory.decodeResource(getResources(),R.drawable.m9_new);
    Bitmap m10 = BitmapFactory.decodeResource(getResources(),R.drawable.m10);
    Bitmap m10_ = BitmapFactory.decodeResource(getResources(),R.drawable.m10_new);
    Bitmap m11 = BitmapFactory.decodeResource(getResources(),R.drawable.m11);
    Bitmap m11_ = BitmapFactory.decodeResource(getResources(),R.drawable.m11_new);
    Bitmap m12 = BitmapFactory.decodeResource(getResources(),R.drawable.m12);
    Bitmap m12_ = BitmapFactory.decodeResource(getResources(),R.drawable.m12_new);
    Bitmap m13 = BitmapFactory.decodeResource(getResources(),R.drawable.m13);
    Bitmap m13_ = BitmapFactory.decodeResource(getResources(),R.drawable.m13_new);
    Bitmap m14 = BitmapFactory.decodeResource(getResources(),R.drawable.m14);
    Bitmap m14_ = BitmapFactory.decodeResource(getResources(),R.drawable.m14_new);
    Bitmap m15 = BitmapFactory.decodeResource(getResources(),R.drawable.m15);
    Bitmap m15_ = BitmapFactory.decodeResource(getResources(),R.drawable.m15_new);
    Bitmap m16 = BitmapFactory.decodeResource(getResources(),R.drawable.m16);
    Bitmap m16_ = BitmapFactory.decodeResource(getResources(),R.drawable.m16_new);
    Bitmap m17 = BitmapFactory.decodeResource(getResources(),R.drawable.m17);
    Bitmap m17_ = BitmapFactory.decodeResource(getResources(),R.drawable.m17_new);
    Bitmap m18 = BitmapFactory.decodeResource(getResources(),R.drawable.m18);
    Bitmap m18_ = BitmapFactory.decodeResource(getResources(),R.drawable.m18_new);
    Bitmap m19 = BitmapFactory.decodeResource(getResources(),R.drawable.m19);
    Bitmap m19_ = BitmapFactory.decodeResource(getResources(),R.drawable.m19_new);
    Bitmap m20 = BitmapFactory.decodeResource(getResources(),R.drawable.m20);
    Bitmap m20_ = BitmapFactory.decodeResource(getResources(),R.drawable.m20_new);
    Bitmap m21 = BitmapFactory.decodeResource(getResources(),R.drawable.m21);
    Bitmap m21_ = BitmapFactory.decodeResource(getResources(),R.drawable.m21_new);
//    Bitmap m22 = BitmapFactory.decodeResource(getResources(),R.drawable.m22);
//    Bitmap m22_ = BitmapFactory.decodeResource(getResources(),R.drawable.m22_new);
//    Bitmap m22 = BitmapFactory.decodeResource(getResources(),R.drawable.m22);
    Bitmap m23 = BitmapFactory.decodeResource(getResources(),R.drawable.m23);
    Bitmap m23_ = BitmapFactory.decodeResource(getResources(),R.drawable.m23_new);


    Bitmap shop = BitmapFactory.decodeResource(getResources(),R.drawable.shop);
    Bitmap shop_ = BitmapFactory.decodeResource(getResources(),R.drawable.shop_new);
    Bitmap mWuZei = BitmapFactory.decodeResource(getResources(),R.drawable.m21);

    Bitmap girl = BitmapFactory.decodeResource(getResources(),R.drawable.girl);
    Bitmap girl_ = BitmapFactory.decodeResource(getResources(),R.drawable.girl_new);

    Bitmap eif = BitmapFactory.decodeResource(getResources(),R.drawable.eif);
    Bitmap eif_ = BitmapFactory.decodeResource(getResources(),R.drawable.eif_new);




    Bitmap firewall = BitmapFactory.decodeResource(getResources(),R.drawable.firewall);
    Bitmap firewall_ = BitmapFactory.decodeResource(getResources(),R.drawable.firewall_new);




    Bitmap npc = BitmapFactory.decodeResource(getResources(),R.drawable.npc);
    Bitmap npc_ = BitmapFactory.decodeResource(getResources(),R.drawable.npc_new);
    Bitmap thief = BitmapFactory.decodeResource(getResources(),R.drawable.thief);
    Bitmap thief_ = BitmapFactory.decodeResource(getResources(),R.drawable.thief_new);

    Bitmap merchant = BitmapFactory.decodeResource(getResources(),R.drawable.merchant);
    Bitmap merchant_ = BitmapFactory.decodeResource(getResources(),R.drawable.merchant_new);


    Bitmap Null = BitmapFactory.decodeResource(getResources(),R.drawable.png);



    private Bitmap getbitmap(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = SCREEN_11/width+0.005f;
        float scaleHeight = SCREEN_11/height+0.005f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    private Bitmap getbitmap3_3(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = 3*SCREEN_11/width;
        float scaleHeight = 3*SCREEN_11/height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }

    public void onDraw(Canvas canvas) {
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++) {
                if(!event[i][j].equals(""))
                    canvas.drawBitmap(getbitmap(bitmap[i][j]), i * SCREEN_11, j * SCREEN_11, paint);
                if(event[i][j].equals("m21"))
                    start_m21 = true;
            }
        }
        if(start_m21){
            start_m21 = false;
            if(M21) {
                M21 = false;
                mWuZei = m21;
            }
            else {
                mWuZei = m21_;
                M21 = true;
            }
            canvas.drawBitmap(getbitmap3_3(mWuZei), 3 * SCREEN_11, 3 * SCREEN_11, paint);

        }
    }



    public void setScreenHeight(int ScreenHeight){
        ShiningEvent.SCREEN_11 = ScreenHeight/11.0f;
    }
    void setShining1(){
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){

                if(bitmap[i][j]==m1){
                    bitmap[i][j]=m1_; }
                else if(bitmap[i][j]==m2){
                    bitmap[i][j]=m2_;}
                else if(bitmap[i][j]==m3){
                    bitmap[i][j]=m3_;}
                else if(bitmap[i][j]==m4) {
                    bitmap[i][j] = m4_; }
                else if(bitmap[i][j]==m5) {
                    bitmap[i][j] = m5_; }
                else if(bitmap[i][j]==m6) {
                    bitmap[i][j] = m6_; }
                else if(bitmap[i][j]==m7) {
                    bitmap[i][j] = m7_; }
                else if(bitmap[i][j]==m8) {
                    bitmap[i][j] = m8_; }
                else if(bitmap[i][j]==m9) {
                    bitmap[i][j] = m9_; }
                else if(bitmap[i][j]==m10) {
                    bitmap[i][j] = m10_; }
                else if(bitmap[i][j]==m11) {
                    bitmap[i][j] = m11_; }
                else if(bitmap[i][j]==m12) {
                    bitmap[i][j] = m12_; }
                else if(bitmap[i][j]==m13) {
                    bitmap[i][j] = m13_; }
                else if(bitmap[i][j]==m14) {
                    bitmap[i][j] = m14_; }
                else if(bitmap[i][j]==m15) {
                    bitmap[i][j] = m15_; }
                else if(bitmap[i][j]==m16) {
                    bitmap[i][j] = m16_; }
                else if(bitmap[i][j]==m17) {
                    bitmap[i][j] = m17_; }
                else if(bitmap[i][j]==m18) {
                    bitmap[i][j] = m18_; }
                else if(bitmap[i][j]==m19) {
                    bitmap[i][j] = m19_; }
                else if(bitmap[i][j]==m20) {
                    bitmap[i][j] = m20_; }
//                else if(bitmap[i][j]==m21) {
//                    bitmap[i][j] = m21_; }
//                else if(bitmap[i][j]==m22) {
//                    bitmap[i][j] = m22_; }
                else if(bitmap[i][j]==m23) {
                    bitmap[i][j] = m23_; }



                else if(bitmap[i][j]==thief) {
                    bitmap[i][j] = thief_; }
                else if(bitmap[i][j]==eif) {
                    bitmap[i][j] = eif_; }
                else if(bitmap[i][j]==npc) {
                    bitmap[i][j] = npc_; }
                else if(bitmap[i][j]== merchant) {
                    bitmap[i][j] = merchant_; }
                else if(bitmap[i][j]==shop) {
                    bitmap[i][j] = shop_; }
                else if(bitmap[i][j]==girl) {
                    bitmap[i][j] = girl_; }

                else if(bitmap[i][j]==firewall||bitmap[i][j]==firewall) {
                    bitmap[i][j] = firewall_; }
            }
        }
        this.invalidate();
    }
    public void setShining2() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (bitmap[i][j] == m1_) {
                    bitmap[i][j] = m1;
                } else if (bitmap[i][j] == m2_) {
                    bitmap[i][j] = m2;
                } else if (bitmap[i][j] == m3_) {
                    bitmap[i][j] = m3;
                } else if (bitmap[i][j] == m4_) {
                    bitmap[i][j] = m4;
                } else if (bitmap[i][j] == m5_) {
                    bitmap[i][j] = m5;
                } else if (bitmap[i][j] == m6_) {
                    bitmap[i][j] = m6;
                } else if (bitmap[i][j] == m7_) {
                    bitmap[i][j] = m7;
                } else if (bitmap[i][j] == m8_) {
                    bitmap[i][j] = m8;
                } else if (bitmap[i][j] == m9_) {
                    bitmap[i][j] = m9;
                } else if (bitmap[i][j] == npc_) {
                    bitmap[i][j] = npc;
                } else if (bitmap[i][j] == merchant_) {
                    bitmap[i][j] = merchant;
                } else if(bitmap[i][j]==thief_) {
                        bitmap[i][j] = thief;
                } else if (bitmap[i][j] == shop_) {
                    bitmap[i][j] = shop;
                } else if (bitmap[i][j] == m10_) {
                    bitmap[i][j] = m10;
                } else if (bitmap[i][j] == m11_) {
                    bitmap[i][j] = m11;
                } else if (bitmap[i][j] == m12_) {
                    bitmap[i][j] = m12;
                } else if (bitmap[i][j] == m13_) {
                    bitmap[i][j] = m13;
                } else if (bitmap[i][j] == m14_) {
                    bitmap[i][j] = m14;
                } else if (bitmap[i][j] == m15_) {
                    bitmap[i][j] = m15;
                } else if (bitmap[i][j] == m16_) {
                    bitmap[i][j] = m16;
                } else if (bitmap[i][j] == m17_) {
                    bitmap[i][j] = m17;
                } else if (bitmap[i][j] == m18_) {
                    bitmap[i][j] = m18;
                } else if (bitmap[i][j] == m18_) {
                    bitmap[i][j] = m18;
                } else if (bitmap[i][j] == m19_) {
                    bitmap[i][j] = m19;
                } else if (bitmap[i][j] == m20_) {
                    bitmap[i][j] = m20;
//                } else if (bitmap[i][j] == m21_) {
//                    bitmap[i][j] = m21;
//                } else if (bitmap[i][j] == m22_) {
//                    bitmap[i][j] = m22;
                } else if (bitmap[i][j] == eif_) {
                    bitmap[i][j] = eif;
                } else if (bitmap[i][j] == m23_) {
                    bitmap[i][j] = m23;
                } else if(bitmap[i][j]==firewall_) {
                    bitmap[i][j] = firewall;
                } else if(bitmap[i][j]==girl_) {
                    bitmap[i][j] = girl; }

            }
        }
        this.invalidate();
    }
    public void setEvent(String[][] a){
        this.event = a;
        setBitmap();
        invalidate();

    }

    public void set886(int i,int j){
        event[i][j]="";
        bitmap[i][j] = Null;
        invalidate();
    }

    public void setBitmap(){
        for(int i=0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(event[i][j]=="m1")
                    bitmap[i][j]=m1;
                else if(event[i][j]=="m2")
                    bitmap[i][j]=m2;
                else if(event[i][j]=="m3")
                    bitmap[i][j]=m3;
                else if(event[i][j]=="m4")
                    bitmap[i][j]=m4;
                else if(event[i][j]=="m5")
                    bitmap[i][j]=m5;
                else if(event[i][j]=="m6")
                    bitmap[i][j]=m6;
                else if(event[i][j]=="m7")
                    bitmap[i][j]=m7;
                else if(event[i][j]=="m8")
                    bitmap[i][j]=m8;
                else if(event[i][j]=="m9")
                    bitmap[i][j]=m9;
                else if(event[i][j]=="m10")
                    bitmap[i][j]=m10;
                else if(event[i][j]=="m11")
                    bitmap[i][j]=m11;
                else if(event[i][j]=="m12")
                    bitmap[i][j]=m12;
                else if(event[i][j]=="m13")
                    bitmap[i][j]=m13;
                else if(event[i][j]=="m14")
                    bitmap[i][j]=m14;
                else if(event[i][j]=="m15")
                    bitmap[i][j]=m15;
                else if(event[i][j]=="m16")
                    bitmap[i][j]=m16;
                else if(event[i][j]=="m17")
                    bitmap[i][j]=m17;
                else if(event[i][j]=="m18")
                    bitmap[i][j]=m18;
                else if(event[i][j]=="m19")
                    bitmap[i][j]=m19;
                else if(event[i][j]=="m20")
                    bitmap[i][j]=m20;
//                else if(event[i][j]=="m21")
//                    bitmap[i][j]=m21;
//                else if(event[i][j]=="m22")
//                    bitmap[i][j]=m22;
                else if(event[i][j]=="m23")
                    bitmap[i][j]=m23;






                else if(event[i][j]=="npc")
                    bitmap[i][j]=npc;
                else if(event[i][j]=="thief")
                    bitmap[i][j]=thief;
                else if(event[i][j].equals("merchant")||event[i][j].equals("merchant2")||event[i][j].equals("merchant3"))
                    bitmap[i][j]=merchant;
                else if(event[i][j]=="shop")
                    bitmap[i][j]=shop;
                else if(event[i][j]=="firewall")
                    bitmap[i][j]=firewall;
                else if(event[i][j].equals("girl"))
                    bitmap[i][j]=girl;
                else if(event[i][j].equals("eif"))
                    bitmap[i][j]=eif;
                else bitmap[i][j]=Null;

                }
        }


    }

}