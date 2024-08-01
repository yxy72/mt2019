package com.yxy.www.mtgame2019_20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class staticEventOnDraw extends View {


    private static float SCREEN_11=72;
    private Bitmap bitmap[][] = new Bitmap[11][11];
    private String event1[][] = new String[11][14];
    private float x=1,y=1;
    private Paint paint;


    private Bitmap Null = BitmapFactory.decodeResource(getResources(),R.drawable.png);
    private Bitmap wall = BitmapFactory.decodeResource(getResources(),R.drawable.wall2);
    private Bitmap up = BitmapFactory.decodeResource(getResources(),R.drawable.up);
    private Bitmap down = BitmapFactory.decodeResource(getResources(),R.drawable.down);

    private Bitmap ad = BitmapFactory.decodeResource(getResources(),R.drawable.ad);
    private Bitmap def = BitmapFactory.decodeResource(getResources(),R.drawable.def);
    private Bitmap rhp = BitmapFactory.decodeResource(getResources(),R.drawable.rhp1);
    private Bitmap bhp = BitmapFactory.decodeResource(getResources(),R.drawable.bhp1);
    private Bitmap ky = BitmapFactory.decodeResource(getResources(),R.drawable.key_y);
    private Bitmap kb = BitmapFactory.decodeResource(getResources(),R.drawable.key_b);
    private Bitmap kr = BitmapFactory.decodeResource(getResources(),R.drawable.key_r);

    private Bitmap ad_1 = BitmapFactory.decodeResource(getResources(),R.drawable.ad_1);
    private Bitmap ad_2 = BitmapFactory.decodeResource(getResources(),R.drawable.ad_2);
    private Bitmap def_1 = BitmapFactory.decodeResource(getResources(),R.drawable.def_1);
    private Bitmap def_2 = BitmapFactory.decodeResource(getResources(),R.drawable.def_2);
    private Bitmap blood_1 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_1);
    private Bitmap blood_2 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_2);
    private Bitmap blood_3 = BitmapFactory.decodeResource(getResources(),R.drawable.blood_3);
    private Bitmap baoji_1 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_1);
    private Bitmap baoji_2 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_2);
    private Bitmap baoji_3 = BitmapFactory.decodeResource(getResources(),R.drawable.baoji_3);

    private Bitmap glove = BitmapFactory.decodeResource(getResources(),R.drawable.glove);
    private Bitmap wall_break = BitmapFactory.decodeResource(getResources(),R.drawable.wall_break);
    private Bitmap szj = BitmapFactory.decodeResource(getResources(),R.drawable.szj);

    private Bitmap dy = BitmapFactory.decodeResource(getResources(),R.drawable.door_y);
    private Bitmap db = BitmapFactory.decodeResource(getResources(),R.drawable.door_b);
    private Bitmap dr = BitmapFactory.decodeResource(getResources(),R.drawable.door_r);
    private Bitmap de = BitmapFactory.decodeResource(getResources(),R.drawable.door_event);
    private Bitmap dz = BitmapFactory.decodeResource(getResources(),R.drawable.door_zhalan1);
    private Bitmap shopleft = BitmapFactory.decodeResource(getResources(),R.drawable.shopleft);
    private Bitmap shopright = BitmapFactory.decodeResource(getResources(),R.drawable.shopright);
    private Bitmap tiejiangpu = BitmapFactory.decodeResource(getResources(),R.drawable.tiejiangpu);
    private Bitmap floorChanger = BitmapFactory.decodeResource(getResources(), R.drawable.floor_tool_change);

    private Bitmap little_gold = BitmapFactory.decodeResource(getResources(),R.drawable.little_gold);




    public staticEventOnDraw(Context context, AttributeSet attrs){
        super(context,attrs);

        for(int i=0;i<11;i++){
            for(int j = 0;j<11;j++){
                bitmap[i][j] = Null;
                event1[i][j]="";
            }
        }
        paint = new Paint();
    }


    private Bitmap getbitmap(Bitmap bitmap){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = x*SCREEN_11/width + 0.005f;
        float scaleHeight = y*SCREEN_11/height+ 0.005f;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,true);
        return newbm;
    }

    public void onDraw(Canvas canvas) {
        setBitmap();
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++) {
                if(event1[i][j].equals("wall")||event1[i][j].equals("wallE")||event1[i][j].equals("szjWALL")){
                    canvas.drawBitmap(getbitmap(wall), i * SCREEN_11, j * SCREEN_11, paint);
                }
                else{
                    canvas.drawBitmap(getbitmap(bitmap[i][j]), i * SCREEN_11, j * SCREEN_11, paint);

                }


            }
        }
        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                if (event1[i][j] == "smithy") {
                    x = 2.175f;
                    y = 3;
                    canvas.drawBitmap(getbitmap(tiejiangpu), (i - 0.62f) * SCREEN_11, (j - 2) * SCREEN_11, paint);
                    x = y = 1;
                    break;
                }
            }
        }
    }



    public void setScreenHeight(int ScreenHeight){
        staticEventOnDraw.SCREEN_11 = ScreenHeight/11.0f;
    }

    public void setEvent(String[][] a){
        this.event1 = a;
        setBitmap();
        this.invalidate();
    }
    public void setBitmap(){
        for(int i=0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(event1[i][j]=="ad")
                    bitmap[i][j]=ad;
                else if(event1[i][j]=="def")
                    bitmap[i][j]=def;
                else if(event1[i][j]=="rhp")
                    bitmap[i][j]=rhp;
                else if(event1[i][j]=="bhp")
                    bitmap[i][j]=bhp;
                else if(event1[i][j]=="bhp")
                    bitmap[i][j]=bhp;
                else if(event1[i][j]=="ky")
                    bitmap[i][j]=ky;
                else if(event1[i][j]=="kb")
                    bitmap[i][j]=kb;
                else if(event1[i][j]=="kr")
                    bitmap[i][j]=kr;
                else if(event1[i][j]=="ad_1")
                    bitmap[i][j]=ad_1;
                else if(event1[i][j]=="ad_2")
                    bitmap[i][j]=ad_2;
                else if(event1[i][j]=="def_1")
                    bitmap[i][j]=def_1;
                else if(event1[i][j]=="def_2")
                    bitmap[i][j]=def_2;
                else if(event1[i][j]=="blood_1")
                    bitmap[i][j]=blood_1;
                else if(event1[i][j]=="blood_2")
                    bitmap[i][j]=blood_2;
                else if(event1[i][j]=="blood_3")
                    bitmap[i][j]=blood_3;
                else if(event1[i][j]=="baoji_1")
                    bitmap[i][j]=baoji_1;
                else if(event1[i][j]=="baoji_2")
                    bitmap[i][j]=baoji_2;
                else if(event1[i][j]=="baoji_3")
                    bitmap[i][j]=baoji_3;
                else if(event1[i][j]=="dy")
                    bitmap[i][j]=dy;
                else if(event1[i][j]=="db")
                    bitmap[i][j]=db;
                else if(event1[i][j]=="dr")
                    bitmap[i][j]=dr;
                else if(event1[i][j]=="de1"||event1[i][j]=="de2"||event1[i][j]=="specialDoor1"||event1[i][j]=="specialDoor2")
                    bitmap[i][j]=de;
                else if(event1[i][j]=="dz")
                    bitmap[i][j]=dz;
                else if(event1[i][j]=="shopleft")
                    bitmap[i][j]=shopleft;
                else if(event1[i][j]=="shopright")
                    bitmap[i][j]=shopright;
                else if(event1[i][j]=="little_gold")
                    bitmap[i][j]=little_gold;
                else if(event1[i][j]=="wall")
                    bitmap[i][j]=wall;
                else if(event1[i][j]=="up")
                    bitmap[i][j]=up;
                else if(event1[i][j]=="down")
                    bitmap[i][j]=down;
                else if(event1[i][j]=="floorChanger")
                    bitmap[i][j]=floorChanger;
                else if(event1[i][j]=="glove")
                    bitmap[i][j]=glove;
                else if(event1[i][j].equals("wall_break"))
                    bitmap[i][j]=wall_break;
                else if(event1[i][j].equals("szj"))
                    bitmap[i][j]=szj;
                else bitmap[i][j] = Null;
            }
        }


    }


}