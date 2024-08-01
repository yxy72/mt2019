package com.yxy.www.mtgame2019_20;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.Touch;
import android.util.DisplayMetrics;
import android.view.CollapsibleActionView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebHistoryItem;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
public class MainGame extends AppCompatActivity {



    private int temp=0;
    private int TouchSignX = 0,TouchSignY=0;
    private int LSignX,LSignY,TempX,TempY;
    private int numberOfMonster = 24;
    private int[] shopAbilityUp = new int[3];
    private int moveInterval = 100;
    private float downY;

    private static int ScreenHeight;
    private static int ScreenWidth;
    private static float SCREEN_11;

    private boolean TouchBoolean = true;
    private boolean toolMessageOnShow = false;
    private boolean VeryKill[] = new boolean[100];
    private boolean floorReset = false;
    private boolean test = false;
    private boolean nowGLOVE = false;
    private boolean processShow = true;
    private boolean atSp = false;

    private String AllMonsterInformation[][] = new String[numberOfMonster][5];
    private String m[] = new String[numberOfMonster];
    private String[][] THIS_FLOOR;
//    private String publicTempString = "";
    private String face;
    private String dialogOfWho = "";

    private String app10[] = new String[2];
    private int APP10[][] = new int[2][4];
    private int  stepLen = 20;
    private int autoStep[][] = new int[stepLen][2];
    private int APP13X,APP13Y,APP14X1,APP14X2,APP14Y;
    private int prior_app10X,prior_app10Y;

    private Timer noticeTimer = new Timer();
    private Timer TouchTimer = new Timer();
    private Timer TouchTimerWait= new Timer();
    private Timer FreshFlash1= new Timer();
    private Timer FreshFlash2= new Timer();
    private Timer FPhelper = new Timer();
    private Timer FProcess = new Timer();
    private Timer PlayerLoseHp1 = new Timer();
    private Timer MonsterLoseHp2 = new Timer();
    private Timer timerDoorFlash = new Timer();
    private Timer goldMineTimer = new Timer();
    private Timer auto1 = new Timer(),auto2 = new Timer(),auto3 = new Timer(),auto4 = new Timer();
    private TimerTask FPhelperTask = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask FPhelper2Task = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask FProcessTask = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask PlayerLoseHp1Task = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask MonsterLoseHp2Task = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask TouchTimerTash = new TimerTask(){
        @Override
        public void run() {

        }
    };
    private TimerTask TouchTimerWaitTask = new TimerTask() {
        @Override
        public void run() {

        }
    };

    private Handler VisibleHandle,moveHandle,invalidateHandle,specialEventHandle;
    ;
    private AllShop shop,smithy_4f;
    private AllMerchantShop merchantShop;
    private FloorChange floorChange;
    private ShiningEvent monsNpc;
    private staticEventOnDraw staticEventOnDraw;
    private Player player;
    private informationView infWindow;
    private LevelFatherClass FLOOR;
    private doorFlash doorFlasher;
    private Dialog dialog,musicSwitch,superDialog;
    private MonsterInformation handbook;
    private notice_window notice;
    private SuperButton move;
    private ToolsTouch toolsTouch;
    private BackGround backGround;
    private Cover cover1;
    private GoldMine goldMine;
    private messageBGD messageBGD,fcBGD;
    private ToolsBag toolsBag;
    private SpecialNotice specialNotice;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_game);

        DisplayMetrics WINDOW = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(WINDOW);
        ScreenHeight = WINDOW.heightPixels;
        ScreenWidth = WINDOW.widthPixels;

        ViewGroup.LayoutParams layoutParamsRadio;
        SCREEN_11 = ScreenHeight / 11.0f;
        SoundPlayer.init(this);
        MonsterInformationINTI();

        FLOOR = new LevelFatherClass();
        THIS_FLOOR = FLOOR.getFloorEvent(0);
        THIS_FLOOR[8][12] = "yes";

        Menu.setScreenHeight(ScreenHeight);
        menu = findViewById(R.id.menu);
        layoutParamsRadio = menu.getLayoutParams();
        layoutParamsRadio.width = (int) (11 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        menu.setX(SCREEN_11);
        menu.setY(SCREEN_11);
        menu.setLayoutParams(layoutParamsRadio);
        menu.setEnabled(false);

        SpecialNotice.setScreenHeight(ScreenHeight);
        specialNotice = findViewById(R.id.spNotice);
        layoutParamsRadio = specialNotice.getLayoutParams();
        layoutParamsRadio.width = (int) (11 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        specialNotice.setX(1 * SCREEN_11);
        specialNotice.setY(1 * SCREEN_11);
        specialNotice.setLayoutParams(layoutParamsRadio);
        specialNotice.setEnabled(false);


        com.yxy.www.mtgame2019_20.messageBGD.setScreenHeight(ScreenHeight);
        fcBGD = findViewById(R.id.fcBGD);
        layoutParamsRadio = fcBGD.getLayoutParams();
        layoutParamsRadio.width = (int) (11.5 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        fcBGD.setX(SCREEN_11);
        fcBGD.setY(SCREEN_11);
        fcBGD.setLayoutParams(layoutParamsRadio);
        fcBGD.setSetFC(true);
        fcBGD.setEnabled(false);

        messageBGD = findViewById(R.id.messageBGD);
        layoutParamsRadio = messageBGD.getLayoutParams();
        layoutParamsRadio.width = (int) (15 * SCREEN_11);
        layoutParamsRadio.height = (int) (8.5 * SCREEN_11);
        messageBGD.setX(1 * SCREEN_11);
        messageBGD.setY(1.5f * SCREEN_11);
        messageBGD.setLayoutParams(layoutParamsRadio);
        messageBGD.setEnabled(false);

        ToolsBag.setScreenHeight(ScreenHeight);
        toolsBag = findViewById(R.id.toolbag);
        layoutParamsRadio = toolsBag.getLayoutParams();
        layoutParamsRadio.width = (int) (4.75 * SCREEN_11);
        layoutParamsRadio.height = (int) (2.75 * SCREEN_11);
        toolsBag.setX(7.25f * SCREEN_11);
        toolsBag.setY(5 * SCREEN_11);
        toolsBag.setLayoutParams(layoutParamsRadio);
        toolsBag.setEnabled(false);

        GoldMine.setScreenHeight(ScreenHeight);
        goldMine = findViewById(R.id.goldMine1);
        layoutParamsRadio = goldMine.getLayoutParams();
        layoutParamsRadio.width = (int) (10 * SCREEN_11);
        layoutParamsRadio.height = (int) (6 * SCREEN_11);
        goldMine.setX(2 * SCREEN_11);
        goldMine.setY(2.5f * SCREEN_11);
        goldMine.setLayoutParams(layoutParamsRadio);
        goldMine.setEnabled(false);


        ToolsTouch.setScreenHeight(ScreenHeight);
        toolsTouch = findViewById(R.id.toolsTouch);
        layoutParamsRadio = toolsTouch.getLayoutParams();
        layoutParamsRadio.width = (int) (2 * SCREEN_11);
        layoutParamsRadio.height = layoutParamsRadio.width;
        toolsTouch.setLayoutParams(layoutParamsRadio);
        toolsTouch.setX(12 * SCREEN_11);
        toolsTouch.setY(4 * SCREEN_11);


        BackGround.setScreenHeight(ScreenHeight);
        backGround = findViewById(R.id.background);
        layoutParamsRadio = backGround.getLayoutParams();
        layoutParamsRadio.width = (int)(18*SCREEN_11);
        layoutParamsRadio.height = ScreenHeight;
        backGround.setLayoutParams(layoutParamsRadio);

        Cover.setScreenHeight(ScreenHeight);
        cover1 = findViewById(R.id.cover1);
        layoutParamsRadio = cover1.getLayoutParams();
        layoutParamsRadio.width = ScreenWidth;
        layoutParamsRadio.height = ScreenHeight;
        cover1.setLayoutParams(layoutParamsRadio);


        AllMerchantShop.setScreenHeight(ScreenHeight);

        merchantShop = findViewById(R.id.merchant);
        merchantShop.setEnabled(false);
        layoutParamsRadio = merchantShop.getLayoutParams();
        layoutParamsRadio.width = (int) (11 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        merchantShop.setLayoutParams(layoutParamsRadio);
        merchantShop.setX(SCREEN_11);
        merchantShop.setY(SCREEN_11);


        AllShop.setScreenHeight(ScreenHeight);

        shop = findViewById(R.id.shop_3f);
        shop.setEnabled(false);
        layoutParamsRadio = shop.getLayoutParams();
        layoutParamsRadio.width = (int) (11 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        shop.setLayoutParams(layoutParamsRadio);
        shop.setX(SCREEN_11);
        shop.setY(SCREEN_11);
        shop.setShopKind("shop");


        smithy_4f = findViewById(R.id.smithy_4f);
        smithy_4f.setEnabled(false);
        layoutParamsRadio = smithy_4f.getLayoutParams();

        layoutParamsRadio.width = (int) (11 * SCREEN_11);
        layoutParamsRadio.height = (int) (9 * SCREEN_11);
        smithy_4f.setLayoutParams(layoutParamsRadio);
        smithy_4f.setX(SCREEN_11);
        smithy_4f.setY(SCREEN_11);
        smithy_4f.setShopKind("smithy");


        FloorChange.setScreenHeight(ScreenHeight);

        floorChange = findViewById(R.id.floorChange);
        layoutParamsRadio = floorChange.getLayoutParams();
        layoutParamsRadio.width = ((int) (11.5f * SCREEN_11));
        layoutParamsRadio.height = ((int) (6 * SCREEN_11));
        floorChange.setX(SCREEN_11);
        floorChange.setY(3*SCREEN_11);
        floorChange.setEnabled(false);
        floorChange.setLayoutParams(layoutParamsRadio);





        infWindow = findViewById(R.id.infWINDOW);
        infWindow.setFloorNumber(THIS_FLOOR[5][11]);
        infWindow.setScreenHeight(ScreenHeight);
        infWindow.setScreenWidth(ScreenWidth);
        layoutParamsRadio = infWindow.getLayoutParams();
        layoutParamsRadio.width = ((int) (7 * SCREEN_11));
        layoutParamsRadio.height = ((int) (11 * SCREEN_11));
        infWindow.setLayoutParams(layoutParamsRadio);
        infWindow.setX(11 * SCREEN_11);
        infWindow.setY(0 * SCREEN_11);
        infWindow.setHaveReach(floorChange.getHaveReach());
        floorChange.setHasReach(Integer.parseInt(THIS_FLOOR[5][11]),true);
        toolsBag.setOwn(infWindow.getOwnTool());


        Player.setScreenHeight(ScreenHeight);
        player = findViewById(R.id.player);
        player.setFace("u");
        layoutParamsRadio = player.getLayoutParams();
        layoutParamsRadio.width = (int) SCREEN_11;
        layoutParamsRadio.height = (int) SCREEN_11;
        player.setLayoutParams(layoutParamsRadio);
        player.setX(Integer.parseInt(THIS_FLOOR[2][11]) * SCREEN_11);
        player.setY(Integer.parseInt(THIS_FLOOR[3][11]) * SCREEN_11);


        LSignX = Integer.parseInt(THIS_FLOOR[2][11]);
        LSignY = Integer.parseInt(THIS_FLOOR[3][11]);


        doorFlasher = findViewById(R.id.doorFlasher);
        doorFlasher.setScreenHeight(ScreenHeight);
        layoutParamsRadio = doorFlasher.getLayoutParams();
        layoutParamsRadio.width = ScreenWidth;
        layoutParamsRadio.height = ScreenHeight;
        doorFlasher.setLayoutParams(layoutParamsRadio);


        monsNpc = findViewById(R.id.monsNpc);

        layoutParamsRadio = monsNpc.getLayoutParams();
        layoutParamsRadio.width = ScreenWidth;
        layoutParamsRadio.height = ScreenHeight;
        monsNpc.setScreenHeight(11 * (int) SCREEN_11);
        monsNpc.setLayoutParams(layoutParamsRadio);
        monsNpc.setEvent(THIS_FLOOR);


        staticEventOnDraw = findViewById(R.id.staticEvent);
        staticEventOnDraw.setScreenHeight(ScreenHeight);

        layoutParamsRadio.width = ScreenWidth;
        layoutParamsRadio.height = ScreenHeight;
        staticEventOnDraw.setLayoutParams(layoutParamsRadio);
        staticEventOnDraw.setEvent(THIS_FLOOR);


        Dialog.setScreenHeight(ScreenHeight);

        dialog = findViewById(R.id.dialog);
        layoutParamsRadio = dialog.getLayoutParams();
        layoutParamsRadio.width = (int) (12.5 * SCREEN_11);
        layoutParamsRadio.height = ScreenHeight;
        dialog.setKind("dialog");
        dialog.setNpcNameAndSaying(THIS_FLOOR[8][11], THIS_FLOOR[9][11], THIS_FLOOR[10][11]);
        dialog.setNameWidth(2.5f);
        dialog.setEnabled(false);
        dialog.setLayoutParams(layoutParamsRadio);
        dialog.setNpcImage("npc");

        superDialog = findViewById(R.id.superDialog);
        layoutParamsRadio = superDialog.getLayoutParams();
        layoutParamsRadio.width = (int) (18 * SCREEN_11);
        layoutParamsRadio.height = (int) (11 * SCREEN_11);
        superDialog.setEnabled(false);
        superDialog.setKind("");
        superDialog.setFightWithWho("m1");
        superDialog.setLayoutParams(layoutParamsRadio);

        MonsterInformation.setScreenHeight(ScreenHeight);
        handbook = findViewById(R.id.handbook);
        layoutParamsRadio = handbook.getLayoutParams();
        layoutParamsRadio.width = (int) (13 * SCREEN_11);
        layoutParamsRadio.height = (int) (5.5 * SCREEN_11);
        handbook.setLayoutParams(layoutParamsRadio);
        handbook.setX(2 * SCREEN_11);
        handbook.setY(3.5f * SCREEN_11);
        handbook.setEnabled(false);
        handbook.setMonsterInfmation(AllMonsterInformation);
//                            handbook.setEnabled(true);
//        VisibleHandle.sendEmptyMessage(0x135);

        notice = findViewById(R.id.notice111);
        notice.setScreenHeight(ScreenHeight);
        notice.setMonsterInfmation(AllMonsterInformation);
        layoutParamsRadio = notice.getLayoutParams();
        layoutParamsRadio.width = (int) (18 * SCREEN_11);
        layoutParamsRadio.height = (int) (11 * SCREEN_11);
        notice.setLayoutParams(layoutParamsRadio);


        move = findViewById(R.id.move);
        move.setScreenHeight(ScreenHeight);
        layoutParamsRadio = move.getLayoutParams();
        layoutParamsRadio.width = (int) (4 * SCREEN_11);
        layoutParamsRadio.height = (int) (4 * SCREEN_11);
        move.setLayoutParams(layoutParamsRadio);
        move.setX(12f * SCREEN_11);
        move.setY(7f * SCREEN_11);


        musicSwitch = findViewById(R.id.musicSwitch);
        musicSwitch.setKind("musicSwitch");
        musicSwitch.setMusicSwitchContent("菜单");
        layoutParamsRadio = musicSwitch.getLayoutParams();
        layoutParamsRadio.width = (int) (2 * (SCREEN_11));
        layoutParamsRadio.height = (int) (0.75 * (SCREEN_11));
        musicSwitch.setLayoutParams(layoutParamsRadio);
        musicSwitch.setX(15.5f * SCREEN_11);
        musicSwitch.setY(7.5f * SCREEN_11);

        face = "up";

        setMusicSwitchOnTouchListener();
        setSuperDialogOnTouchListener();
        setDialogTouchListener();
        setToolOnTouchListener();
        setFloorChangeOnTouchListener();
        setSmithy_4fOnTouchListener();
        setShopOnTouchListener();
        setMerchantOnTouch();
        setAllHandle();
        setGoldMineOnTouchListener();
        setBackGroundOntTouchListener();
        setHandbookOnTouchListener();
        setMessageBGDonTouchListener();
        setfcBgdTouchListener();
        setToolBagOnTouchListener();
        setSpecialNoticeOnTouchListener();
        setMenuOnTouchListener();
        SoundPlayer.musicPlay();
    }
    @Override
    protected void onResume() {
        /*
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();

////        SoundPlayer.init(this);
//        SoundPlayer.setSoundSt(true);
////        if(SoundPlayer.isMusicSt()){
//            SoundPlayer.startMusic();
//        }

        setMoveOnTouchListener();
        specialEventHandle.sendEmptyMessage(14404);


        if(menu.getCase(0))
            SoundPlayer.setSd(true);
        if(menu.getCase(1))
            SoundPlayer.musicPlay();


    }
    @Override
    protected void onPause() {
        super.onPause();
        FreshFlash1.cancel();
        FreshFlash2.cancel();
        SoundPlayer.setSd(false);
        SoundPlayer.musicPause();


//        SoundPlayer.pauseMusic();
//        SoundPlayer.setSoundSt(false);
    }


    @SuppressLint({"ClickableViewAccessibility", "HandlerLeak"})
    private void throughDoor(String color,int i,int j) {
        moveObstacle();
        switch (color) {
            case("dy"): {
                if(infWindow.getKeyYnum()>=1) {
                    infWindow.setKeyYnum(infWindow.getKeyYnum() - 1);
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color,i,j);
                    SoundPlayer.openDoor();
                }
                else{
                    setNoticeInformation("door");
                    SoundPlayer.noKey();
                }
                break;
            }
            case("db"): {
                if (infWindow.getKeyBnum() >= 1) {
                    infWindow.setKeyBnum(infWindow.getKeyBnum() - 1);
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color, i, j);
                    SoundPlayer.openDoor();
                } else {
                    setNoticeInformation( "door");
                    SoundPlayer.noKey();
                }
                break;
            }
            case("wallE"):{
                THIS_FLOOR[i][j]="";
                invalidateHandle.sendEmptyMessage(14407);
                doorFlash(color, i, j);

                break;
            }
            case("dr"): {
                if (infWindow.getKeyRnum() >= 1) {
                    infWindow.setKeyRnum(infWindow.getKeyRnum() - 1);
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color,i,j);
                    SoundPlayer.openDoor();
                }  else{
                    setNoticeInformation("door");
                    SoundPlayer.noKey();
                }
                break;
            }
            case("de1"): {

                if (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[0][12])][Integer.parseInt(THIS_FLOOR[1][12])].equals("") && THIS_FLOOR[Integer.parseInt(THIS_FLOOR[2][12])][Integer.parseInt(THIS_FLOOR[3][12])].equals("")) {
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color,i,j);
                    SoundPlayer.openDoor();
                } else{
                    SoundPlayer.noKey();
                }
                break;

            }
            case("de2"): {
                if (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][12])][Integer.parseInt(THIS_FLOOR[5][12])].equals("") && THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][12])][Integer.parseInt(THIS_FLOOR[7][12])].equals("")) {
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color,i,j);
                    SoundPlayer.openDoor();
                } else{
                    SoundPlayer.noKey();
                }
                break;
            }
            case("dz"): {
                if ((THIS_FLOOR[Integer.parseInt(THIS_FLOOR[0][13])][Integer.parseInt(THIS_FLOOR[1][13])].equals("")) && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[2][13])][Integer.parseInt(THIS_FLOOR[3][13])].equals(""))) {
                    THIS_FLOOR[i][j]="";
                    invalidateHandle.sendEmptyMessage(14407);
                    doorFlash(color, i, j);
                } else {
                    SoundPlayer.noKey();
                }
                break;
            }


        }
        invalidateHandle.sendEmptyMessage(14400);
    }
    private void throughSpecialDoor(){
        SoundPlayer.noKey();
        moveObstacle();
    }
    private void throughMonster(String[] Allmoninf,String kind,int i,int j,String who){
        //ad0,def1,hp2,gold3
        moveObstacle();
        boolean ifCanKill = true;

        int tempAD = infWindow.getAD();
        int tempHP = (int)infWindow.getHP();


        switch (who) {
            case "m19":
                if (infWindow.getIfOwn(1)) {
                    infWindow.setAD(2 * infWindow.getAD());
                } else {
                    superDialog.setplaLoseHp(String.valueOf((int) (infWindow.getHP() / 10)));
                    infWindow.setHP(infWindow.getHP() - (int) (infWindow.getHP() / 10));
                    superDialog.setNowPlayerHp(infWindow.getHP() - (int) (infWindow.getHP() / 10));
                    superDialog.invalidate();
                }
                break;
            case "m17":
                if (infWindow.getIfOwn(1)) {
                    infWindow.setAD(2 * infWindow.getAD());
                } else {
                    superDialog.setplaLoseHp("100");
                    infWindow.setHP(infWindow.getHP() - 100);
                    superDialog.setNowPlayerHp(infWindow.getHP() - 100);
                    superDialog.invalidate();
                }
                break;
            case "m20":
                if (infWindow.getIfOwn(1)) {
                    infWindow.setAD(2 * infWindow.getAD());
                }
                break;
        }


        if(infWindow.getAD() <= Integer.parseInt(Allmoninf[1])){ifCanKill = false;setNoticeInformation("cannot");}
        else {
            if(infWindow.getAD() > Integer.parseInt(Allmoninf[1]) && infWindow.getDEF() >= Integer.parseInt(Allmoninf[0])){ }
            else{
                int timeKillMonster = Integer.parseInt(Allmoninf[2]) / (infWindow.getAD() - Integer.parseInt(Allmoninf[1]));if (Integer.parseInt(Allmoninf[2]) % (infWindow.getAD() - Integer.parseInt(Allmoninf[1])) > 0) timeKillMonster += 1;
                int timeKillPlayer = (int)infWindow.getHP() / (Integer.parseInt(Allmoninf[0]) - infWindow.getDEF());if (infWindow.getHP() % (Integer.parseInt(Allmoninf[0]) - infWindow.getDEF()) > 0) timeKillPlayer += 1;
                if(timeKillMonster>timeKillPlayer){                ifCanKill = false;setNoticeInformation("hp");
                }
            }
        }

        infWindow.setAD(tempAD);
        infWindow.setHP(tempHP);


        if(ifCanKill){
            int sort = 0;

            for(int k=1;k<=numberOfMonster-1;k++){
                if(kind.equals(m[k])){sort = k;break;}
            }
            fightProcess(who,sort,kind,Allmoninf,i,j);
        }
        else{
            SoundPlayer.noKey();
        }








    }
    private void throughNpc(int i,int j){
        moveObstacle();
//        publicTempString = THIS_FLOOR[7][13];
        TempX = i;
        TempY = j;
        move.setDirection(5);
        backGround.setEnabled(false);

        moveHandle.sendEmptyMessage(14402);
        move.setEnabled(false);
        backGround.setEnabled(false);


        dialog.setNameTextSize(0.69f*ScreenHeight/11.0f);
        dialog.setNpcNameAndSaying(THIS_FLOOR[8][11], THIS_FLOOR[9][11], THIS_FLOOR[10][11]);
        dialog.setNpcImage("npc");
        dialog.setNameWidth(2.5f);
        VisibleHandle.sendEmptyMessage(0x129);
        dialogOfWho = THIS_FLOOR[7][11];

        dialog.setEnabled(true);
        backGround.setEnabled(false);
        toolsTouch.setEnabled(false);
    }
    private void throughMerchant(String kind,int i,int j){

        moveObstacle();
        move.setDirection(5);
        move.setEnabled(false);
        backGround.setEnabled(false);
        moveHandle.sendEmptyMessage(14402);
        toolsTouch.setEnabled(false);



        switch (kind){
            case "merchant":
                VisibleHandle.sendEmptyMessage(0x129);
                dialogOfWho = kind;
                dialog.setEnabled(true);
                dialog.setNameTextSize(0.69f*ScreenHeight/11.0f);
                dialog.setNpcImage("merchant");
                dialog.setNpcNameAndSaying(THIS_FLOOR[8][13], THIS_FLOOR[9][13], THIS_FLOOR[10][13]);
                dialog.setNameWidth(5.5f);
                break;
            case "merchant2":
                merchantShop.setKey(true);
                merchantShop.invalidate();

                VisibleHandle.sendEmptyMessage(0x146);
                merchantShop.setEnabled(true);

                break;
            case "merchant3":
                TempX = i;TempY = j;
                dialogOfWho = kind;
                VisibleHandle.sendEmptyMessage(0x129);
                dialog.setEnabled(true);
                dialog.setNameTextSize(0.69f*ScreenHeight/11.0f);
                dialog.setNpcImage("merchant");
                dialog.setNpcNameAndSaying(THIS_FLOOR[8][13], THIS_FLOOR[9][13], THIS_FLOOR[10][13]);
                dialog.setNameWidth(3.5f);
                break;

        }





    }
    private void throughThief(int i,int j){
        moveObstacle();
        move.setDirection(5);

        TempX = i;
        TempY = j;
        moveHandle.sendEmptyMessage(14402);
        move.setEnabled(false);
        backGround.setEnabled(false);
        dialog.setNameTextSize(0.69f*ScreenHeight/11.0f);
        dialog.setNpcNameAndSaying(THIS_FLOOR[8][11], THIS_FLOOR[9][11], THIS_FLOOR[10][11]);
        switch (THIS_FLOOR[5][11]){
            case "10":dialogOfWho = "10";break;
            case "15":dialogOfWho = "4";break;
        }
        dialog.setNpcImage("thief");
        dialog.setNameWidth(2);
        VisibleHandle.sendEmptyMessage(0x129);
        dialog.setEnabled(true);
        backGround.setEnabled(false);
        toolsTouch.setEnabled(false);

    }
    private void throughShop() {
        moveHandle.sendEmptyMessage(14402);
        player.setY(player.getY() + SCREEN_11);
        LSignY += 1;
        toolsTouch.setEnabled(false);
        move.setEnabled(false);
        backGround.setEnabled(false);
        shop.setEnabled(true);
        VisibleHandle.sendEmptyMessage(0x130);
        shop.setEnabled(true);
        move.setDirection(5);

    }
    private void throughSmithy(){
        moveHandle.sendEmptyMessage(14402);
        player.setY(player.getY() + SCREEN_11);
        LSignY += 1;
        toolsTouch.setEnabled(false);
        move.setEnabled(false);
        backGround.setEnabled(false);
        smithy_4f.setEnabled(true);
        VisibleHandle.sendEmptyMessage(0x149);
        smithy_4f.setEnabled(true);
        move.setDirection(5);

    }
    private void throughGoldMine(){
        switch (face){
            case "up":
            case "right": goldMine.setEnabled(true);
                VisibleHandle.sendEmptyMessage(0x133);
                backGround.setEnabled(false);
                move.setEnabled(false);
                if(!infWindow.goldMine1) {
                    infWindow.goldMine1 = true;
                    toolsTouch.setIconGoldMine(true);
                    goldMineTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if(goldMine.getHasHowMuch()<=goldMine.getGoldMax()) {
                                goldMine.setHasHowMuch(goldMine.getHasHowMuch() + goldMine.getCreateSpeed());
                                goldMine.invalidate();
                                toolsTouch.setSetProcess((int) (100 * goldMine.getHasHowMuch() / goldMine.goldMax));
                                if (goldMine.getHasHowMuch() > goldMine.getGoldMax()) {
                                    goldMine.setHasHowMuch(goldMine.getGoldMax());
                                    goldMine.invalidate();
                                    toolsTouch.setSetProcess(100);
                                }
                            }
                        }
                    }, 0, 1000);
                }
                break;
        }
        move.setDirection(5);
        backGround.setEnabled(false);
        moveObstacle();
        moveHandle.sendEmptyMessage(14402);
        move.setEnabled(false);
        backGround.setEnabled(false);

    }
    private void throughGirl(){
        dialog.setNpcImage("thief");
        dialog.setNameTextSize(0.69f*SCREEN_11);
        dialog.setNameWidth(2);
        THIS_FLOOR[7][11] = "7";
        dialog.setNpcNameAndSaying("作者","恭喜通关前20层！您的分数为"+String.valueOf((int)(10*infWindow.getAD()+10*infWindow.getDEF()+2*infWindow.getHP()+50*infWindow.getBLOOD()+10*infWindow.getVERYBIT())),"");
        VisibleHandle.sendEmptyMessage(0x129);
        dialog.setEnabled(true);
        SoundPlayer.successBuy();
        move.setDirection(5);
        backGround.setEnabled(false);
        moveObstacle();
        moveHandle.sendEmptyMessage(14402);
        move.setEnabled(false);
        backGround.setEnabled(false);    }
    private void throughSZJ(){
        THIS_FLOOR[3][3] = "";
        invalidateHandle.sendEmptyMessage(14407);
        doorFlash("wallE",3,3);

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                THIS_FLOOR[3][3] = "szj";
                staticEventOnDraw.invalidate();
                t.cancel();
            }
        },300);

        moveObstacle();
    }
    private void throughEif(int i,int j){
        moveObstacle();
        THIS_FLOOR[7][13] = "";
        TempX = i;
        TempY = j;
        move.setDirection(5);
        backGround.setEnabled(false);

        moveHandle.sendEmptyMessage(14402);
        move.setEnabled(false);
        backGround.setEnabled(false);

        dialog.setNameTextSize(0.69f*ScreenHeight/11.0f);
        dialog.setNpcNameAndSaying(THIS_FLOOR[8][11], THIS_FLOOR[9][11], THIS_FLOOR[10][11]);
        dialog.setNpcImage("eif");
        dialog.setNameWidth(2.5f);
        VisibleHandle.sendEmptyMessage(0x129);
        dialog.setEnabled(true);
        backGround.setEnabled(false);
        toolsTouch.setEnabled(false);
    }
    private void instr (){
        move.setEnabled(false);backGround.setEnabled(false);specialNotice.setKind("instr");specialNotice.setEnabled(true);VisibleHandle.sendEmptyMessage(0x144);
        THIS_FLOOR[4][9] = THIS_FLOOR[5][9] = THIS_FLOOR[6][9] = "";
    }

    private void getAbilityUp(String kind,int i,int j) {
        moveObstacle();
        switch (kind) {
            case("ad"):infWindow.setAD(infWindow.getAD() + 2);setNoticeInformation("ad");break;
            case("def"):infWindow.setDEF(infWindow.getDEF() + 2);setNoticeInformation("def");break;
            case("bhp"):infWindow.setHP(infWindow.getHP() + 400);setNoticeInformation("bhp");break;
            case("rhp"):infWindow.setHP(infWindow.getHP() + 200);setNoticeInformation("rhp");break;
            case("ky"): infWindow.setKeyYnum(infWindow.getKeyYnum() + 1);setNoticeInformation("yk");break;
            case("kb"): infWindow.setKeyBnum(infWindow.getKeyBnum() + 1);setNoticeInformation("bk");break;
            case("kr"): infWindow.setKeyRnum(infWindow.getKeyRnum() + 1);setNoticeInformation("rk");break;
            case("blood_1"): infWindow.setAD(infWindow.getAD()+5);setNoticeInformation(kind);infWindow.numOfBlood_1+=1;break;
            case("blood_2"):
                if (infWindow.numOfBlood_2 == 0) {
                    infWindow.setBLOOD(infWindow.getBLOOD() + 10);
                    setNoticeInformation( kind);
                    infWindow.numOfBlood_2 += 1;
                }
                else
                {
                    infWindow.numOfBlood_2 += 1;
                    setNoticeInformation( "redundantBlood_2");
                }
                break;
            case("baoji_1"): infWindow.setVERYBIT(infWindow.getVERYBIT()+4);setNoticeInformation(kind);infWindow.numOfBaoji_1+=1;break;
            case("baoji_2"): infWindow.setVERYBIT(infWindow.getVERYBIT()+2);setNoticeInformation(kind);infWindow.numOfBaoji_2+=1;break;
            case("baoji_3"):
                if (infWindow.numOfBaoji_3 == 0) {
                    infWindow.setVERYBIT(infWindow.getVERYBIT() + 15);
                    setNoticeInformation( kind);
                    infWindow.numOfBaoji_3 += 1;
                }
                else
                {
                    infWindow.numOfBaoji_3 += 1;
                    setNoticeInformation( "redundantBaoji_3");
                }
                break;
            case("ad_1"): infWindow.setAD(infWindow.getAD() + 10);setNoticeInformation(kind);infWindow.setToolShow(kind);break;
            case("ad_2"): infWindow.setAD(infWindow.getAD() + 20);setNoticeInformation(kind);infWindow.setToolShow(kind);break;



            case("def_1"): infWindow.setDEF(infWindow.getDEF() + 10);setNoticeInformation(kind);infWindow.setToolShow(kind);break;
            case("def_2"): infWindow.setDEF(infWindow.getDEF() + 20);setNoticeInformation(kind);infWindow.setToolShow(kind);break;



            case("little_gold"): infWindow.setGOLD(infWindow.getGOLD() + 50);setNoticeInformation(kind);break;
            case("floorChanger"):infWindow.setTOOLS(2);setNoticeInformation(kind);break;
            case("glove"):move.setEnabled(false);backGround.setEnabled(false);infWindow.setOwnTool(0);specialNotice.setKind("glove");specialNotice.setEnabled(true);VisibleHandle.sendEmptyMessage(0x144);break;
            case("wall_break"):;move.setEnabled(false);backGround.setEnabled(false);infWindow.setOwnTool(2);specialNotice.setKind("pqg");specialNotice.setEnabled(true);VisibleHandle.sendEmptyMessage(0x144);break;
            case("szj"):;move.setEnabled(false);backGround.setEnabled(false);infWindow.setOwnTool(1);specialNotice.setKind("szj");specialNotice.setEnabled(true);VisibleHandle.sendEmptyMessage(0x144);break;



        }
        THIS_FLOOR[i][j] = "";
        invalidateHandle.sendEmptyMessage(14407);
        invalidateHandle.sendEmptyMessage(14400);
        SoundPlayer.getAbility();
    }
    private void setNoticeInformation( String kind) {
        notice.setKind(kind);
        invalidateHandle.sendEmptyMessage(14405);
        VisibleHandle.sendEmptyMessage(0x123);
        noticeTimer.cancel();

        noticeTimer = new Timer();
        noticeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                VisibleHandle.sendEmptyMessage(0x124);
                noticeTimer.cancel();
            }
        }, 1500);
    }
    private void doorFlash(final String color,  final int i, final int j) {

        doorFlasher.setDoorFlash1(i,j,color);
        invalidateHandle.sendEmptyMessage(14404);
        timerDoorFlash = new Timer();
        timerDoorFlash.schedule(new TimerTask() {
            @Override
            public void run() {
                doorFlasher.setDoorFlash2(i,j,color);
                invalidateHandle.sendEmptyMessage(14404);
            }
        }, 100);
        timerDoorFlash.schedule(new TimerTask() {
            @Override
            public void run() {
                doorFlasher.setDoorFlash3(i,j,color);
                invalidateHandle.sendEmptyMessage(14404);
            }
        }, 200);
        timerDoorFlash.schedule(new TimerTask() {
            @Override
            public void run() {
                doorFlasher.setDoorFlashClose(color);
                invalidateHandle.sendEmptyMessage(14404);
//                if(szj){
//                    szj = false;
//                    THIS_FLOOR[3][3] = "szj";
//                    staticEventOnDraw.invalidate();
//                }
                timerDoorFlash.cancel();

            }
        }, 300);


    }

    private void floorChange(String upOrDown){
        SoundPlayer.floorChange();

        //离开特定楼层时的特定事件。
        switch(Integer.parseInt(THIS_FLOOR[5][11])){
            case 14: backGround.setFloorKind(1);cover1.setCoverFlag(false);cover1.invalidate();break;
            case 15: invalidateHandle.sendEmptyMessage(14401);break;
        }

        //重设楼层，瞬移角色位置。
        if(upOrDown.equals("up")){
            if(temp==0){
                THIS_FLOOR = FLOOR.getFloorEvent(Integer.parseInt(THIS_FLOOR[4][11]));}
            else {
                THIS_FLOOR = FLOOR.getFloorEvent(temp);temp = 0; }
            player.setX(Integer.parseInt(THIS_FLOOR[2][11])*SCREEN_11);player.setY(Integer.parseInt(THIS_FLOOR[3][11])*SCREEN_11);
            LSignX = Integer.parseInt(THIS_FLOOR[2][11]);LSignY = Integer.parseInt(THIS_FLOOR[3][11]);
        }
        else if(upOrDown.equals("down")){
            if(temp==0){
                THIS_FLOOR = FLOOR.getFloorEvent(Integer.parseInt(THIS_FLOOR[6][11]));}
            else {
                THIS_FLOOR = FLOOR.getFloorEvent(temp);temp = 0; }
            player.setX(Integer.parseInt(THIS_FLOOR[0][11])*SCREEN_11);player.setY(Integer.parseInt(THIS_FLOOR[1][11])*SCREEN_11);
            LSignX = Integer.parseInt(THIS_FLOOR[0][11]);LSignY = Integer.parseInt(THIS_FLOOR[1][11]);
        }

        //重置信息窗口显示、重绘动静态图像。
        infWindow.setFloorNumber(THIS_FLOOR[5][11]);
        staticEventOnDraw.setEvent(THIS_FLOOR);
        monsNpc.setEvent(THIS_FLOOR);
        if(infWindow.getIfOwn(1))
            handbook.getSZJ();
        handbook.setPlay(infWindow);
        handbook.setEnabled(true);
        for (int i = 0; i <= numberOfMonster - 1; i++) {
            setMonsterLook(m[i]);
        }
        invalidateHandle.sendEmptyMessage(14400);
        invalidateHandle.sendEmptyMessage(14401);
        invalidateHandle.sendEmptyMessage(14409);

        //进入特定楼层时的特定事件。
        switch(Integer.parseInt(THIS_FLOOR[5][11])){
            case 3  :shop.setShopFloor(3);shopAbilityUp[0]=shopAbilityUp[1]=4;shopAbilityUp[2]=800;shop.setAbilityUp(shopAbilityUp);break;
            case 11 :shop.setShopFloor(11);shopAbilityUp[0]=6;shopAbilityUp[1]=8;shopAbilityUp[2]=1314;shop.setAbilityUp(shopAbilityUp);break;
            case 14 :backGround.setFloorKind(2);cover1.setCoverFlag(true);cover1.invalidate();break;
            case 15 :invalidateHandle.sendEmptyMessage(14401);break;
        }
        if(!infWindow.getHaveReach(Integer.parseInt(THIS_FLOOR[5][11]))) {
            THIS_FLOOR[8][12] = "yes";
            floorChange.setHasReach(Integer.parseInt(THIS_FLOOR[5][11]),true);
        }
        //处理多接口楼层切换。
        if(floorReset){
            floorReset = false;
            FLOOR.setEvent(2,0,11,"9");
            FLOOR.setEvent(2,1,11,"0");
            FLOOR.setEvent(2,4,11,"3");
            FLOOR.setEvent(14,2,11,"0");
            FLOOR.setEvent(14,3,11,"1");
            FLOOR.setEvent(14,6,11,"13");
        }


        //重置npc对话框内容。
        dialog.setNpcNameAndSaying(THIS_FLOOR[8][11],THIS_FLOOR[9][11],THIS_FLOOR[10][11]);




    }

    private void setMonsterInformation(int line,int ad,int def,int hp,int gold){
        AllMonsterInformation[line][0] = String.valueOf(ad);
        AllMonsterInformation[line][1] = String.valueOf(def);
        AllMonsterInformation[line][2] = String.valueOf(hp);
        AllMonsterInformation[line][3] = String.valueOf(gold);;
        AllMonsterInformation[line][4] = String.valueOf(line);
    }
    private void setMonsterLook(String mx){
        boolean showFlag = false;
        for(int i = 0;i<11;i++){
            for(int j =0;j<11;j++){
                if(THIS_FLOOR[i][j].equals(mx)){showFlag =true;break;}
            }
        }
        if(showFlag){
            for(int i=1;i<=numberOfMonster-1;i++){
                if(mx.equals(m[i])) {
                    handbook.setYn(true,i);
                    break;
                }
            }
        }
        else {
            for(int i=1;i<=numberOfMonster-1;i++){
                if(mx==m[i]) {
                    handbook.setYn(false,i);
                    break;
                }
            }
        }
    }
    private void MonsterInformationINTI(){
        m[1]="m1";m[2]="m2";m[3]="m3";m[4]="m4";m[5]="m5";m[6]="m6";m[7]="m7";m[8]="m8";m[9]="m9";m[10]="m10";m[11]="m11";m[12]="m12";m[13]="m13";m[14]="m14";m[15]="m15";m[16]="m16";m[17]="m17";m[18]="m18";m[19]="m19";m[20]="m20";m[21]="m21";m[22]="m22";m[23]="m23";
//        m[24]="m24";m[25]="m25";m[26]="m26";m[27]="m27";m[28]="m28";m[29]="m29";m[30]="m30";








        //创建怪物信息；
        for(int i=0;i<numberOfMonster;i++){
            for(int j=0;j<5;j++)
            {
                AllMonsterInformation[i][j] = "";
            }
        }
        setMonsterInformation(1,20,1,50,1);
        setMonsterInformation(2,15,2,70,2);
        setMonsterInformation(3,20,5,100,3);
        setMonsterInformation(4,25,5,110,5);
        setMonsterInformation(5,35,10,200,5);
        setMonsterInformation(6,50,20,150,8);
        setMonsterInformation(7,55,25,125,7);
        setMonsterInformation(8,90,42,250,9);
        setMonsterInformation(9,85,55,300,13);
        setMonsterInformation(10,90,50,400,15);
        setMonsterInformation(11,65,30,250,6);
        setMonsterInformation(12,70,40,275,9);
        setMonsterInformation(13,80,45,300,10);
        setMonsterInformation(14,120,60,250,13);
        setMonsterInformation(15,150,90,450,22);
        setMonsterInformation(16,80,120,100,15);
        setMonsterInformation(17,160,80,300,19);
        setMonsterInformation(18,220,100,550,25);
        setMonsterInformation(19,250,120,600,30);
        setMonsterInformation(20,300,150,1000,35);
        setMonsterInformation(21,270,120,500,27);
        setMonsterInformation(22,450,330,900,50);
        setMonsterInformation(23,240,100,640,27);
    }
    private void fightProcess(final String who, int sort, final String kind, final String[] Allmoninf, final int i, final int j){

        if(processShow){


            TouchBoolean=false;
            superDialog.setKind("fightProcess");
            superDialog.setMonsterInfmation(AllMonsterInformation);
            superDialog.setFightWithWho(who);
            superDialog.setEnabled(false);
            superDialog.setBaoJiShow(false);
            superDialog.setPlayerGetHpFromMons("");
            superDialog.setmosLoseHp("");
            VisibleHandle.sendEmptyMessage(0x125);
            VisibleHandle.sendEmptyMessage(0x124);

            final int tempAD = infWindow.getAD();


            switch (who) {
                case "m19":
                    if (infWindow.getIfOwn(1)) {
                        infWindow.setAD(2 * infWindow.getAD());
                    } else {
                        superDialog.setplaLoseHp(String.valueOf((int) (infWindow.getHP() / 10)));
                        infWindow.setHP(infWindow.getHP() - (int) (infWindow.getHP() / 10));
                        superDialog.setNowPlayerHp(infWindow.getHP() - (int) (infWindow.getHP() / 10));
                        superDialog.invalidate();
                    }
                    break;
                case "m17":
                    if (infWindow.getIfOwn(1)) {
                        infWindow.setAD(2 * infWindow.getAD());
                    } else {
                        superDialog.setplaLoseHp("100");
                        infWindow.setHP(infWindow.getHP() - 100);
                        superDialog.setNowPlayerHp(infWindow.getHP() - 100);
                        superDialog.invalidate();
                    }
                    break;
                case "m20":
                    if (infWindow.getIfOwn(1)) {
                        infWindow.setAD(2 * infWindow.getAD());
                    }
                    break;
            }



            backGround.setEnabled(false);
            move.setEnabled(false);
            backGround.setEnabled(false);
            toolsTouch.setEnabled(false);


            moveHandle.sendEmptyMessage(14403);



            FPhelperTask.cancel();
            FPhelper2Task.cancel();
            FProcessTask.cancel();
            PlayerLoseHp1Task.cancel();
            MonsterLoseHp2Task.cancel();
            FPhelper.cancel();
            FProcess.cancel();
            PlayerLoseHp1.cancel();
            MonsterLoseHp2.cancel();


            for(int k=0;k<infWindow.getVERYBIT();k++){
                VeryKill[k] = true;
            }

            superDialog.setPlay(infWindow);
            VisibleHandle.sendEmptyMessage(0x125);
            superDialog.setNowMonsterHp(Integer.parseInt(AllMonsterInformation[sort][2]));
            superDialog.setNowPlayerHp(infWindow.getHP());

//        FPhelper2 = new Timer();
//        FPhelper2Task  = new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        };
//        FPhelper2.schedule(FPhelper2Task,650,500);

            PlayerLoseHp1 = new Timer();
            PlayerLoseHp1Task = new TimerTask() {
                @Override
                public void run() {
                    superDialog.setplaLoseHp("");
                }
            };
            PlayerLoseHp1.schedule(PlayerLoseHp1Task,800,500);


            MonsterLoseHp2 = new Timer();
            MonsterLoseHp2Task = new TimerTask() {
                @Override
                public void run() {
                    superDialog.setmosLoseHp("");
                    superDialog.setBaoJiShow(false);

                    int damage2 = Integer.parseInt(Allmoninf[0])-infWindow.getDEF();
                    if(damage2<0) {
                        superDialog.setplaLoseHp(String.valueOf(""));
                    }
                    else {
                        superDialog.setplaLoseHp(String.valueOf(damage2));
                        superDialog.setNowPlayerHp(superDialog.getNowPlayerHp() - damage2);
                    }
                    superDialog.setPlayerGetHpFromMons("");
                    invalidateHandle.sendEmptyMessage(14402);
                }
            };
            MonsterLoseHp2.schedule(MonsterLoseHp2Task,650,500);


            FProcess = new Timer();
            FProcessTask = new TimerTask() {
                @Override
                public void run() {
                    int damage = infWindow.getAD() - Integer.parseInt(Allmoninf[1]);

                    int x = (int)(Math.random()*(99+1));
                    boolean baojikill = false;
                    if(VeryKill[x]) {
                        superDialog.setmosLoseHp( String.valueOf(2*damage));
                        superDialog.setNowMonsterHp(superDialog.getNowMonsterHp() - 2*damage);
                        baojikill = true;
                        superDialog.setBaoJiShow(true);

                        float getBloodFromMons = (((infWindow.getBLOOD()/100.0f))*2*damage);

                        int m = (int)(getBloodFromMons*10);
                        int m1 = m/10;
                        int m2 = m%10;

                        if(infWindow.getBLOOD()==0){}
                        else {
                            if(m1==0&&m2==0) {}
                            else{
                                if (m2 == 0) {
                                    superDialog.setPlayerGetHpFromMons("+" + String.valueOf(m1));
                                } else {
                                    superDialog.setPlayerGetHpFromMons("+" + String.valueOf(m1) + "." + String.valueOf(m2));
                                }
                                superDialog.setNowPlayerHp(superDialog.getNowPlayerHp() + getBloodFromMons);
                            }
                        }
                        SoundPlayer.baoji();
                    }else{
                        superDialog.setmosLoseHp( String.valueOf(damage));
                        superDialog.setNowMonsterHp(superDialog.getNowMonsterHp() - damage);
                        superDialog.setBaoJiShow(false);
                        float getBloodFromMons = ((infWindow.getBLOOD()/100.0f)*damage);
                        int m = (int)(getBloodFromMons*10);
                        int m1 = m/10;
                        int m2 = m%10;
                        if(infWindow.getBLOOD()==0){}
                        else {
                            if(m1==0&&m2==0) {}
                            else{
                                if (m2 == 0) {
                                    superDialog.setPlayerGetHpFromMons("+" + String.valueOf(m1));
                                } else {
                                    superDialog.setPlayerGetHpFromMons("+" + String.valueOf(m1) + "." + String.valueOf(m2));
                                }
                                superDialog.setNowPlayerHp(superDialog.getNowPlayerHp() + getBloodFromMons);
                            }
                        }
                        SoundPlayer.fight();
                    }
                    invalidateHandle.sendEmptyMessage(14402);



                    if(superDialog.getNowMonsterHp()<=0){
                        int getBloodFromMons = (int)((infWindow.getBLOOD()/100.0f)*damage);
                        if(baojikill){
                            superDialog.setmosLoseHp(String.valueOf(superDialog.getNowMonsterHp() + 2*damage));
                            if(infWindow.getBLOOD()!=0)
                                superDialog.setPlayerGetHpFromMons("+" + String.valueOf((int)((superDialog.getNowMonsterHp() + 2*damage)*infWindow.getBLOOD()/100.0f)));

                        }
                        else {
                            superDialog.setmosLoseHp(String.valueOf(superDialog.getNowMonsterHp() + damage));
                            if(infWindow.getBLOOD()!=0)
                                superDialog.setPlayerGetHpFromMons("+" + String.valueOf((int)((superDialog.getNowMonsterHp() + damage)*infWindow.getBLOOD()/100.0f)));
                        }
                        superDialog.setNowPlayerHp(superDialog.getNowPlayerHp()-(getBloodFromMons-(int)((superDialog.getNowMonsterHp() + damage)*infWindow.getBLOOD()/100.0f)));

                        superDialog.setNowMonsterHp(0);
                        FPhelper = new Timer();
                        FPhelperTask = new TimerTask() {
                            @Override
                            public void run() {
                                FProcess.cancel();
                                VisibleHandle.sendEmptyMessage(0x126);

                                infWindow.setHP(superDialog.getNowPlayerHp());
                                infWindow.setGOLD(infWindow.getGOLD()+Integer.parseInt(Allmoninf[3]));
                                invalidateHandle.sendEmptyMessage(14400);

                                monsNpc.set886(i,j);


                                if(THIS_FLOOR[5][11].equals("10")) {

                                    if (!THIS_FLOOR[5][3].equals("")) {
                                        if (THIS_FLOOR[3][4].equals("") && THIS_FLOOR[7][4].equals("") && THIS_FLOOR[4][5].equals("") && THIS_FLOOR[6][5].equals("") && THIS_FLOOR[3][6].equals("") && THIS_FLOOR[5][6].equals("") && THIS_FLOOR[7][6].equals("") && THIS_FLOOR[4][7].equals("") && THIS_FLOOR[6][7].equals("")) {
                                            THIS_FLOOR[5][3] = "";
                                            invalidateHandle.sendEmptyMessage(14407);
                                            doorFlash("de1", 5, 3);
                                            specialEventHandle.sendEmptyMessage(14403);
                                        }
                                    }
                                    if (THIS_FLOOR[5][3].equals("")) {
                                        if (THIS_FLOOR[5][2].equals("")) {
                                            THIS_FLOOR[5][8] = "";
                                            invalidateHandle.sendEmptyMessage(14407);
                                            doorFlash("de1", 5, 8);
                                            specialEventHandle.sendEmptyMessage(14402);
                                            atSp = false;

                                        }
                                    }
                                }

                                if(THIS_FLOOR[5][11].equals("20") && THIS_FLOOR[5][5].equals(""))
                                {
                                    atSp = false;
                                    THIS_FLOOR[5][8]="";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    doorFlash("de1", 5,8);
                                }




                                VisibleHandle.sendEmptyMessage(0x134);
                                setNoticeInformation(kind);
                                if(!THIS_FLOOR[4][13].equals("") && !THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][13])][Integer.parseInt(THIS_FLOOR[5][13])].equals("") && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[0][12])][Integer.parseInt(THIS_FLOOR[1][12])].equals("")) && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[2][12])][Integer.parseInt(THIS_FLOOR[3][12])].equals(""))) {
                                    THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][13])][Integer.parseInt(THIS_FLOOR[5][13])] = "";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    doorFlash("de1", Integer.parseInt(THIS_FLOOR[4][13]), Integer.parseInt(THIS_FLOOR[5][13]));
                                    THIS_FLOOR[4][13]="";
                                }
                                if(!THIS_FLOOR[6][13].equals("") && !THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][13])][Integer.parseInt(THIS_FLOOR[7][13])].equals("") &&(THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][12])][Integer.parseInt(THIS_FLOOR[5][12])].equals("")) && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][12])][Integer.parseInt(THIS_FLOOR[7][12])].equals(""))) {
                                    THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][13])][Integer.parseInt(THIS_FLOOR[7][13])] = "";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    doorFlash("de2", Integer.parseInt(THIS_FLOOR[6][13]), Integer.parseInt(THIS_FLOOR[7][13]));
                                    THIS_FLOOR[6][13]="";
                                }
                                backGround.setEnabled(true);

                                if(who.equals("m17")||who.equals("m19")||who.equals("m20"))
                                    infWindow.setAD(tempAD);
                                toolsTouch.setEnabled(true);
                                SoundPlayer.floorChange();
                                move.setEnabled(true);
                                backGround.setEnabled(true);
                                TouchBoolean = true;


                                FPhelperTask.cancel();
                                FPhelper2Task.cancel();
                                FProcessTask.cancel();
                                PlayerLoseHp1Task.cancel();
                                MonsterLoseHp2Task.cancel();
                                FPhelper.cancel();
                                FProcess.cancel();
                                PlayerLoseHp1.cancel();
                                MonsterLoseHp2.cancel();


                            }
                        };
                        FPhelper.schedule(FPhelperTask,150);
                    }
                }
            };
            FProcess.schedule(FProcessTask, 400, 500);

        }
        else{

            int tempAD = infWindow.getAD();


            switch (who) {
                case "m19":
                    if (infWindow.getIfOwn(1)) {
                        tempAD *= 2;
                    } else {
                        infWindow.setHP(infWindow.getHP()-(int)(infWindow.getHP()*0.1));
                    }
                    break;
                case "m17":
                    if (infWindow.getIfOwn(1)) {
                        tempAD *= 2;
                    } else {
                        infWindow.setHP(infWindow.getHP() - 100);
                    }
                    break;
                case "m20":
                    if (infWindow.getIfOwn(1)) {
                        tempAD *= 2;
                    }
                    break;
            }

            for(int k=0;k<infWindow.getVERYBIT();k++){
                VeryKill[k] = true;
            }
            int x = (int)(Math.random()*(99+1));
            if(VeryKill[x]){
                tempAD*=2;
                SoundPlayer.baoji();
            }
            else
                SoundPlayer.fight();


            if(infWindow.getDEF()<Integer.parseInt(Allmoninf[0])){
                int tKm = Integer.parseInt(Allmoninf[2])/(tempAD - Integer.parseInt(Allmoninf[1]));
                infWindow.setHP(infWindow.getHP()- tKm * (Integer.parseInt(Allmoninf[0])-infWindow.getDEF()));
                invalidateHandle.sendEmptyMessage(14400);
            }

            monsNpc.set886(i,j);

            if(infWindow.getBLOOD()>0){
                infWindow.setHP(infWindow.getHP()+(infWindow.getBLOOD()/100f)*Integer.parseInt(Allmoninf[2]));
            }


            infWindow.setGOLD(infWindow.getGOLD()+Integer.parseInt(Allmoninf[3]));
            invalidateHandle.sendEmptyMessage(14400);




            if(THIS_FLOOR[5][11].equals("10")) {

                if (!THIS_FLOOR[5][3].equals("")) {
                    if (THIS_FLOOR[3][4].equals("") && THIS_FLOOR[7][4].equals("") && THIS_FLOOR[4][5].equals("") && THIS_FLOOR[6][5].equals("") && THIS_FLOOR[3][6].equals("") && THIS_FLOOR[5][6].equals("") && THIS_FLOOR[7][6].equals("") && THIS_FLOOR[4][7].equals("") && THIS_FLOOR[6][7].equals("")) {
                        THIS_FLOOR[5][3] = "";
                        invalidateHandle.sendEmptyMessage(14407);
                        doorFlash("de1", 5, 3);
                        specialEventHandle.sendEmptyMessage(14403);
                    }
                }
                if (THIS_FLOOR[5][3].equals("")) {
                    if (THIS_FLOOR[5][2].equals("")) {
                        THIS_FLOOR[5][8] = "";
                        invalidateHandle.sendEmptyMessage(14407);
                        doorFlash("de1", 5, 8);
                        specialEventHandle.sendEmptyMessage(14402);
                        atSp = false;

                    }
                }
            }





            if(!THIS_FLOOR[4][13].equals("") && !THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][13])][Integer.parseInt(THIS_FLOOR[5][13])].equals("") && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[0][12])][Integer.parseInt(THIS_FLOOR[1][12])].equals("")) && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[2][12])][Integer.parseInt(THIS_FLOOR[3][12])].equals(""))) {
                THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][13])][Integer.parseInt(THIS_FLOOR[5][13])] = "";
                invalidateHandle.sendEmptyMessage(14407);
                doorFlash("de1", Integer.parseInt(THIS_FLOOR[4][13]), Integer.parseInt(THIS_FLOOR[5][13]));
                THIS_FLOOR[4][13]="";
            }
            if(!THIS_FLOOR[6][13].equals("") && !THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][13])][Integer.parseInt(THIS_FLOOR[7][13])].equals("") &&(THIS_FLOOR[Integer.parseInt(THIS_FLOOR[4][12])][Integer.parseInt(THIS_FLOOR[5][12])].equals("")) && (THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][12])][Integer.parseInt(THIS_FLOOR[7][12])].equals(""))) {
                THIS_FLOOR[Integer.parseInt(THIS_FLOOR[6][13])][Integer.parseInt(THIS_FLOOR[7][13])] = "";
                invalidateHandle.sendEmptyMessage(14407);
                doorFlash("de2", Integer.parseInt(THIS_FLOOR[6][13]), Integer.parseInt(THIS_FLOOR[7][13]));
                THIS_FLOOR[6][13]="";
            }
            if(THIS_FLOOR[5][11].equals("20") && THIS_FLOOR[5][5].equals(""))
            {
                THIS_FLOOR[5][8]="";
                invalidateHandle.sendEmptyMessage(14407);
                doorFlash("de1", 5,8);
                atSp = false;

            }



        }
    }

    private void setMerchantOnTouch(){
        merchantShop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    float selectedX = (event.getX() / merchantShop.getWidth());
                    float selectedY = (event.getY() / merchantShop.getHeight());
                    TouchSignX = (int) (110 * selectedX);
                    TouchSignY = (int) (90 * selectedY);

                    if(!merchantShop.getIfKey()) {
                        if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 25 && TouchSignY <= 35) {
                            if (infWindow.numOfBlood_3 >= 1) {
                                infWindow.setGOLD(infWindow.getGOLD() + 100);
                                infWindow.numOfBlood_3 -= 1;
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 40 && TouchSignY <= 50) {
                            if (infWindow.numOfBlood_2 >= 1) {
                                infWindow.setGOLD(infWindow.getGOLD() + 150);
                                infWindow.numOfBlood_2 -= 1;
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 55 && TouchSignY <= 65) {
                            if (infWindow.numOfBaoji_3 >= 1) {
                                infWindow.setGOLD(infWindow.getGOLD() + 100);
                                infWindow.numOfBaoji_3 -= 1;
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (40 <= TouchSignX && TouchSignX <= 70 && TouchSignY >= 75 && TouchSignY <= 85) {
                            move.setEnabled(true);
                            backGround.setEnabled(true);
                            merchantShop.setEnabled(false);
                            VisibleHandle.sendEmptyMessage(0x147);
                            toolsTouch.setEnabled(true);
                        }
                    }
                    else{
                        if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 25 && TouchSignY <= 35) {
                            if (infWindow.getGOLD()>= 50) {
                                infWindow.setGOLD(infWindow.getGOLD() - 50);
                                infWindow.setKeyYnum(infWindow.getKeyYnum()+1);
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 40 && TouchSignY <= 50) {
                            if (infWindow.getGOLD()>= 100) {
                                infWindow.setGOLD(infWindow.getGOLD() - 100);
                                infWindow.setKeyBnum(infWindow.getKeyBnum()+1);
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (70 <= TouchSignX && TouchSignX <= 90 && TouchSignY >= 55 && TouchSignY <= 65) {
                            if (infWindow.getGOLD()>= 150) {
                                infWindow.setGOLD(infWindow.getGOLD() - 150);
                                infWindow.setKeyRnum(infWindow.getKeyRnum()+1);
                                invalidateHandle.sendEmptyMessage(14400);
                                SoundPlayer.successBuy();
                            } else {
                                SoundPlayer.noMoneyBuy();
                            }
                        } else if (40 <= TouchSignX && TouchSignX <= 70 && TouchSignY >= 75 && TouchSignY <= 85) {
                            move.setEnabled(true);
                            backGround.setEnabled(true);
                            merchantShop.setEnabled(false);
                            VisibleHandle.sendEmptyMessage(0x147);
                            toolsTouch.setEnabled(true);
                        }
                    }
                }
                return true;
            }
        });
    }
    private void setShopOnTouchListener(){
        shop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP ) {
                    float selectedX = (event.getX() / shop.getWidth());
                    float selectedY = (event.getY() / shop.getHeight());
                    TouchSignX = (int) (110 * selectedX);
                    TouchSignY = (int) (90 * selectedY);

                    if(30<=TouchSignX&&TouchSignX<=80 && TouchSignY >= 30 && TouchSignY<=40){
                        if (infWindow.getGOLD() >= shop.getShopNeedMoney()) {
                            infWindow.setAD(infWindow.getAD() + (shop.getAbilityUp()[0])  );
                            infWindow.setGOLD(infWindow.getGOLD() - shop.getShopNeedMoney());
                            invalidateHandle.sendEmptyMessage(14400);
                            shop.setShopNeedGold();
                            SoundPlayer.successBuy();
                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(30<=TouchSignX&&TouchSignX<=80 && TouchSignY >= 45 && TouchSignY<=55){
                        if (infWindow.getGOLD() >= shop.getShopNeedMoney()) {
                            infWindow.setDEF(infWindow.getDEF() + (shop.getAbilityUp()[1]));
                            infWindow.setGOLD(infWindow.getGOLD() - shop.getShopNeedMoney());
                            invalidateHandle.sendEmptyMessage(14400);
                            shop.setShopNeedGold();
                            SoundPlayer.successBuy();
                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(30<=TouchSignX&&TouchSignX<=80 && TouchSignY >= 60 && TouchSignY<=70){
                        if (infWindow.getGOLD() >= shop.getShopNeedMoney()) {
                            infWindow.setHP(infWindow.getHP() + (shop.getAbilityUp()[2]));
                            infWindow.setGOLD(infWindow.getGOLD() - shop.getShopNeedMoney());
                            invalidateHandle.sendEmptyMessage(14400);
                            shop.setShopNeedGold();
                            SoundPlayer.successBuy();
                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(40<=TouchSignX&&TouchSignX<=70 && TouchSignY >= 75 && TouchSignY<=85){
                        shop.setEnabled(false);
                        VisibleHandle.sendEmptyMessage(0x152);
                        move.setEnabled(true);
                        backGround.setEnabled(true);
                        toolsTouch.setEnabled(true);

                    }

                }

                return true;
            }
        });

    }
    private void setSmithy_4fOnTouchListener(){
        smithy_4f.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN ) {
                    float selectedX = (event.getX() / smithy_4f.getWidth());
                    float selectedY = (event.getY() / smithy_4f.getHeight());
                    TouchSignX = (int) (110 * selectedX);
                    TouchSignY = (int) (90 * selectedY);

                    if(80<=TouchSignX&&TouchSignX<=100 && TouchSignY >= 25 && TouchSignY<=35){
                        if (infWindow.getGOLD() >= 150 && infWindow.numOfBlood_1>=2) {
                            infWindow.setGOLD(infWindow.getGOLD() - 150);

                            if (infWindow.numOfBlood_3 == 0) {
                                infWindow.setAD(infWindow.getAD() + 25);
                                setNoticeInformation("blood_3");
                            }
                            else
                            {
                                setNoticeInformation( "redundantBlood_3");
                            }

                            infWindow.numOfBlood_1 -= 2;
                            infWindow.numOfBlood_3 += 1;
                            invalidateHandle.sendEmptyMessage(14400);
                            SoundPlayer.successBuy();
                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(80<=TouchSignX&&TouchSignX<=100 && TouchSignY >= 40 && TouchSignY<=50){
                        if (infWindow.getGOLD() >= 200 && infWindow.numOfBlood_1>=1) {
                            infWindow.setGOLD(infWindow.getGOLD() - 200);
                            if (infWindow.numOfBlood_2 == 0) {
                                infWindow.setBLOOD(infWindow.getBLOOD() + 10);
                                setNoticeInformation("blood_2");
                            }
                            else
                            {
                                setNoticeInformation( "redundantBlood_2");
                            }
                            infWindow.numOfBlood_1 -= 1;
                            infWindow.numOfBlood_2 += 1;
                            invalidateHandle.sendEmptyMessage(14400);
                            SoundPlayer.successBuy();

                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(80<=TouchSignX&&TouchSignX<=100 && TouchSignY >= 55 && TouchSignY<=65){
                        if (infWindow.getGOLD() >= 150 && infWindow.numOfBaoji_1>=1 && infWindow.numOfBaoji_2>=1) {
                            infWindow.setGOLD(infWindow.getGOLD() - 150);
                            infWindow.setVERYBIT(infWindow.getVERYBIT()-6);

                            if (infWindow.numOfBaoji_3 == 0) {
                                infWindow.setVERYBIT(infWindow.getVERYBIT() + 15);
                                setNoticeInformation("baoji_3CREATE");
                            }
                            else
                            {
                                setNoticeInformation( "redundantBaoji_3");
                            }
                            infWindow.numOfBaoji_1 -= 1;
                            infWindow.numOfBaoji_2 -= 1;
                            infWindow.numOfBaoji_3 +=1;
                            invalidateHandle.sendEmptyMessage(14400);
                            SoundPlayer.successBuy();
                        }
                        else{
                            SoundPlayer.noMoneyBuy();
                        }
                    }
                    else if(40<=TouchSignX&&TouchSignX<=70 && TouchSignY >= 75 && TouchSignY<=85){
                        smithy_4f.setEnabled(false);
                        VisibleHandle.sendEmptyMessage(0x150);
                        move.setEnabled(true);
                        backGround.setEnabled(true);
                        toolsTouch.setEnabled(true);

                    }

                }

                return false;
            }
        });

    }
    private void setDialogTouchListener(){
        dialog.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:

                        float selectedX = (event.getX() / dialog.getWidth());
                        float selectedY = (event.getY() / dialog.getHeight());
                        TouchSignX = (int) (125 * selectedX);
                        TouchSignY = (int) (110 * selectedY);


                        if (5 < TouchSignX && TouchSignX < 125 && 75 < TouchSignY && TouchSignY < 105) {
                            VisibleHandle.sendEmptyMessage(0x148);
                            dialog.setEnabled(false);


                            toolsTouch.setEnabled(true);
//                            toolMessageOnShow = false;
                            floorChange.setEnabled(true);
                            move.setEnabled(true);
                            backGround.setEnabled(true);

                            switch (dialogOfWho) {
                                case "merchant3":
                                    infWindow.setGOLD(infWindow.getGOLD() + 100);
                                    invalidateHandle.sendEmptyMessage(14400);
                                    merchantShop.setKey(false);
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    break;

                                case "merchant":
                                    VisibleHandle.sendEmptyMessage(0x146);

                                    merchantShop.setEnabled(true);
                                    toolsTouch.setEnabled(false);
                                    floorChange.setEnabled(false);
                                    move.setEnabled(false);
                                    backGround.setEnabled(false);
                                    break;
                                case ("1"):
                                    setNoticeInformation("mons_inf");
                                    infWindow.setTOOLS(1);
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    break;
                                case ("2"):
                                    specialEventHandle.sendEmptyMessage(14401);
                                    THIS_FLOOR[8][11] = "作者";THIS_FLOOR[9][11] = "由于暂未开发存读档，所以提供紧急通道。";
                                    THIS_FLOOR[7][8]="";THIS_FLOOR[7][9]="thief";THIS_FLOOR[6][9]="";
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    THIS_FLOOR[7][11] = "";
                                    break;
                                case ("4"):THIS_FLOOR[5][0] = "wallE";
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    break;
                                case ("5"):
                                    THIS_FLOOR[8][11] = "徐大爷";THIS_FLOOR[9][11] = "你找到圣十字架了吗？";
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    break;
                                case ("6"):
                                case ("7"):
                                    break;
                                case ("8"):
                                    break;
                                case ("9"):
                                    infWindow.setAD(infWindow.getAD()+(int)(0.1*infWindow.getAD()));
                                    infWindow.setDEF(infWindow.getDEF()+(int)(0.1*infWindow.getDEF()));
                                    invalidateHandle.sendEmptyMessage(14400);
                                    THIS_FLOOR[TempX][TempY] = "";
                                    invalidateHandle.sendEmptyMessage(14401);
                                    break;
                                case ("10"):
                                    atSp = false;

                                    break;
                                    default:
                                        THIS_FLOOR[TempX][TempY] = "";
                                        invalidateHandle.sendEmptyMessage(14401);
                            }


















                        }

                        break;
                }

                return true;
            }
        });
    }
    private void setSuperDialogOnTouchListener(){
        superDialog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int nowY=0;
                switch (event.getAction()){
                    case (0):

                        break;
                    case (1):
                        VisibleHandle.sendEmptyMessage(0x126);

                        toolsTouch.setEnabled(true);
                        toolMessageOnShow = false;
                        move.setEnabled(true);
                        backGround.setEnabled(true);
                        toolsTouch.setEnabled(true);
                        toolMessageOnShow = false;
//                        VisibleHandle.sendEmptyMessage(0x136);
//                        handbook.setEnabled(false);
                        break;
                    case 2:

                        break;

                }
                return true;
            }
        });
    }
    private void setHandbookOnTouchListener(){
        handbook.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float nowY=0;
                switch (event.getAction()){
                    case (0):
                        downY = event.getY();
                        break;
                    case (1):
                        handbook.startY = handbook.nowY;
                        handbook.moveY = 0;
                        break;
                    case 2:
                        nowY = event.getY();
                        if(handbook.startY+(nowY - downY) <= 0 && handbook.startY + (nowY - downY) >= (5 - handbook.tempSort)*SCREEN_11){
                            handbook.moveY = (nowY - downY);
                            handbook.nowY = handbook.startY + handbook.moveY;
                            invalidateHandle.sendEmptyMessage(14409);
                        }
                        break;

                }
                return true;
            }
        });

    }
    private void setMusicSwitchOnTouchListener(){
        musicSwitch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (musicSwitch.getMusicSwitchContent().equals("关闭测试")) {
                    musicSwitch.setMusicSwitchContent("打开测试");
                    invalidateHandle.sendEmptyMessage(14406);
                    test = false;
                } else if (musicSwitch.getMusicSwitchContent().equals("打开测试")) {
                    musicSwitch.setMusicSwitchContent("关闭测试");
                    invalidateHandle.sendEmptyMessage(14406);
                    test = true;
                }



                move.setEnabled(false);
                backGround.setEnabled(false);
                toolsTouch.setEnabled(false);
                musicSwitch.setEnabled(false);
                VisibleHandle.sendEmptyMessage(0x153);
                menu.setEnabled(true);

                return false;
            }
        });
    }
    private void setMoveOnTouchListener(){
        move.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float selectedX = (event.getX() / move.getWidth());
                float selectedY = (event.getY() / move.getHeight());
                TouchSignX = (int) (1000 * selectedX);
                TouchSignY = (int) (1000 * selectedY);

                auto1.cancel();
                auto2.cancel();
                auto3.cancel();
                auto4.cancel();

                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN):
                        moveHandle.sendEmptyMessage(14400);
                        break;
                    case (MotionEvent.ACTION_MOVE):
                        if (TouchBoolean)
                        {
                            TouchBoolean = false;


                            TouchTimerWaitTask.cancel();
                            TouchTimerWait.cancel();

                            TouchTimerWait = new Timer();
                            TouchTimerWaitTask = new TimerTask() {
                                @Override
                                public void run() {
                                    moveHandle.sendEmptyMessage(14401);
                                    TouchTimerWaitTask.cancel();
                                    TouchTimerWait.cancel();
                                }
                            };
                            TouchTimerWait.schedule(TouchTimerWaitTask, 400);
                        }

                        break;
                    case (MotionEvent.ACTION_UP):
                        move.setDirection(5);
                        moveHandle.sendEmptyMessage(14402);
                }


                return true;
            }
        });
    }
    private void setToolOnTouchListener(){
        toolsTouch.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    float selectedX = (event.getX() / toolsTouch.getWidth());
                    float selectedY = (event.getY() / toolsTouch.getHeight());
                    int TouchSignX = (int) (2 * selectedX);
                    int TouchSignY = (int) (2 * selectedY);

                    if (!toolMessageOnShow) {
                        if (TouchSignX == 0 && TouchSignY == 0 && infWindow.getTOOLSown(1)) {
                            toolsTouch.setEnabled(false);
                            toolMessageOnShow = true;
                            messageBGD.setSetFC(false);
                            VisibleHandle.sendEmptyMessage(0x139);
                            floorChange.setEnabled(false);
                            move.setEnabled(false);
                            backGround.setEnabled(false);
                            messageBGD.setEnabled(true);
                            VisibleHandle.sendEmptyMessage(0x137);
                            if(infWindow.getIfOwn(1))
                                handbook.getSZJ();
                            handbook.startY = 0;
                            handbook.moveY = 0 ;
                            handbook.setPlay(infWindow);
                            handbook.setEnabled(true);
                            for (int i = 0; i <= numberOfMonster - 1; i++) {
                                setMonsterLook(m[i]);
                            }
                            invalidateHandle.sendEmptyMessage(14409);
                            VisibleHandle.sendEmptyMessage(0x135);

                        } else if (TouchSignX == 1 && TouchSignY == 0 && infWindow.getTOOLSown(2)) {

                            floorChange.setMoveY(0);
                            VisibleHandle.sendEmptyMessage(0x140);
                            fcBGD.setEnabled(true);
                            move.setEnabled(false);
                            backGround.setEnabled(false);
                            toolMessageOnShow = true;
                            toolsTouch.setEnabled(false);
                            floorChange.setEnabled(true);
                            VisibleHandle.sendEmptyMessage(0x131);
                        } else if (TouchSignX == 0 && TouchSignY == 1) {

                            toolMessageOnShow = true;
                            toolsTouch.setEnabled(false);
                            toolsBag.setEnabled(true);
                            VisibleHandle.sendEmptyMessage(0x142);
                            backGround.setEnabled(false);
                        }
                    }
                    else{
                        toolMessageOnShow = false;
                    }
                }
                return false;
            }
        });
    }
    private void setGoldMineOnTouchListener(){
        goldMine.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    float selectedX = (event.getX() / goldMine.getWidth());
                    float selectedY = (event.getY() / goldMine.getHeight());
                    int TouchSignX = (int) (100 * selectedX);
                    int TouchSignY = (int) (60 * selectedY);



                    if(40<=TouchSignX&&TouchSignX<=60 && TouchSignY >= 45 && TouchSignY<=55) {
                        if((int)goldMine.getHasHowMuch()>0){
                            infWindow.setGOLD(infWindow.getGOLD()+(int)goldMine.getHasHowMuch());
                            invalidateHandle.sendEmptyMessage(14400);
                            goldMine.setHasHowMuch(goldMine.getHasHowMuch()-(int)goldMine.getHasHowMuch());
                            goldMine.invalidate();
                            toolsTouch.setSetProcess(0);
                            SoundPlayer.successBuy();
                        }
                        else SoundPlayer.noMoneyBuy();
                    }
                    else {
                        backGround.setEnabled(true);
                        move.setEnabled(true);
                        goldMine.setEnabled(false);
                        VisibleHandle.sendEmptyMessage(0x156);
                    }

                }
                return false;
            }
        });
    }
    private void setBackGroundOntTouchListener(){
        backGround.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float selectedX = (event.getX() / backGround.getWidth());
                float selectedY = (event.getY() / backGround.getHeight());
                TouchSignX = (int) (18 * selectedX);
                TouchSignY = (int) (11 * selectedY);
                auto1.cancel();
                auto2.cancel();
                auto3.cancel();
                auto4.cancel();
//                infWindow.log = "";
                if(TouchSignX<11 && (TouchSignX != LSignX || TouchSignY != LSignY)) {

                    if(!nowGLOVE) {

                        if (!THIS_FLOOR[TouchSignX][TouchSignY].equals("wall")) {
                            if (test) {
                                THIS_FLOOR[TouchSignX][TouchSignY] = "";
                                staticEventOnDraw.invalidate();
                                monsNpc.invalidate();
                                player.setX(TouchSignX * SCREEN_11);
                                LSignX = TouchSignX;
                                player.setY(TouchSignY * SCREEN_11);
                                LSignY = TouchSignY;

                            } else {
                                int wayFirst1 = Approach10_PerfectReturn(0, TouchSignX, TouchSignY, LSignX, LSignY, 1);
                                int rcd_1_X = APP10[0][0], rcd_1_Y = APP10[0][1];
                                int wayFirst2 = Approach10_PerfectReturn(1, TouchSignX, TouchSignY, LSignX, LSignY, 1);
                                int rcd_2_X = APP10[0][0], rcd_2_Y = APP10[0][1];

                                infWindow.invalidate();
                                if (wayFirst1 != 51 || wayFirst2 != 51) {
                                    if (wayFirst1 == wayFirst2) {
                                        if (prior_app10X > prior_app10Y) {
                                            APP10[0][0] = rcd_1_X;
                                            APP10[0][1] = rcd_1_Y;
                                            RunApproach10(0);
                                        } else {
                                            APP10[0][0] = rcd_2_X;
                                            APP10[0][1] = rcd_2_Y;
                                            RunApproach10(1);
                                        }
                                    } else if (wayFirst1 < wayFirst2) {
                                        APP10[0][0] = rcd_1_X;
                                        APP10[0][1] = rcd_1_Y;
                                        RunApproach10(0);
                                    } else {
                                        APP10[0][0] = rcd_2_X;
                                        APP10[0][1] = rcd_2_Y;
                                        RunApproach10(1);

                                    }
                                } else if (Approach13_PERFECT() < 51) {
                                    RunApproach13(0);

                                } else {
                                    for (int i = 0; i < stepLen; i++)
                                        autoStep[i][1] = i + 1;

                                    autoStep[0][0] = Approach1_Fork_Left_and_Left();
                                    autoStep[1][0] = Approach2_Fork_Right_and_Left(false);
                                    autoStep[2][0] = Approach3_Fork_Head_and_Left(false);
                                    autoStep[3][0] = Approach4_Fork_Left_and_Right(false);
                                    autoStep[4][0] = Approach5_Fork_Right_and_Right(LSignX, LSignY, TouchSignX, TouchSignY, face);
                                    autoStep[5][0] = Approach6_Fork_Head_and_Right(false);
                                    autoStep[6][0] = Approach2_Fork_Right_and_Left(true);
                                    autoStep[7][0] = Approach3_Fork_Head_and_Left(true);
                                    autoStep[8][0] = Approach4_Fork_Left_and_Right(true);
                                    autoStep[9][0] = Approach6_Fork_Head_and_Right(true);
                                    autoStep[10][0] = Approach7_Only_RightHead(false);
                                    autoStep[11][0] = Approach7_Only_RightHead(true);
                                    autoStep[12][0] = Approach8_Only_LeftHead(false);
                                    autoStep[13][0] = Approach8_Only_LeftHead(true);
//                            autoStep[16][0] = Approach9_Return("ul");
//                            autoStep[17][0] = Approach9_Return("ur");
//                            autoStep[18][0] = Approach9_Return("dl");
//                            autoStep[19][0] = Approach9_Return("dr");
//                            autoStep[20][0] = Approach9_Return("lu");
//                            autoStep[21][0] = Approach9_Return("ru");
//                            autoStep[22][0] = Approach9_Return("ld");
//                            autoStep[23][0] = Approach9_Return("rd");
                                    autoStep[14][0] = Approach11_Fork_onlyRight_and_Left(false);
                                    autoStep[15][0] = Approach11_Fork_onlyRight_and_Left(true);
                                    autoStep[16][0] = Approach12_Fork_onlyLeft_and_Left(false);
                                    autoStep[17][0] = Approach12_Fork_onlyLeft_and_Left(true);
                                    autoStep[18][0] = Approach14_PerfectX_and_Only_Right();
                                    autoStep[19][0] = Approach15_Fork_onlyRight_and_Right();


                                    infWindow.invalidate();
                                    int cnt = 0;
                                    for (int i = 0; i < stepLen; i++) {
                                        if (autoStep[i][0] == 51)
                                            cnt++;
                                    }

                                    if (cnt != stepLen) {
                                        for (int i = 0; i < stepLen - 1; i++) {
                                            for (int j = 0; j < stepLen - i - 1; j++) {
                                                if (autoStep[j][0] >= autoStep[j + 1][0]) {
                                                    int temp[] = autoStep[j].clone();
                                                    autoStep[j] = autoStep[j + 1].clone();
                                                    autoStep[j + 1] = temp.clone();
                                                }
                                            }
                                        }
                                        switch (autoStep[0][1]) {
                                            case 1:
                                                RunApproach1();
                                                break;
                                            case 2:
                                                RunApproach2(false);
                                                break;
                                            case 3:
                                                RunApproach3(false);
                                                break;
                                            case 4:
                                                RunApproach4(false);
                                                break;
                                            case 5:
                                                RunApproach5();
                                                break;
                                            case 6:
                                                RunApproach6(false);
                                                break;
                                            case 7:
                                                RunApproach2(true);
                                                break;
                                            case 8:
                                                RunApproach3(true);
                                                break;
                                            case 9:
                                                RunApproach4(true);
                                                break;
                                            case 10:
                                                RunApproach6(true);
                                                break;
                                            case 11:
                                                RunApproach7(false);
                                                break;
                                            case 12:
                                                RunApproach7(true);
                                                break;
                                            case 13:
                                                RunApproach8(true);
                                                break;
                                            case 14:
                                                RunApproach8(false);
                                                break;
//                                    case 17: RunApproach9("ul");break;
//                                    case 18: RunApproach9("ur");break;
//                                    case 19: RunApproach9("dl");break;
//                                    case 20: RunApproach9("dr");break;
//                                    case 21: RunApproach9("lu");break;
//                                    case 22: RunApproach9("ru");break;
//                                    case 23: RunApproach9("ld");break;
//                                    case 24: RunApproach9("rd");break;
                                            case 15:
                                                RunApproach11(false);
                                                break;
                                            case 16:
                                                RunApproach11(true);
                                                break;
                                            case 17:
                                                RunApproach12(false);
                                                break;
                                            case 18:
                                                RunApproach12(true);
                                                break;
                                            case 19:
                                                RunApproach14();
                                                break;
                                            case 20:
                                                RunApproach115();
                                                break;
                                        }
                                    } else if (Approach13_PERFECT() < 51) {
                                        RunApproach13(0);
                                    } else {
                                        SoundPlayer.noKey();
                                    }
                                }


                            }
                        } else {
                            SoundPlayer.noKey();
                        }
                    }
                    else {
                        THIS_FLOOR[TouchSignX][TouchSignY]="";
                        invalidateHandle.sendEmptyMessage(14401);
                        invalidateHandle.sendEmptyMessage(14407);
//                        nowGLOVE = false;

                        infWindow.numOfGlove-=1;
                        if(infWindow.numOfGlove==0)
                            nowGLOVE = false;
                        invalidateHandle.sendEmptyMessage(14400);
                        SoundPlayer.baoji();
                    }






                }
//




//                        infWindow.way1 = autoStep[0][0];infWindow.w1 = autoStep[0][1];
//                        infWindow.way2 = autoStep[1][0];infWindow.w2 = autoStep[1][1];
//                        infWindow.way3 = autoStep[2][0];infWindow.w3 = autoStep[2][1];
//                        infWindow.way4 = autoStep[3][0];infWindow.w4 = autoStep[3][1];
//                        infWindow.way5 = autoStep[4][0];infWindow.w5 = autoStep[4][1];
//                        infWindow.way6 = autoStep[5][0];infWindow.w6 = autoStep[5][1]
                return false;
            }
        });

    }
    private void setFloorChangeOnTouchListener(){
        floorChange.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float nowY = 0;
                switch (event.getAction()){
                    case (0):
                        downY = event.getY();
                        break;
                    case (1):
                        nowY = event.getY();
                        floorChange.startY = floorChange.nowY;
                        floorChange.moveY = 0;

                        if(distance((int)nowY,(int)downY)<0.5f*SCREEN_11){
                            float selectedX = (event.getX()/floorChange.getWidth() );
                            float selectedY = (event.getY()/floorChange.getHeight() );
                            int SignX = (int)(1150*selectedX);
                            int SignY = (int)(600*selectedY);
                            float perHeight = (floorChange.startY/(floorChange.getHeight()/600f));

                            int floorSort = -1;
                            for(int i=0;i<3;i++){
                                for(int j=0;j<10;j++){
                                    if(150+300*i<SignX && SignX<400+300*i && 0+135*j<SignY - perHeight && SignY - perHeight<100+135*j){
                                        floorSort = i+3*j+1;
                                        break;
                                    }
                                }
                            }
                            if(floorSort!=Integer.parseInt(THIS_FLOOR[5][11])){
                                if(floorSort >=1 && floorSort<=30) {
                                    if(floorChange.getHaveReach(floorSort)) {
                                        if(atSp){
                                            setNoticeInformation("atsp");
                                            SoundPlayer.noKey();
                                        }
                                        else {
                                            auto1.cancel();
                                            auto2.cancel();
                                            auto3.cancel();
                                            auto4.cancel();
                                            temp = floorSort;
                                            if (Integer.parseInt(THIS_FLOOR[5][11]) < floorSort)
                                                floorChange("up");
                                            else if (Integer.parseInt(THIS_FLOOR[5][11]) > floorSort)
                                                floorChange("down");
                                            VisibleHandle.sendEmptyMessage(0x139);
                                            floorChange.setEnabled(false);
                                            move.setEnabled(true);
                                            backGround.setEnabled(true);
                                            toolsTouch.setEnabled(true);
                                            toolMessageOnShow = false;
                                            fcBGD.setEnabled(false);
                                            VisibleHandle.sendEmptyMessage(0x157);
                                        }
                                    }
                                    else{
                                        SoundPlayer.noKey();
                                        setNoticeInformation("!reach");
                                    }
                                }
                                invalidateHandle.sendEmptyMessage(14400);
                            }
                        }
                        break;
                    case 2:
                        nowY = event.getY();
                        if(floorChange.startY+(nowY - downY) <= 0 && floorChange.startY + (nowY - downY) >= -7.75f*SCREEN_11){
                            floorChange.moveY = (nowY - downY);
                            floorChange.nowY = floorChange.startY + floorChange.moveY;
                            invalidateHandle.sendEmptyMessage(14410);
                        }
                        break;
                }
                return true;
            }
        });
    }
    private void setMessageBGDonTouchListener(){
        messageBGD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float selectedX = (event.getX() / messageBGD.getWidth());
                float selectedY = (event.getY() / messageBGD.getHeight());
                TouchSignX = (int) (150 * selectedX);
                TouchSignY = (int) (85 * selectedY);



                if(TouchSignX>=140 && TouchSignX<=150 && TouchSignY>=0 && TouchSignY<=10)
                {
                    move.setEnabled(true);
                    backGround.setEnabled(true);
                    toolsTouch.setEnabled(true);
                    toolMessageOnShow = false;
                    VisibleHandle.sendEmptyMessage(0x136);
                    VisibleHandle.sendEmptyMessage(0x138);
                    messageBGD.setEnabled(false);
                    handbook.setEnabled(false);
                }
                return false;
            }
        });

    }
    private void setfcBgdTouchListener(){
        fcBGD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float selectedX = (event.getX() / fcBGD.getWidth());
                float selectedY = (event.getY() / fcBGD.getHeight());
                int TouchSignX = (int) (115 * selectedX);
                int TouchSignY = (int) (90 * selectedY);



                if(TouchSignX>=105 && TouchSignX<=115 && TouchSignY>=0 && TouchSignY<=10)
                {
                    move.setEnabled(true);
                    backGround.setEnabled(true);
                    toolsTouch.setEnabled(true);
                    toolMessageOnShow = false;
                    VisibleHandle.sendEmptyMessage(0x139);
                    VisibleHandle.sendEmptyMessage(0x141);
                    fcBGD.setEnabled(false);
                    floorChange.setEnabled(false);
                }
                return false;
            }
        });

    }
    private void setToolBagOnTouchListener(){
        toolsBag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                    float selectedX = (event.getX() / toolsBag.getWidth());
                    float selectedY = (event.getY() / toolsBag.getHeight());
                    int TouchSignX = (int) (475 * selectedX);
                    int TouchSignY = (int) (275 * selectedY);



                    if(TouchSignX>425 && TouchSignX<475 && TouchSignY>=0 && TouchSignY<=50)
                    {
                        backGround.setEnabled(true);
                        toolMessageOnShow = false;
                        toolsBag.setEnabled(false);
                        toolsTouch.setEnabled(true);
                        VisibleHandle.sendEmptyMessage(0x143);
                    } else if(toolsBag.getIfOwn(0) && TouchSignX>25 && TouchSignX<125 && TouchSignY>=50 && TouchSignY<=150) {
                        toolsBag.setOwn(0,false);
                        toolsBag.invalidate();
                        int[][] life = new int[50][2];
                        int k=0;
                        for(int i=0;i<11;i++){
                            for(int j=0;j<11;j++) {

                                if (THIS_FLOOR[i][j].equals("npc")||THIS_FLOOR[i][j].equals("merchant")||THIS_FLOOR[i][j].equals("thief")||THIS_FLOOR[i][j].equals("girl")) {
                                    life[k][0] = i;
                                    life[k][1] = j;
                                    k++;

                                }
                                else {
                                    for (int s = 0; s < numberOfMonster; s++) {
                                        if (THIS_FLOOR[i][j].equals(m[s])) {
                                            life[k][0] = i;
                                            life[k][1] = j;
                                            k++;

                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if(k!=0){
                            int[] delete = new int[k];
                            int sort = 0;
                            int rand = 0;
                            int n = 0 ;
                            for(int i=0;i<k/2;i++) {
                                rand = (int) (Math.random() * (k-1 - 0 + 1));

                                for(n=0;n<sort;n++){
                                    if(delete[n]==rand)
                                        break;
                                }
                                if(n==sort)
                                    delete[sort++] = rand;
                                else
                                    i--;
                            }
                            for(int x=0;x<sort;x++){
                                THIS_FLOOR[life[delete[x]][0]][life[delete[x]][1]]="";
                            }
                            SoundPlayer.baoji();
                            invalidateHandle.sendEmptyMessage(14401);
                            invalidateHandle.sendEmptyMessage(14407);
                        }
                    } else if(toolsBag.getIfOwn(2) && TouchSignX>225 && TouchSignX<325 && TouchSignY>=75 && TouchSignY<=175) {
                        toolsBag.setOwn(2,false);
                        toolsBag.invalidate();
                        switch (face){
                            case "up":
                                if(LSignY>=1 && (THIS_FLOOR[LSignX][LSignY-1].equals("wall")||THIS_FLOOR[LSignX][LSignY-1].equals("wallE"))) {
                                    THIS_FLOOR[LSignX][LSignY - 1] = "";
                                    SoundPlayer.openDoor();
                                    invalidateHandle.sendEmptyMessage(14407);
                                }
                                break;
                            case "down":
                                if(LSignY<=9 &&( THIS_FLOOR[LSignX][LSignY+1].equals("wall")||THIS_FLOOR[LSignX][LSignY+1].equals("wallE"))) {
                                    THIS_FLOOR[LSignX][LSignY +1] = "";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    SoundPlayer.openDoor();
                                }
                                break;
                            case "left":
                                if(LSignX>=1 &&( THIS_FLOOR[LSignX-1][LSignY].equals("wall")||THIS_FLOOR[LSignX-1][LSignY].equals("wallE"))) {
                                    THIS_FLOOR[LSignX-1][LSignY] = "";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    SoundPlayer.openDoor();
                                }
                                break;
                            case "right":
                                if(LSignX<=9 && (THIS_FLOOR[LSignX+1][LSignY].equals("wall")||THIS_FLOOR[LSignX+1][LSignY].equals("wallE"))) {
                                    THIS_FLOOR[LSignX+1][LSignY] = "";
                                    invalidateHandle.sendEmptyMessage(14407);
                                    SoundPlayer.openDoor();
                                }
                                break;
                        }
                    }
                }
                return true;
            }
        });
    }
    private void setSpecialNoticeOnTouchListener(){
        specialNotice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP) {
                    float selectedX = (event.getX() / specialNotice.getWidth());
                    float selectedY = (event.getY() / specialNotice.getHeight());
                    int TouchSignX = (int) (110 * selectedX);
                    int TouchSignY = (int) (90 * selectedY);


                    if (TouchSignX >= 40 && TouchSignX <= 70 && TouchSignY >= 70 && TouchSignY <= 80) {
                        specialNotice.setEnabled(false);
                        VisibleHandle.sendEmptyMessage(0x145);
                        move.setEnabled(true);
                        backGround.setEnabled(true);
                    }
                }
                return true;
            }
        });

    }
    private void setMenuOnTouchListener(){
        menu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP) {
                    float selectedX = (event.getX() / menu.getWidth());
                    float selectedY = (event.getY() / menu.getHeight());
                    int TouchSignX = (int) (110 * selectedX);
                    int TouchSignY = (int) (90 * selectedY);



                    if (TouchSignX >= 35 && TouchSignX <= 75 && TouchSignY >= 10 && TouchSignY <= 20) {
                        if(menu.getCase(0)){
                            SoundPlayer.setSd(false);
                            menu.setCase(0,false);
                        }else{
                            SoundPlayer.setSd(true);
                            menu.setCase(0,true);
                        }
                        SoundPlayer.successBuy();
                        menu.invalidate();
                    }else if (TouchSignX >= 35 && TouchSignX <= 75 && TouchSignY >= 25 && TouchSignY <= 35) {
                        if(menu.getCase(1)){
                            menu.setCase(1,false);
                            SoundPlayer.musicPause();
                        }else{
                            SoundPlayer.musicPlay();
                            menu.setCase(1,true);
                        }
                        menu.invalidate();
                        SoundPlayer.successBuy();

                    }else if (TouchSignX >= 30 && TouchSignX <= 80 && TouchSignY >= 40 && TouchSignY <= 50) {
                        if(menu.getCase(2)){
                            menu.setCase(2,false);
                            processShow = false;
                        }else{
                            menu.setCase(2,true);
                            processShow = true;
                        }
                        menu.invalidate();
                        SoundPlayer.successBuy();

                    }else if (TouchSignX >= 40 && TouchSignX <= 70 && TouchSignY >= 70 && TouchSignY <= 80) {
                        move.setEnabled(true);
                        backGround.setEnabled(true);
                        toolsTouch.setEnabled(true);
                        musicSwitch.setEnabled(true);
                        VisibleHandle.sendEmptyMessage(0x154);

                        menu.setEnabled(false);
                    }else if (TouchSignX >= 100 && TouchSignX <= 110 && TouchSignY >= 80 && TouchSignY <= 90) {
                        if(test){
                            test = false;
                            menu.setCase(3,false);
                            menu.invalidate();
                        }
                        else{
                            test = true;
                            menu.setCase(3,true);
                            menu.invalidate();
                            infWindow.setAD(infWindow.getAD()+100);
                            infWindow.setDEF(infWindow.getDEF()+100);
                            infWindow.setHP(infWindow.getHP()+1000);
                            infWindow.setOwnTool(0);
                            infWindow.setOwnTool(2);
                            infWindow.setKeyBnum(10);
                            infWindow.setKeyRnum(10);
                            infWindow.setKeyYnum(10);
                            infWindow.monsterHandBook = true;
                            infWindow.floorChanger = true;
                            infWindow.invalidate();
                            for(int i=0;i<=20;i++)
                                floorChange.setHasReach(i,true);
                            atSp = false;
                        }
                    }




                }
                return true;
            }
        });
    }

    private void MOVE_EVENT(int SignX,int SignY){
        if (0 < SignY && SignY < 1000 && SignY<1000-SignX  && SignY > SignX) {
            move.setDirection(3);
            player.setX(player.getX() - SCREEN_11);
            player.setFace("l");
            invalidateHandle.sendEmptyMessage(14411);
            LSignX -= 1;
            face = "left";
            infWindow.face = face;
            infWindow.invalidate();
            String Event;
            if (LSignX == -1) {
                player.setX(player.getX() + SCREEN_11);
                LSignX += 1;
                Event = "";
            }
            else Event = THIS_FLOOR[LSignX][LSignY];
            SwitchEvent(Event);
        }//left
        else if (0 < SignX && SignX < 1000 && SignY<1000-SignX  && SignY < SignX) {
            move.setDirection(1);
            face = "up";
            player.setFace("u");
            invalidateHandle.sendEmptyMessage(14411);
            infWindow.face = face;
            infWindow.invalidate();
            if(THIS_FLOOR[LSignX][LSignY].equals("to2F")){
                THIS_FLOOR[6][11]="2";
                THIS_FLOOR = FLOOR.getFloorEvent(2);
                THIS_FLOOR[0][11]="10";
                THIS_FLOOR[1][11]="11";
                THIS_FLOOR = FLOOR.getFloorEvent(14);
                floorReset = true;
                floorChange("down");
            }
            player.setY(player.getY() - SCREEN_11);
            LSignY -= 1;
            if (LSignY == -1)
                moveObstacle();
             else
                SwitchEvent(THIS_FLOOR[LSignX][LSignY]);
        }//up
        else if (0 <= SignX && SignX <= 1000 && SignY>1000-SignX  && SignY > SignX) {
            move.setDirection(2);
            face = "down";
            player.setFace("d");
            invalidateHandle.sendEmptyMessage(14411);
            infWindow.face = face;
            infWindow.invalidate();
            if(THIS_FLOOR[LSignX][LSignY].equals("to14F")){
                THIS_FLOOR[4][11]="14";
                THIS_FLOOR = FLOOR.getFloorEvent(14);
                THIS_FLOOR[2][11]="7";
                THIS_FLOOR[3][11]="-1";
                THIS_FLOOR = FLOOR.getFloorEvent(2);
                floorReset = true;
                floorChange("up");
            }
            player.setY(player.getY() + SCREEN_11);
            LSignY += 1;
            if (LSignY == 11)
                moveObstacle();
            else
                SwitchEvent( THIS_FLOOR[LSignX][LSignY]);

        }//down
        else if (0 < SignY && SignY < 1000 && SignY>1000-SignX  && SignY < SignX) {
            move.setDirection(4);
            player.setX(player.getX() + SCREEN_11);
            player.setFace("r");
            invalidateHandle.sendEmptyMessage(14411);
            LSignX += 1;
            String Event;
            face = "right";
            infWindow.face = face;
            infWindow.invalidate();
            if (LSignX == 11) {
                player.setX(player.getX() - SCREEN_11);
                LSignX -= 1;
                Event = "";
            }
            else Event = THIS_FLOOR[LSignX][LSignY];
            SwitchEvent(Event);
        }//right
    }
    private void SwitchEvent(String Event){

        switch (Event) {
            case "": break;
            case "wall":
            case "ob":
            case "shopleft":
            case "shopright":
                moveObstacle();break;
            case "db":
            case "dy":
            case "dr":
            case "de1":
            case "de2":
            case "dz":
            case "wallE":
                throughDoor(Event, LSignX, LSignY);break;
            case "szjWALL":
                throughSZJ();
                break;
            case "ad":
            case "def":
            case "rhp":
            case "bhp":
            case "ky":
            case "kb":
            case "kr":
            case "ad_1":
            case "ad_2":
            case "def_1":
            case "def_2":
            case "baoji_1":
            case "baoji_2":
            case "baoji_3":
            case "blood_1":
            case "blood_2":
            case "blood_3":
            case "little_gold":
            case "floorChanger":
            case "glove":
            case "wall_break":
            case "szj":
                getAbilityUp(Event, LSignX, LSignY);break;
            case "instr":
                instr();break;
            case "specialDoor1":
            case "specialDoor2":
                throughSpecialDoor();break;
            case "shop":
                throughShop();break;
            case "npc":
                throughNpc(LSignX, LSignY);break;
            case "eif":
                throughEif(LSignX, LSignY);break;
            case "up":
            case "down":
                floorChange(Event);break;
            case "smithy":
                throughSmithy();break;
            case "merchant":
            case "merchant2":
            case "merchant3":
                throughMerchant(Event,LSignX,LSignY);break;
            case "thief":
                throughThief(LSignX,LSignY);break;
            case "mine":
                throughGoldMine();break;
            case "specialEvent1":
                specialEvent1();break;
            case "spE2":
                spE2();break;
            case "spE3":
                spE3();break;
            case "girl":
                throughGirl();break;
            case "waigua":
                infWindow.setDEF(260);
                infWindow.setHP(5400);
                infWindow.setAD(520);
                infWindow.setGOLD(1000);
                infWindow.setKeyYnum(10);
                infWindow.setKeyBnum(10);
                infWindow.setKeyRnum(10);
                infWindow.setVERYBIT(50);
                infWindow.setBLOOD(20);
                infWindow.numOfGlove = 99;
                invalidateHandle.sendEmptyMessage(14400);
                break;
            default:
                for (int i = 1; i <= numberOfMonster - 1; i++) {
                    if (Event.equals(m[i])) {
                        throughMonster(AllMonsterInformation[i], Event, LSignX, LSignY, Event);
                        break;
                    }
                }
                break;
        }
    }
    private void moveObstacle(){

        switch (face) {
            case ("down"):
                player.setY(player.getY() - SCREEN_11);
                LSignY -= 1;
                break;
            case ("up"):
                player.setY(player.getY() + SCREEN_11);
                LSignY += 1;
                break;
            case ("left"):
                player.setX(player.getX() + SCREEN_11);
                LSignX += 1;
                break;
            case ("right"):
                player.setX(player.getX() - SCREEN_11);
                LSignX -= 1;
                break;
        }
    }
    private void goAhead(String kind){
        switch (kind) {
            case ("down"):
                player.setY(player.getY() + SCREEN_11);
                LSignY += 1;
                player.setFace("d");
                break;
            case ("up"):
                player.setY(player.getY() - SCREEN_11);
                LSignY -= 1;
                player.setFace("u");
                break;
            case ("left"):
                player.setX(player.getX() - SCREEN_11);
                LSignX -= 1;
                player.setFace("l");
                break;
            case ("right"):
                player.setFace("r");
                player.setX(player.getX() + SCREEN_11);
                LSignX += 1;
                break;
        }
        face = kind;
        invalidateHandle.sendEmptyMessage(14411);

    }

    private boolean ifRightNull(String face,int LSignX,int LSignY){
        switch (face){
            case "left": if(LSignY==0)return false;else return THIS_FLOOR[LSignX][LSignY-1].equals("");
            case "right":
                if(LSignY==10)
                    return false;
                else
                    return THIS_FLOOR[LSignX][LSignY+1].equals("");
            case "up": if(LSignX==10)return false;else return THIS_FLOOR[LSignX+1][LSignY].equals("");
            case "down":if(LSignX==0)return false;else return THIS_FLOOR[LSignX-1][LSignY].equals("");
            default:return false;
        }
    }
    private boolean ifLeftNull(String face,int LSignX,int LSignY){
        switch (face){
            case "left":if(LSignY==10)return false;else return THIS_FLOOR[LSignX][LSignY+1].equals("");
            case "right":if(LSignY==0)return false;else return THIS_FLOOR[LSignX][LSignY-1].equals("");
            case "up": if(LSignX==0)return false;else return THIS_FLOOR[LSignX-1][LSignY].equals("");
            case "down":if(LSignX==10)return false;else return THIS_FLOOR[LSignX+1][LSignY].equals("");
            default:return false;
        }
    }
    private boolean ifCanGoAhead(String face,int LSignX,int LSignY){

        switch (face){
            case "left": if(LSignX==0) return false; else return THIS_FLOOR[LSignX-1][LSignY].equals("");
            case "right": if(LSignX==10) return false;else return THIS_FLOOR[LSignX+1][LSignY].equals("");
            case "up":
                if(LSignY==0)
                    return false;
                else
                    return THIS_FLOOR[LSignX][LSignY-1].equals("");
            case "down": if(LSignY==10) return false;else return THIS_FLOOR[LSignX][LSignY+1].equals("");
            default:return false;
        }
    }
    private int[] VirtualAhead(int x,int y,String face){
        int[] result = new int[2];
        switch (face) {
            case "up":
                result[0] = x;
                result[1] = y-1;
                break;
            case "down":
                result[0] = x;
                result[1] = y+1;
                break;
            case "left":
                result[0] = x-1;
                result[1] = y;
                break;
            case "right":
                result[0] = x+1;
                result[1] = y;
                break;
        }
        return result;
    }
    private int[] VirtualRight(int x,int y,String face){
        int[] result = new int[2];
        switch (face) {
            case "up":
                result[0] = x+1;
                result[1] = y;
                break;
            case "down":
                result[0] = x-1;
                result[1] = y;
                break;
            case "left":
                result[0] = x;
                result[1] = y-1;
                break;
            case "right":
                result[0] = x;
                result[1] = y+1;
                break;
        }
        return result;
    }
    private int[] VirtualLeft(int x,int y,String face){
        int[] result = new int[2];
        switch (face) {
            case "up":
                result[0] = x-1;
                result[1] = y;
                break;
            case "down":
                result[0] = x+1;
                result[1] = y;
                break;
            case "left":
                result[0] = x;
                result[1] = y+1;
                break;
            case "right":
                result[0] = x;
                result[1] = y-1;
                break;
        }
        return result;
    }
    private boolean judgeAroundReach(int lsX,int lsY,int TouchSignX,int TouchSignY){
        if(lsX == TouchSignX){
            if(distance(lsY,TouchSignY)==1)
                return true;
            else
                return false;
        }
        else if(lsY == TouchSignY){
            if(distance(lsX,TouchSignX)==1)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    private void moveToAroundReach(int TouchSignX,int TouchSignY){


        if(LSignX==TouchSignX){
            if(LSignY<TouchSignY){
                goAhead("down");
            }
            else {
                goAhead("up");
            }
        }
        else if(LSignY==TouchSignY){
            if(LSignX<TouchSignX){
                goAhead("right");

            }
            else {
                goAhead("left");
            }
        }
    }

    private String turnRight(String face){
        switch (face) {
            case "left": return "up";
            case "right":  return "down";
            case "up":  return "right";
            case "down":  return "left";
            default: return "";
        }
    }
    private String turnLeft(String face){
        switch (face) {
            case "left": return "down";
            case "right":  return "up";
            case "up":  return "left";
            case "down":  return "right";
            default: return "";
        }
    }
    private String ChangeFace(String face){
        switch (face){
            case "up":return "down";
            case "down":return "up";
            case "left":return "right";
            case "right":return  "left";
            default: return "";
        }
    }

    private int max(int x,int y){
            return x>y?x:y;
    }
    private void judgeMoveX(int LSignX,int x){
        if (x < LSignX) {
            goAhead("left");
        }
        else {
            goAhead("right");
        }
        infWindow.face = face;
        infWindow.invalidate();
    }
    private int min(int x,int y){
        return x<y?x:y;
    }
    private int distance(int x,int y){
        return max(x,y)-min(x,y);
    }
    private void judgeMoveY(int LSignY,int y){
        if (y < LSignY){
            goAhead("up");
            face = "up";
        }
        else{
            goAhead("down");
            face = "down";
        }
        infWindow.face = face;
        infWindow.invalidate();
    }
    private int Approach1_Fork_Left_and_Left(){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;


            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifLeftNull(face,tempX,tempY)) {
                    face = turnLeft(face);
                } else if (ifRightNull(face,tempX,tempY))
                    face = turnRight(face);
                else {
                }
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else {
                face = ChangeFace(face);
            }


            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }


            step++;

            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach2_Fork_Right_and_Left(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifRightNull(face,tempX,tempY)) {
                    face = turnRight(face);
                } else if (ifLeftNull(face,tempX,tempY))
                    face = turnLeft(face);
                else {
                }
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                infWindow.log += step;
                infWindow.invalidate();
                return step;

            } else if(step>50){
                return 51;}

        }
    }
    private int Approach3_Fork_Head_and_Left(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach4_Fork_Left_and_Right(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifLeftNull(face,tempX,tempY)) {
                    face = turnLeft(face);
                } else if (ifRightNull(face,tempX,tempY))
                    face = turnRight(face);
                else {
                }
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach5_Fork_Right_and_Right(int tempX,int tempY,int TouchSignX,int TouchSignY,String face){
        int step = 0;
//        int tempX = LSignX,tempY = LSignY;
//        String face = this.face;

        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifRightNull(face,tempX,tempY)) {
                    face = turnRight(face);
                } else if (ifLeftNull(face,tempX,tempY))
                    face = turnLeft(face);
                else {
                }
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach6_Fork_Head_and_Right(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
//        while(step[0] <=20) {
//
//        }
    }
    private int Approach7_Only_RightHead(boolean overturn) {

        int step = 0;
        int tempX = LSignX;
        int tempY =  LSignY ;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);

         while(true) {
             if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                 return step+1;
             if (ifRightNull(face, tempX, tempY))
                 face = turnRight(face);
             if(!ifCanGoAhead(face,tempX,tempY)){
                 return 51;
             }
             switch (face) {
                 case "up":
                     tempY--;
                     break;
                 case "down":
                     tempY++;
                     break;
                 case "left":
                     tempX--;
                     break;
                 case "right":
                     tempX++;
                     break;
             }
             step++;

             if (TouchSignX == tempX && TouchSignY == tempY) {
                 return step;
             } else if (step > 50) {
                 return 51;
             }
         }
    }
    private int Approach8_Only_LeftHead(boolean overturn) {

        int step = 0;
        int tempX = LSignX;
        int tempY =  LSignY ;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);

        while(true) {


            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifLeftNull(face, tempX, tempY))
                face = turnLeft(face);

            if(!ifCanGoAhead(face,tempX,tempY)){
                return 51;
            }
            switch (face) {
                case "up":
                    tempY--;
                    break;
                case "down":
                    tempY++;
                    break;
                case "left":
                    tempX--;
                    break;
                case "right":
                    tempX++;
                    break;
            }
            step++;

            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if (step > 50) {
                return 51;
            }
        }
    }
    private int Approach9_Return(String Case) {

        int step = 0;
        int tempX = LSignX;
        int tempY =  LSignY ;

        if(Case.equals("ul")||Case.equals("ur")||Case.equals("dl")||Case.equals("dr")) {
            if(tempY == TouchSignY)
            {
                switch (Case){
                    case "ul":
                    case "ur":
                    case "dl":
                    case "dr":return 51;

                }
            }
            while (tempY != TouchSignY) {
                switch (Case) {
                    case "ul":
                    case "ur": tempY--;step++;break;
                    case "dl":
                    case "dr": tempY++;step++;break;
                }
                if ((tempX<0||tempX>10||tempY<0||tempY>10)||!THIS_FLOOR[tempX][tempY].equals(""))
                    return 51;
            }
            while (tempX != TouchSignX){
                switch (Case) {
                    case "ul":
                    case "dl": tempX--;step++;break;
                    case "ur":
                    case "dr": tempX++;step++;break;
                }
                if ((tempX<0||tempX>10||tempY<0||tempY>10)||!THIS_FLOOR[tempX][tempY].equals(""))
                        return 51;
            }
            return step;
        }else {
            if(tempX == TouchSignX)
            {
                switch (Case){
                    case "lu":
                    case "ru":
                    case "ld":
                    case "rd":return 51;

                }
            }
            while (tempX != TouchSignX) {
                switch (Case) {
                    case "lu":
                    case "ld":
                        tempX--;
                        step++;
                        break;
                    case "ru":
                    case "rd":
                        tempX++;
                        step++;
                        break;
                }
                if ((tempX<0||tempX>10||tempY<0||tempY>10)||!THIS_FLOOR[tempX][tempY].equals(""))
                    return 51;
            }
            while (tempY != TouchSignY) {
                switch (Case) {
                    case "lu":
                    case "ru":
                        tempY--;
                        step++;
                        break;
                    case "ld":
                    case "rd":
                        tempY++;
                        step++;
                        break;
                }
                if ((tempX<0||tempX>10||tempY<0||tempY>10)||!THIS_FLOOR[tempX][tempY].equals(""))
                    return 51;
            }
            return step;
        }
    }
    private int Approach10_PerfectReturn(int CASE,int TouchSignX,int TouchSignY,int LSignX,int LSignY,int rcdCase){

        int step = 0;
        if(CASE==0){
            prior_app10X = 0;
            app10[0]="";
            if( TouchSignY == LSignY ) {
                boolean y1 = true;
                for (int x = min(TouchSignX+1, LSignX); x <= max(TouchSignX-1, LSignX); x++) {
                    if (!THIS_FLOOR[x][LSignY].equals("")) {
                        y1 = false;
                        break;
                    }
                }
                if (y1) {

                    prior_app10X = 9;
                    app10[0] = "y1";
                    return distance(TouchSignX, LSignX);
                }
            }
            boolean y2 = true;
            for(int x = min(TouchSignX,LSignX) ; x <= max(TouchSignX,LSignX) ; x++) {
                if (!THIS_FLOOR[x][LSignY].equals("")) {
                    y2 = false;
                    break;
                }
            }
            for(int y = min(TouchSignY+1,LSignY) ; y <= max(TouchSignY-1,LSignY) ; y++) {
                if (!THIS_FLOOR[TouchSignX][y].equals("")) {
                    y2 = false;
                    break;
                }
            }
            if (y2) {

                app10[0] = "y2";
                prior_app10X = 8;
                return distance(TouchSignX, LSignX) + distance(TouchSignY, LSignY);
            } else {

                boolean y3 = true;
                for (int i = 0; i < 11; i++) {
                    y3 = true;
                    for (int x = min(i, LSignX); x <= max(i, LSignX); x++) {
                        if (!THIS_FLOOR[x][LSignY].equals("")) {
                            y3 = false;
                            break;
                        }
                    }
                    if (y3)
                        for (int y = min(TouchSignY, LSignY); y <= max(TouchSignY, LSignY); y++) {
                            if (!THIS_FLOOR[i][y].equals("")) {
                                y3 = false;
                                break;
                            }
                        }
                    if (y3)
                        for (int x = min(i, TouchSignX + 1); x <= max(i, TouchSignX - 1); x++) {
                            if (!THIS_FLOOR[x][TouchSignY].equals("")) {
                                y3 = false;
                                break;
                            }
                        }
                    if (y3) {
                        if(rcdCase == 1)
                            APP10[0][0] = i;
                        else
                            APP10[0][2] = i;
                        break;
                    }
                }
                if (y3) {
                    app10[0] = "y3";
                    prior_app10X = 7;



                    if(rcdCase==1)
                        return distance(APP10[0][0], LSignX) + distance(APP10[0][0], TouchSignX) + distance(TouchSignY, LSignY);
                    else
                        return distance(APP10[0][2], LSignX) + distance(APP10[0][2], TouchSignX) + distance(TouchSignY, LSignY);

                } else {

                    boolean y4 = false;
                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            boolean thisXok = true;
                            for (int x = min(i, TouchSignX); x <= max(i, TouchSignX); x++) {
                                if (!THIS_FLOOR[x][j].equals("")) {
                                    thisXok = false;
                                    break;
                                }
                            }
                            if (thisXok) {
                                boolean thisYok = true;
                                for (int y = min(j, LSignY); y <= max(j, LSignY); y++) {
                                    if (!THIS_FLOOR[i][y].equals("")) {
                                        thisYok = false;
                                        break;
                                    }
                                }
                                if (thisYok) {
                                    boolean toTouch = true;
                                    for (int yy = min(j, TouchSignY + 1); yy <= max(j, TouchSignY - 1); yy++) {
                                        if (!THIS_FLOOR[TouchSignX][yy].equals("")) {
                                            toTouch = false;
                                            break;
                                        }
                                    }
                                    if (toTouch) {
                                        y4 = true;
                                        for (int xx = min(i, LSignX); xx <= max(i, LSignX); xx++) {
                                            if (!THIS_FLOOR[xx][LSignY].equals("")) {
                                                y4 = false;
                                                break;
                                            }
                                        }
                                        if (LSignX == i)
                                            y4 = false;
                                    }
                                }
                            }
                            if (y4) {
                                if(rcdCase==1)
                                    APP10[0][1] = j;
                                else
                                    APP10[0][3] = j;
                                step += distance(LSignY, j) + distance(TouchSignY, j);
                                break;
                            }
                        }
                        if (y4) {
                            if(rcdCase == 1)
                                APP10[0][0] = i;
                            else
                                APP10[0][2] = i;
                            step += distance(LSignX, i) + distance(TouchSignX, i);
                            break;
                        }
                    }
                    if (y4) {
                        app10[0] = "y4";
                        prior_app10X = 6;
                        return step;
                    } else {

//                        if(rcdCase == 1)
//                            APP10[0][0] = APP10[0][1] = -1;
//                        else
//                            APP10[0][2] = APP10[0][3] = -1;
                        return 51;
                    }
                }
            }

        } else {
            prior_app10Y = 0;
            app10[1] = "";
            if (TouchSignX == LSignX) {
                boolean y1 = true;
                for (int Y = min(TouchSignY + 1, LSignY); Y <= max(TouchSignY - 1, LSignY); Y++) {
                    if (!THIS_FLOOR[LSignX][Y].equals("")) {
                        y1 = false;
                        break;
                    }
                }
                if (y1) {
                    app10[1] = "y1";
                    prior_app10Y = 9;
                    return distance(TouchSignY, LSignY);
                }
            }
            boolean y2 = true;
            for (int Y = min(TouchSignY, LSignY); Y <= max(TouchSignY, LSignY); Y++) {
                if (!THIS_FLOOR[LSignX][Y].equals("")) {
                    y2 = false;
                    break;
                }
            }
            for (int X = min(TouchSignX + 1, LSignX); X <= max(TouchSignX - 1, LSignX); X++) {
                if (!THIS_FLOOR[X][TouchSignY].equals("")) {
                    y2 = false;
                    break;
                }
            }
            if (y2) {
                prior_app10Y = 8;
                app10[1] = "y2";
                return distance(TouchSignY, LSignY) + distance(TouchSignX, LSignX);
            } else {
                boolean y3 = true;
                for (int j = 0; j < 11; j++) {
                    y3 = true;
                    for (int y = min(j, LSignY); y <= max(j, LSignY); y++) {
                        if (!THIS_FLOOR[LSignX][y].equals("")) {
                            y3 = false;
                            break;
                        }
                    }
                    if (y3)
                        for (int x = min(TouchSignX, LSignX); x <= max(TouchSignX, LSignX); x++) {
                            if (!THIS_FLOOR[x][j].equals("")) {
                                y3 = false;
                                break;
                            }
                        }
                    if (y3)
                        for (int y = min(j, TouchSignY + 1); y <= max(j, TouchSignY - 1); y++) {
                            if (!THIS_FLOOR[TouchSignX][y].equals("")) {
                                y3 = false;
                                break;
                            }
                        }
                    if (y3) {
                        if(rcdCase == 1)
                            APP10[1][0] = j;
                        else
                            APP10[1][2] = j;
                        break;
                    }
                }
                if (y3) {

                    app10[1] = "y3";
                    prior_app10Y = 7;
                    if(rcdCase == 1)
                        return distance(APP10[1][0], LSignY) + distance(APP10[1][0], TouchSignY) + distance(TouchSignX, LSignX);
                    else
                        return distance(APP10[1][2], LSignY) + distance(APP10[1][2], TouchSignY) + distance(TouchSignX, LSignX);
                } else {
                    boolean y4 = false;
                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {

                            boolean thisYok = true;
                            for (int Y = min(j, TouchSignY); Y <= max(j, TouchSignY); Y++) {
                                if (!THIS_FLOOR[i][Y].equals("")) {
                                    thisYok = false;
                                    break;
                                }
                            }
                            if (thisYok) {
                                boolean thisXok = true;
                                for (int X = min(i, LSignX); X <= max(i, LSignX); X++) {
                                    if (!THIS_FLOOR[X][j].equals("")) {
                                        thisXok = false;
                                        break;
                                    }
                                }
                                if (thisXok) {
                                    boolean toTouch = true;
                                    for (int xx = min(i, TouchSignX + 1); xx <= max(i, TouchSignX - 1); xx++) {
                                        if (!THIS_FLOOR[xx][TouchSignY].equals("")) {
                                            toTouch = false;
                                            break;
                                        }
                                    }
                                    if (toTouch) {
                                        y4 = true;
                                        for (int yy = min(j, LSignY); yy <= max(j, LSignY); yy++) {
                                            if (!THIS_FLOOR[LSignX][yy].equals("")) {
                                                y4 = false;
                                                break;
                                            }
                                        }
                                        if (LSignY == j)
                                            y4 = false;
                                    }
                                }
                            }
                            if (y4) {
                                if(rcdCase == 1)
                                    APP10[1][1] = j;
                                else
                                    APP10[1][3] = j;
                                step += distance(LSignY, j) + distance(TouchSignY, j);
                                break;
                            }
                        }
                        if (y4) {
                            if(rcdCase == 1)
                                APP10[1][0] = i;
                            else
                                APP10[1][2] = i;
                            step += distance(LSignX, i) + distance(TouchSignX, i);
                            break;
                        }
                    }
                    if (y4) {
                        prior_app10Y = 6;
                        app10[1] = "y4";
                        return step;
                    } else {
//                        if(rcdCase == 1)
//                            APP10[0][0] = APP10[0][1] = -1;
//                        else
//                            APP10[0][2] = APP10[0][3] = -1;
                        return 51;
                    }
                }
            }
        }
    }
    private int Approach11_Fork_onlyRight_and_Left(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }
            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifRightNull(face,tempX,tempY)) {
                    face = turnRight(face);
                }
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach12_Fork_onlyLeft_and_Left(boolean overturn){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        if(overturn)
            face = ChangeFace(face);
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }else

            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifLeftNull(face,tempX,tempY)) {
                    face = turnLeft(face);
                }
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }
    private int Approach13_PERFECT(){
        APP13X = APP13Y = -1;
        int rcd1,rcd2;
        String appRcd;
        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                rcd2 = Approach10_PerfectReturn(0, TouchSignX, TouchSignY, i, j,2);
                appRcd = app10[0];
                rcd1 = Approach10_PerfectReturn(0, i, j, LSignX, LSignY,1);
                if (app10[0].equals("y4") && appRcd.equals("y1")) {
                    app10[0] = "y5";

                    APP13X = i;
                    APP13Y = j;
                    return rcd1 + rcd2;
                }
            }
        }
        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                rcd2 = Approach10_PerfectReturn(0, TouchSignX, TouchSignY, i, j,2);
                appRcd = app10[0];
                rcd1 = Approach10_PerfectReturn(0, i, j, LSignX, LSignY,1);
                if (app10[0].equals("y4") && appRcd.equals("y2")) {
                    app10[0] = "y6";
                    APP13X = i;
                    APP13Y = j;
                    return rcd1 + rcd2;
                }
            }
        }
        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                rcd2 = Approach10_PerfectReturn(0, TouchSignX, TouchSignY, i, j,2);

                appRcd = app10[0];
                rcd1 = Approach10_PerfectReturn(0, i, j, LSignX, LSignY,1);
                if (app10[0].equals("y4") && appRcd.equals("y3")) {
                    app10[0] = "y7";

                    APP13X = i;
                    APP13Y = j;
                    return rcd1 + rcd2;
                }
            }
        }
        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                rcd2 = Approach10_PerfectReturn(0, TouchSignX, TouchSignY, i, j,2);
                appRcd = app10[0];
                rcd1 = Approach10_PerfectReturn(0, i, j, LSignX, LSignY,1);
                if (app10[0].equals("y4") && appRcd.equals("y4")) {
                    app10[0] = "y8";
                    APP13X = i;
                    APP13Y = j;
                    return rcd1 + rcd2;
                }
            }
        }
        return 51;
    }
    private int Approach14_PerfectX_and_Only_Right(){
        int stepA,stepB=0;
        int ii;
        APP14X1 = APP14X2 = APP14Y = -1;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(THIS_FLOOR[i][j].equals("")  &&  (stepA = Approach10_PerfectReturn(0,i,j,LSignX,LSignY,1))<51) {
                    for (ii = i;  ii>=1 && THIS_FLOOR[ii - 1][j].equals(""); ii--,stepB++) ;
                    if ((stepB += Approach5_Fork_Right_and_Right(ii, j, TouchSignX, TouchSignY, "left")) < 51) {
                        APP14X1 = i;
                        APP14X2 = ii;
                        APP14Y = j;


                        return stepA + stepB;
                    }
                }
            }
        }
        return 51;
    }
    private int Approach15_Fork_onlyRight_and_Right(){
        int step = 0;
        int tempX = LSignX,tempY = LSignY;
        String face = this.face;
        while (true) {
            if(!ifCanGoAhead(face,tempX,tempY)&&!ifLeftNull(face,tempX,tempY)&&!ifRightNull(face,tempX,tempY)&&!ifCanGoAhead(ChangeFace(face),tempX,tempY)) {
                if(judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                    return 1;
                else
                    return 51;
            }
            if (judgeAroundReach(tempX,tempY,TouchSignX,TouchSignY))
                return step+1;
            if (ifCanGoAhead(face,tempX,tempY)) {
                if (ifRightNull(face,tempX,tempY)) {
                    face = turnRight(face);
                }
            } else if (ifRightNull(face,tempX,tempY)) {
                face = turnRight(face);
            } else if (ifLeftNull(face,tempX,tempY)) {
                face = turnLeft(face);
            } else {
                face = ChangeFace(face);
            }
            switch (face){
                case "up":tempY--;break;
                case "down":tempY++;break;
                case "left":tempX--;break;
                case "right":tempX++;break;
            }
            step++;
            if (TouchSignX == tempX && TouchSignY == tempY) {
                return step;
            } else if(step>50){
                return 51;}

        }
    }


    private void RunApproach1(){
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }
                else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifLeftNull(face, LSignX, LSignY)) {
                            face = turnLeft(face);
                        } else if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        } else {
                        }
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }

            }
        },0,moveInterval);
    }
    private void RunApproach2(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }
                else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        } else if (ifLeftNull(face, LSignX, LSignY)) {
                            face = turnLeft(face);
                        } else {
                        }
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }

        },0,moveInterval);
    }
    private void RunApproach3(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach4(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {

                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }
                else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifLeftNull(face, LSignX, LSignY)) {
                            face = turnLeft(face);
                        } else if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        } else {
                        }
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }

            }
        },0,moveInterval);
    }
    private void RunApproach5(){
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        } else if (ifLeftNull(face, LSignX, LSignY)) {
                            face = turnLeft(face);
                        } else {
                        }
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach6(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach7(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifRightNull(face, LSignX, LSignY))
                        face = turnRight(face);
                    goAhead(face);
                }
            }

        },0,moveInterval);
    }
    private void RunApproach8(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifLeftNull(face, LSignX, LSignY))
                        face = turnLeft(face);
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach9(final String Case) {

        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {

                switch (Case) {
                    case "ul":
                    case "ur":
                        goAhead("up");
                        break;
                    case "dl":
                    case "dr":
                        goAhead("down");
                        break;
                    case "lu":
                    case "ld":
                        goAhead("left");
                        break;
                    case "ru":
                    case "rd":
                        goAhead("right");
                        break;
                }
                switch (Case) {
                    case "ul":
                    case "ur":
                    case "dl":
                    case "dr":
                        if (LSignY == TouchSignY) {
                            auto1.cancel();
                            auto2 = new Timer();
                            auto2.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    if (LSignX == TouchSignX) {
                                        auto2.cancel();
                                        SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                    }
                                    else
                                        switch (Case) {
                                            case "ul":
                                            case "dl":
                                                goAhead("left");
                                                break;
                                            case "ur":
                                            case "dr":
                                                goAhead("right");
                                                break;
                                        }
                                }
                            }, 400, 400);
                        }
                        break;
                    case "lu":
                    case "ld":
                    case "ru":
                    case "rd":
                        if (LSignX == TouchSignX) {
                            auto1.cancel();
                            auto2 = new Timer();
                            auto2.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    if (LSignY == TouchSignY) {
                                        auto2.cancel();
                                        SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                    }
                                    else
                                        switch (Case) {
                                            case "lu":
                                            case "ru":
                                                goAhead("up");
                                                break;
                                            case "rd":
                                            case "ld":
                                                goAhead("down");
                                                break;
                                        }


                                }
                            }, 400, 400);
                        }
                        break;
                }


            }
        },0,moveInterval);
    }
    private void RunApproach10(int CASE){

        switch (CASE){
            case 0:
                switch (app10[0]){
                    case "y1":

                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (TouchSignX != LSignX) {
                                    if(TouchSignX < LSignX) {
                                        goAhead("left");
                                        face = "left";
                                    }
                                    else{
                                        goAhead("right");
                                        face = "right";
                                    }
                                }
                                if(TouchSignX == LSignX) {
                                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                    auto1.cancel();
                                }
                            }
                        }, 0, moveInterval);
                        break;
                    case "y2":
                        auto2 = new Timer();
                        auto2.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (TouchSignX != LSignX) {
                                    judgeMoveX(LSignX,TouchSignX);
                                } else {
                                    auto2.cancel();
                                    auto3 = new Timer();
                                    auto3.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (TouchSignY != LSignY) {
                                                judgeMoveY(LSignY,TouchSignY);
                                            }
                                            if(TouchSignY == LSignY) {
                                                SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                auto3.cancel();
                                                ;
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                    case "y3":

                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (LSignX != APP10[0][0]) {
                                    judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (LSignY != TouchSignY) {
                                                judgeMoveY(LSignY,TouchSignY);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != TouchSignX) {
                                                            judgeMoveX(LSignX,TouchSignX);
                                                        }
                                                        if(TouchSignX == LSignX) {
                                                            SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                            auto3.cancel();
                                                            ;
                                                        }
                                                    }
                                                },0,moveInterval);
                                            }
                                        }
                                    },0,moveInterval);
                                }
                            }
                        },0,moveInterval);
                        break;
                    case "y4":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[0][0] != LSignX) {
                                   judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[0][1] != LSignY) {
                                                judgeMoveY(LSignY,APP10[0][1]);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != TouchSignX) {
                                                            if (LSignX < TouchSignX)
                                                                goAhead("right");
                                                            else
                                                                goAhead("left");
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignY != TouchSignY) {
                                                                        if (LSignY < TouchSignY){
                                                                            goAhead("down");
                                                                            face = "down";
                                                                        }
                                                                        else{
                                                                            goAhead("up");
                                                                            face = "up";
                                                                        }
                                                                    }
                                                                    if(TouchSignY == LSignY) {
                                                                        SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                        auto4.cancel();

                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                }
                break;
            case 1:

                switch (app10[1]){
                    case "y1":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (TouchSignY != LSignY) {
                                    if (TouchSignY < LSignY){
                                        face = "up";
                                        goAhead("up");}
                                    else{
                                        face = "down";
                                        goAhead("down");}
                                }
                                if(TouchSignY == LSignY) {
                                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                    auto1.cancel();
                                }
                            }
                        }, 0, moveInterval);
                        break;
                    case "y2":

                        auto2 = new Timer();
                        auto2.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (TouchSignY != LSignY) {
                                    if (TouchSignY < LSignY)
                                        goAhead("up");
                                    else
                                        goAhead("down");
                                } else {
                                    auto2.cancel();
                                    auto3 = new Timer();
                                    auto3.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (TouchSignX != LSignX) {
                                                if (TouchSignX < LSignX){
                                                    face = "left";
                                                    goAhead("left");}
                                                else {
                                                    face = "right";
                                                    goAhead("right");
                                                }
                                            }
                                            if(TouchSignX == LSignX) {
                                                SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                auto3.cancel();
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                    case "y3":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (LSignY != APP10[1][0]) {
                                    if (LSignY < APP10[1][0])
                                        goAhead("down");
                                    else
                                        goAhead("up");
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (LSignX != TouchSignX) {
                                                if (LSignX < TouchSignX)
                                                    goAhead("right");
                                                else
                                                    goAhead("left");
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignY != TouchSignY) {
                                                            if (LSignY < TouchSignY)
                                                                goAhead("down");
                                                            else
                                                                goAhead("up");
                                                        }
                                                        if(TouchSignY == LSignY) {
                                                            SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                            auto3.cancel();
                                                            ;
                                                        }
                                                    }
                                                },0,moveInterval);
                                            }
                                        }
                                    },0,moveInterval);
                                }
                            }
                        },0,moveInterval);
                        break;
                    case "y4":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[1][1] != LSignY) {
                                    if (APP10[1][1] < LSignY)
                                        goAhead("up");
                                    else
                                        goAhead("down");
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[1][0] != LSignX) {
                                                if (APP10[1][0] < LSignX)
                                                    goAhead("left");
                                                else
                                                    goAhead("right");
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignY != TouchSignY) {
                                                            if (LSignY < TouchSignY)
                                                                goAhead("down");
                                                            else
                                                                goAhead("up");
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignX != TouchSignX) {
                                                                        if (LSignX < TouchSignX) {
                                                                            goAhead("right");
                                                                            face = "right";
                                                                        }
                                                                        else{
                                                                            face = "left";
                                                                            goAhead("left");
                                                                        }
                                                                    }
                                                                    if(TouchSignX == LSignX) {
                                                                        SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                        auto4.cancel();
                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                }
                break;

        }

    }
    private void RunApproach11(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        }
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach12(boolean overturn){
        if(overturn)
            face = ChangeFace(face);
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifLeftNull(face, LSignX, LSignY)) {
                            face = turnLeft(face);
                        }
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }
    private void RunApproach13(int CASE){
        switch (CASE){
            case 0:
//                infWindow.log = "log!";
//                infWindow.invalidate();
                switch (app10[0]){
                    case "y5":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[0][0] != LSignX) {
                                   judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[0][1] != LSignY) {
                                                judgeMoveY(LSignY,APP10[0][1]);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != APP13X) {
                                                            judgeMoveX(LSignX,APP13X);
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignY != APP13Y) {
                                                                        judgeMoveY(LSignY,APP13Y);
                                                                    } else {
                                                                        auto4.cancel();
                                                                        auto1 = new Timer();
                                                                        auto1.schedule(new TimerTask() {
                                                                            @Override
                                                                            public void run() {
                                                                                if (LSignX != TouchSignX) {
                                                                                    if (LSignX < TouchSignX){
                                                                                        goAhead("right");
                                                                                        face = "right";
                                                                                    }
                                                                                    else{
                                                                                        goAhead("left");
                                                                                        face = "left";
                                                                                    }
                                                                                }
                                                                                if (LSignX == TouchSignX) {
                                                                                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                                    auto1.cancel();
                                                                                }
                                                                            }
                                                                        },0,moveInterval);
                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);

                        break;
                    case "y6":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[0][0] != LSignX) {
                                   judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[0][1] != LSignY) {
                                                judgeMoveY(LSignY,APP10[0][1]);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != APP13X) {
                                                            judgeMoveX(LSignX,APP13X);
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignY != APP13Y) {
                                                                        judgeMoveY(LSignY,APP13Y);
                                                                    } else {
                                                                        auto4.cancel();
                                                                        auto1 = new Timer();
                                                                        auto1.schedule(new TimerTask() {
                                                                            @Override
                                                                            public void run() {
                                                                                if (LSignX != TouchSignX) {
                                                                                    if (LSignX < TouchSignX){
                                                                                        goAhead("right");
                                                                                        face = "right";
                                                                                    }
                                                                                    else{
                                                                                        goAhead("left");
                                                                                        face = "left";
                                                                                    }
                                                                                }else  {
                                                                                    auto1.cancel();
                                                                                    auto2 = new Timer();
                                                                                    auto2.schedule(new TimerTask() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            if (LSignY != TouchSignY) {
                                                                                                if (LSignY < TouchSignY) {
                                                                                                    goAhead("down");
                                                                                                    face = "down";
                                                                                                } else {
                                                                                                    goAhead("up");
                                                                                                    face = "up";
                                                                                                }
                                                                                            }
                                                                                            if (LSignY == TouchSignY) {
                                                                                                SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                                                auto2.cancel();
                                                                                            }                                                                                        }
                                                                                    },0,moveInterval);
                                                                                }
                                                                            }
                                                                        },0,moveInterval);
                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);

                        break;
                    case "y7":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[0][0] != LSignX) {
                                   judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[0][1] != LSignY) {
                                                judgeMoveY(LSignY,APP10[0][1]);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != APP13X) {
                                                            judgeMoveX(LSignX,APP13X);
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignY != APP13Y) {
                                                                        judgeMoveY(LSignY,APP13Y);
                                                                    } else {
                                                                        auto4.cancel();
                                                                        auto1 = new Timer();
                                                                        auto1.schedule(new TimerTask() {
                                                                            @Override
                                                                            public void run() {
                                                                                if (LSignX != APP10[0][2]) {
                                                                                    judgeMoveX(LSignX,APP10[0][2]);
                                                                                }else  {
                                                                                    auto1.cancel();
                                                                                    auto2 = new Timer();
                                                                                    auto2.schedule(new TimerTask() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            if (LSignY != TouchSignY) {
                                                                                                judgeMoveY(LSignY,TouchSignY);
                                                                                            } else {
                                                                                                auto2.cancel();
                                                                                                auto3 = new Timer();
                                                                                                auto3.schedule(new TimerTask() {
                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        if (LSignX != TouchSignX) {
                                                                                                            judgeMoveX(LSignX,TouchSignX);
                                                                                                        }
                                                                                                        if(LSignX==TouchSignX){
                                                                                                            SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                                                            auto3.cancel();
                                                                                                        }
                                                                                                    }
                                                                                                },0,moveInterval);
                                                                                            }                                                                                        }
                                                                                    },0,moveInterval);
                                                                                }
                                                                            }
                                                                        },0,moveInterval);
                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                    case "y8":
                        auto1 = new Timer();
                        auto1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (APP10[0][0] != LSignX) {
                                   judgeMoveX(LSignX,APP10[0][0]);
                                } else {
                                    auto1.cancel();
                                    auto2 = new Timer();
                                    auto2.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (APP10[0][1] != LSignY) {
                                                judgeMoveY(LSignY,APP10[0][1]);
                                            } else {
                                                auto2.cancel();
                                                auto3 = new Timer();
                                                auto3.schedule(new TimerTask() {
                                                    @Override
                                                    public void run() {
                                                        if (LSignX != APP13X) {
                                                            judgeMoveX(LSignX,APP13X);
                                                        } else {
                                                            auto3.cancel();
                                                            auto4 = new Timer();
                                                            auto4.schedule(new TimerTask() {
                                                                @Override
                                                                public void run() {
                                                                    if (LSignY != APP13Y) {
                                                                        judgeMoveY(LSignY,APP13Y);
                                                                    } else {
                                                                        auto4.cancel();
                                                                        auto1 = new Timer();
                                                                        auto1.schedule(new TimerTask() {
                                                                            @Override
                                                                            public void run() {
                                                                                if (LSignX != APP10[0][2]) {
                                                                                    judgeMoveX(LSignX,APP10[0][2]);
                                                                                }else  {
                                                                                    auto1.cancel();
                                                                                    auto2 = new Timer();
                                                                                    auto2.schedule(new TimerTask() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            if (LSignY != APP10[0][3]) {
                                                                                                judgeMoveY(LSignY,APP10[0][3]);
                                                                                            } else {
                                                                                                auto2.cancel();
                                                                                                auto3 = new Timer();
                                                                                                auto3.schedule(new TimerTask() {
                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        if (LSignX != TouchSignX) {
                                                                                                            judgeMoveX(LSignX,TouchSignX);
                                                                                                        }else{
                                                                                                            auto3.cancel();
                                                                                                            auto4 = new Timer();
                                                                                                            auto4.schedule(new TimerTask() {
                                                                                                                @Override
                                                                                                                public void run() {
                                                                                                                    if (LSignY != TouchSignY) {
                                                                                                                        judgeMoveY(LSignY,TouchSignY);
                                                                                                                    }
                                                                                                                    if(LSignY == TouchSignY){
                                                                                                                        auto4.cancel();
                                                                                                                        SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                                                                    }
                                                                                                                }
                                                                                                            },0,moveInterval);
                                                                                                        }
                                                                                                    }
                                                                                                },0,moveInterval);
                                                                                            }                                                                                        }
                                                                                    },0,moveInterval);
                                                                                }
                                                                            }
                                                                        },0,moveInterval);
                                                                    }
                                                                }
                                                            }, 0, moveInterval);
                                                        }
                                                    }
                                                }, 0, moveInterval);
                                            }
                                        }
                                    }, 0, moveInterval);
                                }
                            }
                        }, 0, moveInterval);
                        break;
                }
                break;




            case 1:
                break;

        }
    }
    private void RunApproach14(){
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if (APP10[0][0] != LSignX) {
                    judgeMoveX(LSignX,APP10[0][0]);
                } else {
                    auto1.cancel();
                    auto2 = new Timer();
                    auto2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (APP10[0][1] != LSignY) {
                                judgeMoveY(LSignY,APP10[0][1]);
                            } else {
                                auto2.cancel();
                                auto3 = new Timer();
                                auto3.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        if (LSignX != APP14X1) {
                                            if (LSignX < APP14X1)
                                                goAhead("right");
                                            else
                                                goAhead("left");
                                        } else {
                                            auto3.cancel();
                                            auto4 = new Timer();
                                            auto4.schedule(new TimerTask() {
                                                @Override
                                                public void run() {
                                                    if (LSignY != APP14Y) {
                                                        if (LSignY < APP14Y){
                                                            goAhead("down");
                                                            face = "down";
                                                        }
                                                        else{
                                                            goAhead("up");
                                                            face = "up";
                                                        }
                                                    } else {
                                                        auto4.cancel();
                                                        auto1 = new Timer();
                                                        auto1.schedule(new TimerTask() {
                                                            @Override
                                                            public void run() {
                                                                if(LSignX != APP14X2){
                                                                    judgeMoveX(LSignX,APP14X2);
                                                                }else{
                                                                    auto1.cancel();
                                                                    auto2 = new Timer();
                                                                    auto2.schedule(new TimerTask() {
                                                                        @Override
                                                                        public void run() {
                                                                            if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                                                                                moveToAroundReach(TouchSignX,TouchSignY);
                                                                                SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                                                                                auto2.cancel();
                                                                            }else {
                                                                                if (ifCanGoAhead(face, LSignX, LSignY)) {
                                                                                    if (ifRightNull(face, LSignX, LSignY)) {
                                                                                        face = turnRight(face);
                                                                                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                                                                                        face = turnLeft(face);
                                                                                    } else {
                                                                                    }
                                                                                } else if (ifRightNull(face, LSignX, LSignY)) {
                                                                                    face = turnRight(face);
                                                                                } else if (ifLeftNull(face, LSignX, LSignY)) {
                                                                                    face = turnLeft(face);
                                                                                } else {
                                                                                    face = ChangeFace(face);
                                                                                }
                                                                                goAhead(face);
                                                                            }
                                                                        }
                                                                    },0,moveInterval);
                                                                }
                                                            }
                                                        },0,moveInterval);
                                                    }
                                                }
                                            }, 0, moveInterval);
                                        }
                                    }
                                }, 0, moveInterval);
                            }
                        }
                    }, 0, moveInterval);
                }
            }
        }, 0, moveInterval);

    }
    private void RunApproach115(){
        auto1 = new Timer();
        auto1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(judgeAroundReach(LSignX,LSignY,TouchSignX,TouchSignY)){
                    moveToAroundReach(TouchSignX,TouchSignY);
                    SwitchEvent(THIS_FLOOR[TouchSignX][TouchSignY]);
                    auto1.cancel();
                }else {
                    if (ifCanGoAhead(face, LSignX, LSignY)) {
                        if (ifRightNull(face, LSignX, LSignY)) {
                            face = turnRight(face);
                        }
                    } else if (ifRightNull(face, LSignX, LSignY)) {
                        face = turnRight(face);
                    } else if (ifLeftNull(face, LSignX, LSignY)) {
                        face = turnLeft(face);
                    } else {
                        face = ChangeFace(face);
                    }
                    goAhead(face);
                }
            }
        },0,moveInterval);
    }

    private void specialEvent1() {
        atSp = true;
        THIS_FLOOR[5][7]="";
            dialog.setNameTextSize(0.48f*SCREEN_11);
            dialog.setNpcImage("boss1");
            THIS_FLOOR[7][11] = "2";
            dialog.setNpcNameAndSaying("骷髅队长","哈哈哈你中计了沙雕！","大家冲鸭！！");

            VisibleHandle.sendEmptyMessage(0x129);
            dialogOfWho = THIS_FLOOR[7][11];
            dialog.setEnabled(true);
            invalidateHandle.sendEmptyMessage(14403);
            move.setEnabled(false);
            backGround.setEnabled(false);
            toolsTouch.setEnabled(false);
            moveHandle.sendEmptyMessage(14402);
    }
    private void spE2(){
        dialog.setNpcImage("girl");
        dialog.setNameTextSize(0.69f*SCREEN_11);
        dialog.setNameWidth(2);
        THIS_FLOOR[7][11] = "6";
        dialog.setNpcNameAndSaying("公主","（大喊）救我鸭快救我鸭！！","");
        THIS_FLOOR[5][8]="";
        VisibleHandle.sendEmptyMessage(0x129);
        dialogOfWho = THIS_FLOOR[7][11];

        dialog.setEnabled(true);
        move.setEnabled(false);
        backGround.setEnabled(false);

    }
    private void spE3(){
        atSp = true;
        THIS_FLOOR[5][5] = "m20";
        move.setEnabled(false);
        backGround.setEnabled(false);
        invalidateHandle.sendEmptyMessage(14401);
        dialog.setNpcImage("boss2");
        dialog.setNameTextSize(0.48f*SCREEN_11);
        dialog.setNameWidth(3.2f);
        THIS_FLOOR[7][11] = "8";
        dialog.setNpcNameAndSaying("吸血鬼魔王","很好！你居然到了这里！和我决斗吧小呆瓜！","");
        SoundPlayer.openDoor();
        THIS_FLOOR[5][8] = "de1";
        THIS_FLOOR[0][12] = "5"; THIS_FLOOR[1][12] = "5"; THIS_FLOOR[2][12] = "5"; THIS_FLOOR[3][12] = "4";
        invalidateHandle.sendEmptyMessage(14407);
        THIS_FLOOR[5][7]="";
        VisibleHandle.sendEmptyMessage(0x129);
        dialogOfWho = THIS_FLOOR[7][11];

        dialog.setEnabled(true);
    }
    @SuppressLint("HandlerLeak")
    private void setAllHandle() {

        invalidateHandle = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 14408 :backGround.invalidate();break;
                    case(14400):infWindow.invalidate();break;
                    case(14401):monsNpc.setBitmap();monsNpc.invalidate();break;
                    case(14402):superDialog.invalidate();break;
                    case(14403):dialog.invalidate();break;
                    case(14404):doorFlasher.invalidate();break;
                    case(14405):notice.invalidate();break;
                    case(14406):musicSwitch.invalidate();break;
                    case(14407):staticEventOnDraw.invalidate();break;
                    case 14409 :handbook.invalidate();break;
                    case 14410 :floorChange.invalidate();break;
                    case 14411:player.invalidate();break;
                }
            }
        };
        specialEventHandle = new Handler(){
            public void handleMessage(Message msg){
                switch (msg.what){
                    case 14401:
                        THIS_FLOOR[5][2] = "m10";
                        THIS_FLOOR[5][5] = "";
                        THIS_FLOOR[3][4] = "m11";
                        THIS_FLOOR[7][4] = "m11";
                        THIS_FLOOR[4][7] = "m11";
                        THIS_FLOOR[6][7] = "m11";
                        THIS_FLOOR[4][5] = "m12";
                        THIS_FLOOR[6][5] = "m12";
                        THIS_FLOOR[5][6] = "m12";
                        THIS_FLOOR[3][6] = "m6";
                        THIS_FLOOR[7][6] = "m6";
                        SoundPlayer.openDoor();
                        THIS_FLOOR[5][3] = "specialDoor1";
                        THIS_FLOOR[5][8] = "specialDoor2";


                        staticEventOnDraw.setEvent(THIS_FLOOR);
                        monsNpc.setEvent(THIS_FLOOR);
                        break;
                    case 14402:
                        THIS_FLOOR[5][8] = "";
                        invalidateHandle.sendEmptyMessage(14407);
                        doorFlash("de1", 5, 8);
                        THIS_FLOOR[5][0] = "up";
                        THIS_FLOOR[4][5] = THIS_FLOOR[5][5] = THIS_FLOOR[6][5] = "ad";
                        THIS_FLOOR[4][6] = THIS_FLOOR[5][6] = THIS_FLOOR[6][6] = "def";
                        THIS_FLOOR[3][4] = THIS_FLOOR[3][5] = "rhp";
                        THIS_FLOOR[3][6] = THIS_FLOOR[3][7] = "bhp";
                        THIS_FLOOR[7][4] = THIS_FLOOR[7][5] = THIS_FLOOR[7][6] = THIS_FLOOR[7][7] = "ky";
                        THIS_FLOOR[7][8]="wall";THIS_FLOOR[6][9]="wall";

                        staticEventOnDraw.setEvent(THIS_FLOOR);
                        break;
                    case 14403:
                        THIS_FLOOR[5][3] = "";
                        invalidateHandle.sendEmptyMessage(14407);
                        doorFlash("de1", 5, 3);
                        THIS_FLOOR[7][11] = "";
                        TempX = 5;
                        TempY = 5;
                        dialog.setNpcImage("boss1");
                        dialog.setNameTextSize(0.48f*ScreenHeight/11.0f);
                        dialog.setNameWidth(2.5f);


                        dialog.setNpcNameAndSaying("骷髅队长","好强！","可是不搞死我就不给过！");
                        VisibleHandle.sendEmptyMessage(0x129);
                        dialogOfWho = THIS_FLOOR[7][11];

                        dialog.setEnabled(true);
                        invalidateHandle.sendEmptyMessage(14403);
                        move.setEnabled(false);
                        backGround.setEnabled(false);
                        toolsTouch.setEnabled(false);
                        moveHandle.sendEmptyMessage(14402);
                        break;
                    case 14404:
                        FreshFlash1.cancel();
                        FreshFlash2.cancel();

                        FreshFlash1 = new Timer();
                        FreshFlash1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                monsNpc.setShining1();

                            }
                        },0,2000);
                        FreshFlash2 = new Timer();
                        FreshFlash2.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                monsNpc.setShining2();
                            }
                        }, 1000, 2000);
                        break;
                }
            }
        };

        VisibleHandle = new Handler() {
            public void handleMessage(Message msg) {

                switch (msg.what){
                    case 0x128:cover1.setVisibility(View.VISIBLE);break;
                    case 0x132:cover1.setVisibility(View.GONE);break;
                    case 0x123:notice.setVisibility(View.VISIBLE);break;
                    case 0x124:notice.setVisibility(View.GONE);break;
                    case 0x125:superDialog.setVisibility(View.VISIBLE);break;
                    case 0x126:superDialog.setVisibility(View.GONE);break;
                    case 0x127:toolsTouch.setEnabled(false);break;
                    case 0x129:dialog.setVisibility(View.VISIBLE);break;
                    case 0x130:shop.setVisibility(View.VISIBLE);break;
                    case 0x131:floorChange.setVisibility(View.VISIBLE);break;
                    case 0x133:goldMine.setVisibility(View.VISIBLE);break;
                    case 0x134:notice.setVisibility(View.VISIBLE);break;
                    case 0x135:handbook.setVisibility(View.VISIBLE);break;
                    case 0x136:handbook.setVisibility(View.GONE);break;
                    case 0x137:messageBGD.setVisibility(View.VISIBLE);break;
                    case 0x138:messageBGD.setVisibility(View.GONE);break;
                    case 0x139:floorChange.setVisibility(View.GONE);break;
                    case 0x140:fcBGD.setVisibility(View.VISIBLE);break;
                    case 0x141:fcBGD.setVisibility(View.GONE);break;
                    case 0x142:toolsBag.setVisibility(View.VISIBLE);break;
                    case 0x143:toolsBag.setVisibility(View.GONE);break;
                    case 0x144:specialNotice.setVisibility(View.VISIBLE);break;
                    case 0x145:specialNotice.setVisibility(View.GONE);break;
                    case 0x146:merchantShop.setVisibility(View.VISIBLE);break;
                    case 0x147:merchantShop.setVisibility(View.GONE);break;
                    case 0x148:dialog.setVisibility(View.GONE);break;
                    case 0x149:smithy_4f.setVisibility(View.VISIBLE);break;
                    case 0x150:smithy_4f.setVisibility(View.GONE);break;
                    case 0x151:shop.setVisibility(View.VISIBLE);break;
                    case 0x152:shop.setVisibility(View.GONE);break;
                    case 0x153:menu.setVisibility(View.VISIBLE);break;
                    case 0x154:menu.setVisibility(View.GONE);break;
                    case 0x155:goldMine.setVisibility(View.VISIBLE);break;
                    case 0x156:goldMine.setVisibility(View.GONE);break;
                    case 0x157:fcBGD.setVisibility(View.GONE);break;
                }

            }
        };
        moveHandle = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 14400) {
                    MOVE_EVENT(TouchSignX, TouchSignY);
                }
                else if (msg.what == 14401) {
                    TouchTimer = new Timer();
                    TouchTimerTash = new TimerTask() {
                        @Override
                        public void run() {
                            moveHandle.sendEmptyMessage(14400);
                        }
                    };
                    TouchTimer.schedule(TouchTimerTash,0, 200);
                }
                else if (msg.what == 14402) {
                    TouchTimerTash.cancel();
                    TouchTimer.cancel();
                    TouchTimerWaitTask.cancel();
                    TouchTimerWait.cancel();
                    TouchBoolean = true;
                }
                else if (msg.what == 14403) {
                    TouchTimerTash.cancel();
                    TouchTimer.cancel();
                    TouchTimerWaitTask.cancel();
                    TouchTimerWait.cancel();
                }

            }
        };
    }

}
