package com.yxy.www.mtgame2019_20;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.yxy.www.mtgame2019_20.LoadingClass;
import com.yxy.www.mtgame2019_20.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    private LoadingClass loading;
    private final int[] sort = {0};
    private Button b1,b2;
    private ImageView i1;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);//全屏

        DisplayMetrics WINDOW = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(WINDOW);
        int screenHeight = WINDOW.heightPixels;
        int screenWidth = WINDOW.widthPixels;


        i1= findViewById( R.id.imageView);
        b1 = findViewById(R.id.Start001);
        b2 = findViewById(R.id.Start002);


        int x = (int)(Math.random()*(4-0+1));



        loading = findViewById(R.id.loading);

        loading.setScreenHeight(screenHeight);
        loading.setMessage(x);


        ViewGroup.LayoutParams radio = loading.getLayoutParams();
        radio.width = (screenWidth);
        radio.height = (screenHeight);
        loading.setLayoutParams(radio);
        loading.setX(3.5f* screenWidth /11.0f);
        loading.setY(4* screenHeight /11.0f);
        loading.setVisibility(View.GONE);


        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case (14400):
                        startActivity(new Intent(MainActivity.this,MainGame.class));
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);break;
//                    case (14401):
//                        loading.setVisibility(View.VISIBLE);
//
//                        b1.setVisibility(View.GONE);b1.setClickable(false);
//                        b2.setVisibility(View.GONE);b2.setClickable(false);
//                        i1.setVisibility(View.GONE);break;
                }
            }
        };
    }
    public void Start001(View v){

        loading.setVisibility(View.VISIBLE);
        b1.setVisibility(View.INVISIBLE);b1.setClickable(false);
        b2.setVisibility(View.INVISIBLE);b2.setClickable(false);
        i1.setVisibility(View.INVISIBLE);
        Timer startTimer = new Timer();
        startTimer.schedule(new TimerTask() {
            @SuppressLint("PrivateResource")
            @Override
            public void run() {
//                startActivity(new Intent(MainActivity.this,MainGame.class));
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                handler.sendEmptyMessage(14400);
            }
        },1000);








    }
    public void Start002(View v){
        finish();
    }
    @Override
    protected void onResume() {
        /*
         * 设置为横屏
         */
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();



        loading.setVisibility(View.GONE);
        b1.setVisibility(View.VISIBLE);b1.setClickable(true);
        b2.setVisibility(View.VISIBLE);b2.setClickable(true);
        i1.setVisibility(View.VISIBLE);
        Timer fresh = new Timer();
        fresh.schedule(new TimerTask() {
            @Override
            public void run() {

                sort[0]+=1;
                loading.setLoadingX(sort[0]);

                if(sort[0]==6)
                    sort[0] = -1;
            }
        },0,150);


    }

//    protected void onPause(){
//        super.onPause();
//
////        b1.setVisibility(View.VISIBLE);b1.setEnabled(true);
////        b2.setVisibility(View.VISIBLE);b2.setEnabled(true);
//////        i1.setVisibility(View.VISIBLE);
////        loading.setVisibility(View.GONE);
////        fresh.cancel();
////        StartTimer.cancel();
//    }

}

