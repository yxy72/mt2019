package com.yxy.www.mtgame2019_20;


class LevelFatherClass {

    private int floorNumber = 20;
    private String FLOOR[][][] = new String[floorNumber+1][11][14];


    LevelFatherClass(){

//        event[0][0] = "";event[1][0] = "";event[2][0] = "";event[3][0] = "";event[4][0] = "";event[5][0] = "";event[6][0] = "";event[7][0] = "";event[8][0] = "";event[9][0] = "";event[10][0] = "";
//        event[0][1] = "";event[1][1] = "";event[2][1] = "";event[3][1] = "";event[4][1] = "";event[5][1] = "";event[6][1] = "";event[7][1] = "";event[8][1] = "";event[9][1] = "";event[10][1] = "";
//        event[0][2] = "";event[1][2] = "";event[2][2] = "";event[3][2] = "";event[4][2] = "";event[5][2] = "";event[6][2] = "";event[7][2] = "";event[8][2] = "";event[9][2] = "";event[10][2] = "";
//        event[0][3] = "";event[1][3] = "";event[2][3] = "";event[3][3] = "";event[4][3] = "";event[5][3] = "";event[6][3] = "";event[7][3] = "";event[8][3] = "";event[9][3] = "";event[10][3] = "";
//        event[0][4] = "";event[1][4] = "";event[2][4] = "";event[3][4] = "";event[4][4] = "";event[5][4] = "";event[6][4] = "";event[7][4] = "";event[8][4] = "";event[9][4] = "";event[10][4] = "";
//        event[0][5] = "";event[1][5] = "";event[2][5] = "";event[3][5] = "";event[4][5] = "";event[5][5] = "";event[6][5] = "";event[7][5] = "";event[8][5] = "";event[9][5] = "";event[10][5] = "";
//        event[0][6] = "";event[1][6] = "";event[2][6] = "";event[3][6] = "";event[4][6] = "";event[5][6] = "";event[6][6] = "";event[7][6] = "";event[8][6] = "";event[9][6] = "";event[10][6] = "";
//        event[0][7] = "";event[1][7] = "";event[2][7] = "";event[3][7] = "";event[4][7] = "";event[5][7] = "";event[6][7] = "";event[7][7] = "";event[8][7] = "";event[9][7] = "";event[10][7] = "";
//        event[0][8] = "";event[1][8] = "";event[2][8] = "";event[3][8] = "";event[4][8] = "";event[5][8] = "";event[6][8] = "";event[7][8] = "";event[8][8] = "";event[9][8] = "";event[10][8] = "";
//        event[0][9] = "";event[1][9] = "";event[2][9] = "";event[3][9] = "";event[4][9] = "";event[5][9] = "";event[6][9] = "";event[7][9] = "";event[8][9] = "";event[9][9] = "";event[10][9] = "";
//        event[0][10] = "";event[1][10] = "";event[2][10] = "";event[3][10] = "";event[4][10] = "";event[5][10] = "";event[6][10] = "";event[7][10] = "";event[8][10] = "";event[9][10] = "";event[10][10] = "";
//        event[0][11] = "";event[1][11] = "";event[2][11] = "";event[3][11] = "";event[4][11] = "";event[5][11] = "";event[6][11] = "";event[7][11] = "";event[8][11] = "";event[9][11] = "";event[10][11] = "";
//        event[0][12] = "";event[1][12] = "";event[2][12] = "";event[3][12] = "";event[4][12] = "";event[5][12] = "";event[6][12] = "";event[7][12] = "";event[8][12] = "";event[9][12] = "";event[10][12] = "";
//        event[0][13] = "";event[1][13] = "";event[2][13] = "";event[3][13] = "";event[4][13] = "";event[5][13] = "";event[6][13] = "";event[7][13] = "";event[8][13] = "";event[9][13] = "";event[10][13] = "";



        for(int i=0;i<=floorNumber;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<14;k++){
                    FLOOR[i][j][k]="";
                }
            }
        }


        for(int i=0;i<3;i++){
            for(int j=0;j<11;j++){
                FLOOR[0][i][j]="firewall";
            }
        }
        for(int i=8;i<11;i++){
            for(int j=0;j<11;j++){
                FLOOR[0][i][j]="firewall";
            }
        }
        for(int i=3;i==3||i==7;i+=4){
            for(int j=0;j<11;j++){
                FLOOR[0][i][j]="wall";
            }
        }

        FLOOR[0][5][5] = "eif";FLOOR[0][5][0] = "up";FLOOR[0][4][9] = FLOOR[0][5][9] =FLOOR[0][6][9] = "instr";
        FLOOR[0][0][11] = "5";FLOOR[0][1][11] = "1";FLOOR[0][2][11] = "5";FLOOR[0][3][11] = "10";FLOOR[0][4][11] = "1";FLOOR[0][5][11] = "0";FLOOR[0][6][11] = "-1";FLOOR[0][8][11] = "仙子";FLOOR[0][9][11] = "勇士！你来了！快救救公主吧！";FLOOR[0][10][11] = "";



        FLOOR[1][0][0] = "rhp";    FLOOR[1][1][0] = "";       FLOOR[1][2][0] = "wall";   FLOOR[1][3][0] = "";  FLOOR[1][4][0] = "";  FLOOR[1][5][0] = "m1";    FLOOR[1][6][0] = "m2";      FLOOR[1][7][0] = "m1";     FLOOR[1][8][0] = "ky";      FLOOR[1][9][0] = "";FLOOR[1][10][0] = "up";
        FLOOR[1][0][1] = "m7";     FLOOR[1][1][1] = "ky";     FLOOR[1][2][1] = "wall";   FLOOR[1][3][1] = "";  FLOOR[1][4][1] = "wall";   FLOOR[1][5][1] = "wall";  FLOOR[1][6][1] = "wall";    FLOOR[1][7][1] = "dy";     FLOOR[1][8][1] = "wall";    FLOOR[1][9][1] = "wall";FLOOR[1][10][1] = "wall";
        FLOOR[1][0][2] = "dy";     FLOOR[1][1][2] = "wall";   FLOOR[1][2][2] = "wall";   FLOOR[1][3][2] = "";  FLOOR[1][4][2] = "wall";   FLOOR[1][5][2] = "rhp";   FLOOR[1][6][2] = "ad";     FLOOR[1][7][2] = "m4";      FLOOR[1][8][2] = "ky";      FLOOR[1][9][2] = "wall";FLOOR[1][10][2] = "ad";
        FLOOR[1][0][3] = "ad";     FLOOR[1][1][3] = "rhp";    FLOOR[1][2][3] = "wall";   FLOOR[1][3][3] = "";  FLOOR[1][4][3] = "wall";   FLOOR[1][5][3] = "m4";    FLOOR[1][6][3] = "wall";    FLOOR[1][7][3] = "wall";   FLOOR[1][8][3] = "wall";        FLOOR[1][9][3] = "wall";FLOOR[1][10][3] = "m6";
        FLOOR[1][0][4] = "ky";     FLOOR[1][1][4] = "m6";     FLOOR[1][2][4] = "wall";   FLOOR[1][3][4] = "";  FLOOR[1][4][4] = "wall";   FLOOR[1][5][4] = "ky";    FLOOR[1][6][4] = "def";      FLOOR[1][7][4] = "";      FLOOR[1][8][4] = "dy";      FLOOR[1][9][4] = "m7";FLOOR[1][10][4] = "";
        FLOOR[1][0][5] = "wall";   FLOOR[1][1][5] = "dy";     FLOOR[1][2][5] = "wall";   FLOOR[1][3][5] = "";  FLOOR[1][4][5] = "wall";   FLOOR[1][5][5] = "wall";  FLOOR[1][6][5] = "wall";    FLOOR[1][7][5] = "wall";   FLOOR[1][8][5] = "wall";        FLOOR[1][9][5] = "wall";FLOOR[1][10][5] = "dy";
        FLOOR[1][0][6] = "npc";    FLOOR[1][1][6] = "";  FLOOR[1][2][6] = "";  FLOOR[1][3][6] = "";  FLOOR[1][4][6] = "";  FLOOR[1][5][6] = ""; FLOOR[1][6][6] = "";   FLOOR[1][7][6] = "";  FLOOR[1][8][6] = "";       FLOOR[1][9][6] = "";FLOOR[1][10][6] = "ky";
        FLOOR[1][0][7] = "";     FLOOR[1][1][7] = "";  FLOOR[1][2][7] = "";  FLOOR[1][3][7] = "wall";   FLOOR[1][4][7] = "wall";   FLOOR[1][5][7] = "wall";  FLOOR[1][6][7] = "wall";    FLOOR[1][7][7] = "wall";   FLOOR[1][8][7] = "wall";    FLOOR[1][9][7] = "wall";FLOOR[1][10][7] = "wall";
        FLOOR[1][0][8] = "wall";   FLOOR[1][1][8] = "wall";   FLOOR[1][2][8] = "";  FLOOR[1][3][8] = "wall";   FLOOR[1][4][8] = "m4";     FLOOR[1][5][8] = "wall";  FLOOR[1][6][8] = "m6";      FLOOR[1][7][8] = "wall";   FLOOR[1][8][8] = "bhp"; FLOOR[1][9][8] = "";FLOOR[1][10][8] = "ky";
        FLOOR[1][0][9] = "wall";   FLOOR[1][1][9] = "";  FLOOR[1][2][9] = "";        FLOOR[1][3][9] = "db";     FLOOR[1][4][9] = "";  FLOOR[1][5][9] = "de1";    FLOOR[1][6][9] = "";   FLOOR[1][7][9] = "de2";  FLOOR[1][8][9] = "";   FLOOR[1][9][9] = "blood_1";FLOOR[1][10][9] = "";
        FLOOR[1][0][10] = "down";  FLOOR[1][1][10] = ""; FLOOR[1][2][10] = ""; FLOOR[1][3][10] = "wall";  FLOOR[1][4][10] = "m4";    FLOOR[1][5][10] = "wall"; FLOOR[1][6][10] = "m6";     FLOOR[1][7][10] = "wall";  FLOOR[1][8][10] = "ky"; FLOOR[1][9][10] = "";FLOOR[1][10][10] = "bhp";
        FLOOR[1][0][11] = "9";  FLOOR[1][1][11] = "0"; FLOOR[1][2][11] = "1"; FLOOR[1][3][11] = "10";  FLOOR[1][4][11] = "2";    FLOOR[1][5][11] = "1"; FLOOR[1][6][11] = "0";     FLOOR[1][7][11] = "1";  FLOOR[1][8][11] = "张大爷"; FLOOR[1][9][11] = "小伙子我看你骨骼惊奇，给你一本怪物手册吧！";FLOOR[1][10][11] = "";
        FLOOR[1][0][12] = "4";FLOOR[1][1][12] = "8";FLOOR[1][2][12] = "4";FLOOR[1][3][12] = "10";FLOOR[1][4][12] = "6";FLOOR[1][5][12] = "8";FLOOR[1][6][12] = "6";FLOOR[1][7][12] = "10";
        FLOOR[1][4][13] = "5";FLOOR[1][5][13] = "9";FLOOR[1][6][13] = "7";FLOOR[1][7][13] = "9";
        FLOOR[1][8][12] = "n";

        FLOOR[2][0][0] = "down";    FLOOR[2][1][0] = "";     FLOOR[2][2][0] = "";   FLOOR[2][3][0] = "";  FLOOR[2][4][0] = "";  FLOOR[2][5][0] = "";    FLOOR[2][6][0] = "";      FLOOR[2][7][0] = "";FLOOR[2][8][0] = "";FLOOR[2][9][0] = "";FLOOR[2][10][0] = "up";
        FLOOR[2][0][1] = "wall";    FLOOR[2][1][1] = "wall";     FLOOR[2][2][1] = "wall";   FLOOR[2][3][1] = "wall";  FLOOR[2][4][1] = "m23";   FLOOR[2][5][1] = "";  FLOOR[2][6][1] = "m23";    FLOOR[2][7][1] = "wall";FLOOR[2][8][1] = "wall";FLOOR[2][9][1] = "wall";FLOOR[2][10][1] = "wall";
        FLOOR[2][0][2] = "bhp";     FLOOR[2][1][2] = "rhp";   FLOOR[2][2][2] = "";   FLOOR[2][3][2] = "wall";  FLOOR[2][4][2] = "wall";   FLOOR[2][5][2] = "";   FLOOR[2][6][2] = "wall";     FLOOR[2][7][2] = "wall";FLOOR[2][8][2] = "";FLOOR[2][9][2] = "ky";FLOOR[2][10][2] = "kb";
        FLOOR[2][0][3] = "bhp";     FLOOR[2][1][3] = "rhp";    FLOOR[2][2][3] = "";   FLOOR[2][3][3] = "wall";  FLOOR[2][4][3] = "";   FLOOR[2][5][3] = "";    FLOOR[2][6][3] = "";    FLOOR[2][7][3] = "wall";FLOOR[2][8][3] = "";FLOOR[2][9][3] = "ky";FLOOR[2][10][3] = "kb";
        FLOOR[2][0][4] = "wall";     FLOOR[2][1][4] = "rhp";     FLOOR[2][2][4] = "";   FLOOR[2][3][4] = "dz";  FLOOR[2][4][4] = "";   FLOOR[2][5][4] = "";    FLOOR[2][6][4] = "";      FLOOR[2][7][4] = "dz";FLOOR[2][8][4] = "";FLOOR[2][9][4] = "ky";FLOOR[2][10][4] = "wall";
        FLOOR[2][0][5] = "wall";   FLOOR[2][1][5] = "wall";     FLOOR[2][2][5] = "wall";   FLOOR[2][3][5] = "wall";  FLOOR[2][4][5] = "";   FLOOR[2][5][5] = "";  FLOOR[2][6][5] = "";    FLOOR[2][7][5] = "wall";FLOOR[2][8][5] = "wall";FLOOR[2][9][5] = "wall";FLOOR[2][10][5] = "wall";
        FLOOR[2][0][6] = "npc";    FLOOR[2][1][6] = "";  FLOOR[2][2][6] = "m8";  FLOOR[2][3][6] = "dz";  FLOOR[2][4][6] = "";  FLOOR[2][5][6] = ""; FLOOR[2][6][6] = "";   FLOOR[2][7][6] = "dz";FLOOR[2][8][6] = "m8";FLOOR[2][9][6] = "";FLOOR[2][10][6] = "merchant3";
        FLOOR[2][0][7] = "";  FLOOR[2][1][7] = "";  FLOOR[2][2][7] = "";  FLOOR[2][3][7] = "wall";   FLOOR[2][4][7] = "";   FLOOR[2][5][7] = "";  FLOOR[2][6][7] = "";    FLOOR[2][7][7] = "wall";FLOOR[2][8][7] = "";FLOOR[2][9][7] = "";FLOOR[2][10][7] = "";
        FLOOR[2][0][8] = "wall";   FLOOR[2][1][8] = "wall";   FLOOR[2][2][8] = "wall";  FLOOR[2][3][8] = "wall";   FLOOR[2][4][8] = "wall";     FLOOR[2][5][8] = "dz";  FLOOR[2][6][8] = "wall";      FLOOR[2][7][8] = "wall";FLOOR[2][8][8] = "wall";FLOOR[2][9][8] = "wall";FLOOR[2][10][8] = "wall";
        FLOOR[2][0][9] = "kr";   FLOOR[2][1][9] = "";  FLOOR[2][2][9] = "";  FLOOR[2][3][9] = "";     FLOOR[2][4][9] = "m15";  FLOOR[2][5][9] = "";    FLOOR[2][6][9] = "m15";   FLOOR[2][7][9] = "";FLOOR[2][8][9] = "";FLOOR[2][9][9] = "dr";FLOOR[2][10][9] = "";
        FLOOR[2][0][10] = "wall";  FLOOR[2][1][10] = "wall"; FLOOR[2][2][10] = "ad"; FLOOR[2][3][10] = "ad";  FLOOR[2][4][10] = "wall";    FLOOR[2][5][10] = "wall"; FLOOR[2][6][10] = "wall";     FLOOR[2][7][10] = "def";FLOOR[2][8][10] = "def";FLOOR[2][9][10] = "wall";FLOOR[2][10][10] = "to14F";
        FLOOR[2][0][11] = "9";  FLOOR[2][1][11] = "0"; FLOOR[2][2][11] = "1"; FLOOR[2][3][11] = "0";  FLOOR[2][4][11] = "3";    FLOOR[2][5][11] = "2"; FLOOR[2][6][11] = "1";FLOOR[2][7][11]="9";FLOOR[2][8][11]="孙大爷";FLOOR[2][9][11]="谢谢你孩子救了我！为了报答你我将提升你的攻防各10%！";
        FLOOR[2][0][13] = "4";FLOOR[2][1][13] = "1";FLOOR[2][2][13] = "6";FLOOR[2][3][13] = "1";FLOOR[2][8][13]="流浪商人";FLOOR[2][9][13]="既然你救了我，那我就大发慈悲地给你100块钱！";
        FLOOR[2][8][12] = "n";

        FLOOR[3][0][0] = "wall";FLOOR[3][1][0] = "shopleft";FLOOR[3][2][0] = "shop";FLOOR[3][3][0] = "shopright";FLOOR[3][4][0] = "wall";FLOOR[3][5][0] = "rhp";FLOOR[3][6][0] = "wall";FLOOR[3][7][0] = "";FLOOR[3][8][0] = "blood_2";FLOOR[3][9][0] = "";FLOOR[3][10][0] = "wall";
        FLOOR[3][0][1] = "wall";FLOOR[3][1][1] = "";FLOOR[3][2][1] = "";FLOOR[3][3][1] = "";FLOOR[3][4][1] = "wall";FLOOR[3][5][1] = "";FLOOR[3][6][1] = "wall";FLOOR[3][7][1] = "";FLOOR[3][8][1] = "";FLOOR[3][9][1] = "";FLOOR[3][10][1] = "wall";
        FLOOR[3][0][2] = "wall";FLOOR[3][1][2] = "wall";FLOOR[3][2][2] = "dy";FLOOR[3][3][2] = "wall";FLOOR[3][4][2] = "wall";FLOOR[3][5][2] = "m1";FLOOR[3][6][2] = "wall";FLOOR[3][7][2] = "wall";FLOOR[3][8][2] = "db";FLOOR[3][9][2] = "wall";FLOOR[3][10][2] = "wall";
        FLOOR[3][0][3] = "";FLOOR[3][1][3] = "";FLOOR[3][2][3] = "m4";FLOOR[3][3][3] = "m3";FLOOR[3][4][3] = "";FLOOR[3][5][3] = "npc";FLOOR[3][6][3] = "";FLOOR[3][7][3] = "";FLOOR[3][8][3] = "m15";FLOOR[3][9][3] = "";FLOOR[3][10][3] = "kb";
        FLOOR[3][0][4] = "";FLOOR[3][1][4] = "wall";FLOOR[3][2][4] = "wall";FLOOR[3][3][4] = "wall";FLOOR[3][4][4] = "wall";FLOOR[3][5][4] = "wall";FLOOR[3][6][4] = "";FLOOR[3][7][4] = "wall";FLOOR[3][8][4] = "wall";FLOOR[3][9][4] = "wall";FLOOR[3][10][4] = "wall";
        FLOOR[3][0][5] = "rhp";FLOOR[3][1][5] = "wall";FLOOR[3][2][5] = "";FLOOR[3][3][5] = "m2";FLOOR[3][4][5] = "";FLOOR[3][5][5] = "wall";FLOOR[3][6][5] = "";FLOOR[3][7][5] = "wall";FLOOR[3][8][5] = "m2";FLOOR[3][9][5] = "ky";FLOOR[3][10][5] = "ky";
        FLOOR[3][0][6] = "";FLOOR[3][1][6] = "";FLOOR[3][2][6] = "m3";FLOOR[3][3][6] = "wall";FLOOR[3][4][6] = "m3";FLOOR[3][5][6] = "";FLOOR[3][6][6] = "";FLOOR[3][7][6] = "dy";FLOOR[3][8][6] = "";FLOOR[3][9][6] = "m3";FLOOR[3][10][6] = "bhp";
        FLOOR[3][0][7] = "m3";FLOOR[3][1][7] = "wall";FLOOR[3][2][7] = "dy";FLOOR[3][3][7] = "wall";FLOOR[3][4][7] = "wall";FLOOR[3][5][7] = "wall";FLOOR[3][6][7] = "";FLOOR[3][7][7] = "wall";FLOOR[3][8][7] = "m2";FLOOR[3][9][7] = "ad";FLOOR[3][10][7] = "def";
        FLOOR[3][0][8] = "";FLOOR[3][1][8] = "wall";FLOOR[3][2][8] = "m4";FLOOR[3][3][8] = "";FLOOR[3][4][8] = "ky";FLOOR[3][5][8] = "wall";FLOOR[3][6][8] = "";FLOOR[3][7][8] = "wall";FLOOR[3][8][8] = "wall";FLOOR[3][9][8] = "wall";FLOOR[3][10][8] = "wall";
        FLOOR[3][0][9] = "";FLOOR[3][1][9] = "wall";FLOOR[3][2][9] = "";FLOOR[3][3][9] = "ky";FLOOR[3][4][9] = "m2";FLOOR[3][5][9] = "wall";FLOOR[3][6][9] = "";FLOOR[3][7][9] = "dy";FLOOR[3][8][9] = "m4";FLOOR[3][9][9] = "m3";FLOOR[3][10][9] = "";
        FLOOR[3][0][10] = "down";FLOOR[3][1][10] = "wall";FLOOR[3][2][10] = "ky";FLOOR[3][3][10] = "m2";FLOOR[3][4][10] = "ad_1";FLOOR[3][5][10] = "wall";FLOOR[3][6][10] = "up";FLOOR[3][7][10] = "wall";FLOOR[3][8][10] = "m3";FLOOR[3][9][10] = "";FLOOR[3][10][10] = "kb";
        FLOOR[3][0][11] = "6";FLOOR[3][1][11] = "9";FLOOR[3][2][11] = "0";FLOOR[3][3][11] = "9";FLOOR[3][4][11] = "4";FLOOR[3][5][11] = "3";FLOOR[3][6][11] = "2";FLOOR[3][8][11]="高大爷";FLOOR[3][9][11]="在商店你最好提升优先攻击力，必要时才选择提升HP。";
        FLOOR[3][8][12] = "n";

        FLOOR[4][0][0] = "firewall";FLOOR[4][1][0] = "firewall";FLOOR[4][2][0] = "wall";FLOOR[4][3][0] = "";FLOOR[4][4][0] = "";FLOOR[4][5][0] = "";FLOOR[4][6][0] = "";FLOOR[4][7][0] = "";FLOOR[4][8][0] = "wall";FLOOR[4][9][0] = "firewall";FLOOR[4][10][0] = "firewall";
        FLOOR[4][0][1] = "firewall";FLOOR[4][1][1] = "firewall";FLOOR[4][2][1] = "wall";FLOOR[4][3][1] = "";FLOOR[4][4][1] = "";FLOOR[4][5][1] = "";FLOOR[4][6][1] = "";FLOOR[4][7][1] = "";FLOOR[4][8][1] = "wall";FLOOR[4][9][1] = "firewall";FLOOR[4][10][1] = "firewall";
        FLOOR[4][0][2] = "firewall";FLOOR[4][1][2] = "firewall";FLOOR[4][2][2] = "wall";FLOOR[4][3][2] = "";FLOOR[4][4][2] = "";FLOOR[4][5][2] = "smithy";FLOOR[4][6][2] = "";FLOOR[4][7][2] = "";FLOOR[4][8][2] = "wall";FLOOR[4][9][2] = "firewall";FLOOR[4][10][2] = "firewall";
        FLOOR[4][0][3] = "wall";FLOOR[4][1][3] = "wall";FLOOR[4][2][3] = "wall";FLOOR[4][3][3] = "wall";FLOOR[4][4][3] = "wall";FLOOR[4][5][3] = "dy";FLOOR[4][6][3] = "wall";FLOOR[4][7][3] = "wall";FLOOR[4][8][3] = "wall";FLOOR[4][9][3] = "wall";FLOOR[4][10][3] = "wall";
        FLOOR[4][0][4] = "baoji_2";FLOOR[4][1][4] = "m3";FLOOR[4][2][4] = "db";FLOOR[4][3][4] = "m6";FLOOR[4][4][4] = "wall";FLOOR[4][5][4] = "";FLOOR[4][6][4] = "wall";FLOOR[4][7][4] = "";FLOOR[4][8][4] = "ky";FLOOR[4][9][4] = "ky";FLOOR[4][10][4] = "";
        FLOOR[4][0][5] = "rhp";FLOOR[4][1][5] = "ky";FLOOR[4][2][5] = "wall";FLOOR[4][3][5] = "";FLOOR[4][4][5] = "wall";FLOOR[4][5][5] = "";FLOOR[4][6][5] = "wall";FLOOR[4][7][5] = "m5";FLOOR[4][8][5] = "wall";FLOOR[4][9][5] = "wall";FLOOR[4][10][5] = "m5";
        FLOOR[4][0][6] = "wall";FLOOR[4][1][6] = "wall";FLOOR[4][2][6] = "wall";FLOOR[4][3][6] = "";FLOOR[4][4][6] = "wall";FLOOR[4][5][6] = "rhp";FLOOR[4][6][6] = "wall";FLOOR[4][7][6] = "";FLOOR[4][8][6] = "m2";FLOOR[4][9][6] = "wall";FLOOR[4][10][6] = "";
        FLOOR[4][0][7] = "npc";FLOOR[4][1][7] = "rhp";FLOOR[4][2][7] = "wall";FLOOR[4][3][7] = "";FLOOR[4][4][7] = "wall";FLOOR[4][5][7] = "m3";FLOOR[4][6][7] = "wall";FLOOR[4][7][7] = "wall";FLOOR[4][8][7] = "rhp";FLOOR[4][9][7] = "wall";FLOOR[4][10][7] = "";
        FLOOR[4][0][8] = "ad";FLOOR[4][1][8] = "m5";FLOOR[4][2][8] = "dy";FLOOR[4][3][8] = "m4";FLOOR[4][4][8] = "dy";FLOOR[4][5][8] = "";FLOOR[4][6][8] = "dy";FLOOR[4][7][8] = "";FLOOR[4][8][8] = "";FLOOR[4][9][8] = "wall";FLOOR[4][10][8] = "up";
        FLOOR[4][0][9] = "wall";FLOOR[4][1][9] = "wall";FLOOR[4][2][9] = "wall";FLOOR[4][3][9] = "wall";FLOOR[4][4][9] = "wall";FLOOR[4][5][9] = "m4";FLOOR[4][6][9] = "wall";FLOOR[4][7][9] = "wall";FLOOR[4][8][9] = "wall";FLOOR[4][9][9] = "wall";FLOOR[4][10][9] = "wall";
        FLOOR[4][0][10] = "down";FLOOR[4][1][10] = "";FLOOR[4][2][10] = "m3";FLOOR[4][3][10] = "m2";FLOOR[4][4][10] = "m3";FLOOR[4][5][10] = "";FLOOR[4][6][10] = "dy";FLOOR[4][7][10] = "m5";FLOOR[4][8][10] = "ad";FLOOR[4][9][10] = "rhp";FLOOR[4][10][10] = "ky";
        FLOOR[4][0][11] = "10";FLOOR[4][1][11] = "7";FLOOR[4][2][11] = "1";FLOOR[4][3][11] = "10";FLOOR[4][4][11] = "5";FLOOR[4][5][11] = "4";FLOOR[4][6][11] = "3";
        FLOOR[4][8][11] = "王大爷"; FLOOR[4][9][11] = "系统判定不考虑暴击和吸血！";FLOOR[4][10][11] = "";
        FLOOR[4][8][12] = "n";

        FLOOR[5][0][0] = "ky";FLOOR[5][1][0] = "ky";FLOOR[5][2][0] = "m6";FLOOR[5][3][0] = "";FLOOR[5][4][0] = "wall";FLOOR[5][5][0] = "wall";FLOOR[5][6][0] = "wall";FLOOR[5][7][0] = "m6";FLOOR[5][8][0] = "";FLOOR[5][9][0] = "rhp";FLOOR[5][10][0] = "def_1";
        FLOOR[5][0][1] = "wall";FLOOR[5][1][1] = "wall";FLOOR[5][2][1] = "wall";FLOOR[5][3][1] = "";FLOOR[5][4][1] = "wall";FLOOR[5][5][1] = "ad";FLOOR[5][6][1] = "wall";FLOOR[5][7][1] = "m7";FLOOR[5][8][1] = "m4";FLOOR[5][9][1] = "";FLOOR[5][10][1] = "bhp";
        FLOOR[5][0][2] = "rhp";FLOOR[5][1][2] = "";FLOOR[5][2][2] = "wall";FLOOR[5][3][2] = "";FLOOR[5][4][2] = "wall";FLOOR[5][5][2] = "m9";FLOOR[5][6][2] = "wall";FLOOR[5][7][2] = "dy";FLOOR[5][8][2] = "wall";FLOOR[5][9][2] = "wall";FLOOR[5][10][2] = "wall";
        FLOOR[5][0][3] = "";FLOOR[5][1][3] = "m7";FLOOR[5][2][3] = "dy";FLOOR[5][3][3] = "";FLOOR[5][4][3] = "wall";FLOOR[5][5][3] = "";FLOOR[5][6][3] = "";FLOOR[5][7][3] = "";FLOOR[5][8][3] = "npc";FLOOR[5][9][3] = "de1";FLOOR[5][10][3] = "baoji_1";
        FLOOR[5][0][4] = "wall";FLOOR[5][1][4] = "wall";FLOOR[5][2][4] = "wall";FLOOR[5][3][4] = "";FLOOR[5][4][4] = "wall";FLOOR[5][5][4] = "dy";FLOOR[5][6][4] = "wall";FLOOR[5][7][4] = "wall";FLOOR[5][8][4] = "wall";FLOOR[5][9][4] = "wall";FLOOR[5][10][4] = "wall";
        FLOOR[5][0][5] = "down";FLOOR[5][1][5] = "";FLOOR[5][2][5] = "";FLOOR[5][3][5] = "";FLOOR[5][4][5] = "";FLOOR[5][5][5] = "";FLOOR[5][6][5] = "";FLOOR[5][7][5] = "";FLOOR[5][8][5] = "";FLOOR[5][9][5] = "";FLOOR[5][10][5] = "up";
        FLOOR[5][0][6] = "wall";FLOOR[5][1][6] = "wall";FLOOR[5][2][6] = "wall";FLOOR[5][3][6] = "wall";FLOOR[5][4][6] = "wall";FLOOR[5][5][6] = "dy";FLOOR[5][6][6] = "wall";FLOOR[5][7][6] = "";FLOOR[5][8][6] = "wall";FLOOR[5][9][6] = "wall";FLOOR[5][10][6] = "wall";
        FLOOR[5][0][7] = "";FLOOR[5][1][7] = "rhp";FLOOR[5][2][7] = "ky";FLOOR[5][3][7] = "ky";FLOOR[5][4][7] = "m6";FLOOR[5][5][7] = "";FLOOR[5][6][7] = "wall";FLOOR[5][7][7] = "";FLOOR[5][8][7] = "dy";FLOOR[5][9][7] = "m6";FLOOR[5][10][7] = "rhp";
        FLOOR[5][0][8] = "";FLOOR[5][1][8] = "wall";FLOOR[5][2][8] = "wall";FLOOR[5][3][8] = "wall";FLOOR[5][4][8] = "wall";FLOOR[5][5][8] = "m9";FLOOR[5][6][8] = "wall";FLOOR[5][7][8] = "dy";FLOOR[5][8][8] = "wall";FLOOR[5][9][8] = "wall";FLOOR[5][10][8] = "m7";
        FLOOR[5][0][9] = "";FLOOR[5][1][9] = "wall";FLOOR[5][2][9] = "";FLOOR[5][3][9] = "def";FLOOR[5][4][9] = "wall";FLOOR[5][5][9] = "def";FLOOR[5][6][9] = "wall";FLOOR[5][7][9] = "m7";FLOOR[5][8][9] = "wall";FLOOR[5][9][9] = "ky";FLOOR[5][10][9] = "ky";
        FLOOR[5][0][10] = "";FLOOR[5][1][10] = "dy";FLOOR[5][2][10] = "m7";FLOOR[5][3][10] = "";FLOOR[5][4][10] = "wall";FLOOR[5][5][10] = "wall";FLOOR[5][6][10] = "wall";FLOOR[5][7][10] = "kb";FLOOR[5][8][10] = "wall";FLOOR[5][9][10] = "ky";FLOOR[5][10][10] = "kb";
        FLOOR[5][0][11] = "9";FLOOR[5][1][11] = "5";FLOOR[5][2][11] = "1";FLOOR[5][3][11] = "5";FLOOR[5][4][11] = "6";FLOOR[5][5][11] = "5";FLOOR[5][6][11] = "4";
        FLOOR[5][0][12] = "5";FLOOR[5][1][12] = "2";FLOOR[5][2][12] = "5";FLOOR[5][3][12] = "8";
        FLOOR[5][4][13] = "9";FLOOR[5][5][13] = "3";
        FLOOR[5][8][11] = "刘大爷"; FLOOR[5][9][11] = "有些机关门打开需要击杀的怪物离得较远。";FLOOR[5][10][11] = "";
        FLOOR[5][8][12] = "n";

        FLOOR[6][0][0] = "";FLOOR[6][1][0] = "dy";FLOOR[6][2][0] = "";FLOOR[6][3][0] = "wall";FLOOR[6][4][0] = "";FLOOR[6][5][0] = "floorChanger";FLOOR[6][6][0] = "";FLOOR[6][7][0] = "wall";FLOOR[6][8][0] = "";FLOOR[6][9][0] = "dy";FLOOR[6][10][0] = "";
        FLOOR[6][0][1] = "m11";FLOOR[6][1][1] = "wall";FLOOR[6][2][1] = "rhp";FLOOR[6][3][1] = "wall";FLOOR[6][4][1] = "bhp";FLOOR[6][5][1] = "kr";FLOOR[6][6][1] = "bhp";FLOOR[6][7][1] = "wall";FLOOR[6][8][1] = "rhp";FLOOR[6][9][1] = "wall";FLOOR[6][10][1] = "m11";
        FLOOR[6][0][2] = "";FLOOR[6][1][2] = "wall";FLOOR[6][2][2] = "m5";FLOOR[6][3][2] = "wall";FLOOR[6][4][2] = "wall";FLOOR[6][5][2] = "de2";FLOOR[6][6][2] = "wall";FLOOR[6][7][2] = "wall";FLOOR[6][8][2] = "m5";FLOOR[6][9][2] = "wall";FLOOR[6][10][2] = "";
        FLOOR[6][0][3] = "ad";FLOOR[6][1][3] = "wall";FLOOR[6][2][3] = "m5";FLOOR[6][3][3] = "wall";FLOOR[6][4][3] = "m12";FLOOR[6][5][3] = "";FLOOR[6][6][3] = "m12";FLOOR[6][7][3] = "wall";FLOOR[6][8][3] = "m5";FLOOR[6][9][3] = "wall";FLOOR[6][10][3] = "def";
        FLOOR[6][0][4] = "ad";FLOOR[6][1][4] = "wall";FLOOR[6][2][4] = "";FLOOR[6][3][4] = "wall";FLOOR[6][4][4] = "";FLOOR[6][5][4] = "";FLOOR[6][6][4] = "";FLOOR[6][7][4] = "wall";FLOOR[6][8][4] = "";FLOOR[6][9][4] = "wall";FLOOR[6][10][4] = "def";
        FLOOR[6][0][5] = "ad";FLOOR[6][1][5] = "wall";FLOOR[6][2][5] = "ad";FLOOR[6][3][5] = "wall";FLOOR[6][4][5] = "wall";FLOOR[6][5][5] = "db";FLOOR[6][6][5] = "wall";FLOOR[6][7][5] = "wall";FLOOR[6][8][5] = "def";FLOOR[6][9][5] = "wall";FLOOR[6][10][5] = "def";
        FLOOR[6][0][6] = "dy";FLOOR[6][1][6] = "wall";FLOOR[6][2][6] = "";FLOOR[6][3][6] = "wall";FLOOR[6][4][6] = "ky";FLOOR[6][5][6] = "";FLOOR[6][6][6] = "ky";FLOOR[6][7][6] = "wall";FLOOR[6][8][6] = "";FLOOR[6][9][6] = "wall";FLOOR[6][10][6] = "dy";
        FLOOR[6][0][7] = "bhp";FLOOR[6][1][7] = "wall";FLOOR[6][2][7] = "";FLOOR[6][3][7] = "ky";FLOOR[6][4][7] = "";FLOOR[6][5][7] = "";FLOOR[6][6][7] = "";FLOOR[6][7][7] = "ky";FLOOR[6][8][7] = "";FLOOR[6][9][7] = "wall";FLOOR[6][10][7] = "bhp";
        FLOOR[6][0][8] = "wall";FLOOR[6][1][8] = "wall";FLOOR[6][2][8] = "wall";FLOOR[6][3][8] = "wall";FLOOR[6][4][8] = "wall";FLOOR[6][5][8] = "dr";FLOOR[6][6][8] = "wall";FLOOR[6][7][8] = "wall";FLOOR[6][8][8] = "wall";FLOOR[6][9][8] = "wall";FLOOR[6][10][8] = "wall";
        FLOOR[6][0][9] = "";FLOOR[6][1][9] = "";FLOOR[6][2][9] = "";FLOOR[6][3][9] = "ky";FLOOR[6][4][9] = "m1";FLOOR[6][5][9] = "m2";FLOOR[6][6][9] = "m1";FLOOR[6][7][9] = "ky";FLOOR[6][8][9] = "";FLOOR[6][9][9] = "";FLOOR[6][10][9] = "";
        FLOOR[6][0][10] = "down";FLOOR[6][1][10] = "wall";FLOOR[6][2][10] = "wall";FLOOR[6][3][10] = "wall";FLOOR[6][4][10] = "wall";FLOOR[6][5][10] = "wall";FLOOR[6][6][10] = "wall";FLOOR[6][7][10] = "wall";FLOOR[6][8][10] = "wall";FLOOR[6][9][10] = "wall";FLOOR[6][10][10] = "up";
        FLOOR[6][0][11] = "10";FLOOR[6][1][11] = "9";FLOOR[6][2][11] = "0";FLOOR[6][3][11] = "9";FLOOR[6][4][11] = "7";FLOOR[6][5][11] = "6";FLOOR[6][6][11] = "5";
        FLOOR[6][0][12] = "4";FLOOR[6][1][12] = "3";FLOOR[6][2][12] = "6";FLOOR[6][3][12] = "3";
        FLOOR[6][4][13] = "5";FLOOR[6][5][13] = "2";
        FLOOR[6][8][12] = "n";

        FLOOR[7][0][0] = "";FLOOR[7][1][0] = "";FLOOR[7][2][0] = "";FLOOR[7][3][0] = "";FLOOR[7][4][0] = "m7";FLOOR[7][5][0] = "rhp";FLOOR[7][6][0] = "rhp";FLOOR[7][7][0] = "m7";FLOOR[7][8][0] = "";FLOOR[7][9][0] = "";FLOOR[7][10][0] = "kb";
        FLOOR[7][0][1] = "m11";FLOOR[7][1][1] = "wall";FLOOR[7][2][1] = "dy";FLOOR[7][3][1] = "wall";FLOOR[7][4][1] = "wall";FLOOR[7][5][1] = "wall";FLOOR[7][6][1] = "wall";FLOOR[7][7][1] = "wall";FLOOR[7][8][1] = "wall";FLOOR[7][9][1] = "dy";FLOOR[7][10][1] = "wall";
        FLOOR[7][0][2] = "bhp";FLOOR[7][1][2] = "wall";FLOOR[7][2][2] = "";FLOOR[7][3][2] = "wall";FLOOR[7][4][2] = "";FLOOR[7][5][2] = "ky";FLOOR[7][6][2] = "ky";FLOOR[7][7][2] = "wall";FLOOR[7][8][2] = "m6";FLOOR[7][9][2] = "";FLOOR[7][10][2] = "m6";
        FLOOR[7][0][3] = "wall";FLOOR[7][1][3] = "wall";FLOOR[7][2][3] = "";FLOOR[7][3][3] = "dy";FLOOR[7][4][3] = "m5";FLOOR[7][5][3] = "";FLOOR[7][6][3] = "";FLOOR[7][7][3] = "wall";FLOOR[7][8][3] = "rhp";FLOOR[7][9][3] = "m12";FLOOR[7][10][3] = "rhp";
        FLOOR[7][0][4] = "down";FLOOR[7][1][4] = "";FLOOR[7][2][4] = "";FLOOR[7][3][4] = "wall";FLOOR[7][4][4] = "wall";FLOOR[7][5][4] = "wall";FLOOR[7][6][4] = "";FLOOR[7][7][4] = "wall";FLOOR[7][8][4] = "";FLOOR[7][9][4] = "little_gold";FLOOR[7][10][4] = "";
        FLOOR[7][0][5] = "wall";FLOOR[7][1][5] = "wall";FLOOR[7][2][5] = "";FLOOR[7][3][5] = "npc";FLOOR[7][4][5] = "up";FLOOR[7][5][5] = "wall";FLOOR[7][6][5] = "";FLOOR[7][7][5] = "wall";FLOOR[7][8][5] = "wall";FLOOR[7][9][5] = "wall";FLOOR[7][10][5] = "wall";
        FLOOR[7][0][6] = "";FLOOR[7][1][6] = "dy";FLOOR[7][2][6] = "";FLOOR[7][3][6] = "";FLOOR[7][4][6] = "";FLOOR[7][5][6] = "wall";FLOOR[7][6][6] = "";FLOOR[7][7][6] = "dy";FLOOR[7][8][6] = "m13";FLOOR[7][9][6] = "";FLOOR[7][10][6] = "ky";
        FLOOR[7][0][7] = "m12";FLOOR[7][1][7] = "wall";FLOOR[7][2][7] = "wall";FLOOR[7][3][7] = "wall";FLOOR[7][4][7] = "db";FLOOR[7][5][7] = "wall";FLOOR[7][6][7] = "";FLOOR[7][7][7] = "wall";FLOOR[7][8][7] = "";FLOOR[7][9][7] = "ky";FLOOR[7][10][7] = "little_gold";
        FLOOR[7][0][8] = "";FLOOR[7][1][8] = "wall";FLOOR[7][2][8] = "ky";FLOOR[7][3][8] = "m5";FLOOR[7][4][8] = "m11";FLOOR[7][5][8] = "wall";FLOOR[7][6][8] = "";FLOOR[7][7][8] = "wall";FLOOR[7][8][8] = "ky";FLOOR[7][9][8] = "little_gold";FLOOR[7][10][8] = "kb";
        FLOOR[7][0][9] = "";FLOOR[7][1][9] = "wall";FLOOR[7][2][9] = "ad";FLOOR[7][3][9] = "ky";FLOOR[7][4][9] = "m5";FLOOR[7][5][9] = "wall";FLOOR[7][6][9] = "";FLOOR[7][7][9] = "wall";FLOOR[7][8][9] = "wall";FLOOR[7][9][9] = "wall";FLOOR[7][10][9] = "wall";
        FLOOR[7][0][10] = "kr";FLOOR[7][1][10] = "wall";FLOOR[7][2][10] = "bhp";FLOOR[7][3][10] = "def";FLOOR[7][4][10] = "ky";FLOOR[7][5][10] = "wall";FLOOR[7][6][10] = "";FLOOR[7][7][10] = "m11";FLOOR[7][8][10] = "m7";FLOOR[7][9][10] = "rhp";FLOOR[7][10][10] = "ad";
        FLOOR[7][0][11] = "3";FLOOR[7][1][11] = "5";FLOOR[7][2][11] = "1";FLOOR[7][3][11] = "4";FLOOR[7][4][11] = "8";FLOOR[7][5][11] = "7";FLOOR[7][6][11] = "6";FLOOR[7][8][11]="魏大爷";FLOOR[7][9][11]="当你不知道该怎么走的时候，记得回去看看之前的楼层。";
        FLOOR[7][8][12] = "n";

        FLOOR[8][0][0] = "wall";FLOOR[8][1][0] = "kb";FLOOR[8][2][0] = "blood_1";FLOOR[8][3][0] = "";FLOOR[8][4][0] = "wall";FLOOR[8][5][0] = "down";FLOOR[8][6][0] = "wall";FLOOR[8][7][0] = "";FLOOR[8][8][0] = "m13";FLOOR[8][9][0] = "dy";FLOOR[8][10][0] = "";
        FLOOR[8][0][1] = "wall";FLOOR[8][1][1] = "ky";FLOOR[8][2][1] = "";FLOOR[8][3][1] = "m13";FLOOR[8][4][1] = "wall";FLOOR[8][5][1] = "";FLOOR[8][6][1] = "wall";FLOOR[8][7][1] = "";FLOOR[8][8][1] = "";FLOOR[8][9][1] = "wall";FLOOR[8][10][1] = "rhp";
        FLOOR[8][0][2] = "wall";FLOOR[8][1][2] = "wall";FLOOR[8][2][2] = "wall";FLOOR[8][3][2] = "dy";FLOOR[8][4][2] = "wall";FLOOR[8][5][2] = "";FLOOR[8][6][2] = "wall";FLOOR[8][7][2] = "ky";FLOOR[8][8][2] = "ky";FLOOR[8][9][2] = "wall";FLOOR[8][10][2] = "rhp";
        FLOOR[8][0][3] = "wall";FLOOR[8][1][3] = "";FLOOR[8][2][3] = "rhp";FLOOR[8][3][3] = "";FLOOR[8][4][3] = "wall";FLOOR[8][5][3] = "m5";FLOOR[8][6][3] = "wall";FLOOR[8][7][3] = "ky";FLOOR[8][8][3] = "ky";FLOOR[8][9][3] = "wall";FLOOR[8][10][3] = "m5";
        FLOOR[8][0][4] = "wall";FLOOR[8][1][4] = "dy";FLOOR[8][2][4] = "wall";FLOOR[8][3][4] = "wall";FLOOR[8][4][4] = "wall";FLOOR[8][5][4] = "";FLOOR[8][6][4] = "wall";FLOOR[8][7][4] = "wall";FLOOR[8][8][4] = "wall";FLOOR[8][9][4] = "wall";FLOOR[8][10][4] = "dy";
        FLOOR[8][0][5] = "wall";FLOOR[8][1][5] = "m12";FLOOR[8][2][5] = "";FLOOR[8][3][5] = "m11";FLOOR[8][4][5] = "dy";FLOOR[8][5][5] = "";FLOOR[8][6][5] = "wall";FLOOR[8][7][5] = "";FLOOR[8][8][5] = "m3";FLOOR[8][9][5] = "";FLOOR[8][10][5] = "m12";
        FLOOR[8][0][6] = "bhp";FLOOR[8][1][6] = "";FLOOR[8][2][6] = "m3";FLOOR[8][3][6] = "";FLOOR[8][4][6] = "wall";FLOOR[8][5][6] = "";FLOOR[8][6][6] = "dy";FLOOR[8][7][6] = "m11";FLOOR[8][8][6] = "";FLOOR[8][9][6] = "rhp";FLOOR[8][10][6] = "wall";
        FLOOR[8][0][7] = "wall";FLOOR[8][1][7] = "wall";FLOOR[8][2][7] = "wall";FLOOR[8][3][7] = "wall";FLOOR[8][4][7] = "wall";FLOOR[8][5][7] = "m5";FLOOR[8][6][7] = "wall";FLOOR[8][7][7] = "wall";FLOOR[8][8][7] = "wall";FLOOR[8][9][7] = "wall";FLOOR[8][10][7] = "wall";
        FLOOR[8][0][8] = "wall";FLOOR[8][1][8] = "m13";FLOOR[8][2][8] = "";FLOOR[8][3][8] = "m11";FLOOR[8][4][8] = "dy";FLOOR[8][5][8] = "";FLOOR[8][6][8] = "wall";FLOOR[8][7][8] = "def";FLOOR[8][8][8] = "wall";FLOOR[8][9][8] = "bhp";FLOOR[8][10][8] = "wall";
        FLOOR[8][0][9] = "wall";FLOOR[8][1][9] = "ky";FLOOR[8][2][9] = "wall";FLOOR[8][3][9] = "def";FLOOR[8][4][9] = "wall";FLOOR[8][5][9] = "";FLOOR[8][6][9] = "dy";FLOOR[8][7][9] = "m11";FLOOR[8][8][9] = "wall";FLOOR[8][9][9] = "m3";FLOOR[8][10][9] = "wall";
        FLOOR[8][0][10] = "wall";FLOOR[8][1][10] = "ky";FLOOR[8][2][10] = "wall";FLOOR[8][3][10] = "rhp";FLOOR[8][4][10] = "wall";FLOOR[8][5][10] = "up";FLOOR[8][6][10] = "wall";FLOOR[8][7][10] = "";FLOOR[8][8][10] = "m13";FLOOR[8][9][10] = "";FLOOR[8][10][10] = "wall";
        FLOOR[8][0][11] = "5";FLOOR[8][1][11] = "9";FLOOR[8][2][11] = "5";FLOOR[8][3][11] = "1";FLOOR[8][4][11] = "9";FLOOR[8][5][11] = "8";FLOOR[8][6][11] = "7";
        FLOOR[8][8][12] = "n";

        FLOOR[9][0][0] = "";FLOOR[9][1][0] = "";FLOOR[9][2][0] = "";FLOOR[9][3][0] = "";FLOOR[9][4][0] = "";FLOOR[9][5][0] = "";FLOOR[9][6][0] = "";FLOOR[9][7][0] = "";FLOOR[9][8][0] = "";FLOOR[9][9][0] = "";FLOOR[9][10][0] = "up";
        FLOOR[9][0][1] = "";FLOOR[9][1][1] = "wall";FLOOR[9][2][1] = "wall";FLOOR[9][3][1] = "wall";FLOOR[9][4][1] = "wall";FLOOR[9][5][1] = "dy";FLOOR[9][6][1] = "wall";FLOOR[9][7][1] = "wall";FLOOR[9][8][1] = "wall";FLOOR[9][9][1] = "wall";FLOOR[9][10][1] = "";
        FLOOR[9][0][2] = "";FLOOR[9][1][2] = "wall";FLOOR[9][2][2] = "";FLOOR[9][3][2] = "";FLOOR[9][4][2] = "dy";FLOOR[9][5][2] = "m15";FLOOR[9][6][2] = "wall";FLOOR[9][7][2] = "";FLOOR[9][8][2] = "rhp";FLOOR[9][9][2] = "wall";FLOOR[9][10][2] = "";
        FLOOR[9][0][3] = "";FLOOR[9][1][3] = "wall";FLOOR[9][2][3] = "rhp";FLOOR[9][3][3] = "ky";FLOOR[9][4][3] = "wall";FLOOR[9][5][3] = "";FLOOR[9][6][3] = "dy";FLOOR[9][7][3] = "m11";FLOOR[9][8][3] = "ky";FLOOR[9][9][3] = "wall";FLOOR[9][10][3] = "";
        FLOOR[9][0][4] = "";FLOOR[9][1][4] = "wall";FLOOR[9][2][4] = "m13";FLOOR[9][3][4] = "ad";FLOOR[9][4][4] = "wall";FLOOR[9][5][4] = "";FLOOR[9][6][4] = "wall";FLOOR[9][7][4] = "";FLOOR[9][8][4] = "ky";FLOOR[9][9][4] = "wall";FLOOR[9][10][4] = "";
        FLOOR[9][0][5] = "";FLOOR[9][1][5] = "wall";FLOOR[9][2][5] = "dy";FLOOR[9][3][5] = "wall";FLOOR[9][4][5] = "wall";FLOOR[9][5][5] = "";FLOOR[9][6][5] = "wall";FLOOR[9][7][5] = "wall";FLOOR[9][8][5] = "wall";FLOOR[9][9][5] = "wall";FLOOR[9][10][5] = "";
        FLOOR[9][0][6] = "";FLOOR[9][1][6] = "wall";FLOOR[9][2][6] = "";FLOOR[9][3][6] = "rhp";FLOOR[9][4][6] = "db";FLOOR[9][5][6] = "";FLOOR[9][6][6] = "wall";FLOOR[9][7][6] = "";FLOOR[9][8][6] = "rhp";FLOOR[9][9][6] = "wall";FLOOR[9][10][6] = "";
        FLOOR[9][0][7] = "";FLOOR[9][1][7] = "wall";FLOOR[9][2][7] = "baoji_3";FLOOR[9][3][7] = "def";FLOOR[9][4][7] = "wall";FLOOR[9][5][7] = "";FLOOR[9][6][7] = "dy";FLOOR[9][7][7] = "m11";FLOOR[9][8][7] = "ky";FLOOR[9][9][7] = "wall";FLOOR[9][10][7] = "";
        FLOOR[9][0][8] = "";FLOOR[9][1][8] = "wall";FLOOR[9][2][8] = "";FLOOR[9][3][8] = "m13";FLOOR[9][4][8] = "dy";FLOOR[9][5][8] = "m15";FLOOR[9][6][8] = "wall";FLOOR[9][7][8] = "";FLOOR[9][8][8] = "ky";FLOOR[9][9][8] = "wall";FLOOR[9][10][8] = "";
        FLOOR[9][0][9] = "";FLOOR[9][1][9] = "wall";FLOOR[9][2][9] = "wall";FLOOR[9][3][9] = "wall";FLOOR[9][4][9] = "wall";FLOOR[9][5][9] = "dy";FLOOR[9][6][9] = "wall";FLOOR[9][7][9] = "wall";FLOOR[9][8][9] = "wall";FLOOR[9][9][9] = "wall";FLOOR[9][10][9] = "";
        FLOOR[9][0][10] = "down";FLOOR[9][1][10] = "";FLOOR[9][2][10] = "";FLOOR[9][3][10] = "";FLOOR[9][4][10] = "";FLOOR[9][5][10] = "";FLOOR[9][6][10] = "";FLOOR[9][7][10] = "";FLOOR[9][8][10] = "";FLOOR[9][9][10] = "";FLOOR[9][10][10] = "";
        FLOOR[9][0][11] = "9";FLOOR[9][1][11] = "0";FLOOR[9][2][11] = "1";FLOOR[9][3][11] = "10";FLOOR[9][4][11] = "10";FLOOR[9][5][11] = "9";FLOOR[9][6][11] = "8";
        FLOOR[9][8][12] = "n";

        FLOOR[10][0][0] = "";FLOOR[10][1][0] = "";FLOOR[10][2][0] = "wall";FLOOR[10][3][0] = "";FLOOR[10][4][0] = "wall";FLOOR[10][5][0] = "";FLOOR[10][6][0] = "wall";FLOOR[10][7][0] = "";FLOOR[10][8][0] = "wall";FLOOR[10][9][0] = "";FLOOR[10][10][0] = "";
        FLOOR[10][0][1] = "";FLOOR[10][1][1] = "";FLOOR[10][2][1] = "wall";FLOOR[10][3][1] = "";FLOOR[10][4][1] = "wall";FLOOR[10][5][1] = "";FLOOR[10][6][1] = "wall";FLOOR[10][7][1] = "";FLOOR[10][8][1] = "wall";FLOOR[10][9][1] = "";FLOOR[10][10][1] = "";
        FLOOR[10][0][2] = "";FLOOR[10][1][2] = "";FLOOR[10][2][2] = "wall";FLOOR[10][3][2] = "";FLOOR[10][4][2] = "wall";FLOOR[10][5][2] = "";FLOOR[10][6][2] = "wall";FLOOR[10][7][2] = "";FLOOR[10][8][2] = "wall";FLOOR[10][9][2] = "";FLOOR[10][10][2] = "";
        FLOOR[10][0][3] = "wall";FLOOR[10][1][3] = "wall";FLOOR[10][2][3] = "wall";FLOOR[10][3][3] = "wall";FLOOR[10][4][3] = "wall";FLOOR[10][5][3] = "";FLOOR[10][6][3] = "wall";FLOOR[10][7][3] = "wall";FLOOR[10][8][3] = "wall";FLOOR[10][9][3] = "wall";FLOOR[10][10][3] = "wall";
        FLOOR[10][0][4] = "";FLOOR[10][1][4] = "";FLOOR[10][2][4] = "wall";FLOOR[10][3][4] = "";FLOOR[10][4][4] = "";FLOOR[10][5][4] = "";FLOOR[10][6][4] = "";FLOOR[10][7][4] = "";FLOOR[10][8][4] = "wall";FLOOR[10][9][4] = "";FLOOR[10][10][4] = "";
        FLOOR[10][0][5] = "";FLOOR[10][1][5] = "";FLOOR[10][2][5] = "wall";FLOOR[10][3][5] = "";FLOOR[10][4][5] = "";FLOOR[10][5][5] = "m10";FLOOR[10][6][5] = "";FLOOR[10][7][5] = "";FLOOR[10][8][5] = "wall";FLOOR[10][9][5] = "";FLOOR[10][10][5] = "";
        FLOOR[10][0][6] = "";FLOOR[10][1][6] = "";FLOOR[10][2][6] = "wall";FLOOR[10][3][6] = "";FLOOR[10][4][6] = "";FLOOR[10][5][6] = "";FLOOR[10][6][6] = "";FLOOR[10][7][6] = "";FLOOR[10][8][6] = "wall";FLOOR[10][9][6] = "";FLOOR[10][10][6] = "";
        FLOOR[10][0][7] = "";FLOOR[10][1][7] = "";FLOOR[10][2][7] = "wall";FLOOR[10][3][7] = "";FLOOR[10][4][7] = "";FLOOR[10][5][7] = "specialEvent1";FLOOR[10][6][7] = "";FLOOR[10][7][7] = "";FLOOR[10][8][7] = "wall";FLOOR[10][9][7] = "";FLOOR[10][10][7] = "";
        FLOOR[10][0][8] = "wall";FLOOR[10][1][8] = "wall";FLOOR[10][2][8] = "wall";FLOOR[10][3][8] = "wall";FLOOR[10][4][8] = "wall";FLOOR[10][5][8] = "dr";FLOOR[10][6][8] = "wall";FLOOR[10][7][8] = "wall";FLOOR[10][8][8] = "wall";FLOOR[10][9][8] = "wall";FLOOR[10][10][8] = "wall";
        FLOOR[10][0][9] = "";FLOOR[10][1][9] = "";FLOOR[10][2][9] = "wall";FLOOR[10][3][9] = "";FLOOR[10][4][9] = "wall";FLOOR[10][5][9] = "";FLOOR[10][6][9] = "wall";FLOOR[10][7][9] = "";FLOOR[10][8][9] = "wall";FLOOR[10][9][9] = "";FLOOR[10][10][9] = "";
        FLOOR[10][0][10] = "";FLOOR[10][1][10] = "";FLOOR[10][2][10] = "wall";FLOOR[10][3][10] = "";FLOOR[10][4][10] = "wall";FLOOR[10][5][10] = "down";FLOOR[10][6][10] = "wall";FLOOR[10][7][10] = "";FLOOR[10][8][10] = "wall";FLOOR[10][9][10] = "";FLOOR[10][10][10] = "";
        FLOOR[10][0][11] = "5";FLOOR[10][1][11] = "1";FLOOR[10][2][11] = "5";FLOOR[10][3][11] = "9";FLOOR[10][4][11] = "11";FLOOR[10][5][11] = "10";FLOOR[10][6][11] = "9";
        FLOOR[10][8][12] = "n";

        FLOOR[11][0][0] = "";FLOOR[11][1][0] = "";FLOOR[11][2][0] = "npc";FLOOR[11][3][0] = "rhp";FLOOR[11][4][0] = "";FLOOR[11][5][0] = "";FLOOR[11][6][0] = "";FLOOR[11][7][0] = "m14";FLOOR[11][8][0] = "";FLOOR[11][9][0] = "";FLOOR[11][10][0] = "up";
        FLOOR[11][0][1] = "m9";FLOOR[11][1][1] = "wall";FLOOR[11][2][1] = "wall";FLOOR[11][3][1] = "wall";FLOOR[11][4][1] = "wall";FLOOR[11][5][1] = "wall";FLOOR[11][6][1] = "wall";FLOOR[11][7][1] = "wall";FLOOR[11][8][1] = "wall";FLOOR[11][9][1] = "wall";FLOOR[11][10][1] = "wall";
        FLOOR[11][0][2] = "rhp";FLOOR[11][1][2] = "";FLOOR[11][2][2] = "wall";FLOOR[11][3][2] = "ad";FLOOR[11][4][2] = "bhp";FLOOR[11][5][2] = "def";FLOOR[11][6][2] = "wall";FLOOR[11][7][2] = "";FLOOR[11][8][2] = "";FLOOR[11][9][2] = "";FLOOR[11][10][2] = "wall";
        FLOOR[11][0][3] = "wall";FLOOR[11][1][3] = "m9";FLOOR[11][2][3] = "wall";FLOOR[11][3][3] = "ky";FLOOR[11][4][3] = "m17";FLOOR[11][5][3] = "ky";FLOOR[11][6][3] = "wall";FLOOR[11][7][3] = "";FLOOR[11][8][3] = "merchant";FLOOR[11][9][3] = "";FLOOR[11][10][3] = "wall";
        FLOOR[11][0][4] = "rhp";FLOOR[11][1][4] = "";FLOOR[11][2][4] = "wall";FLOOR[11][3][4] = "m8";FLOOR[11][4][4] = "";FLOOR[11][5][4] = "m8";FLOOR[11][6][4] = "wall";FLOOR[11][7][4] = "";FLOOR[11][8][4] = "";FLOOR[11][9][4] = "";FLOOR[11][10][4] = "wall";
        FLOOR[11][0][5] = "wall";FLOOR[11][1][5] = "dy";FLOOR[11][2][5] = "wall";FLOOR[11][3][5] = "wall";FLOOR[11][4][5] = "dy";FLOOR[11][5][5] = "wall";FLOOR[11][6][5] = "wall";FLOOR[11][7][5] = "wall";FLOOR[11][8][5] = "dy";FLOOR[11][9][5] = "wall";FLOOR[11][10][5] = "wall";
        FLOOR[11][0][6] = "";FLOOR[11][1][6] = "";FLOOR[11][2][6] = "ky";FLOOR[11][3][6] = "m16";FLOOR[11][4][6] = "ky";FLOOR[11][5][6] = "";FLOOR[11][6][6] = "";FLOOR[11][7][6] = "wall";FLOOR[11][8][6] = "";FLOOR[11][9][6] = "wall";FLOOR[11][10][6] = "down";
        FLOOR[11][0][7] = "m7";FLOOR[11][1][7] = "wall";FLOOR[11][2][7] = "wall";FLOOR[11][3][7] = "wall";FLOOR[11][4][7] = "wall";FLOOR[11][5][7] = "wall";FLOOR[11][6][7] = "m13";FLOOR[11][7][7] = "wall";FLOOR[11][8][7] = "";FLOOR[11][9][7] = "wall";FLOOR[11][10][7] = "";
        FLOOR[11][0][8] = "m13";FLOOR[11][1][8] = "wall";FLOOR[11][2][8] = "shopleft";FLOOR[11][3][8] = "shop";FLOOR[11][4][8] = "shopright";FLOOR[11][5][8] = "wall";FLOOR[11][6][8] = "m8";FLOOR[11][7][8] = "wall";FLOOR[11][8][8] = "";FLOOR[11][9][8] = "wall";FLOOR[11][10][8] = "";
        FLOOR[11][0][9] = "dy";FLOOR[11][1][9] = "wall";FLOOR[11][2][9] = "rhp";FLOOR[11][3][9] = "";FLOOR[11][4][9] = "rhp";FLOOR[11][5][9] = "wall";FLOOR[11][6][9] = "db";FLOOR[11][7][9] = "wall";FLOOR[11][8][9] = "m8";FLOOR[11][9][9] = "wall";FLOOR[11][10][9] = "m3";
        FLOOR[11][0][10] = "";FLOOR[11][1][10] = "";FLOOR[11][2][10] = "";FLOOR[11][3][10] = "";FLOOR[11][4][10] = "";FLOOR[11][5][10] = "";FLOOR[11][6][10] = "";FLOOR[11][7][10] = "";FLOOR[11][8][10] = "";FLOOR[11][9][10] = "m3";FLOOR[11][10][10] = "";
        FLOOR[11][0][11] = "9";FLOOR[11][1][11] = "0";FLOOR[11][2][11] = "10";FLOOR[11][3][11] = "7";FLOOR[11][4][11] = "12";FLOOR[11][5][11] = "11";FLOOR[11][6][11] = "10";
        FLOOR[11][8][12] = "n";
        FLOOR[11][8][11] = "吴大爷"; FLOOR[11][9][11] = "当你拥有圣十字架时，在面对所有兽人和蝙蝠类时都会";FLOOR[11][10][11] = "使你攻击力翻倍。";
        FLOOR[11][7][13]="1"; FLOOR[11][8][13] = "陶宝卖家陆仁贾"; FLOOR[11][9][13] = "Oh！高价回收旧装备咯！";

        FLOOR[12][0][0] = "up";FLOOR[12][1][0] = "wall";FLOOR[12][2][0] = "rhp";FLOOR[12][3][0] = "";FLOOR[12][4][0] = "rhp";FLOOR[12][5][0] = "wall";FLOOR[12][6][0] = "wall";FLOOR[12][7][0] = "wall";FLOOR[12][8][0] = "wall";FLOOR[12][9][0] = "wall";FLOOR[12][10][0] = "wall";
        FLOOR[12][0][1] = "";FLOOR[12][1][1] = "wall";FLOOR[12][2][1] = "";FLOOR[12][3][1] = "def_2";FLOOR[12][4][1] = "";FLOOR[12][5][1] = "wall";FLOOR[12][6][1] = "ky";FLOOR[12][7][1] = "ky";FLOOR[12][8][1] = "ky";FLOOR[12][9][1] = "ky";FLOOR[12][10][1] = "wall";
        FLOOR[12][0][2] = "";FLOOR[12][1][2] = "wall";FLOOR[12][2][2] = "";FLOOR[12][3][2] = "";FLOOR[12][4][2] = "";FLOOR[12][5][2] = "wall";FLOOR[12][6][2] = "kb";FLOOR[12][7][2] = "";FLOOR[12][8][2] = "m9";FLOOR[12][9][2] = "";FLOOR[12][10][2] = "wall";
        FLOOR[12][0][3] = "m8";FLOOR[12][1][3] = "wall";FLOOR[12][2][3] = "wall";FLOOR[12][3][3] = "de1";FLOOR[12][4][3] = "wall";FLOOR[12][5][3] = "wall";FLOOR[12][6][3] = "wall";FLOOR[12][7][3] = "wall";FLOOR[12][8][3] = "dy";FLOOR[12][9][3] = "wall";FLOOR[12][10][3] = "wall";
        FLOOR[12][0][4] = "m17";FLOOR[12][1][4] = "wall";FLOOR[12][2][4] = "m15";FLOOR[12][3][4] = "";FLOOR[12][4][4] = "m15";FLOOR[12][5][4] = "wall";FLOOR[12][6][4] = "kb";FLOOR[12][7][4] = "m18";FLOOR[12][8][4] = "";FLOOR[12][9][4] = "npc";FLOOR[12][10][4] = "m8";
        FLOOR[12][0][5] = "m8";FLOOR[12][1][5] = "wall";FLOOR[12][2][5] = "";FLOOR[12][3][5] = "";FLOOR[12][4][5] = "";FLOOR[12][5][5] = "wall";FLOOR[12][6][5] = "wall";FLOOR[12][7][5] = "wall";FLOOR[12][8][5] = "wall";FLOOR[12][9][5] = "wall";FLOOR[12][10][5] = "dy";
        FLOOR[12][0][6] = "";FLOOR[12][1][6] = "dy";FLOOR[12][2][6] = "";FLOOR[12][3][6] = "";FLOOR[12][4][6] = "";FLOOR[12][5][6] = "";FLOOR[12][6][6] = "";FLOOR[12][7][6] = "";FLOOR[12][8][6] = "";FLOOR[12][9][6] = "";FLOOR[12][10][6] = "";
        FLOOR[12][0][7] = "wall";FLOOR[12][1][7] = "wall";FLOOR[12][2][7] = "wall";FLOOR[12][3][7] = "wall";FLOOR[12][4][7] = "db";FLOOR[12][5][7] = "wall";FLOOR[12][6][7] = "wall";FLOOR[12][7][7] = "wallE";FLOOR[12][8][7] = "wall";FLOOR[12][9][7] = "wall";FLOOR[12][10][7] = "down";
        FLOOR[12][0][8] = "ky";FLOOR[12][1][8] = "";FLOOR[12][2][8] = "m17";FLOOR[12][3][8] = "dy";FLOOR[12][4][8] = "";FLOOR[12][5][8] = "wall";FLOOR[12][6][8] = "ad";FLOOR[12][7][8] = "";FLOOR[12][8][8] = "m14";FLOOR[12][9][8] = "wall";FLOOR[12][10][8] = "wall";
        FLOOR[12][0][9] = "rhp";FLOOR[12][1][9] = "ky";FLOOR[12][2][9] = "";FLOOR[12][3][9] = "wall";FLOOR[12][4][9] = "m8";FLOOR[12][5][9] = "wall";FLOOR[12][6][9] = "";FLOOR[12][7][9] = "bhp";FLOOR[12][8][9] = "";FLOOR[12][9][9] = "de2";FLOOR[12][10][9] = "kr";
        FLOOR[12][0][10] = "blood_1";FLOOR[12][1][10] = "rhp";FLOOR[12][2][10] = "ky";FLOOR[12][3][10] = "wall";FLOOR[12][4][10] = "def";FLOOR[12][5][10] = "dy";FLOOR[12][6][10] = "m16";FLOOR[12][7][10] = "";FLOOR[12][8][10] = "m14";FLOOR[12][9][10] = "wall";FLOOR[12][10][10] = "wall";
        FLOOR[12][8][11] = "赵大爷"; FLOOR[12][9][11] = "我爹告诉我这魔塔存在暗墙。";FLOOR[12][10][11] = "";
        FLOOR[12][0][11]="0";FLOOR[12][1][11]="1";FLOOR[12][2][11]="10";FLOOR[12][3][11]="6";FLOOR[12][4][11] = "13";FLOOR[12][5][11] = "12";FLOOR[12][6][11] = "11";
        FLOOR[12][0][12]="2";FLOOR[12][1][12]="4";FLOOR[12][2][12]="4";FLOOR[12][3][12]="4";FLOOR[12][4][12]="8";FLOOR[12][5][12]="8";FLOOR[12][6][12]="8";FLOOR[12][7][12]="10";
        FLOOR[12][4][13]="3";FLOOR[12][5][13]="3";FLOOR[12][6][13]="9";FLOOR[12][7][13]="9";


        FLOOR[13][0][0] = "def";FLOOR[13][1][0] = "ky";FLOOR[13][2][0] = "rhp";FLOOR[13][3][0] = "wall";FLOOR[13][4][0] = "ky";FLOOR[13][5][0] = "ad";FLOOR[13][6][0] = "m16";FLOOR[13][7][0] = "dy";FLOOR[13][8][0] = "";FLOOR[13][9][0] = "wall";FLOOR[13][10][0] = "down";
        FLOOR[13][0][1] = "";FLOOR[13][1][1] = "m14";FLOOR[13][2][1] = "";FLOOR[13][3][1] = "wall";FLOOR[13][4][1] = "ky";FLOOR[13][5][1] = "rhp";FLOOR[13][6][1] = "";FLOOR[13][7][1] = "wall";FLOOR[13][8][1] = "";FLOOR[13][9][1] = "wall";FLOOR[13][10][1] = "";
        FLOOR[13][0][2] = "wall";FLOOR[13][1][2] = "dy";FLOOR[13][2][2] = "wall";FLOOR[13][3][2] = "wall";FLOOR[13][4][2] = "wall";FLOOR[13][5][2] = "wall";FLOOR[13][6][2] = "wall";FLOOR[13][7][2] = "wall";FLOOR[13][8][2] = "";FLOOR[13][9][2] = "dy";FLOOR[13][10][2] = "";
        FLOOR[13][0][3] = "";FLOOR[13][1][3] = "";FLOOR[13][2][3] = "m8";FLOOR[13][3][3] = "";FLOOR[13][4][3] = "wall";FLOOR[13][5][3] = "";FLOOR[13][6][3] = "m8";FLOOR[13][7][3] = "";FLOOR[13][8][3] = "";FLOOR[13][9][3] = "wall";FLOOR[13][10][3] = "npc";
        FLOOR[13][0][4] = "wall";FLOOR[13][1][4] = "wall";FLOOR[13][2][4] = "wall";FLOOR[13][3][4] = "rhp";FLOOR[13][4][4] = "db";FLOOR[13][5][4] = "rhp";FLOOR[13][6][4] = "wall";FLOOR[13][7][4] = "wall";FLOOR[13][8][4] = "wall";FLOOR[13][9][4] = "wall";FLOOR[13][10][4] = "m8";
        FLOOR[13][0][5] = "wall";FLOOR[13][1][5] = "";FLOOR[13][2][5] = "m8";FLOOR[13][3][5] = "";FLOOR[13][4][5] = "wall";FLOOR[13][5][5] = "";FLOOR[13][6][5] = "m8";FLOOR[13][7][5] = "";FLOOR[13][8][5] = "wall";FLOOR[13][9][5] = "m8";FLOOR[13][10][5] = "";
        FLOOR[13][0][6] = "wall";FLOOR[13][1][6] = "ky";FLOOR[13][2][6] = "wall";FLOOR[13][3][6] = "wall";FLOOR[13][4][6] = "wall";FLOOR[13][5][6] = "wall";FLOOR[13][6][6] = "";FLOOR[13][7][6] = "m17";FLOOR[13][8][6] = "wall";FLOOR[13][9][6] = "m14";FLOOR[13][10][6] = "wall";
        FLOOR[13][0][7] = "wall";FLOOR[13][1][7] = "ky";FLOOR[13][2][7] = "wall";FLOOR[13][3][7] = "m14";FLOOR[13][4][7] = "dy";FLOOR[13][5][7] = "";FLOOR[13][6][7] = "";FLOOR[13][7][7] = "wall";FLOOR[13][8][7] = "wall";FLOOR[13][9][7] = "dy";FLOOR[13][10][7] = "wall";
        FLOOR[13][0][8] = "wall";FLOOR[13][1][8] = "m16";FLOOR[13][2][8] = "wall";FLOOR[13][3][8] = "wallE";FLOOR[13][4][8] = "wall";FLOOR[13][5][8] = "wall";FLOOR[13][6][8] = "wall";FLOOR[13][7][8] = "wall";FLOOR[13][8][8] = "m17";FLOOR[13][9][8] = "";FLOOR[13][10][8] = "m17";
        FLOOR[13][0][9] = "";FLOOR[13][1][9] = "";FLOOR[13][2][9] = "dy";FLOOR[13][3][9] = "";FLOOR[13][4][9] = "m14";FLOOR[13][5][9] = "ky";FLOOR[13][6][9] = "bhp";FLOOR[13][7][9] = "wall";FLOOR[13][8][9] = "blood_1";FLOOR[13][9][9] = "m18";FLOOR[13][10][9] = "ky";
        FLOOR[13][0][10] = "up";FLOOR[13][1][10] = "";FLOOR[13][2][10] = "wall";FLOOR[13][3][10] = "";FLOOR[13][4][10] = "";FLOOR[13][5][10] = "m14";FLOOR[13][6][10] = "ky";FLOOR[13][7][10] = "wall";FLOOR[13][8][10] = "kb";FLOOR[13][9][10] = "bhp";FLOOR[13][10][10] = "ky";
        FLOOR[13][0][11] = "0";FLOOR[13][1][11] = "9";FLOOR[13][2][11] = "10";FLOOR[13][3][11] = "1";FLOOR[13][4][11] = "14";FLOOR[13][5][11] = "13";FLOOR[13][6][11] = "12";FLOOR[13][7][11] = "";FLOOR[13][8][11] = "齐大爷";FLOOR[13][9][11] = "当心！在面对吸血红蝙蝠时会被固定减少你100生命值，而";FLOOR[13][10][11] = "兽人武士会直接减少你10%生命值。";
//        FLOOR[13][0][12] = "";FLOOR[13][1][12] = "";FLOOR[13][2][12] = "";FLOOR[13][3][12] = "";FLOOR[13][4][12] = "";FLOOR[13][5][12] = "";FLOOR[13][6][12] = "";FLOOR[13][7][12] = "";FLOOR[13][8][12] = "";FLOOR[13][9][12] = "";FLOOR[13][10][12] = "";
//        FLOOR[13][0][13] = "";FLOOR[13][1][13] = "";FLOOR[13][2][13] = "";FLOOR[13][3][13] = "";FLOOR[13][4][13] = "";FLOOR[13][5][13] = "";FLOOR[13][6][13] = "";FLOOR[13][7][13] = "";FLOOR[13][8][13] = "";FLOOR[13][9][13] = "";FLOOR[13][10][13] = "";



        FLOOR[14][0][0] = "down";FLOOR[14][1][0] = "wall";FLOOR[14][2][0] = "";FLOOR[14][3][0] = "";FLOOR[14][4][0] = "";FLOOR[14][5][0] = "";FLOOR[14][6][0] = "ob";FLOOR[14][7][0] = "to2F";FLOOR[14][8][0] = "ob";FLOOR[14][9][0] = "";FLOOR[14][10][0] = "";
        FLOOR[14][0][1] = "";FLOOR[14][1][1] = "wall";FLOOR[14][2][1] = "";FLOOR[14][3][1] = "";FLOOR[14][4][1] = "";FLOOR[14][5][1] = "";FLOOR[14][6][1] = "ob";FLOOR[14][7][1] = "";FLOOR[14][8][1] = "ob";FLOOR[14][9][1] = "";FLOOR[14][10][1] = "";
        FLOOR[14][0][2] = "";FLOOR[14][1][2] = "wall";FLOOR[14][2][2] = "ob";FLOOR[14][3][2] = "ob";FLOOR[14][4][2] = "ob";FLOOR[14][5][2] = "ob";FLOOR[14][6][2] = "ob";FLOOR[14][7][2] = "";FLOOR[14][8][2] = "ob";FLOOR[14][9][2] = "ob";FLOOR[14][10][2] = "ob";
        FLOOR[14][0][3] = "";FLOOR[14][1][3] = "wall";FLOOR[14][2][3] = "";FLOOR[14][3][3] = "";FLOOR[14][4][3] = "";FLOOR[14][5][3] = "";FLOOR[14][6][3] = "";FLOOR[14][7][3] = "";FLOOR[14][8][3] = "";FLOOR[14][9][3] = "";FLOOR[14][10][3] = "";
        FLOOR[14][0][4] = "";FLOOR[14][1][4] = "wall";FLOOR[14][2][4] = "";FLOOR[14][3][4] = "";FLOOR[14][4][4] = "";FLOOR[14][5][4] = "";FLOOR[14][6][4] = "";FLOOR[14][7][4] = "";FLOOR[14][8][4] = "";FLOOR[14][9][4] = "";FLOOR[14][10][4] = "";
        FLOOR[14][0][5] = "npc";FLOOR[14][1][5] = "wall";FLOOR[14][2][5] = "";FLOOR[14][3][5] = "";FLOOR[14][4][5] = "";FLOOR[14][5][5] = "mine";FLOOR[14][6][5] = "ob";FLOOR[14][7][5] = "ob";FLOOR[14][8][5] = "ob";FLOOR[14][9][5] = "";FLOOR[14][10][5] = "";
        FLOOR[14][0][6] = "";FLOOR[14][1][6] = "wall";FLOOR[14][2][6] = "";FLOOR[14][3][6] = "";FLOOR[14][4][6] = "";FLOOR[14][5][6] = "";FLOOR[14][6][6] = "mine";FLOOR[14][7][6] = "";FLOOR[14][8][6] = "";FLOOR[14][9][6] = "";FLOOR[14][10][6] = "";
        FLOOR[14][0][7] = "";FLOOR[14][1][7] = "wall";FLOOR[14][2][7] = "";FLOOR[14][3][7] = "";FLOOR[14][4][7] = "";FLOOR[14][5][7] = "";FLOOR[14][6][7] = "";FLOOR[14][7][7] = "";FLOOR[14][8][7] = "";FLOOR[14][9][7] = "";FLOOR[14][10][7] = "";
        FLOOR[14][0][8] = "";FLOOR[14][1][8] = "wall";FLOOR[14][2][8] = "";FLOOR[14][3][8] = "";FLOOR[14][4][8] = "";FLOOR[14][5][8] = "";FLOOR[14][6][8] = "";FLOOR[14][7][8] = "";FLOOR[14][8][8] = "";FLOOR[14][9][8] = "";FLOOR[14][10][8] = "";
        FLOOR[14][0][9] = "";FLOOR[14][1][9] = "wall";FLOOR[14][2][9] = "";FLOOR[14][3][9] = "";FLOOR[14][4][9] = "";FLOOR[14][5][9] = "";FLOOR[14][6][9] = "";FLOOR[14][7][9] = "";FLOOR[14][8][9] = "";FLOOR[14][9][9] = "";FLOOR[14][10][9] = "";
        FLOOR[14][0][10] = "up";FLOOR[14][1][10] = "wall";FLOOR[14][2][10] = "";FLOOR[14][3][10] = "";FLOOR[14][4][10] = "";FLOOR[14][5][10] = "";FLOOR[14][6][10] = "";FLOOR[14][7][10] = "";FLOOR[14][8][10] = "";FLOOR[14][9][10] = "";FLOOR[14][10][10] = "";
        FLOOR[14][0][11]="0";FLOOR[14][1][11]="9";FLOOR[14][2][11]="0";FLOOR[14][3][11]="1";FLOOR[14][4][11] = "15";FLOOR[14][5][11] = "14";FLOOR[14][6][11] = "13";
        FLOOR[14][8][11] = "李大爷"; FLOOR[14][9][11] = "魔塔的14层是一个的金矿开采场，但我听说只有第二层有";FLOOR[14][10][11] = "通向金矿的道路。";

        FLOOR[15][0][0] = "up";FLOOR[15][1][0] = "";FLOOR[15][2][0] = "";FLOOR[15][3][0] = "";FLOOR[15][4][0] = "";FLOOR[15][5][0] = "wall";FLOOR[15][6][0] = "m14";FLOOR[15][7][0] = "";FLOOR[15][8][0] = "wall";FLOOR[15][9][0] = "ad";FLOOR[15][10][0] = "def";
        FLOOR[15][0][1] = "wall";FLOOR[15][1][1] = "wall";FLOOR[15][2][1] = "wall";FLOOR[15][3][1] = "de1";FLOOR[15][4][1] = "wall";FLOOR[15][5][1] = "wall";FLOOR[15][6][1] = "wall";FLOOR[15][7][1] = "";FLOOR[15][8][1] = "wall";FLOOR[15][9][1] = "m17";FLOOR[15][10][1] = "bhp";
        FLOOR[15][0][2] = "kr";FLOOR[15][1][2] = "ky";FLOOR[15][2][2] = "wall";FLOOR[15][3][2] = "";FLOOR[15][4][2] = "wall_break";FLOOR[15][5][2] = "";FLOOR[15][6][2] = "wall";FLOOR[15][7][2] = "";FLOOR[15][8][2] = "wall";FLOOR[15][9][2] = "db";FLOOR[15][10][2] = "wall";
        FLOOR[15][0][3] = "ky";FLOOR[15][1][3] = "m19";FLOOR[15][2][3] = "wall";FLOOR[15][3][3] = "";FLOOR[15][4][3] = "";FLOOR[15][5][3] = "";FLOOR[15][6][3] = "wall";FLOOR[15][7][3] = "rhp";FLOOR[15][8][3] = "wall";FLOOR[15][9][3] = "rhp";FLOOR[15][10][3] = "ky";
        FLOOR[15][0][4] = "wall";FLOOR[15][1][4] = "dy";FLOOR[15][2][4] = "wall";FLOOR[15][3][4] = "";FLOOR[15][4][4] = "";FLOOR[15][5][4] = "";FLOOR[15][6][4] = "wall";FLOOR[15][7][4] = "m14";FLOOR[15][8][4] = "wall";FLOOR[15][9][4] = "ky";FLOOR[15][10][4] = "m17";
        FLOOR[15][0][5] = "rhp";FLOOR[15][1][5] = "";FLOOR[15][2][5] = "wall";FLOOR[15][3][5] = "";FLOOR[15][4][5] = "m21";FLOOR[15][5][5] = "";FLOOR[15][6][5] = "wall";FLOOR[15][7][5] = "m8";FLOOR[15][8][5] = "wall";FLOOR[15][9][5] = "wall";FLOOR[15][10][5] = "dy";
        FLOOR[15][0][6] = "m18";FLOOR[15][1][6] = "ad";FLOOR[15][2][6] = "wall";FLOOR[15][3][6] = "wall";FLOOR[15][4][6] = "dy";FLOOR[15][5][6] = "wall";FLOOR[15][6][6] = "wall";FLOOR[15][7][6] = "";FLOOR[15][8][6] = "";FLOOR[15][9][6] = "";FLOOR[15][10][6] = "";
        FLOOR[15][0][7] = "dy";FLOOR[15][1][7] = "wall";FLOOR[15][2][7] = "wall";FLOOR[15][3][7] = "ky";FLOOR[15][4][7] = "m8";FLOOR[15][5][7] = "";FLOOR[15][6][7] = "";FLOOR[15][7][7] = "";FLOOR[15][8][7] = "wall";FLOOR[15][9][7] = "wall";FLOOR[15][10][7] = "wallE";
        FLOOR[15][0][8] = "";FLOOR[15][1][8] = "ky";FLOOR[15][2][8] = "wall";FLOOR[15][3][8] = "m8";FLOOR[15][4][8] = "wall";FLOOR[15][5][8] = "m8";FLOOR[15][6][8] = "wall";FLOOR[15][7][8] = "";FLOOR[15][8][8] = "m16";FLOOR[15][9][8] = "wall";FLOOR[15][10][8] = "";
        FLOOR[15][0][9] = "bhp";FLOOR[15][1][9] = "ky";FLOOR[15][2][9] = "wall";FLOOR[15][3][9] = "";FLOOR[15][4][9] = "wall";FLOOR[15][5][9] = "";FLOOR[15][6][9] = "wall";FLOOR[15][7][9] = "";FLOOR[15][8][9] = "";FLOOR[15][9][9] = "dz";FLOOR[15][10][9] = "thief";
        FLOOR[15][0][10] = "";FLOOR[15][1][10] = "m17";FLOOR[15][2][10] = "dy";FLOOR[15][3][10] = "";FLOOR[15][4][10] = "wall";FLOOR[15][5][10] = "down";FLOOR[15][6][10] = "wall";FLOOR[15][7][10] = "";FLOOR[15][8][10] = "m16";FLOOR[15][9][10] = "wall";FLOOR[15][10][10] = "";
        FLOOR[15][0][11] = "1";FLOOR[15][1][11] = "0";FLOOR[15][2][11] = "5";FLOOR[15][3][11] = "9";FLOOR[15][4][11] = "16";FLOOR[15][5][11] = "15";FLOOR[15][6][11] = "14";FLOOR[15][7][11] = "4";FLOOR[15][8][11] = "小偷";FLOOR[15][9][11] = "oh！谁能想到我会被救，我去帮你打通去16层的路吧...";FLOOR[15][10][11] = "哦还有，乌贼那有宝物！";
        FLOOR[15][0][12] = "4";FLOOR[15][1][12] = "5";FLOOR[15][2][12] = "1";FLOOR[15][3][12] = "0";FLOOR[15][4][12] = "";FLOOR[15][5][12] = "";FLOOR[15][6][12] = "";FLOOR[15][7][12] = "";FLOOR[15][8][12] = "";FLOOR[15][9][12] = "";FLOOR[15][10][12] = "";
        FLOOR[15][0][13] = "8";FLOOR[15][1][13] = "8";FLOOR[15][2][13] = "8";FLOOR[15][3][13] = "10";FLOOR[15][4][13] = "3";FLOOR[15][5][13] = "1";FLOOR[15][6][13] = "";FLOOR[15][7][13] = "";FLOOR[15][8][13] = "";FLOOR[15][9][13] = "";FLOOR[15][10][13] = "";

        FLOOR[16][0][0] = "m19";FLOOR[16][1][0] = "ky";FLOOR[16][2][0] = "dy";FLOOR[16][3][0] = "";FLOOR[16][4][0] = "wall";FLOOR[16][5][0] = "up";FLOOR[16][6][0] = "wall";FLOOR[16][7][0] = "m18";FLOOR[16][8][0] = "db";FLOOR[16][9][0] = "rhp";FLOOR[16][10][0] = "merchant2";
        FLOOR[16][0][1] = "bhp";FLOOR[16][1][1] = "";FLOOR[16][2][1] = "wall";FLOOR[16][3][1] = "";FLOOR[16][4][1] = "dy";FLOOR[16][5][1] = "";FLOOR[16][6][1] = "dy";FLOOR[16][7][1] = "";FLOOR[16][8][1] = "wall";FLOOR[16][9][1] = "ad";FLOOR[16][10][1] = "little_gold";
        FLOOR[16][0][2] = "dy";FLOOR[16][1][2] = "wall";FLOOR[16][2][2] = "wall";FLOOR[16][3][2] = "wall";FLOOR[16][4][2] = "wall";FLOOR[16][5][2] = "wall";FLOOR[16][6][2] = "wall";FLOOR[16][7][2] = "wall";FLOOR[16][8][2] = "wall";FLOOR[16][9][2] = "wall";FLOOR[16][10][2] = "wall";
        FLOOR[16][0][3] = "";FLOOR[16][1][3] = "m17";FLOOR[16][2][3] = "ky";FLOOR[16][3][3] = "wall";FLOOR[16][4][3] = "";FLOOR[16][5][3] = "";FLOOR[16][6][3] = "";FLOOR[16][7][3] = "wall";FLOOR[16][8][3] = "ad";FLOOR[16][9][3] = "def";FLOOR[16][10][3] = "bhp";
        FLOOR[16][0][4] = "dy";FLOOR[16][1][4] = "wall";FLOOR[16][2][4] = "ky";FLOOR[16][3][4] = "wall";FLOOR[16][4][4] = "";FLOOR[16][5][4] = "glove";FLOOR[16][6][4] = "";FLOOR[16][7][4] = "wall";FLOOR[16][8][4] = "ad";FLOOR[16][9][4] = "def";FLOOR[16][10][4] = "bhp";
        FLOOR[16][0][5] = "rhp";FLOOR[16][1][5] = "wall";FLOOR[16][2][5] = "m18";FLOOR[16][3][5] = "wall";FLOOR[16][4][5] = "";FLOOR[16][5][5] = "";FLOOR[16][6][5] = "";FLOOR[16][7][5] = "wall";FLOOR[16][8][5] = "ad";FLOOR[16][9][5] = "def";FLOOR[16][10][5] = "bhp";
        FLOOR[16][0][6] = "wall";FLOOR[16][1][6] = "wall";FLOOR[16][2][6] = "dy";FLOOR[16][3][6] = "wall";FLOOR[16][4][6] = "wall";FLOOR[16][5][6] = "dr";FLOOR[16][6][6] = "wall";FLOOR[16][7][6] = "wall";FLOOR[16][8][6] = "wall";FLOOR[16][9][6] = "wall";FLOOR[16][10][6] = "dr";
        FLOOR[16][0][7] = "";FLOOR[16][1][7] = "m9";FLOOR[16][2][7] = "";FLOOR[16][3][7] = "";FLOOR[16][4][7] = "wall";FLOOR[16][5][7] = "m19";FLOOR[16][6][7] = "wall";FLOOR[16][7][7] = "";FLOOR[16][8][7] = "m16";FLOOR[16][9][7] = "";FLOOR[16][10][7] = "m17";
        FLOOR[16][0][8] = "db";FLOOR[16][1][8] = "wall";FLOOR[16][2][8] = "wall";FLOOR[16][3][8] = "m9";FLOOR[16][4][8] = "wall";FLOOR[16][5][8] = "rhp";FLOOR[16][6][8] = "wall";FLOOR[16][7][8] = "m17";FLOOR[16][8][8] = "wall";FLOOR[16][9][8] = "wall";FLOOR[16][10][8] = "wall";
        FLOOR[16][0][9] = "rhp";FLOOR[16][1][9] = "bhp";FLOOR[16][2][9] = "wall";FLOOR[16][3][9] = "";FLOOR[16][4][9] = "dy";FLOOR[16][5][9] = "";FLOOR[16][6][9] = "dy";FLOOR[16][7][9] = "";FLOOR[16][8][9] = "wall";FLOOR[16][9][9] = "ad";FLOOR[16][10][9] = "ky";
        FLOOR[16][0][10] = "rhp";FLOOR[16][1][10] = "bhp";FLOOR[16][2][10] = "wall";FLOOR[16][3][10] = "wall";FLOOR[16][4][10] = "wall";FLOOR[16][5][10] = "down";FLOOR[16][6][10] = "wall";FLOOR[16][7][10] = "";FLOOR[16][8][10] = "dy";FLOOR[16][9][10] = "m18";FLOOR[16][10][10] = "rhp";
        FLOOR[16][0][11] = "5";FLOOR[16][1][11] = "1";FLOOR[16][2][11] = "5";FLOOR[16][3][11] = "9";FLOOR[16][4][11] = "17";FLOOR[16][5][11] = "16";FLOOR[16][6][11] = "15";FLOOR[16][7][11] = "";FLOOR[16][8][11] = "";FLOOR[16][9][11] = "";FLOOR[16][10][11] = "";
//        FLOOR[16][0][12] = "";FLOOR[16][1][12] = "";FLOOR[16][2][12] = "";FLOOR[16][3][12] = "";FLOOR[16][4][12] = "";FLOOR[16][5][12] = "";FLOOR[16][6][12] = "";FLOOR[16][7][12] = "";FLOOR[16][8][12] = "";FLOOR[16][9][12] = "";FLOOR[16][10][12] = "";
//        FLOOR[16][0][13] = "";FLOOR[16][1][13] = "";FLOOR[16][2][13] = "";FLOOR[16][3][13] = "";FLOOR[16][4][13] = "";FLOOR[16][5][13] = "";FLOOR[16][6][13] = "";FLOOR[16][7][13] = "";FLOOR[16][8][13] = "";FLOOR[16][9][13] = "";FLOOR[16][10][13] = "";


        FLOOR[17][0][0] = "ky";FLOOR[17][1][0] = "ad";FLOOR[17][2][0] = "wall";FLOOR[17][3][0] = "little_gold";FLOOR[17][4][0] = "kb";FLOOR[17][5][0] = "m18";FLOOR[17][6][0] = "wall";FLOOR[17][7][0] = "";FLOOR[17][8][0] = "ad_2";FLOOR[17][9][0] = "";FLOOR[17][10][0] = "wall";
        FLOOR[17][0][1] = "def";FLOOR[17][1][1] = "rhp";FLOOR[17][2][1] = "wall";FLOOR[17][3][1] = "ky";FLOOR[17][4][1] = "m19";FLOOR[17][5][1] = "";FLOOR[17][6][1] = "wall";FLOOR[17][7][1] = "ky";FLOOR[17][8][1] = "";FLOOR[17][9][1] = "kr";FLOOR[17][10][1] = "wall";
        FLOOR[17][0][2] = "m17";FLOOR[17][1][2] = "";FLOOR[17][2][2] = "wall";FLOOR[17][3][2] = "m18";FLOOR[17][4][2] = "";FLOOR[17][5][2] = "rhp";FLOOR[17][6][2] = "wall";FLOOR[17][7][2] = "wall";FLOOR[17][8][2] = "de2";FLOOR[17][9][2] = "wall";FLOOR[17][10][2] = "wall";
        FLOOR[17][0][3] = "db";FLOOR[17][1][3] = "wall";FLOOR[17][2][3] = "wall";FLOOR[17][3][3] = "wall";FLOOR[17][4][3] = "wall";FLOOR[17][5][3] = "dy";FLOOR[17][6][3] = "wall";FLOOR[17][7][3] = "m19";FLOOR[17][8][3] = "";FLOOR[17][9][3] = "m19";FLOOR[17][10][3] = "wall";
        FLOOR[17][0][4] = "";FLOOR[17][1][4] = "";FLOOR[17][2][4] = "m16";FLOOR[17][3][4] = "";FLOOR[17][4][4] = "wall";FLOOR[17][5][4] = "";FLOOR[17][6][4] = "wall";FLOOR[17][7][4] = "";FLOOR[17][8][4] = "";FLOOR[17][9][4] = "";FLOOR[17][10][4] = "wall";
        FLOOR[17][0][5] = "dy";FLOOR[17][1][5] = "wall";FLOOR[17][2][5] = "wall";FLOOR[17][3][5] = "dy";FLOOR[17][4][5] = "wall";FLOOR[17][5][5] = "m17";FLOOR[17][6][5] = "wall";FLOOR[17][7][5] = "wall";FLOOR[17][8][5] = "de1";FLOOR[17][9][5] = "wall";FLOOR[17][10][5] = "wall";
        FLOOR[17][0][6] = "m18";FLOOR[17][1][6] = "wall";FLOOR[17][2][6] = "";FLOOR[17][3][6] = "m18";FLOOR[17][4][6] = "wall";FLOOR[17][5][6] = "m8";FLOOR[17][6][6] = "wall";FLOOR[17][7][6] = "m15";FLOOR[17][8][6] = "";FLOOR[17][9][6] = "m15";FLOOR[17][10][6] = "wall";
        FLOOR[17][0][7] = "";FLOOR[17][1][7] = "wall";FLOOR[17][2][7] = "rhp";FLOOR[17][3][7] = "";FLOOR[17][4][7] = "wall";FLOOR[17][5][7] = "m17";FLOOR[17][6][7] = "wall";FLOOR[17][7][7] = "";FLOOR[17][8][7] = "m17";FLOOR[17][9][7] = "";FLOOR[17][10][7] = "wall";
        FLOOR[17][0][8] = "rhp";FLOOR[17][1][8] = "wall";FLOOR[17][2][8] = "m16";FLOOR[17][3][8] = "";FLOOR[17][4][8] = "wall";FLOOR[17][5][8] = "";FLOOR[17][6][8] = "wall";FLOOR[17][7][8] = "rhp";FLOOR[17][8][8] = "";FLOOR[17][9][8] = "rhp";FLOOR[17][10][8] = "wall";
        FLOOR[17][0][9] = "wall";FLOOR[17][1][9] = "wall";FLOOR[17][2][9] = "dy";FLOOR[17][3][9] = "wall";FLOOR[17][4][9] = "wall";FLOOR[17][5][9] = "";FLOOR[17][6][9] = "wall";FLOOR[17][7][9] = "wall";FLOOR[17][8][9] = "dy";FLOOR[17][9][9] = "wall";FLOOR[17][10][9] = "wall";
        FLOOR[17][0][10] = "up";FLOOR[17][1][10] = "";FLOOR[17][2][10] = "";FLOOR[17][3][10] = "";FLOOR[17][4][10] = "";FLOOR[17][5][10] = "";FLOOR[17][6][10] = "";FLOOR[17][7][10] = "";FLOOR[17][8][10] = "";FLOOR[17][9][10] = "";FLOOR[17][10][10] = "down";
        FLOOR[17][0][11] = "1";FLOOR[17][1][11] = "10";FLOOR[17][2][11] = "9";FLOOR[17][3][11] = "10";FLOOR[17][4][11] = "18";FLOOR[17][5][11] = "17";FLOOR[17][6][11] = "16";FLOOR[17][7][11] = "";FLOOR[17][8][11] = "";FLOOR[17][9][11] = "";FLOOR[17][10][11] = "";
        FLOOR[17][0][12] = "7";FLOOR[17][1][12] = "6";FLOOR[17][2][12] = "9";FLOOR[17][3][12] = "6";FLOOR[17][4][12] = "7";FLOOR[17][5][12] = "3";FLOOR[17][6][12] = "9";FLOOR[17][7][12] = "3";FLOOR[17][8][12] = "";FLOOR[17][9][12] = "";FLOOR[17][10][12] = "";
        FLOOR[17][0][13] = "";FLOOR[17][1][13] = "";FLOOR[17][2][13] = "";FLOOR[17][3][13] = "";FLOOR[17][4][13] = "8";FLOOR[17][5][13] = "5";FLOOR[17][6][13] = "8";FLOOR[17][7][13] = "2";FLOOR[17][8][13] = "";FLOOR[17][9][13] = "";FLOOR[17][10][13] = "";

        FLOOR[18][0][0] = "wall";FLOOR[18][1][0] = "wall";FLOOR[18][2][0] = "wall";FLOOR[18][3][0] = "wall";FLOOR[18][4][0] = "wall";FLOOR[18][5][0] = "wall";FLOOR[18][6][0] = "wall";FLOOR[18][7][0] = "up";FLOOR[18][8][0] = "";FLOOR[18][9][0] = "";FLOOR[18][10][0] = "down";
        FLOOR[18][0][1] = "wall";FLOOR[18][1][1] = "";FLOOR[18][2][1] = "";FLOOR[18][3][1] = "";FLOOR[18][4][1] = "";FLOOR[18][5][1] = "";FLOOR[18][6][1] = "wall";FLOOR[18][7][1] = "wall";FLOOR[18][8][1] = "wall";FLOOR[18][9][1] = "dy";FLOOR[18][10][1] = "wall";
        FLOOR[18][0][2] = "wall";FLOOR[18][1][2] = "";FLOOR[18][2][2] = "";FLOOR[18][3][2] = "wall";FLOOR[18][4][2] = "";FLOOR[18][5][2] = "";FLOOR[18][6][2] = "wall";FLOOR[18][7][2] = "";FLOOR[18][8][2] = "rhp";FLOOR[18][9][2] = "m17";FLOOR[18][10][2] = "def";
        FLOOR[18][0][3] = "wall";FLOOR[18][1][3] = "";FLOOR[18][2][3] = "wall";FLOOR[18][3][3] = "szjWALL";FLOOR[18][4][3] = "wall";FLOOR[18][5][3] = "";FLOOR[18][6][3] = "wall";FLOOR[18][7][3] = "m17";FLOOR[18][8][3] = "wall";FLOOR[18][9][3] = "wall";FLOOR[18][10][3] = "wall";
        FLOOR[18][0][4] = "wall";FLOOR[18][1][4] = "";FLOOR[18][2][4] = "";FLOOR[18][3][4] = "wallE";FLOOR[18][4][4] = "";FLOOR[18][5][4] = "";FLOOR[18][6][4] = "wall";FLOOR[18][7][4] = "";FLOOR[18][8][4] = "ky";FLOOR[18][9][4] = "ky";FLOOR[18][10][4] = "";
        FLOOR[18][0][5] = "wall";FLOOR[18][1][5] = "";FLOOR[18][2][5] = "";FLOOR[18][3][5] = "wall";FLOOR[18][4][5] = "";FLOOR[18][5][5] = "";FLOOR[18][6][5] = "wall";FLOOR[18][7][5] = "wall";FLOOR[18][8][5] = "wall";FLOOR[18][9][5] = "wall";FLOOR[18][10][5] = "m16";
        FLOOR[18][0][6] = "wall";FLOOR[18][1][6] = "";FLOOR[18][2][6] = "";FLOOR[18][3][6] = "";FLOOR[18][4][6] = "";FLOOR[18][5][6] = "";FLOOR[18][6][6] = "wall";FLOOR[18][7][6] = "bhp";FLOOR[18][8][6] = "ky";FLOOR[18][9][6] = "m18";FLOOR[18][10][6] = "m8";
        FLOOR[18][0][7] = "wall";FLOOR[18][1][7] = "wall";FLOOR[18][2][7] = "wall";FLOOR[18][3][7] = "dr";FLOOR[18][4][7] = "wall";FLOOR[18][5][7] = "wall";FLOOR[18][6][7] = "wall";FLOOR[18][7][7] = "wall";FLOOR[18][8][7] = "wall";FLOOR[18][9][7] = "wall";FLOOR[18][10][7] = "m16";
        FLOOR[18][0][8] = "firewall";FLOOR[18][1][8] = "firewall";FLOOR[18][2][8] = "wall";FLOOR[18][3][8] = "";FLOOR[18][4][8] = "wall";FLOOR[18][5][8] = "firewall";FLOOR[18][6][8] = "firewall";FLOOR[18][7][8] = "wall";FLOOR[18][8][8] = "m8";FLOOR[18][9][8] = "ad";FLOOR[18][10][8] = "m8";
        FLOOR[18][0][9] = "firewall";FLOOR[18][1][9] = "firewall";FLOOR[18][2][9] = "wall";FLOOR[18][3][9] = "";FLOOR[18][4][9] = "wall";FLOOR[18][5][9] = "wall";FLOOR[18][6][9] = "wall";FLOOR[18][7][9] = "wall";FLOOR[18][8][9] = "dy";FLOOR[18][9][9] = "wall";FLOOR[18][10][9] = "wall";
        FLOOR[18][0][10] = "firewall";FLOOR[18][1][10] = "firewall";FLOOR[18][2][10] = "wall";FLOOR[18][3][10] = "";FLOOR[18][4][10] = "m19";FLOOR[18][5][10] = "m17";FLOOR[18][6][10] = "";FLOOR[18][7][10] = "";FLOOR[18][8][10] = "";FLOOR[18][9][10] = "wallE";FLOOR[18][10][10] = "kr";
        FLOOR[18][0][11] = "8";FLOOR[18][1][11] = "0";FLOOR[18][2][11] = "9";FLOOR[18][3][11] = "0";FLOOR[18][4][11] = "19";FLOOR[18][5][11] = "18";FLOOR[18][6][11] = "17";FLOOR[18][7][11] = "";FLOOR[18][8][11] = "";FLOOR[18][9][11] = "";FLOOR[18][10][11] = "";
        FLOOR[18][0][12] = "";FLOOR[18][1][12] = "";FLOOR[18][2][12] = "";FLOOR[18][3][12] = "";FLOOR[18][4][12] = "";FLOOR[18][5][12] = "";FLOOR[18][6][12] = "";FLOOR[18][7][12] = "";FLOOR[18][8][12] = "";FLOOR[18][9][12] = "";FLOOR[18][10][12] = "";
        FLOOR[18][0][13] = "";FLOOR[18][1][13] = "";FLOOR[18][2][13] = "";FLOOR[18][3][13] = "";FLOOR[18][4][13] = "";FLOOR[18][5][13] = "";FLOOR[18][6][13] = "";FLOOR[18][7][13] = "";FLOOR[18][8][13] = "";FLOOR[18][9][13] = "";FLOOR[18][10][13] = "";

        FLOOR[19][0][0] = "up";FLOOR[19][1][0] = "wall";FLOOR[19][2][0] = "wall";FLOOR[19][3][0] = "wall";FLOOR[19][4][0] = "m19";FLOOR[19][5][0] = "";FLOOR[19][6][0] = "rhp";FLOOR[19][7][0] = "wall";FLOOR[19][8][0] = "";FLOOR[19][9][0] = "";FLOOR[19][10][0] = "m17";
        FLOOR[19][0][1] = "";FLOOR[19][1][1] = "wall";FLOOR[19][2][1] = "ky";FLOOR[19][3][1] = "dy";FLOOR[19][4][1] = "";FLOOR[19][5][1] = "wall";FLOOR[19][6][1] = "";FLOOR[19][7][1] = "dy";FLOOR[19][8][1] = "";FLOOR[19][9][1] = "wall";FLOOR[19][10][1] = "kb";
        FLOOR[19][0][2] = "";FLOOR[19][1][2] = "npc";FLOOR[19][2][2] = "";FLOOR[19][3][2] = "wall";FLOOR[19][4][2] = "";FLOOR[19][5][2] = "";FLOOR[19][6][2] = "m19";FLOOR[19][7][2] = "wall";FLOOR[19][8][2] = "m17";FLOOR[19][9][2] = "";FLOOR[19][10][2] = "";
        FLOOR[19][0][3] = "wall";FLOOR[19][1][3] = "wallE";FLOOR[19][2][3] = "wall";FLOOR[19][3][3] = "wall";FLOOR[19][4][3] = "wall";FLOOR[19][5][3] = "wallE";FLOOR[19][6][3] = "wall";FLOOR[19][7][3] = "wall";FLOOR[19][8][3] = "wall";FLOOR[19][9][3] = "dy";FLOOR[19][10][3] = "wall";
        FLOOR[19][0][4] = "m19";FLOOR[19][1][4] = "def";FLOOR[19][2][4] = "";FLOOR[19][3][4] = "wall";FLOOR[19][4][4] = "";FLOOR[19][5][4] = "";FLOOR[19][6][4] = "m17";FLOOR[19][7][4] = "wall";FLOOR[19][8][4] = "m19";FLOOR[19][9][4] = "";FLOOR[19][10][4] = "";
        FLOOR[19][0][5] = "";FLOOR[19][1][5] = "wall";FLOOR[19][2][5] = "";FLOOR[19][3][5] = "dy";FLOOR[19][4][5] = "";FLOOR[19][5][5] = "wall";FLOOR[19][6][5] = "";FLOOR[19][7][5] = "dy";FLOOR[19][8][5] = "";FLOOR[19][9][5] = "wall";FLOOR[19][10][5] = "";
        FLOOR[19][0][6] = "";FLOOR[19][1][6] = "";FLOOR[19][2][6] = "m19";FLOOR[19][3][6] = "wall";FLOOR[19][4][6] = "m17";FLOOR[19][5][6] = "ad";FLOOR[19][6][6] = "";FLOOR[19][7][6] = "wall";FLOOR[19][8][6] = "";FLOOR[19][9][6] = "bhp";FLOOR[19][10][6] = "m19";
        FLOOR[19][0][7] = "wall";FLOOR[19][1][7] = "dy";FLOOR[19][2][7] = "wall";FLOOR[19][3][7] = "wall";FLOOR[19][4][7] = "wall";FLOOR[19][5][7] = "wallE";FLOOR[19][6][7] = "wall";FLOOR[19][7][7] = "wall";FLOOR[19][8][7] = "wall";FLOOR[19][9][7] = "wallE";FLOOR[19][10][7] = "wall";
        FLOOR[19][0][8] = "";FLOOR[19][1][8] = "";FLOOR[19][2][8] = "m17";FLOOR[19][3][8] = "wall";FLOOR[19][4][8] = "m19";FLOOR[19][5][8] = "ky";FLOOR[19][6][8] = "";FLOOR[19][7][8] = "wall";FLOOR[19][8][8] = "";FLOOR[19][9][8] = "npc";FLOOR[19][10][8] = "";
        FLOOR[19][0][9] = "rhp";FLOOR[19][1][9] = "wall";FLOOR[19][2][9] = "";FLOOR[19][3][9] = "dy";FLOOR[19][4][9] = "";FLOOR[19][5][9] = "wall";FLOOR[19][6][9] = "";FLOOR[19][7][9] = "dy";FLOOR[19][8][9] = "ky";FLOOR[19][9][9] = "wall";FLOOR[19][10][9] = "";
        FLOOR[19][0][10] = "m17";FLOOR[19][1][10] = "";FLOOR[19][2][10] = "";FLOOR[19][3][10] = "wall";FLOOR[19][4][10] = "";FLOOR[19][5][10] = "";FLOOR[19][6][10] = "m19";FLOOR[19][7][10] = "wall";FLOOR[19][8][10] = "wall";FLOOR[19][9][10] = "wall";FLOOR[19][10][10] = "down";
        FLOOR[19][0][11] = "0";FLOOR[19][1][11] = "1";FLOOR[19][2][11] = "10";FLOOR[19][3][11] = "9";FLOOR[19][4][11] = "20";FLOOR[19][5][11] = "19";FLOOR[19][6][11] = "18";FLOOR[19][7][11] = "5";FLOOR[19][8][11] = "蔡大爷";FLOOR[19][9][11] = "这一层构造实际上是完全对称的。";FLOOR[19][10][11] = "";
        FLOOR[19][0][12] = "";FLOOR[19][1][12] = "";FLOOR[19][2][12] = "";FLOOR[19][3][12] = "";FLOOR[19][4][12] = "";FLOOR[19][5][12] = "";FLOOR[19][6][12] = "";FLOOR[19][7][12] = "";FLOOR[19][8][12] = "";FLOOR[19][9][12] = "";FLOOR[19][10][12] = "";
        FLOOR[19][0][13] = "";FLOOR[19][1][13] = "";FLOOR[19][2][13] = "";FLOOR[19][3][13] = "";FLOOR[19][4][13] = "";FLOOR[19][5][13] = "";FLOOR[19][6][13] = "";FLOOR[19][7][13] = "";FLOOR[19][8][13] = "";FLOOR[19][9][13] = "";FLOOR[19][10][13] = "";

        FLOOR[20][0][0] = "firewall";FLOOR[20][1][0] = "firewall";FLOOR[20][2][0] = "firewall";FLOOR[20][3][0] = "firewall";FLOOR[20][4][0] = "wall";FLOOR[20][5][0] = "girl";FLOOR[20][6][0] = "wall";FLOOR[20][7][0] = "firewall";FLOOR[20][8][0] = "firewall";FLOOR[20][9][0] = "firewall";FLOOR[20][10][0] = "firewall";
        FLOOR[20][0][1] = "firewall";FLOOR[20][1][1] = "firewall";FLOOR[20][2][1] = "firewall";FLOOR[20][3][1] = "firewall";FLOOR[20][4][1] = "wall";FLOOR[20][5][1] = "dz";FLOOR[20][6][1] = "wall";FLOOR[20][7][1] = "firewall";FLOOR[20][8][1] = "firewall";FLOOR[20][9][1] = "firewall";FLOOR[20][10][1] = "firewall";
        FLOOR[20][0][2] = "wall";FLOOR[20][1][2] = "wall";FLOOR[20][2][2] = "wall";FLOOR[20][3][2] = "wall";FLOOR[20][4][2] = "wall";FLOOR[20][5][2] = "";FLOOR[20][6][2] = "wall";FLOOR[20][7][2] = "wall";FLOOR[20][8][2] = "wall";FLOOR[20][9][2] = "wall";FLOOR[20][10][2] = "wall";
        FLOOR[20][0][3] = "";FLOOR[20][1][3] = "";FLOOR[20][2][3] = "";FLOOR[20][3][3] = "";FLOOR[20][4][3] = "";FLOOR[20][5][3] = "";FLOOR[20][6][3] = "";FLOOR[20][7][3] = "";FLOOR[20][8][3] = "";FLOOR[20][9][3] = "";FLOOR[20][10][3] = "";
        FLOOR[20][0][4] = "";FLOOR[20][1][4] = "";FLOOR[20][2][4] = "";FLOOR[20][3][4] = "";FLOOR[20][4][4] = "";FLOOR[20][5][4] = "";FLOOR[20][6][4] = "";FLOOR[20][7][4] = "";FLOOR[20][8][4] = "";FLOOR[20][9][4] = "";FLOOR[20][10][4] = "";
        FLOOR[20][0][5] = "";FLOOR[20][1][5] = "";FLOOR[20][2][5] = "";FLOOR[20][3][5] = "";FLOOR[20][4][5] = "";FLOOR[20][5][5] = "m3";FLOOR[20][6][5] = "";FLOOR[20][7][5] = "";FLOOR[20][8][5] = "";FLOOR[20][9][5] = "";FLOOR[20][10][5] = "";
        FLOOR[20][0][6] = "";FLOOR[20][1][6] = "";FLOOR[20][2][6] = "";FLOOR[20][3][6] = "";FLOOR[20][4][6] = "";FLOOR[20][5][6] = "";FLOOR[20][6][6] = "";FLOOR[20][7][6] = "";FLOOR[20][8][6] = "";FLOOR[20][9][6] = "";FLOOR[20][10][6] = "";
        FLOOR[20][0][7] = "";FLOOR[20][1][7] = "";FLOOR[20][2][7] = "";FLOOR[20][3][7] = "";FLOOR[20][4][7] = "";FLOOR[20][5][7] = "spE3";FLOOR[20][6][7] = "";FLOOR[20][7][7] = "";FLOOR[20][8][7] = "";FLOOR[20][9][7] = "";FLOOR[20][10][7] = "";
        FLOOR[20][0][8] = "wall";FLOOR[20][1][8] = "wall";FLOOR[20][2][8] = "wall";FLOOR[20][3][8] = "wall";FLOOR[20][4][8] = "wall";FLOOR[20][5][8] = "spE2";FLOOR[20][6][8] = "wall";FLOOR[20][7][8] = "wall";FLOOR[20][8][8] = "wall";FLOOR[20][9][8] = "wall";FLOOR[20][10][8] = "wall";
        FLOOR[20][0][9] = "firewall";FLOOR[20][1][9] = "firewall";FLOOR[20][2][9] = "firewall";FLOOR[20][3][9] = "firewall";FLOOR[20][4][9] = "wall";FLOOR[20][5][9] = "";FLOOR[20][6][9] = "wall";FLOOR[20][7][9] = "firewall";FLOOR[20][8][9] = "firewall";FLOOR[20][9][9] = "firewall";FLOOR[20][10][9] = "firewall";
        FLOOR[20][0][10] = "firewall";FLOOR[20][1][10] = "firewall";FLOOR[20][2][10] = "firewall";FLOOR[20][3][10] = "firewall";FLOOR[20][4][10] = "wall";FLOOR[20][5][10] = "down";FLOOR[20][6][10] = "wall";FLOOR[20][7][10] = "firewall";FLOOR[20][8][10] = "firewall";FLOOR[20][9][10] = "firewall";FLOOR[20][10][10] = "firewall";
        FLOOR[20][0][11] = "5";FLOOR[20][1][11] = "1";FLOOR[20][2][11] = "5";FLOOR[20][3][11] = "9";FLOOR[20][4][11] = "21";FLOOR[20][5][11] = "20";FLOOR[20][6][11] = "19";FLOOR[20][7][11] = "";FLOOR[20][8][11] = "";FLOOR[20][9][11] = "";FLOOR[20][10][11] = "";
        FLOOR[20][0][12] = "";FLOOR[20][1][12] = "";FLOOR[20][2][12] = "";FLOOR[20][3][12] = "";FLOOR[20][4][12] = "";FLOOR[20][5][12] = "";FLOOR[20][6][12] = "";FLOOR[20][7][12] = "";FLOOR[20][8][12] = "";FLOOR[20][9][12] = "";FLOOR[20][10][12] = "";
        FLOOR[20][0][13] = "5";FLOOR[20][1][13] = "5";FLOOR[20][2][13] = "0";FLOOR[20][3][13] = "3";FLOOR[20][4][13] = "";FLOOR[20][5][13] = "";FLOOR[20][6][13] = "";FLOOR[20][7][13] = "";FLOOR[20][8][13] = "";FLOOR[20][9][13] = "";FLOOR[20][10][13] = "";



    }


    String[][] getFloorEvent(int floorNumber){return FLOOR[floorNumber];}
    public void setEvent(int floor,int x,int y,String event){FLOOR[floor][x][y] = event;}
}

