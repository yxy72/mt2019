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

public class MonsterInformation extends View {
    private static float SCREEN_11 = 500;
    private Paint paint;
    private int monsterSum = 24;
    private String MonsterInfmation[][] = new String[monsterSum][5],mosTemp[] = new String[5];
    private String canvasMonsterInfmation[][] = new String [monsterSum][5];
    private Bitmap canvasBm[]= new Bitmap[9];
    private Bitmap Bm[]= new Bitmap[monsterSum],bmTemp;
    private boolean y[] = new boolean[monsterSum];
    private informationView player;
    public int tempSort=1;
    public float startY = 0;
    public float nowY = 0;
    public float moveY = 0;
    private boolean ifOwnSZJ = false;

    public MonsterInformation(Context context, AttributeSet attrs) {
        super(context, attrs);
        Bm[1] = BitmapFactory.decodeResource(getResources(),R.drawable.m_1);
        Bm[2] = BitmapFactory.decodeResource(getResources(),R.drawable.m_2);
        Bm[3] = BitmapFactory.decodeResource(getResources(),R.drawable.m3);
        Bm[4] = BitmapFactory.decodeResource(getResources(),R.drawable.m4);
        Bm[5]= BitmapFactory.decodeResource(getResources(),R.drawable.m5);
        Bm[6]= BitmapFactory.decodeResource(getResources(),R.drawable.m6);
        Bm[7]= BitmapFactory.decodeResource(getResources(),R.drawable.m7);
        Bm[8]= BitmapFactory.decodeResource(getResources(),R.drawable.m8);
        Bm[9]= BitmapFactory.decodeResource(getResources(),R.drawable.m9);
        Bm[10]= BitmapFactory.decodeResource(getResources(),R.drawable.m10);
        Bm[11]= BitmapFactory.decodeResource(getResources(),R.drawable.m11);
        Bm[12]= BitmapFactory.decodeResource(getResources(),R.drawable.m12);
        Bm[13]= BitmapFactory.decodeResource(getResources(),R.drawable.m13);
        Bm[14]= BitmapFactory.decodeResource(getResources(),R.drawable.m14);
        Bm[15]= BitmapFactory.decodeResource(getResources(),R.drawable.m15);
        Bm[16]= BitmapFactory.decodeResource(getResources(),R.drawable.m16);
        Bm[17]= BitmapFactory.decodeResource(getResources(),R.drawable.m17);
        Bm[18]= BitmapFactory.decodeResource(getResources(),R.drawable.m18);
        Bm[19]= BitmapFactory.decodeResource(getResources(),R.drawable.m19);
        Bm[20]= BitmapFactory.decodeResource(getResources(),R.drawable.m20);
        Bm[21]= BitmapFactory.decodeResource(getResources(),R.drawable.m21);
//        Bm[22]= BitmapFactory.decodeResource(getResources(),R.drawable.m22);
        Bm[23]= BitmapFactory.decodeResource(getResources(),R.drawable.m23);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    private Bitmap setBitmap(Bitmap bitmap,float w,float h){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = w*SCREEN_11/(float)width;
        float scaleHeight = h*SCREEN_11/(float)height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
    }
    public void onDraw(Canvas canvas) {

        tempSort = 1;
        for(int i=1;i<monsterSum;i++){
            if(y[i]){
                canvasBm[tempSort] = Bm[i];
                System.arraycopy(MonsterInfmation[i], 0, canvasMonsterInfmation[tempSort], 0, 5);
                tempSort++;
            }
        }
        tempSort -= 1;

        int cannotSort = tempSort;
        for(int i=1;i<=cannotSort;i++) {
            if (!calculateAbsolutelyIfCanKill(i)) {

                bmTemp = canvasBm[i];
                System.arraycopy(canvasMonsterInfmation[i], 0, mosTemp, 0, 5);

                for(int j=i;j<=cannotSort-1;j++){
                    canvasBm[j] = canvasBm[j+1];
                    System.arraycopy(canvasMonsterInfmation[j + 1], 0, canvasMonsterInfmation[j], 0, 5);
                }

                canvasBm[cannotSort]=bmTemp;
                System.arraycopy(mosTemp, 0, canvasMonsterInfmation[cannotSort], 0, 5);
                cannotSort--;
            }
        }

        for(int i=0;i<tempSort - 1 ;i++){
            for(int j=1;j<tempSort+1 - i -1 ;j++){
                if( calculateAbsolutelyIfCanKill(j)&&calculateAbsolutelyIfCanKill(j+1) && damageForMonsterHandBook(j)>damageForMonsterHandBook(j+1)){
                    bmTemp = canvasBm[j];
                    canvasBm[j] = canvasBm[j+1];
                    canvasBm[j+1] = bmTemp;

                    for(int k=0;k<5;k++){
                        mosTemp[k] = canvasMonsterInfmation[j][k];
                        canvasMonsterInfmation[j][k] = canvasMonsterInfmation[j+1][k];
                        canvasMonsterInfmation[j+1][k] = mosTemp[k];

                    }
                }
            }
        }

        for(int i=1;i<=tempSort;i++){
            setMonsterInfmation(paint, canvas, i, canvasBm[i], 0, -1f+i, 1.2f, -0.3f+i);
        }
        boolean none = true;
        for (int i = 1; i <= monsterSum - 1; i++) {
            if (y[i]) {
                none = false;
                break;
            }
        }
        if (none) {
            paint.setColor(Color.GRAY);
            paint.setAntiAlias(true);
            paint.setTextSize(0.9f * SCREEN_11);
            canvas.drawText("本层怪物已清空!", 3.4f * SCREEN_11, 2.8f * SCREEN_11, paint);
        }
    }
    public void setMonsterInfmation(Paint paint,Canvas canvas,int sort,Bitmap Bmonster,float Bleft,float Btop,float layX,float layY) {
        paint.setTextSize(0.4f*SCREEN_11);
        paint.setColor(Color.BLACK);



        canvas.drawBitmap(setBitmap(Bmonster,1,1), Bleft * SCREEN_11, Btop * SCREEN_11 + moveY + startY, paint);
        canvas.drawText("攻击：", layX * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][0], (layX+1.2f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText("防御：", (layX+2.2f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][1], (layX+3.4f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText("生命：", (layX+4.4f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][2], (layX+5.6f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText("金币：", (layX+6.6f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][3], (layX+7.8f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        canvas.drawText("伤害：", (layX+8.8f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);
        paint = setPaintColor(paint,sort);
        canvas.drawText(damageOutPut(sort), (layX+10f) * SCREEN_11, layY * SCREEN_11+ moveY+ startY, paint);

    }
    public void setMonsterInfmation(String infmation[][]){

        System.arraycopy(infmation, 0, this.MonsterInfmation, 0, monsterSum);
    }
    public Paint setPaintColor(Paint paint,int sort){
        if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20") )&& ifOwnSZJ)
        {
            if(calculateIfCanKill(sort)&&( (2*player.getAD()>= Integer.parseInt(canvasMonsterInfmation[sort][1])+Integer.parseInt(canvasMonsterInfmation[sort][2]))||player.getDEF()>=Integer.parseInt(canvasMonsterInfmation[sort][0]))) {
                paint.setColor(Color.rgb(5,219,0));
            }
            else {
                paint.setColor(Color.RED);
            }
        }
        else{
            if(calculateIfCanKill(sort)&&( (player.getAD()>= Integer.parseInt(canvasMonsterInfmation[sort][1])+Integer.parseInt(canvasMonsterInfmation[sort][2]))||player.getDEF()>=Integer.parseInt(canvasMonsterInfmation[sort][0]))) {
                paint.setColor(Color.rgb(5,219,0));
            }
            else {
                paint.setColor(Color.RED);
            }
        }



        if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20") )&& !ifOwnSZJ)
            this.paint.setColor(Color.RED);




        return paint;
    }
    public  String damageOutPut(int sort){
        if(calculateIfCanKill(sort)) {
            return String.valueOf(damageForMonsterHandBook(sort));
        }
        else {

            if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20") )&& ifOwnSZJ)
            {
                if (2*player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                    return "打不赢哦";
                }
                else {
                    return (String.valueOf(damageForMonsterHandBook(sort))+"！");
                }

            }else {
                if (player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                    return "打不赢哦";
                }
                else {
                    return (String.valueOf(damageForMonsterHandBook(sort))+"！");
                }

            }







        }
    }
    public boolean calculateIfCanKill(int sort) {


        if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20") )&& ifOwnSZJ){
            if (2*player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                return false;
            } else if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0])) {
                return true;
            } else {
                int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (2*player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
                if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (2*player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                    timeKillMonster += 1;
                int timeKillPlayer = (int) player.getHP() / (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF());
                if (player.getHP() % (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) > 0)
                    timeKillPlayer += 1;
                return timeKillMonster <= timeKillPlayer;
            }
        } else if (canvasMonsterInfmation[sort][4].equals("17") && !ifOwnSZJ) {
            if (player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                return false;
            } else if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0])) {
                return true;
            } else {
                int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
                if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                    timeKillMonster += 1;
                int timeKillPlayer = (int) (player.getHP() - 100) / (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF());
                if ((int) (player.getHP() - 100) % (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) > 0)
                    timeKillPlayer += 1;
                return timeKillMonster <= timeKillPlayer;
            }
        } else if (canvasMonsterInfmation[sort][4].equals("19") && !ifOwnSZJ) {
            if (player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                return false;
            } else if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0])) {
                return true;
            } else {
                int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
                if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                    timeKillMonster += 1;
                int timeKillPlayer = (int) (player.getHP() - (int) (player.getHP() / 10)) / (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF());
                if ((int) (player.getHP() - (int) (player.getHP() / 10)) % (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) > 0)
                    timeKillPlayer += 1;
                return timeKillMonster <= timeKillPlayer;
            }
        } else {
            if (player.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                return false;
            } else if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0])) {
                return true;
            } else {
                int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
                if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                    timeKillMonster += 1;
                int timeKillPlayer = (int) player.getHP() / (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF());
                if (player.getHP() % (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) > 0)
                    timeKillPlayer += 1;
                return timeKillMonster <= timeKillPlayer;
            }
        }


    }
    private boolean calculateAbsolutelyIfCanKill(int sort){
        if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20")) && ifOwnSZJ) {
            return 2*player.getAD() > Integer.parseInt(canvasMonsterInfmation[sort][1]);
        }
        return player.getAD() > Integer.parseInt(canvasMonsterInfmation[sort][1]);

    }
    public int damageForMonsterHandBook(int sort){
        int damage;
        if((canvasMonsterInfmation[sort][4].equals("17")||canvasMonsterInfmation[sort][4].equals("19")||canvasMonsterInfmation[sort][4].equals("20")) && ifOwnSZJ) {
            int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (2 * player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
            if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (2 * player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                timeKillMonster += 1;
            if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0]) || (2 * player.getAD() >= Integer.parseInt(canvasMonsterInfmation[sort][1]) + Integer.parseInt(canvasMonsterInfmation[sort][2]))) {
                damage = 0;
            } else {
                damage = (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) * (timeKillMonster - 1);
            }
            return damage;

        }else if(canvasMonsterInfmation[sort][4].equals("17")){
            int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
            if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                timeKillMonster += 1;
            if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0]) || (player.getAD() >= Integer.parseInt(canvasMonsterInfmation[sort][1]) + Integer.parseInt(canvasMonsterInfmation[sort][2]))) {
                damage = 100;
            } else {
                damage = 100 + (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) * (timeKillMonster - 1);
            }
            return damage;
        }else if(canvasMonsterInfmation[sort][4].equals("19")){
            int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
            if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                timeKillMonster += 1;
            if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0]) || (player.getAD() >= Integer.parseInt(canvasMonsterInfmation[sort][1]) + Integer.parseInt(canvasMonsterInfmation[sort][2]))) {
                damage = (int)(0.1*player.getHP());
            } else {
                damage = (int)(0.1*player.getHP()) + (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) * (timeKillMonster - 1);
            }
            return damage;
        } else {

            int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
            if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0)
                timeKillMonster += 1;
            if (player.getDEF() >= Integer.parseInt(canvasMonsterInfmation[sort][0]) || (player.getAD() >= Integer.parseInt(canvasMonsterInfmation[sort][1]) + Integer.parseInt(canvasMonsterInfmation[sort][2]))) {
                damage = 0;
            } else {
                damage = (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) * (timeKillMonster - 1);
            }
            return damage;

        }

    }
    public void setPlay(informationView play){
        this.player = play;
    }
    public void setYn(boolean set,int n){this.y[n]=set;}
    public static void setScreenHeight(int ScreenHeight) {
        MonsterInformation.SCREEN_11 = ScreenHeight/11.0f;
    }
    public void getSZJ(){
        ifOwnSZJ = true;
    }
}


