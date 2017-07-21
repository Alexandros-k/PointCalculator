package com.example.alex.pointcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private int baseStr=8 ;
    private int baseDex = 8;
    private int baseCon = 8;
    private int baseInt = 8;
    private int baseWis = 8;
    private int baseCha = 8;

    int cost ;

    int points =27;

    int counterS;
    int counterD;
    int counterC;
    int counterI;
    int counterW;
    int counterCh;

    int sStr;
    int sDex;
    int sCon;
    int sInte;
    int sWis;
    int sCha;

    int str;
    int dex;
    int con;
    int inte;
    int wis;
    int cha;

    int modS=-1;
    int modD=-1;
    int modC=-1;
    int modI=-1;
    int modW=-1;
    int modCh=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            int sStr  = savedInstanceState.getInt("STRENGTH",0);
            int sDex  = savedInstanceState.getInt("DEXTERITY",0);
            int sCon  = savedInstanceState.getInt("CONSTITUTION",0);
            int sInt  = savedInstanceState.getInt("INTELLIGENCE",0);
            int sWis  = savedInstanceState.getInt("WISDOM",0);
            int sCha  = savedInstanceState.getInt("CHARISMA",0);
            int sPoints  = savedInstanceState.getInt("POINTS",0);

            int sModif  = savedInstanceState.getInt("MODIFIERS",0);
            int dModif  = savedInstanceState.getInt("MODIFIERD",0);
            int cModif  = savedInstanceState.getInt("MODIFIERC",0);
            int iModif  = savedInstanceState.getInt("MODIFIERI",0);
            int wModif  = savedInstanceState.getInt("MODIFIERW",0);
            int chModif  = savedInstanceState.getInt("MODIFIERCH",0);

            int sCounter  = savedInstanceState.getInt("COUNTERS",0);
            int dCounter  = savedInstanceState.getInt("COUNTERD",0);
            int cCounter  = savedInstanceState.getInt("COUNTERC",0);
            int iCounter  = savedInstanceState.getInt("COUNTERI",0);
            int wCounter  = savedInstanceState.getInt("COUNTERW",0);
            int chCounter  = savedInstanceState.getInt("COUNTERCH",0);
            counterS=sCounter;
            counterD=dCounter;
            counterC=cCounter;
            counterI=iCounter;
            counterW=wCounter;
            counterCh=chCounter;


           TextView str1 = (TextView) findViewById(R.id.et1);
            str1.setText(String.valueOf(sStr));
            int str = Integer.parseInt(str1.getText().toString());
            baseStr=str;

            TextView dex1 = (TextView) findViewById(R.id.et2);
            dex1.setText(String.valueOf(sDex));
            int dex = Integer.parseInt(dex1.getText().toString());
            baseDex=dex;

            TextView con1 = (TextView) findViewById(R.id.et3);
            con1.setText(String.valueOf(sCon));
            int con = Integer.parseInt(con1.getText().toString());
            baseCon=con;

            TextView int1 = (TextView) findViewById(R.id.et4);
            int1.setText(String.valueOf(sInt));
            int inte = Integer.parseInt(int1.getText().toString());
            baseInt=inte;

            TextView wis1 = (TextView) findViewById(R.id.et5);
            wis1.setText(String.valueOf(sWis));
            int wis = Integer.parseInt(wis1.getText().toString());
            baseWis=wis;

            TextView cha1 = (TextView) findViewById(R.id.et6);
            cha1.setText(String.valueOf(sCha));
            int cha = Integer.parseInt(cha1.getText().toString());
            baseCha=cha;


            TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);
            totalPoints.setText(String.valueOf(sPoints));
            int nPoints = Integer.parseInt(totalPoints.getText().toString());
              points=nPoints;

            TextView strMod = (TextView) findViewById(R.id.strId);
            strMod.setText(String.valueOf(sModif));
            int nsMod = Integer.parseInt(strMod.getText().toString());
             modS=nsMod;

            TextView dexMod = (TextView) findViewById(R.id.dexId);
            dexMod.setText(String.valueOf(dModif));
            int ndMod = Integer.parseInt(dexMod.getText().toString());
            modD=ndMod;

            TextView conMod = (TextView) findViewById(R.id.conId);
            conMod.setText(String.valueOf(cModif));
            int ncMod = Integer.parseInt(conMod.getText().toString());
            modC=ncMod;

            TextView intMod = (TextView) findViewById(R.id.intId);
            intMod.setText(String.valueOf(iModif));
            int niMod = Integer.parseInt(intMod.getText().toString());
            modI=niMod;

            TextView wisMod = (TextView) findViewById(R.id.wisId);
            wisMod.setText(String.valueOf(wModif));
            int nwMod = Integer.parseInt(wisMod.getText().toString());
            modW=nwMod;

            TextView chaMod = (TextView) findViewById(R.id.chaId);
            chaMod.setText(String.valueOf(chModif));
            int nchMod = Integer.parseInt(chaMod.getText().toString());
            modCh=nchMod;

            System.out.println(String.format("Start+Wis:%s+points:%s+counter:%s+cost:%s",wis,points,counterS,cost));

        }

        System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s +strMod:%s ",
                str,points,counterS,cost,modS));


        Button b13 = (Button) findViewById(R.id.resetId);
        b13.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       reset();
                                   }
                               }
        );






        ImageButton b1 = (ImageButton) findViewById(R.id.upId);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {if (counterS <9 && points>0) {levelUpStrength();

                                          System.out.println("count" + counterS);
                                      }
                                  }
                              }
        );
        System.out.println(String.format("Str1:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));


        ImageButton b2 = (ImageButton) findViewById(R.id.downId);
        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      System.out.println(String.format("Str2:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                                      if (counterS > 0) {

                                          levelDownStrength();
                                          System.out.println(String.format("Str3:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                                      }
                                  }
                              }
        );

        ImageButton b3 = (ImageButton) findViewById(R.id.upButton2);
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if (counterD <9&& points>0) {
                                          levelUpDexterity();
                                      }
                                  }
                              }
        );


        ImageButton b4 = (ImageButton) findViewById(R.id.downButton2);
        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if (counterD> 0) {
                                          levelDownDexterity();
                                      }
                                      }
                              }
        );


        ImageButton b5 = (ImageButton) findViewById(R.id.upButton3);
        b5.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {if (counterC < 9 && points>0) {levelUpConstitution();}}
                              }
        );


        ImageButton b6 = (ImageButton) findViewById(R.id.downButton3);
        b6.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {if (counterC > 0&& points>0) {levelDownConstitution();}
                                  }
                              }
        );


        ImageButton b7 = (ImageButton) findViewById(R.id.upButton4);
        b7.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                     if(counterI < 9 && points>0) {levelUpInteligence();}
                                  }
                              }
        );


        ImageButton b8 = (ImageButton) findViewById(R.id.downButton4);
        b8.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if(counterI > 0&& points>0){levelDownInteligence();}
                                  }
                              }
        );

        ImageButton b9 = (ImageButton) findViewById(R.id.upButton5);
        b9.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      if(counterW < 9 && points>0) {
                                          levelUpWisdom();
                                      }
                                  }
                              }
        );


        ImageButton b10 = (ImageButton) findViewById(R.id.downButton5);
        b10.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       if(counterW > 0){levelDownWisdom();}
                                   }
                               }
        );


        ImageButton b11 = (ImageButton) findViewById(R.id.upButton6);
        b11.setOnClickListener( new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {


                                           if (counterCh < 9 && points>0) {
                                               levelUpDCharisma();
                                           }

                                   }
                               }
        );


        ImageButton b12 = (ImageButton) findViewById(R.id.downButton6);
        b12.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                           if (counterCh >0) {
                                               levelDownCharisma();
                                           }

                                   }
                               }
        );

    }





    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putInt("STRENGTH",baseStr);
        outState.putInt("DEXTERITY",baseDex);
        outState.putInt("CONSTITUTION",baseCon);
        outState.putInt("INTELLIGENCE",baseInt);
        outState.putInt("WISDOM",baseWis);
        outState.putInt("CHARISMA",baseCha);
        outState.putInt("POINTS",points);
        outState.putInt("MODIFIERS",modS);
        outState.putInt("MODIFIERD",modD);
        outState.putInt("MODIFIERC",modC);
        outState.putInt("MODIFIERI",modI);
        outState.putInt("MODIFIERW",modW);
        outState.putInt("MODIFIERCH",modCh);
        outState.putInt("COUNTERS",counterS);
        outState.putInt("COUNTERD",counterD);
        outState.putInt("COUNTERC",counterC);
        outState.putInt("COUNTERI",counterI);
        outState.putInt("COUNTERW",counterW);
        outState.putInt("COUNTERCH",counterCh);


    }

    public void levelUpStrength() {
       TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


       if (baseStr < 15) {
           baseStr++;

       }



       TextView strMod = (TextView) findViewById(R.id.strId);
        TextView str1 = (TextView) findViewById(R.id.et1);
        str1.setText(String.valueOf(baseStr));
        int str = Integer.parseInt(str1.getText().toString());


       totalPoints.setText(String.valueOf(points));
       int tp = Integer.parseInt(totalPoints.getText().toString());
       System.out.println(String.format("StartStr:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));


       switch (str) {

                case 8:
                    modS=-1;

                    strMod.setText(String.valueOf(modS));

                    cost=0;
                    counterS=0;
                    points = points - cost;
                    System.out.println(String.format("8Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    totalPoints.setText(String.valueOf(points));

                    break;
                case 9:
                    modS=-1;
                    strMod.setText(String.valueOf(modS));
                    cost=1;
                   points = points - cost;
                    counterS=1;

                   totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));


                    break;
                case 10:
                    modS=0;
                    strMod.setText(String.valueOf(modS));
                    cost=1;
                    points = points - cost;
                    counterS=2;
                   totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;
                case 11:
                    modS=0;
                    strMod.setText(String.valueOf(modS));
                    cost=1;
                   points = points - cost;
                    counterS=3;
                   totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s+modif:%s",str,points,counterS,cost,modS));

                    break;
                case 12:
                    modS=1;
                    strMod.setText(String.valueOf(modS));
                    cost=1;
                   points = points - cost;
                    counterS=4;
                   totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;
                case 13:
                    modS=1;
                    strMod.setText(String.valueOf(modS));
                    cost=1;
                    points = points - cost;
                    counterS=5;
                   totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;
                case 14:
                    modS=2;
                        strMod.setText(String.valueOf(modS));
                        cost = 2;
                       points = points - cost;
                    counterS=7;
                       totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;

                case 15:
                    modS=2;
                    strMod.setText(String.valueOf(modS));

                        cost = 2;
                        points = points - 2;

                    counterS=9;
                    totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;

            }



        }

    public void levelDownStrength() {

            TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


            final TextView strMod = (TextView) findViewById(R.id.strId);

            TextView str1 = (TextView) findViewById(R.id.et1);
            str1.setText(String.valueOf(baseStr));
            int str = Integer.parseInt(str1.getText().toString());


            System.out.println(String.format("StartStr:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));


            switch (str) {

                case 8:
                    modS=-1;
                        cost = 0;
                    strMod.setText(String.valueOf(modS));
                    points = points + cost;
                    counterS=0;
                    totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));

                    break;


                case 9:
                    modS=-1;
                    strMod.setText(String.valueOf(modS));
                    cost = 1;
                    points = points + cost;
                    counterS=1;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(8));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;

                case 10:
                    modS=-1;
                    strMod.setText(String.valueOf(modS));
                    cost = 1;
                    points = points + cost;
                    counterS=2;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(9));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;

                case 11:
                    modS=0;
                    strMod.setText(String.valueOf(modS));
                    cost = 1;
                    points = points + cost;
                    counterS=3;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(10));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;
                case 12:
                    modS=0;
                    strMod.setText(String.valueOf(modS));
                    cost = 1;
                    points = points + cost;
                    counterS=4;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(11));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;
                case 13:
                    modS=1;
                    strMod.setText(String.valueOf(modS));
                    cost = 1;
                    points = points + cost;
                    counterS=5;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(12));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;
                case 14:
                    modS=1;
                    strMod.setText(String.valueOf(modS));
                    cost = 2;
                    points = points + cost;
                    counterS=7;
                    totalPoints.setText(String.valueOf(points));
                    str1.setText(String.valueOf(13));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;
                case 15:
                    modS=2;
                    strMod.setText(String.valueOf(modS));
                    cost = 2;
                    points = points + cost;
                    counterS=7;
                    str1.setText(String.valueOf(14));


                    totalPoints.setText(String.valueOf(points));
                    System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",str,points,counterS,cost));
                    break;


            }
        if (baseStr > 8) {baseStr--;}

       /* int tp1 = Integer.parseInt(totalPoints.getText().toString());
        points=tp1;*/
    }

    public  void levelUpDexterity(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


        if (baseDex < 15) {
            baseDex++;

        }



        TextView dexMod = (TextView) findViewById(R.id.dexId);
        TextView dex1 = (TextView) findViewById(R.id.et2);
        dex1.setText(String.valueOf(baseDex));
        int dex = Integer.parseInt(dex1.getText().toString());


        totalPoints.setText(String.valueOf(points));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));


        switch (dex) {

            case 8:
                modD=-1;
                dexMod.setText(String.valueOf(modD));

                cost=0;
                counterD=0;
                points = points - cost;
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                totalPoints.setText(String.valueOf(points));

                break;
            case 9:
                modD=-1;
                dexMod.setText(String.valueOf(modD));
                cost=1;
                points = points - cost;
                counterD=1;

                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));


                break;
            case 10:
                modD=0;
                dexMod.setText(String.valueOf(modD));
                cost=1;
                points = points - cost;
                counterD=2;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;
            case 11:
                modD=0;
                dexMod.setText(String.valueOf(modD));
                cost=1;
                points = points - cost;
                counterD=3;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;
            case 12:
                modD=1;
                dexMod.setText(String.valueOf(modD));
                cost=1;
                points = points - cost;
                counterD=4;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;
            case 13:
                modD=1;
                dexMod.setText(String.valueOf(modD));
                cost=1;
                points = points - cost;
                counterD=5;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;
            case 14:
                modD=2;
                dexMod.setText(String.valueOf(modD));
                cost = 2;
                points = points - cost;
                counterD=7;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;

            case 15:
                modD=2;
                dexMod.setText(String.valueOf(modD));

                cost = 2;
                points = points - 2;

                counterD=9;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;

        }



     /*  if(points>0 && points<27) {
                totalPoints.setText(String.valueOf(points));
                int tp1 = Integer.parseInt(totalPoints.getText().toString());

                points = tp1;
            }*/





        /*int tp1 = Integer.parseInt(totalPoints.getText().toString());
        points=tp1;

        System.out.println("dex"+points);*/
    }

    public  void levelDownDexterity(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);
        System.out.println("Startpoints"+points);


        final TextView dexMod = (TextView) findViewById(R.id.dexId);

        TextView dex1 = (TextView) findViewById(R.id.et2);
        dex1.setText(String.valueOf(baseDex));
        int dex = Integer.parseInt(dex1.getText().toString());


        System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));


        switch (dex) {

            case 8:
                modD=-1;
                cost = 0;
                dexMod.setText(String.valueOf(modD));
                points = points + cost;
                counterD=0;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));

                break;


            case 9:
                modD=-1;
                dexMod.setText(String.valueOf(modD));
                cost = 1;
                points = points + cost;
                counterD=1;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(8));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 10:
                modD=-1;
                dexMod.setText(String.valueOf(modD));
                cost = 1;
                points = points + cost;
                counterD=2;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(9));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 11:
                modD=0;
                dexMod.setText(String.valueOf(modD));
                cost = 1;
                points = points + cost;
                counterD=3;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(10));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 12:
                modD=0;
                dexMod.setText(String.valueOf(modD));
                cost = 1;
                points = points + cost;
                counterD=4;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(11));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 13:
                modD=1;
                dexMod.setText(String.valueOf(modD));
                cost = 1;
                points = points + cost;
                counterD=5;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(12));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 14:
                modD=1;
                dexMod.setText(String.valueOf(modD));
                cost = 2;
                points = points + cost;
                counterD=7;
                totalPoints.setText(String.valueOf(points));
                dex1.setText(String.valueOf(13));
                System.out.println(String.format("Start+Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;
            case 15:
                modD=2;
                dexMod.setText(String.valueOf(modD));
                cost = 2;
                points = points + cost;
                counterD=7;
                dex1.setText(String.valueOf(14));


                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Dex:%s+points:%s+counter:%s+cost:%s",dex,points,counterD,cost));
                break;


        }
        if (baseDex > 8) {baseDex--;}

    }

    public  void levelUpConstitution(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


        if (baseCon < 15) {
            baseCon++;

        }



        TextView conMod = (TextView) findViewById(R.id.conId);
        TextView con1 = (TextView) findViewById(R.id.et3);
        con1.setText(String.valueOf(baseCon));
        int con = Integer.parseInt(con1.getText().toString());


        totalPoints.setText(String.valueOf(points));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));


        switch (con) {

            case 8:
                conMod.setText(String.valueOf(modC));
                modC=-1;
                cost=0;
                counterC=0;
                points = points - cost;
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                totalPoints.setText(String.valueOf(points));

                break;
            case 9:
                modC=-1;
                conMod.setText(String.valueOf(modC));
                cost=1;
                points = points - cost;
                counterC=1;

                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));


                break;
            case 10:
                modC=0;
                conMod.setText(String.valueOf(modC));
                cost=1;
                points = points - cost;
                counterC=2;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;
            case 11:
                modC=0;
                conMod.setText(String.valueOf(modC));
                cost=1;
                points = points - cost;
                counterC=3;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;
            case 12:
                modC=1;
                conMod.setText(String.valueOf(modC));
                cost=1;
                points = points - cost;
                counterC=4;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;
            case 13:
                modC=1;
                conMod.setText(String.valueOf(modC));
                cost=1;
                points = points - cost;
                counterC=5;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;
            case 14:
                modC=2;
                conMod.setText(String.valueOf(modC));
                cost = 2;
                points = points - cost;
                counterC=7;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;

            case 15:
                modC=2;
                conMod.setText(String.valueOf(modC));
                if(points>1 && points<27) {
                    cost = 2;
                    points = points - 2;
                }
                counterC=9;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;

        }




    }
    public  void levelDownConstitution(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);
        System.out.println("Startpoints"+points);


        final TextView conMod = (TextView) findViewById(R.id.conId);

        TextView con1 = (TextView) findViewById(R.id.et3);
        con1.setText(String.valueOf(baseCon));
        int con = Integer.parseInt(con1.getText().toString());


        System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));


        switch (con) {

            case 8:
                modC=-1;
                cost = 0;
                conMod.setText(String.valueOf(modC));
                points = points + cost;

                counterC=0;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));

                break;


            case 9:
                modC=-1;
                conMod.setText(String.valueOf(modC));
                cost = 1;
                points = points + cost;
                counterC=1;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(8));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 10:
                modC=-1;
                conMod.setText(String.valueOf(modC));
                cost = 1;
                points = points + cost;
                counterC=2;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(9));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 11:
                modC=0;
                conMod.setText(String.valueOf(modC));
                cost = 1;
                points = points + cost;
                counterC=3;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(10));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 12:
                modC=0;
                conMod.setText(String.valueOf(modC));
                cost = 1;
                points = points + cost;
                counterC=4;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(11));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 13:
                modC=1;
                conMod.setText(String.valueOf(modC));
                cost = 1;
                points = points + cost;
                counterC=5;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(12));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 14:
                modC=1;
                conMod.setText(String.valueOf(modC));
                cost = 2;
                points = points + cost;
                counterC=7;
                totalPoints.setText(String.valueOf(points));
                con1.setText(String.valueOf(13));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;
            case 15:
                modC=2;
                conMod.setText(String.valueOf(modC));
                cost = 2;
                points = points + cost;
                counterC=7;
                con1.setText(String.valueOf(14));


                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Start+Con:%s+points:%s+counter:%s+cost:%s",con,points,counterC,cost));
                break;


        }
        if (baseCon > 8) {baseCon--;}

       /* int tp1 = Integer.parseInt(totalPoints.getText().toString());
        points=tp1;*/
    }


    public  void levelUpInteligence(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


        if (baseInt < 15) {
            baseInt++;

        }



        TextView intMod = (TextView) findViewById(R.id.intId);
        TextView int1 = (TextView) findViewById(R.id.et4);
        int1.setText(String.valueOf(baseInt));
        int inte = Integer.parseInt(int1.getText().toString());


        totalPoints.setText(String.valueOf(points));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));


        switch (inte) {

            case 8:
                modI=-1;
                intMod.setText(String.valueOf(modI));

                cost=0;
                counterI=0;
                points = points - cost;
                System.out.println(String.format("8Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                totalPoints.setText(String.valueOf(points));

                break;
            case 9:
                modI=-1;
                intMod.setText(String.valueOf(modI));
                cost=1;
                points = points - cost;
                counterI=1;

                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));


                break;
            case 10:
                modI=0;
                intMod.setText(String.valueOf(modI));
                cost=1;
                points = points - cost;
                counterI=2;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;
            case 11:
                modI=0;
                intMod.setText(String.valueOf(modI));
                cost=1;
                points = points - cost;
                counterI=3;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;
            case 12:
                modI=1;
                intMod.setText(String.valueOf(modI));
                cost=1;
                points = points - cost;
                counterI=4;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;
            case 13:
                modI=1;
                intMod.setText(String.valueOf(modI));
                cost=1;
                points = points - cost;
                counterI=5;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;
            case 14:
                modI=2;
                intMod.setText(String.valueOf(modI));
                cost = 2;
                points = points - cost;
                counterI=7;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;

            case 15:
                modI=2;
                intMod.setText(String.valueOf(modI));

                cost = 2;
                points = points - 2;

                counterI=9;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));

                break;

        }



    }


    public  void levelDownInteligence(){
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);



        final TextView intMod = (TextView) findViewById(R.id.intId);

        TextView int1 = (TextView) findViewById(R.id.et4);
        int1.setText(String.valueOf(baseInt));
        int inte = Integer.parseInt(int1.getText().toString());


        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterI,cost));


        switch (inte) {

            case 8:
                modI=-1;
                cost = 0;
                intMod.setText(String.valueOf(modI));
                points = points + cost;
                counterI=0;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));

                break;


            case 9:
                intMod.setText(String.valueOf(modI));
                modI=-1;
                cost = 1;
                points = points + cost;
                counterI=1;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(8));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 10:
                modI=-1;
                intMod.setText(String.valueOf(modI));
                cost = 1;
                points = points + cost;
                counterI=2;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(9));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 11:
                modI=0;
                intMod.setText(String.valueOf(modI));
                cost = 1;
                points = points + cost;
                counterI=3;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(10));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 12:
                modI=0;
                intMod.setText(String.valueOf(modI));
                cost = 1;
                points = points + cost;
                counterI=4;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(11));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 13:
                modI=1;
                intMod.setText(String.valueOf(modI));
                cost = 1;
                points = points + cost;
                counterI=5;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(12));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 14:
                modI=1;
                intMod.setText(String.valueOf(modI));
                cost = 2;
                points = points + cost;
                counterI=7;
                totalPoints.setText(String.valueOf(points));
                int1.setText(String.valueOf(13));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;
            case 15:
                modI=2;

                intMod.setText(String.valueOf(modI));
                cost = 2;
                points = points + cost;
                counterI=7;
                int1.setText(String.valueOf(14));


                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",inte,points,counterS,cost));
                break;


        }
        if (baseInt > 8) {baseInt--;}
    }

    public void levelUpWisdom() {
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


        if (baseWis < 15) {
            baseWis++;

        }



        TextView wisMod = (TextView) findViewById(R.id.wisId);
        TextView wis1 = (TextView) findViewById(R.id.et5);
        wis1.setText(String.valueOf(baseWis));
        int wis = Integer.parseInt(wis1.getText().toString());


        totalPoints.setText(String.valueOf(points));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterS,cost));


        switch (wis) {

            case 8:
                modW=-1;
                wisMod.setText(String.valueOf(modW));

                cost=0;
                counterW=0;
                points = points - cost;
                System.out.println(String.format("8Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                totalPoints.setText(String.valueOf(points));

                break;
            case 9:
                modW=-1;
                wisMod.setText(String.valueOf(modW));
                cost=1;
                points = points - cost;
                counterW=1;

                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));


                break;
            case 10:
                modW=0;
                wisMod.setText(String.valueOf(modW));
                cost=1;
                points = points - cost;
                counterW=2;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;
            case 11:
                modW=0;
                wisMod.setText(String.valueOf(modW));
                cost=1;
                points = points - cost;
                counterW=3;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;
            case 12:
                modW=1;
                wisMod.setText(String.valueOf(modW));
                cost=1;
                points = points - cost;
                counterW=4;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;
            case 13:
                modW=1;
                wisMod.setText(String.valueOf(modW));
                cost=1;
                points = points - cost;
                counterW=5;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;
            case 14:
                modW=2;
                wisMod.setText(String.valueOf(modW));
                cost = 2;
                points = points - cost;
                counterW=7;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;

            case 15:
                modW=2;
                wisMod.setText(String.valueOf(modW));

                cost = 2;
                points = points - 2;

                counterW=9;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;

        }



     /*  if(points>0 && points<27) {
                totalPoints.setText(String.valueOf(points));
                int tp1 = Integer.parseInt(totalPoints.getText().toString());

                points = tp1;
            }*/


    }

    public void levelDownWisdom() {

        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);
        System.out.println("Startpoints"+points);


        final TextView strMod = (TextView) findViewById(R.id.wisId);

        TextView wis1 = (TextView) findViewById(R.id.et5);
        wis1.setText(String.valueOf(baseWis));
        int wis = Integer.parseInt(wis1.getText().toString());


        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));


        switch (wis) {

            case 8:
                modW=-1;
                cost = 0;
                strMod.setText(String.valueOf(modW));
                points = points + cost;
                counterW=0;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));

                break;


            case 9:
                modW=-1;
                strMod.setText(String.valueOf(modW));
                cost = 1;
                points = points + cost;
                counterW=1;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(8));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 10:
                modW=-1;
                strMod.setText(String.valueOf(modW));
                cost = 1;
                points = points + cost;
                counterW=2;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(9));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 11:
                modW=0;
                strMod.setText(String.valueOf(modW));
                cost = 1;
                points = points + cost;
                counterW=3;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(10));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 12:
                modW=0;
                strMod.setText(String.valueOf(modW));
                cost = 1;
                points = points + cost;
                counterW=4;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(11));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 13:
                modW=1;
                strMod.setText(String.valueOf(modW));
                cost = 1;
                points = points + cost;
                counterW=5;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(12));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 14:
                modW=1;
                strMod.setText(String.valueOf(modW));
                cost = 2;
                points = points + cost;
                counterW=7;
                totalPoints.setText(String.valueOf(points));
                wis1.setText(String.valueOf(13));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;
            case 15:
                modW=2;
                strMod.setText(String.valueOf(modW));
                cost = 2;
                points = points + cost;
                counterW=7;
                wis1.setText(String.valueOf(14));


                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",wis,points,counterW,cost));
                break;


        }
        if (baseWis > 8) {baseWis--;}

       /* int tp1 = Integer.parseInt(totalPoints.getText().toString());
        points=tp1;*/
    }

    public void levelUpDCharisma() {
        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);


        if (baseCha < 15) {
            baseCha++;

        }



        TextView chaMod = (TextView) findViewById(R.id.chaId);
        TextView cha1 = (TextView) findViewById(R.id.et6);
        cha1.setText(String.valueOf(baseCha));
        int cha = Integer.parseInt(cha1.getText().toString());


        totalPoints.setText(String.valueOf(points));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));


        switch (cha) {

            case 8:
                modCh=-1;
                chaMod.setText(String.valueOf(modCh));

                cost=0;
                counterCh=0;
                points = points - cost;
                System.out.println(String.format("8Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                totalPoints.setText(String.valueOf(points));

                break;
            case 9:
                modCh=-1;
                chaMod.setText(String.valueOf(modCh));
                cost=1;
                points = points - cost;
                counterCh=1;

                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));


                break;
            case 10:
                modCh=0;
                chaMod.setText(String.valueOf(modCh));
                cost=1;
                points = points - cost;
                counterCh=2;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;
            case 11:
                modCh=0;
                chaMod.setText(String.valueOf(modCh));
                cost=1;
                points = points - cost;
                counterCh=3;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;
            case 12:
                modCh=1;
                chaMod.setText(String.valueOf(modCh));
                cost=1;
                points = points - cost;
                counterCh=4;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;
            case 13:
                modCh=1;
                chaMod.setText(String.valueOf(modCh));
                cost=1;
                points = points - cost;
                counterCh=5;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;
            case 14:
                modCh=2;
                chaMod.setText(String.valueOf(modCh));
                cost = 2;
                points = points - cost;
                counterCh=7;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;

            case 15:
                modCh=2;
                chaMod.setText(String.valueOf(modCh));

                cost = 2;
                points = points - 2;

                counterCh=9;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;

        }



     /*  if(points>0 && points<27) {
                totalPoints.setText(String.valueOf(points));
                int tp1 = Integer.parseInt(totalPoints.getText().toString());

                points = tp1;
            }*/


    }

    public void levelDownCharisma() {

        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);



        final TextView chaMod = (TextView) findViewById(R.id.chaId);

        TextView cha1 = (TextView) findViewById(R.id.et6);
        cha1.setText(String.valueOf(baseCha));
        int cha = Integer.parseInt(cha1.getText().toString());


        System.out.println(String.format("Start+Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));


        switch (cha) {

            case 8:
                modCh=-1;
                cost = 0;
                chaMod.setText(String.valueOf(modCh));
                points = points + cost;
                counterCh=0;
                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));

                break;


            case 9:
                modCh=-1;
                chaMod.setText(String.valueOf(modCh));
                cost = 1;
                points = points + cost;
                counterCh=1;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(8));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 10:
                modCh=-1;
                chaMod.setText(String.valueOf(modCh));
                cost = 1;
                points = points + cost;
                counterCh=2;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(9));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 11:
                modCh=0;
                chaMod.setText(String.valueOf(modCh));
                cost = 1;
                points = points + cost;
                counterCh=3;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(10));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 12:
                modCh=0;
                chaMod.setText(String.valueOf(modCh));
                cost = 1;
                points = points + cost;
                counterCh=4;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(11));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 13:
                modCh=1;
                chaMod.setText(String.valueOf(modCh));
                cost = 1;
                points = points + cost;
                counterCh=5;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(12));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 14:
                modCh=1;
                chaMod.setText(String.valueOf(modCh));
                cost = 2;
                points = points + cost;
                counterCh=7;
                totalPoints.setText(String.valueOf(points));
                cha1.setText(String.valueOf(13));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;
            case 15:
                modCh=2;
                chaMod.setText(String.valueOf(modCh));
                cost = 2;
                points = points + cost;
                counterCh=7;
                cha1.setText(String.valueOf(14));


                totalPoints.setText(String.valueOf(points));
                System.out.println(String.format("Str:%s+points:%s+counter:%s+cost:%s",cha,points,counterCh,cost));
                break;


        }
        if (baseCha > 8) {baseCha--;}

       /* int tp1 = Integer.parseInt(totalPoints.getText().toString());
        points=tp1;*/
    }


    public void reset(){

        TextView totalPoints = (TextView) findViewById(R.id.totalPointsId);
        totalPoints.setText(String.valueOf(27));
        int tp = Integer.parseInt(totalPoints.getText().toString());
        setPoints(tp);


        TextView str1 = (TextView) findViewById(R.id.et1);
        str1.setText(String.valueOf(8));
        int str = Integer.parseInt(str1.getText().toString());
        setBaseStr(8);
        setCounterS(0);


        TextView dex1 = (TextView) findViewById(R.id.et2);
        dex1.setText(String.valueOf(8));
        int dex = Integer.parseInt(dex1.getText().toString());
        setBaseDex(8);
        setCounterD(0);

        TextView con1 = (TextView) findViewById(R.id.et3);
        con1.setText(String.valueOf(8));
        int con = Integer.parseInt(con1.getText().toString());
        setBaseCon(8);
        setCounterC(0);

        TextView int1 = (TextView) findViewById(R.id.et4);
        int1.setText(String.valueOf(8));
        int inte = Integer.parseInt(int1.getText().toString());
        setBaseInt(8);
        setCounterI(0);

        TextView wis1 = (TextView) findViewById(R.id.et5);
        wis1.setText(String.valueOf(8));
        int wis = Integer.parseInt(wis1.getText().toString());
        setBaseWis(8);
         setCounterW(0);

        TextView cha1 = (TextView) findViewById(R.id.et6);
        cha1.setText(String.valueOf(8));
        int cha = Integer.parseInt(cha1.getText().toString());
        setBaseCha(8);
        setCounterCh(0);


        final TextView strMod = (TextView) findViewById(R.id.strId);
        strMod.setText(String.valueOf(-1));
        setModS(-1);

        final TextView dexMod = (TextView) findViewById(R.id.dexId);
        dexMod.setText(String.valueOf(-1));
         setModD(-1);

        final TextView conMod = (TextView) findViewById(R.id.conId);
        conMod.setText(String.valueOf(-1));
        setModC(-1);

        final TextView intMod = (TextView) findViewById(R.id.intId);
        intMod.setText(String.valueOf(-1));
        setModI(-1);

        final TextView wisMod = (TextView) findViewById(R.id.wisId);
        wisMod.setText(String.valueOf(-1));
        setModW(-1);

        final TextView chaMod = (TextView) findViewById(R.id.chaId);
        chaMod.setText(String.valueOf(-1));
        setModCh(-1);

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }




    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseCon() {
        return baseCon;
    }

    public void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseWis() {
        return baseWis;
    }

    public void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseCha() {
        return baseCha;
    }

    public void setBaseCha(int baseCha) {
        this.baseCha = baseCha;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getModS() {
        return modS;
    }

    public void setModS(int modS) {
        this.modS = modS;
    }

    public int getModD() {
        return modD;
    }

    public void setModD(int modD) {
        this.modD = modD;
    }

    public int getModC() {
        return modC;
    }

    public void setModC(int modC) {
        this.modC = modC;
    }

    public int getModI() {
        return modI;
    }

    public void setModI(int modI) {
        this.modI = modI;
    }

    public int getModW() {
        return modW;
    }

    public void setModW(int modW) {
        this.modW = modW;
    }

    public int getModCh() {
        return modCh;
    }

    public void setModCh(int modCh) {
        this.modCh = modCh;
    }

    public int getCounterS() {
        return counterS;
    }

    public void setCounterS(int counterS) {
        this.counterS = counterS;
    }

    public int getCounterD() {
        return counterD;
    }

    public void setCounterD(int counterD) {
        this.counterD = counterD;
    }

    public int getCounterC() {
        return counterC;
    }

    public void setCounterC(int counterC) {
        this.counterC = counterC;
    }

    public int getCounterI() {
        return counterI;
    }

    public void setCounterI(int counterI) {
        this.counterI = counterI;
    }

    public int getCounterW() {
        return counterW;
    }

    public void setCounterW(int counterW) {
        this.counterW = counterW;
    }

    public int getCounterCh() {
        return counterCh;
    }

    public void setCounterCh(int counterCh) {
        this.counterCh = counterCh;
    }
}
