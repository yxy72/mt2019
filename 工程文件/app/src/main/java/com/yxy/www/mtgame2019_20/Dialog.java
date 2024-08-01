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
import android.view.ViewStub;


public class Dialog extends View {




    private static float SCREEN_11;
    float NameTextSize;
    int monsterSum = 24;
    String m[] = new String[monsterSum];

    String MonsterInfmation[][] = new String[monsterSum][4],mosTemp[] = new String[4];
    String canvasMonsterInfmation[][] = new String [monsterSum][5];

    com.yxy.www.mtgame2019_20.informationView play;
    private float nameWidth;

    boolean BaoJiShow = false;
    String fightWithWho;

    int nowMonsterHp = 0;
    float nowPlayerHp = 0;
    String monsLoseHp = "";
    String plaLoseHp = "";
    String playerGetHpFromMons = "";

    String npcName = "";
    String npcWords1 = "";
    String npcWords2 ="";

    private String musicSwitchContent = "";
    private int moveY = 0;



    Boolean show = false;

    String kind;

    Paint paint = new Paint();
    public Dialog(Context context, AttributeSet attrs){
        super(context,attrs);
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
        m[1]="m1";m[2]="m2";m[3]="m3";m[4]="m4";m[5]="m5";m[6]="m6";m[7]="m7";m[8]="m8";m[9]="m9";m[10]="m10";m[11]="m11";m[12]="m12";m[13]="m13";m[14]="m14";m[15]="m15";m[16]="m16";m[17]="m17";m[18]="m18";m[19]="m19";m[20]="m20";m[21]="m21";m[22]="m22";m[23]="m23";


    }
    Bitmap dialog = BitmapFactory.decodeResource(getResources(),R.drawable.dialog);
    Bitmap npc = BitmapFactory.decodeResource(getResources(),R.drawable.npc);
    Bitmap boss1 = BitmapFactory.decodeResource(getResources(),R.drawable.m10);
    Bitmap boss2 = BitmapFactory.decodeResource(getResources(),R.drawable.m20);
    Bitmap merchant = BitmapFactory.decodeResource(getResources(),R.drawable.merchant);
    Bitmap thief = BitmapFactory.decodeResource(getResources(),R.drawable.thief);
    Bitmap girl = BitmapFactory.decodeResource(getResources(),R.drawable.girl);
    Bitmap eif = BitmapFactory.decodeResource(getResources(),R.drawable.eif);


    Bitmap NpcClass = BitmapFactory.decodeResource(getResources(),R.drawable.npc);


    Bitmap dialog_little = BitmapFactory.decodeResource(getResources(),R.drawable.dialog_little);
    Bitmap fightProcess = BitmapFactory.decodeResource(getResources(),R.drawable.fight_process);
    Bitmap player = BitmapFactory.decodeResource(getResources(),R.drawable.player);

    Bitmap Bm[]= new Bitmap[monsterSum],bmTemp;

//    Bitmap canvasBm[]= new Bitmap[9];

    Bitmap fire= BitmapFactory.decodeResource(getResources(),R.drawable.fire);
    Bitmap floorChange = BitmapFactory.decodeResource(getResources(),R.drawable.floor_change);







    Bitmap Null = BitmapFactory.decodeResource(getResources(),R.drawable.png);
    Bitmap vs =BitmapFactory.decodeResource(getResources(),R.drawable.vs);

    Bitmap monsWho= Null;



    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);

        paint.setAntiAlias(true);
        if (kind == "fightProcess")
        {
            canvas.drawBitmap(setBitmap(fightProcess, 10, 6), 2 * SCREEN_11, 2.5f * SCREEN_11, paint);
            canvas.drawBitmap(setBitmap(vs, 2, 2), 6.25f * SCREEN_11, 4.5f * SCREEN_11, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(0.5f * SCREEN_11);
            canvas.drawText("Hp", 4f * SCREEN_11, 4f * SCREEN_11, paint);
            canvas.drawText("Hp", 9.25f * SCREEN_11, 4f * SCREEN_11, paint);
            canvas.drawText("攻击", 3f * SCREEN_11, 6.5f * SCREEN_11, paint);
            canvas.drawText("防御", 3f * SCREEN_11, 7.5f * SCREEN_11, paint);
            canvas.drawText("攻击", 10f * SCREEN_11, 6.5f * SCREEN_11, paint);
            canvas.drawText("防御", 10f * SCREEN_11, 7.5f * SCREEN_11, paint);
            canvas.drawBitmap(setBitmap(player, 1, 1), 10 * SCREEN_11, 3.5f * SCREEN_11, paint);
            canvas.drawText(String.valueOf(play.getAD()), 9f * SCREEN_11, 6.5f * SCREEN_11, paint);
            canvas.drawText(String.valueOf(play.getDEF()), 9f * SCREEN_11, 7.5f * SCREEN_11, paint);
            for (int i = 1; i <= monsterSum - 1; i++) {
                if (fightWithWho == m[i]) {
                    monsWho = Bm[i];
                    canvas.drawText(MonsterInfmation[i][0], 4.5f * SCREEN_11, 6.5f * SCREEN_11, paint);
                    canvas.drawText(MonsterInfmation[i][1], 4.5f * SCREEN_11, 7.5f * SCREEN_11, paint);
                    break;
                }
            }
            paint.setColor(Color.WHITE);
            paint.setTextSize(0.75f * SCREEN_11);
            canvas.drawBitmap(setBitmap(monsWho, 1, 1), 3 * SCREEN_11, 3.5f * SCREEN_11, paint);
            canvas.drawText(String.valueOf(nowMonsterHp), 4.5f * SCREEN_11, 5.25f * SCREEN_11, paint);
            canvas.drawText(String.valueOf((int) nowPlayerHp), 8.7f * SCREEN_11, 5.25f * SCREEN_11, paint);
            paint.setColor(Color.RED);
            canvas.drawText(plaLoseHp, 8.25f * SCREEN_11, 4.5f * SCREEN_11, paint);
            paint.setColor(Color.GREEN);
            canvas.drawText(playerGetHpFromMons, 9.25f * SCREEN_11, 4.5f * SCREEN_11, paint);
            float baojiX = 6.5f;
            if (BaoJiShow) {
                paint.setColor(Color.rgb(240, 90, 0));
                canvas.drawBitmap(setBitmap(fire, 0.4f, 0.6f), baojiX * SCREEN_11, 3.9f * SCREEN_11, paint);
            } else {
                paint.setColor(Color.RED);
            }
            canvas.drawText(monsLoseHp, (baojiX - 1.25f) * SCREEN_11, 4.5f * SCREEN_11, paint);
        }else if (kind == "dialog") {
            canvas.drawBitmap(setBitmap(dialog, 12, 3), 0.5f * SCREEN_11, 7.5f * SCREEN_11, paint);
            canvas.drawBitmap(setBitmap(dialog_little, 1, 1), 0.5f * SCREEN_11, 6.5f * SCREEN_11, paint);
            canvas.drawBitmap(setBitmap(dialog_little, nameWidth, 1), 1.6f * SCREEN_11, 6.5f * SCREEN_11, paint);
            paint.setTextSize(SCREEN_11);
            canvas.drawBitmap(setBitmap(NpcClass, 1, 1), 0.5f * SCREEN_11, 6.5f * SCREEN_11, paint);

            paint.setTextSize(NameTextSize);
            paint.setColor(Color.GRAY);
            canvas.drawText(npcName, 1.9f * SCREEN_11, 7.25f * SCREEN_11, paint);

            paint.setTextSize(0.4f * SCREEN_11);
            paint.setColor(Color.rgb(50, 50, 50));
            canvas.drawText(npcWords1, 1.5f * SCREEN_11, 8.5f * SCREEN_11, paint);
            canvas.drawText(npcWords2, 1.5f * SCREEN_11, 9f * SCREEN_11, paint);


            paint.setARGB(255, 168, 168, 168);
            paint.setTextSize(0.35f * SCREEN_11);
            canvas.drawText("触摸对话框继续...", 9.0f *SCREEN_11, 10f * SCREEN_11, paint);
        } else if (kind == "mons_inf") {
            canvas.drawBitmap(setBitmap(dialog, 15, 7), 1 * SCREEN_11, 2 * SCREEN_11, paint);
//            int tempSort=1;
//            for(int i=1;i<monsterSum;i++){
//                if(y[i]){
//                    canvasBm[tempSort] = Bm[i];
//                    System.arraycopy(MonsterInfmation[i], 0, canvasMonsterInfmation[tempSort], 0, 4);
//                    tempSort++;
//                }
//            }
//            tempSort -= 1;
//
//            int cannotSort = tempSort;
//            for(int i=1;i<=cannotSort;i++) {
//                if (!calculateAbsolutelyIfCanKill(i, play)) {
//
//                    bmTemp = canvasBm[i];
//                    System.arraycopy(canvasMonsterInfmation[i], 0, mosTemp, 0, 4);
//
//                    for(int j=i;j<=cannotSort-1;j++){
//                        canvasBm[j] = canvasBm[j+1];
//                        System.arraycopy(canvasMonsterInfmation[j + 1], 0, canvasMonsterInfmation[j], 0, 4);
//                    }
//
//                    canvasBm[cannotSort]=bmTemp;
//                    System.arraycopy(mosTemp, 0, canvasMonsterInfmation[cannotSort], 0, 4);
//                    cannotSort--;
//                }
//            }
//
//            for(int i=0;i<tempSort - 1 ;i++){
//                for(int j=1;j<tempSort+1 - i -1 ;j++){
//                    if( calculateAbsolutelyIfCanKill(j,play)&&calculateAbsolutelyIfCanKill(j+1,play) && damageForMonsterHandBook(j,play)>damageForMonsterHandBook(j+1,play)){
//                        bmTemp = canvasBm[j];
//                        canvasBm[j] = canvasBm[j+1];
//                        canvasBm[j+1] = bmTemp;
//
//                        for(int k=0;k<4;k++){
//                            mosTemp[k] = canvasMonsterInfmation[j][k];
//                            canvasMonsterInfmation[j][k] = canvasMonsterInfmation[j+1][k];
//                            canvasMonsterInfmation[j+1][k] = mosTemp[k];
//
//                        }
//                    }
//                }
//            }
//
//            for(int i=1;i<=tempSort;i++){
//                setMonsterInfmation(paint, canvas, i, canvasBm[i], play, 2, 1.5f+i, 3.2f, 2.2f+i);
//            }
//            boolean none = true;
//            for (int i = 1; i <= monsterSum - 1; i++) {
//                if (y[i]) {
//                    none = false;
//                    break;
//                }
//            }
//            if (none) {
//                paint.setColor(Color.GRAY);
//                paint.setAntiAlias(true);
//                paint.setTextSize(0.9f * SCREEN_11);
//                canvas.drawText("本层怪物已清空!", 5.4f * SCREEN_11, 5.8f * SCREEN_11, paint);
//            }
        } else if (kind == "musicSwitch") {
            paint.setColor(Color.WHITE);
            canvas.drawBitmap(setBitmap(fightProcess, 2, 1), 0 * SCREEN_11, 0 * SCREEN_11, paint);
            paint.setTextSize(0.5f * SCREEN_11);
            canvas.drawText(musicSwitchContent, 0.5f * SCREEN_11, 0.6f * SCREEN_11, paint);
        } else if (kind == "") {

        }
    }


    public static void setScreenHeight(int ScreenHeight){
        Dialog.SCREEN_11 = ScreenHeight/11.0f;
    }
    public void setPlayerGetHpFromMons(String x){this.playerGetHpFromMons = x ;}
    public void setKind(String kind){
        this.kind = kind;
    }
    public void setMonsterInfmation(String infmation[][]){

        System.arraycopy(infmation, 1, this.MonsterInfmation, 1, monsterSum - 1);
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
    public void setPlay(informationView play){
        this.play = play;
    }
    public void setFightWithWho(String x){
        this.fightWithWho = x;
    }
    public void setNowPlayerHp(float x){ this.nowPlayerHp =x;}
    public void setNowMonsterHp(int x){ this.nowMonsterHp =x; }
    public float getNowPlayerHp(){return nowPlayerHp;}
    public int getNowMonsterHp(){return nowMonsterHp;}
    public void setmosLoseHp(String x){ this.monsLoseHp =x;;}
    public void setplaLoseHp(String y){this.plaLoseHp = y;}
    public void setBaoJiShow(boolean x){this.BaoJiShow = x;}
    public void setNpcNameAndSaying(String npcName,String npcWords1,String npcWords2){this.npcName = npcName;this.npcWords1 = npcWords1;this.npcWords2 = npcWords2;}
    public void setNameWidth(float nameWidth){this.nameWidth = nameWidth;}

    public void setMusicSwitchContent(String x){this.musicSwitchContent = x;}
    public String getMusicSwitchContent(){return musicSwitchContent;}
    public void setNpcImage(String x) {
        switch (x) {
            case ("npc"):
                this.NpcClass = npc;
                break;
            case ("boss1"):
                this.NpcClass = boss1;break;
            case "boss2":
                NpcClass = boss2;break;
            case ("merchant"):
                this.NpcClass = merchant;break;
            case "thief":
                this.NpcClass = thief;break;
            case "girl":
                NpcClass = girl;break;
            case "eif":
                NpcClass = eif;break;
        }

    }
    public void setNameTextSize(float x){
        this.NameTextSize = x;
    }
    public boolean calculateIfCanKill(int sort,informationView player) {

        if(player.getAD()<= Integer.parseInt(canvasMonsterInfmation[sort][1])){ return false;}
        else if(player.getDEF()>=Integer.parseInt(canvasMonsterInfmation[sort][0])){return true;}
        else {
            int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
            if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0) timeKillMonster += 1;
            int timeKillPlayer = (int)player.getHP() / (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF());
            if (player.getHP() % (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) > 0) timeKillPlayer += 1;
            return timeKillMonster<=timeKillPlayer;
        }
    }

    private boolean calculateAbsolutelyIfCanKill(int sort,informationView player){
        return player.getAD() > Integer.parseInt(canvasMonsterInfmation[sort][1]);
    }


    public int damageForMonsterHandBook(int sort,informationView player){
        int timeKillMonster = Integer.parseInt(canvasMonsterInfmation[sort][2]) / (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1]));
        if (Integer.parseInt(canvasMonsterInfmation[sort][2]) % (player.getAD() - Integer.parseInt(canvasMonsterInfmation[sort][1])) > 0) timeKillMonster += 1;
        int damage ;
        if(player.getDEF()>=Integer.parseInt(canvasMonsterInfmation[sort][0])||  (player.getAD()>=Integer.parseInt(canvasMonsterInfmation[sort][1])+Integer.parseInt(canvasMonsterInfmation[sort][2]))   ){damage = 0;}
        else {damage = (Integer.parseInt(canvasMonsterInfmation[sort][0]) - player.getDEF()) * (timeKillMonster-1);}
        return damage;
    }


    public Paint setPaintColor(Paint paint,informationView play,int sort){
        if(calculateIfCanKill(sort,play)&&( (play.getAD()>= Integer.parseInt(canvasMonsterInfmation[sort][1])+Integer.parseInt(canvasMonsterInfmation[sort][2]))||play.getDEF()>=Integer.parseInt(canvasMonsterInfmation[sort][0]))) {
            paint.setColor(Color.rgb(5,219,0));
        }
        else {
            paint.setColor(Color.RED);
        }
        return paint;
    }
    public  String damageOutPut(int sort,informationView player){
        if(calculateIfCanKill(sort,player))
        {
            return String.valueOf(damageForMonsterHandBook(sort,player));
        }
        else {
            if (play.getAD() <= Integer.parseInt(canvasMonsterInfmation[sort][1])) {
                return "打不赢哦";
            }
            else {
                return (String.valueOf(damageForMonsterHandBook(sort,player))+"！");
            }
        }
    }
    public void setMonsterInfmation(Paint paint,Canvas canvas,int sort,Bitmap Bmonster,informationView play,float Bleft,float Btop,float layX,float layY) {
        paint.setTextSize(0.4f*SCREEN_11);
        paint.setColor(Color.BLACK);

        canvas.drawBitmap(setBitmap(Bmonster,1,1), Bleft * SCREEN_11, Btop * SCREEN_11 + moveY, paint);
        canvas.drawText("攻击：", layX * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][0], (layX+1.2f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText("防御：", (layX+2.2f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][1], (layX+3.4f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText("生命：", (layX+4.4f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][2], (layX+5.6f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText("金币：", (layX+6.6f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText(canvasMonsterInfmation[sort][3], (layX+7.8f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        canvas.drawText("伤害：", (layX+8.8f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);
        paint = setPaintColor(paint,play,sort);
        canvas.drawText(damageOutPut(sort,play), (layX+10f) * SCREEN_11, layY * SCREEN_11+ moveY, paint);

    }
    public void setMoveY(int y){
        this.moveY = y;

    }

}
