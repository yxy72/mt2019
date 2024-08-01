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

public class notice_window extends View {
    public notice_window(Context context, AttributeSet attrs){
        super(context,attrs);
        m[1]="m1";m[2]="m2";m[3]="m3";m[4]="m4";m[5]="m5";m[6]="m6";m[7]="m7";m[8]="m8";m[9]="m9";m[10]="m10";m[11]="m11";m[12]="m12";m[13]="m13";m[14]="m14";m[15]="m15";m[16]="m16";m[17]="m17";m[18]="m18";m[19]="m19";m[20]="m20";m[21]="m21";m[22]="m22";m[23]="m23";
        paint = new Paint();
    }
    private int monsterSum = 24;
    private Paint paint;
    private String m[] = new String[monsterSum];
    private String MonsterInfmation[][] = new String[monsterSum][];
    private void KuangOutPut(Paint paint,Canvas canvas,String kind,float layX){
        String information = "";
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        switch (kind){
            case("ad"):information="获得红宝石，攻击力+2";break;
            case("def"):information="获得蓝宝石，防御力+2";break;
            case("rhp"):information="获得小血瓶，生命值+200";break;
            case("bhp"):information="获得大血瓶，生命值+400";break;
            case("mons_inf"):information="获得怪物图鉴。";break;
            case("floorChanger"):information="获得楼层传送器。";layX-=0.3f;break;
            case("glove"):information="获得无限手套(消耗品)，选中以使用。";layX-=1.5f;break;
            case("wall_break"):information="获得破墙镐，选中以使用。";layX-=1f;break;
            case("atsp"):information="楼层传送器不给用。";;break;
            case ("!reach"):information= "还没有到达过该楼层。";layX+=0.5f;break;

            case("yk"):information="获得黄钥匙。";break;
            case("bk"):information="获得蓝钥匙。";break;
            case("rk"):information="获得红钥匙。";break;
            case("cannot"):information="打不赢哦！";layX+=1.0f;break;
            case("hp"):information="血量不够。";layX+=1.0f;break;
            case("door"):information="没钥匙，打不开";break;
            case ("blood_1"):information= "获得长剑，攻击力+5";break;
            case ("blood_2"):information= "获得吸血鬼节杖，生命偷取+10%";break;
            case ("blood_3"):information= "合成十字镐，攻击力+25";layX+=0.4f;break;

            case ("redundantBlood_2"):information= "获得了多余的吸血鬼节杖。";break;
            case ("redundantBlood_3"):information= "获得了多余的十字镐。";layX+=0.4;break;

            case ("baoji_1"):information= "获得格斗手套，暴击率+4%";break;
            case ("baoji_2"):information= "获得短剑，暴击率+2%";break;
            case ("baoji_3"):information= "获得【狂热】，暴击率+15%";break;
            case ("baoji_3CREATE"):information= "合成【狂热】，暴击率提升至15%";break;
            case ("blood_3CREATE"):information= "合成【十字镐】，攻击力提升25";break;

            case ("redundantBaoji_3"):information= "获得了多余的【狂热】。";break;
            case ("little_gold"):information= "获得50金币。";layX+=0.9f;break;

            case ("ad_1"):information= "获得铁剑，攻击力+10";break;
            case ("ad_2"):information= "获得银剑，攻击力+20";break;

            case ("def_1"):information= "获得铁盾，防御力+10";break;
            case ("def_2"):information= "获得银盾，防御力+20";break;

            default:
                for(int i =1;i<=monsterSum-1;i++){
                if(kind == m[i]){
                    layX-=0.6f;
                    information = "战斗胜利！获得"+MonsterInfmation[i][3]+"金币。";
                    break;
                }
            }
        }
        paint.setTextSize(0.6f*(float)ScreenHeight/11.0f);
        canvas.drawText(information, layX * ScreenHeight * AREA_y_ratio, 5.5f * ScreenHeight * AREA_y_ratio, paint);
    }

    private int ScreenHeight = 720;
    private float AREA_y_ratio = (float) 1 / 11.0f;
    private String kind = "";




    private Bitmap Kuang_tool = BitmapFactory.decodeResource(getResources(), R.drawable.notice_window);


    private Bitmap kuangFitScreen(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = 15*ScreenHeight / 11.0f / width;
        float scaleHeight = 2*ScreenHeight / 11.0f / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }


    public void onDraw(Canvas canvas) {
            canvas.drawBitmap(kuangFitScreen(Kuang_tool), 1f * AREA_y_ratio * ScreenHeight, 4.5f * AREA_y_ratio * ScreenHeight, paint);
            switch (kind) {
                case ("ad"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("def"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("rhp"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("bhp"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("mons_inf"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("yk"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("bk"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("rk"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("cannot"):KuangOutPut(paint,canvas,kind,6);break;
                case ("hp"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("door"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("blood_1"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("blood_2"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("blood_3"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("redundantBlood_2"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("redundantBlood_3"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("baoji_1"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("baoji_2"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("baoji_3"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("baoji_3CREATE"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("blood_3CREATE"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("redundantBaoji_3"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("little_gold"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("floorChanger"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("glove"):KuangOutPut(paint,canvas,kind,6f);break;
                case ("wall_break"):KuangOutPut(paint,canvas,kind,6f);break;

                case ("atsp"):KuangOutPut(paint,canvas,kind,6f);break;


                case ("ad_1"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("ad_2"):KuangOutPut(paint,canvas,kind,5f);break;

                case ("def_1"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("def_2"):KuangOutPut(paint,canvas,kind,5f);break;
                case ("!reach"):KuangOutPut(paint,canvas,kind,5f);break;

                default:
                    for(int i =1;i<=monsterSum-1;i++){
                        if (kind==m[i]){KuangOutPut(paint,canvas,kind,6f);break;}
                    }
            }


    }

    public void setScreenHeight(int screenHeight){
        this.ScreenHeight = screenHeight;
    }
    public void setKind(String kind){
        this.kind = kind;
    }
    public void setMonsterInfmation(String infmation[][]){
        this.MonsterInfmation = infmation;
    }


}