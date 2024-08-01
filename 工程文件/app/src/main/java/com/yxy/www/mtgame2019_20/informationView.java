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

public class informationView extends View {

    private int AD = 10;
    private int DEF = 10;
    private float HP = 1000;
    private int GOLD = 0;
    private int BLOOD = 0;
    private int VERYBIT = 0;
    private int keyYnum = 0;
    private int keyBnum = 0;
    private int keyRnum = 0;
    private String floorNumber = "";
    public int way1=0,way2=0,way3=0,way4=0,way5=0,way6=0;
    public int w1=0,w2=0,w3=0,w4=0,w5=0,w6=0;
    public String face = "null";
    public String log = "";

    private boolean haveReach[] = new boolean[31];

    private boolean ownTool[] = new boolean[3];

    String Ad ="攻击:",Def="防御:",Hp="生命:",gold="金币：",Blood="吸血：",VeryBit="暴击：";
    Bitmap keyY = BitmapFactory.decodeResource(getResources(),R.drawable.key_y);
    Bitmap keyB = BitmapFactory.decodeResource(getResources(),R.drawable.key_b);
    Bitmap keyR = BitmapFactory.decodeResource(getResources(),R.drawable.key_r);
    Bitmap blood_1 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_1);
    Bitmap blood_2 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_2);
    Bitmap blood_3 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_3);
    Bitmap ad_1 = BitmapFactory.decodeResource(getResources(),R.drawable.ad_1);
    Bitmap ad_2 = BitmapFactory.decodeResource(getResources(),R.drawable.ad_2);
    Bitmap def_1 = BitmapFactory.decodeResource(getResources(),R.drawable.def_1);
    Bitmap def_2 = BitmapFactory.decodeResource(getResources(),R.drawable.def_2);

    Bitmap baoji_1 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_1);
    Bitmap baoji_2 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_2);
    Bitmap baoji_3 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_3);

    Bitmap mons_inf = BitmapFactory.decodeResource(getResources(), R.drawable.mos_inf);
    Bitmap floorChange = BitmapFactory.decodeResource(getResources(), R.drawable.floor_tool_change);
//    Bitmap glove = BitmapFactory.decodeResource(getResources(),R.drawable.glove);
//    Bitmap glove_new = BitmapFactory.decodeResource(getResources(),R.drawable.glove_new);
    Bitmap toolBag = BitmapFactory.decodeResource(getResources(),R.drawable.tool_bag);

    private float SCREEN_11;
    private int ScreenWidth;

    boolean AD_1 = false,DEF_1 = false,AD_2 = false,DEF_2 = false;
    public int numOfBlood_1 = 0,numOfBlood_2 = 0,numOfBaoji_1 = 0,numOfBaoji_2 = 0,numOfBaoji_3 = 0,numOfBlood_3 = 0,numOfGlove = 0;
    public boolean monsterHandBook = false,floorChanger = false,goldMine1 = false,glove1 = false,glove2 = false;

    public boolean[] getOwnTool(){
        return ownTool;
    }
    public void setOwnTool(int sort){
        ownTool[sort] = true;
    }

    Paint paint = new Paint();
    public informationView(Context context, AttributeSet attrs){
        super(context,attrs);
        ownTool[0] = false;ownTool[1] = false;ownTool[2] = false;
    }

    //图片适应比例函数：

    public Bitmap getInfWall(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.d("screen",ScreenWidth+"");
        float scaleWidth = SCREEN_11/(float)width+0.005f;
        float scaleHeight = SCREEN_11/(float)height+0.005f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    @Override
    public void onDraw(Canvas canvas){
        paint.setColor(Color.BLUE);
        paint.setTextSize(40);
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(255,220,140));
        paint.setTextSize(0.5f*SCREEN_11);
        if(AD_2){
            canvas.drawBitmap(getInfWall(ad_2),3*SCREEN_11,4*SCREEN_11,paint);
        } else if(AD_1){
            canvas.drawBitmap(getInfWall(ad_1),3*SCREEN_11,4*SCREEN_11,paint);
        }
        if(DEF_2){
            canvas.drawBitmap(getInfWall(def_2),3*SCREEN_11,5*SCREEN_11,paint);
        }else if(DEF_1){
            canvas.drawBitmap(getInfWall(def_1),3*SCREEN_11,5*SCREEN_11,paint);
        }


        float Blood2Y = 4f, Blood3Y = 5f, Blood1Y = 6f;
        if(numOfBlood_1>=1||numOfBlood_2>=1||numOfBlood_3>=1) {
            if (numOfBlood_2 == 0) {
                Blood3Y -= 1;
                Blood1Y -= 1;
            }
            if (numOfBlood_3 == 0) {
                Blood1Y -= 1;
            }
            if (numOfBlood_1 >= 1) {
                canvas.drawBitmap(getInfWall(blood_1), 4 * SCREEN_11 , Blood1Y * SCREEN_11, paint);
                if (numOfBlood_1 >= 2)
                    canvas.drawText(String.valueOf(numOfBlood_1), 4.7f * SCREEN_11, (Blood1Y+1) * SCREEN_11, paint);
            }
            if (numOfBlood_2 >= 1) {
                canvas.drawBitmap(getInfWall(blood_2), 4 * SCREEN_11 , Blood2Y * SCREEN_11, paint);
                if (numOfBlood_2 >= 2) {
                    paint.setColor(Color.LTGRAY);
                    canvas.drawText(String.valueOf(numOfBlood_2), 4.7f * SCREEN_11, (Blood2Y+1) * SCREEN_11, paint);
                    paint.setColor(Color.rgb(255,220,140));
                }
            }
            if (numOfBlood_3 >= 1) {
                canvas.drawBitmap(getInfWall(blood_3), 4 * SCREEN_11 , Blood3Y * SCREEN_11, paint);
                if (numOfBlood_3 >= 2) {
                    paint.setColor(Color.LTGRAY);
                    canvas.drawText(String.valueOf(numOfBlood_3), 4.7f * SCREEN_11, (Blood3Y+1) * SCREEN_11, paint);
                    paint.setColor(Color.rgb(255,220,140));
                }
            }
        }






        if(monsterHandBook)
            canvas.drawBitmap(getInfWall(mons_inf), 1 * SCREEN_11, 4 * SCREEN_11, paint);
        if(floorChanger)
            canvas.drawBitmap(getInfWall(floorChange), 2 * SCREEN_11, 4 * SCREEN_11, paint);

//        if(numOfGlove>=1){
//            if(numOfGlove>=2)
//                canvas.drawText(String.valueOf(numOfGlove), 1.7f * SCREEN_11, (Blood3Y+1) * SCREEN_11, paint);
//            if(glove2)
//                canvas.drawBitmap(getInfWall(glove_new), 1 * SCREEN_11, 5 * SCREEN_11, paint);
//            else if(glove1)
//                canvas.drawBitmap(getInfWall(glove), 1 * SCREEN_11, 5 * SCREEN_11, paint);
//
//
//        }

        canvas.drawBitmap(getInfWall(toolBag), 1 * SCREEN_11, 5 * SCREEN_11, paint);







        if(numOfBaoji_3>0){
            canvas.drawBitmap(getInfWall(baoji_3),5*SCREEN_11,4*SCREEN_11,paint);
            if(numOfBaoji_3>=2){
                paint.setColor(Color.LTGRAY);
                canvas.drawText(String.valueOf(numOfBaoji_3),5.7f*SCREEN_11,5*SCREEN_11,paint);

            }
            if(numOfBaoji_2>0){
                canvas.drawBitmap(getInfWall(baoji_2),5*SCREEN_11,6*SCREEN_11,paint);
                if(numOfBaoji_2>=2)
                    canvas.drawText(String.valueOf(numOfBaoji_2),5.7f*SCREEN_11,7*SCREEN_11,paint);
            }
            if(numOfBaoji_1>0){
                canvas.drawBitmap(getInfWall(baoji_1),5*SCREEN_11,5*SCREEN_11,paint);
                if(numOfBaoji_1>=2)
                    canvas.drawText(String.valueOf(numOfBaoji_1),5.7f*SCREEN_11,6*SCREEN_11,paint);
            }

        }
        else{
            if(numOfBaoji_2>0){
                canvas.drawBitmap(getInfWall(baoji_2),5*SCREEN_11,5*SCREEN_11,paint);
                if(numOfBaoji_2>=2)
                    canvas.drawText(String.valueOf(numOfBaoji_2),5.7f*SCREEN_11,6*SCREEN_11,paint);
            }
            if(numOfBaoji_1>0){
                canvas.drawBitmap(getInfWall(baoji_1),5*SCREEN_11,4*SCREEN_11,paint);
                if(numOfBaoji_1>=2)
                    canvas.drawText(String.valueOf(numOfBaoji_1),5.7f*SCREEN_11,5*SCREEN_11,paint);
            }
        }

        canvas.drawBitmap(getInfWall(keyY),1*SCREEN_11,6*SCREEN_11,paint);
        canvas.drawBitmap(getInfWall(keyB),2*SCREEN_11,6*SCREEN_11,paint);
        canvas.drawBitmap(getInfWall(keyR),3*SCREEN_11,6*SCREEN_11,paint);

        paint.setColor(Color.WHITE);
        float textSize = 0.45f;
        paint.setTextSize(textSize*SCREEN_11);
        canvas.drawText(String.valueOf(keyYnum),1.65f*SCREEN_11,6.8f*SCREEN_11,paint);
        canvas.drawText(String.valueOf(keyBnum),2.7f*SCREEN_11,6.8f*SCREEN_11,paint);
        canvas.drawText(String.valueOf(keyRnum),3.7f*SCREEN_11,6.8f*SCREEN_11,paint);
        paint.setColor(Color.WHITE);

        float Tleft=0.75f,Ttop = 1.45f;
        float Vleft = 2.25f;
        float LineHeight = 0.7f;
        float ColumnWidth = Tleft+3.0f;

        if(Integer.parseInt(floorNumber)>0)
            canvas.drawText("【第"+floorNumber+"层】",0.75f*Tleft*SCREEN_11,(Ttop-LineHeight)*SCREEN_11,paint);
        else
            canvas.drawText("【魔塔外】",0.75f*Tleft*SCREEN_11,(Ttop-LineHeight)*SCREEN_11,paint);

        paint.setTextSize(0.75f*textSize*SCREEN_11);


        canvas.drawText(log,4*Tleft*SCREEN_11,(Ttop-LineHeight)*SCREEN_11,paint);
        paint.setTextSize(textSize*SCREEN_11);

        canvas.drawText(Ad,Tleft*SCREEN_11,Ttop*SCREEN_11,paint);
        canvas.drawText(Def,Tleft*SCREEN_11,(Ttop+LineHeight)*SCREEN_11,paint);
        canvas.drawText(Hp,Tleft*SCREEN_11,(Ttop+2*LineHeight)*SCREEN_11,paint);
        canvas.drawText(gold,Tleft*SCREEN_11,(Ttop+3*LineHeight)*SCREEN_11,paint);

        canvas.drawText(String.valueOf(AD),Vleft*SCREEN_11,Ttop*SCREEN_11,paint);
        canvas.drawText(String.valueOf(DEF),Vleft*SCREEN_11,(Ttop+LineHeight)*SCREEN_11,paint);
        canvas.drawText(String.valueOf((int)HP),Vleft*SCREEN_11,(Ttop+2*LineHeight)*SCREEN_11,paint);
        canvas.drawText(String.valueOf(GOLD),Vleft*SCREEN_11,(Ttop+3*LineHeight)*SCREEN_11,paint);

        if(BLOOD==0)
            paint.setColor(Color.LTGRAY);
        canvas.drawText(Blood,ColumnWidth*SCREEN_11,Ttop*SCREEN_11,paint);
        canvas.drawText(String.valueOf(BLOOD)+"%",(ColumnWidth+3*textSize)*SCREEN_11,Ttop*SCREEN_11,paint);

        if(VERYBIT==0)
            paint.setColor(Color.LTGRAY);
        else
            paint.setColor(Color.WHITE);
        canvas.drawText(String.valueOf(VERYBIT+"%"),(ColumnWidth+3*textSize)*SCREEN_11,(Ttop+LineHeight)*SCREEN_11,paint);
        canvas.drawText(VeryBit,ColumnWidth*SCREEN_11,(Ttop+LineHeight)*SCREEN_11,paint);

//        paint.setColor(Color.WHITE);
//        canvas.drawText("方法"+w1+":",ColumnWidth*SCREEN_11,(Ttop+2*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way1),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+2*LineHeight)*SCREEN_11,paint);
//        canvas.drawText("方法"+w2+":",ColumnWidth*SCREEN_11,(Ttop+3*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way2),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+3*LineHeight)*SCREEN_11,paint);
//        canvas.drawText("方法"+w3+":",ColumnWidth*SCREEN_11,(Ttop+4*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way3),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+4*LineHeight)*SCREEN_11,paint);
//        canvas.drawText("方法"+w4+":",ColumnWidth*SCREEN_11,(Ttop+5*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way4),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+5*LineHeight)*SCREEN_11,paint);
//        canvas.drawText("方法"+w5+":",ColumnWidth*SCREEN_11,(Ttop+6*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way5),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+6*LineHeight)*SCREEN_11,paint);
//        canvas.drawText("方法"+w6+":",ColumnWidth*SCREEN_11,(Ttop+7*LineHeight)*SCREEN_11,paint);
//        canvas.drawText(String.valueOf(way6),(ColumnWidth+4*textSize)*SCREEN_11,(Ttop+7*LineHeight)*SCREEN_11,paint);

//        canvas.drawText(face,Tleft*SCREEN_11,(Ttop+6.5f*LineHeight)*SCREEN_11,paint);

    }

    public void setScreenHeight(int ScreenHeight){
        this.SCREEN_11 = ScreenHeight/11.0f;
    }
    public void setScreenWidth(int ScreenWidth){
        this.ScreenWidth = ScreenWidth;
    }

    public void setAD(int AD) {
        this.AD = AD;
    }
    public int getAD(){
        return AD;
    }
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }
    public int getDEF(){
        return DEF;
    }
    public void setHP(float HP) {
        this.HP = HP;
    }
    public float getHP(){
        return HP;
    }
    public void setGOLD(int gold){ this.GOLD = gold; }
    public int getGOLD(){ return  GOLD; }
    public void setBLOOD(int blood){this.BLOOD =blood;}
    public int getBLOOD(){return BLOOD;}
    public void setVERYBIT(int verybit){this.VERYBIT = verybit;}
    public int getVERYBIT(){return VERYBIT;}


    public void setKeyYnum(int setKY){
        this.keyYnum = setKY;
    }
    public int getKeyYnum(){
        return keyYnum;
    }
    public void setToolShow(String kind){
        switch (kind){
            case("ad_1"):
                AD_1 = true;
                break;
            case("def_1"):
                DEF_1 = true;
                break;
            case("ad_2"):
                AD_2 = true;
                break;
            case("def_2"):
                DEF_2 = true;
                break;
        }
        this.invalidate();
    }
    public boolean getIfOwn(int sort){
        return ownTool[sort];
    }
    public void setKeyBnum(int setKB){
        this.keyBnum = setKB;
    }
    public int getKeyBnum(){
        return keyBnum;
    }
    public void setKeyRnum(int setKR){
        this.keyRnum = setKR;
    }
    public int getKeyRnum(){
        return keyRnum;
    }
    public void setFloorNumber(String x){this.floorNumber = x;}
    public void setTOOLS(int sort){
        if(sort==1)monsterHandBook = true;
        else if(sort==2)floorChanger = true;
        else if(sort==3){glove1 = true;glove2 = false;}
        else if(sort==4){glove2 = true;glove1 = false;}

        invalidate();}
    public boolean getTOOLSown(int sort){
        if(sort==1)return monsterHandBook;
        else if(sort==2)return floorChanger;
        else if(sort==3)return  glove1;
        else if(sort==4)return  glove2;
    return false;}
    public void setHaveReach(boolean[] a){
        haveReach = a;
    }
    public boolean getHaveReach(int floor) {
        return haveReach[floor];
    }
}
