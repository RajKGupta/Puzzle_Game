package com.example.rajk.puzzle_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout secondLL;
    int sec ;
    int min;
    int hint=3;
TextView time;
    int height,width;
    ImageView earth_1,owl_31,sun_2,monkey_4,cater_6,wing_7,slip_81,slip_82,book_11,kite_12,cat_91,cat_92,ant_51,ant_52,ant_53,ant_54,ant_55
            ,flower_101,flower_102,flower_103,flower_104;
    RelativeLayout.LayoutParams layoutParams_fabButton,layoutParams_earth_1,layoutParams_owl_31,layoutParams_owl_32,layoutParams_sun_2,layoutParams_monkey_4,layoutParams_book_11,
            layoutParams_cater_6,layoutParams_wing_7,layoutParams_slip_81,layoutParams_slip_82,layoutParams_kite_12,layoutParams_cat_91,
            layoutParams_cat_92,layoutParams_ant_51,layoutParams_ant_52,layoutParams_ant_53,layoutParams_ant_54,layoutParams_ant_55,
            layoutParams_flower_101,layoutParams_flower_102,layoutParams_flower_103,layoutParams_flower_104,layoutParams_time;
            FrameLayout.LayoutParams layoutParams_secondLL;
    private ImageButton owl_32;
    TextView earth,sun,owlV,flowerV,antV,cater,catV,kite,book,slipV,monkey,wing;
    int slipper = 2,flower = 4,ant =5 , cat =2,owl =2;
    ArrayList<Integer> ids = new ArrayList<>();
    MediaPlayer player;
    FloatingActionButton fab;
    Button hintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;

        min=0;
        sec=1;

        time = (TextView)findViewById(R.id.times);
        layoutParams_time = new RelativeLayout.LayoutParams(height*25/100,height*25/100);
        time.setTextSize(height*3/100);
        layoutParams_time.topMargin = height*1/100;
        layoutParams_time.leftMargin = width*90/100;
        time.setLayoutParams(layoutParams_time);

        time.setText("00:00");


        secondLL = (LinearLayout) findViewById(R.id.l);
        layoutParams_secondLL = new FrameLayout.LayoutParams(width*40/100,height);
        layoutParams_secondLL.topMargin = 0;
        layoutParams_secondLL.leftMargin = 0;
        secondLL.setLayoutParams(layoutParams_secondLL);

        earth = (TextView)findViewById(R.id.earth);
        sun = (TextView)findViewById(R.id.sun);
        owlV = (TextView)findViewById(R.id.owl);
        monkey = (TextView)findViewById(R.id.monkey);
        antV = (TextView)findViewById(R.id.ant);
        cater = (TextView)findViewById(R.id.cater);
        wing = (TextView)findViewById(R.id.wing);
        slipV = (TextView)findViewById(R.id.slip);
        catV = (TextView)findViewById(R.id.cat);
        flowerV = (TextView)findViewById(R.id.flower);
        book = (TextView)findViewById(R.id.book);
        kite = (TextView)findViewById(R.id.kite);



        hintButton = (Button)findViewById(R.id.hintButton);
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hint();
            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
        layoutParams_fabButton = new RelativeLayout.LayoutParams(height*15/100,height*15/100);
        layoutParams_fabButton.topMargin = height*70/100;
        layoutParams_fabButton.leftMargin = width*90/100;
        fab.setLayoutParams(layoutParams_fabButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int visibility = secondLL.getVisibility();
                if(visibility==View.GONE)
                    secondLL.setVisibility(View.VISIBLE);
                else if(visibility==View.VISIBLE)
                {
                    secondLL.setVisibility(View.GONE);
                }
            }
        });
        final Handler h = new Handler();
        final int delay = 999; //milliseconds

        h.postDelayed(new Runnable(){
            public void run()
            {
                String minute,second;

                if(min<10)
                {
                    minute="0"+min;
                }
                else
                {
                    minute = min+"";
                }
                if(sec<10)
                {
                    second = "0"+sec;
                }
                else
                {
                    second = sec+"";
                }
                time.setText(minute+":"+second);
                sec++;
                if(sec==60)
                {
                    sec=0;
                    min++;
                    time.setTextColor(getResources().getColor(R.color.red));
                }
                if(sec==1)
                {
                    time.setTextColor(getResources().getColor(R.color.white));
                }
                h.postDelayed(this, delay);
            }
        }, delay);




        earth_1 = (ImageButton)findViewById(R.id.earth_1);
        layoutParams_earth_1 = new RelativeLayout.LayoutParams(height*11/100,height*11/100);
        layoutParams_earth_1.topMargin = height*9/100;
        layoutParams_earth_1.leftMargin = width*35/100;
        earth_1.setLayoutParams(layoutParams_earth_1);
        earth_1.setOnClickListener(this);

        sun_2 = (ImageButton)findViewById(R.id.sun_2);
        layoutParams_sun_2 = new RelativeLayout.LayoutParams(height*7/100,height*7/100);
        layoutParams_sun_2.topMargin=height*39/100;
        layoutParams_sun_2.leftMargin=width*83/100;
        sun_2.setLayoutParams(layoutParams_sun_2);
        sun_2.setOnClickListener(this);

        owl_31 = (ImageButton)findViewById(R.id.owl_31);
        layoutParams_owl_31 = new RelativeLayout.LayoutParams(height*30/100,height*9/100);
        layoutParams_owl_31.topMargin=height*24/100;;
        layoutParams_owl_31.leftMargin=width*21/100;
        owl_31.setLayoutParams(layoutParams_owl_31);
        owl_31.setOnClickListener(this);

        owl_32 = (ImageButton)findViewById(R.id.owl_32);
        layoutParams_owl_32 = new RelativeLayout.LayoutParams(height*17/100,height*12/100);
        layoutParams_owl_32.topMargin=height*8/100;
        layoutParams_owl_32.leftMargin=width*19/100;
        owl_32.setLayoutParams(layoutParams_owl_32);
        owl_32.setOnClickListener(this);

        monkey_4 = (ImageButton)findViewById(R.id.monkey_4);
        layoutParams_monkey_4 = new RelativeLayout.LayoutParams(height*5/100,height*5/100);
        layoutParams_monkey_4.topMargin=height*2/100;
        layoutParams_monkey_4.leftMargin=width*55/100;
        monkey_4.setLayoutParams(layoutParams_monkey_4);
        monkey_4.setOnClickListener(this);

        ant_51 = (ImageButton)findViewById(R.id.ant_51);
        layoutParams_ant_51 = new RelativeLayout.LayoutParams(height*7/100,height*7/100);
        layoutParams_ant_51.topMargin=height*4/100;
        layoutParams_ant_51.leftMargin=width*81/100;
        ant_51.setLayoutParams(layoutParams_ant_51);
        ant_51.setOnClickListener(this);

        ant_52 = (ImageButton)findViewById(R.id.ant_52);
        layoutParams_ant_52 = new RelativeLayout.LayoutParams(height*8/100,height*8/100);
        layoutParams_ant_52.topMargin=height*15/100;
        layoutParams_ant_52.leftMargin=width*93/100;
        ant_52.setLayoutParams(layoutParams_ant_52);
        ant_52.setOnClickListener(this);

        ant_53 = (ImageButton)findViewById(R.id.ant_53);
        layoutParams_ant_53 = new RelativeLayout.LayoutParams(height*11/100,height*11/100);
        layoutParams_ant_53.topMargin=height*86/100;
        layoutParams_ant_53.leftMargin=width*93/100;
        ant_53.setLayoutParams(layoutParams_ant_53);
        ant_53.setOnClickListener(this);

        ant_54 = (ImageButton)findViewById(R.id.ant_54);
        layoutParams_ant_54 = new RelativeLayout.LayoutParams(height*11/100,height*11/100);
        layoutParams_ant_54.topMargin=height*84/100;
        layoutParams_ant_54.leftMargin=width*1/100;
        ant_54.setLayoutParams(layoutParams_ant_54);
        ant_54.setOnClickListener(this);

        ant_55 = (ImageButton)findViewById(R.id.ant_55);
        layoutParams_ant_55 = new RelativeLayout.LayoutParams(height*8/100,height*8/100);
        layoutParams_ant_55.topMargin=height*64/100;
        layoutParams_ant_55.leftMargin=width*18/100;
        ant_55.setLayoutParams(layoutParams_ant_55);
        ant_55.setOnClickListener(this);

        cater_6 = (ImageButton)findViewById(R.id.cater_6);
        layoutParams_cater_6 = new RelativeLayout.LayoutParams(height*16/100,height*16/100);
        layoutParams_cater_6.topMargin = height*12/100;
        layoutParams_cater_6.leftMargin = width*1/100;
        cater_6.setLayoutParams(layoutParams_cater_6);
        cater_6.setOnClickListener(this);

        wing_7 = (ImageButton)findViewById(R.id.wing_7);
        layoutParams_wing_7 = new RelativeLayout.LayoutParams(height*20/100,height*20/100);
        layoutParams_wing_7.topMargin = height*83/100;
        layoutParams_wing_7.leftMargin = width*40/100;
        wing_7.setLayoutParams(layoutParams_wing_7);
        wing_7.setOnClickListener(this);

        slip_81 = (ImageButton)findViewById(R.id.slip_81);
        layoutParams_slip_81 = new RelativeLayout.LayoutParams(height*7/100,height*7/100);
        layoutParams_slip_81.topMargin=height*64/100;
        layoutParams_slip_81.leftMargin=width*83/100;
        slip_81.setLayoutParams(layoutParams_slip_81);
        slip_81.setOnClickListener(this);

        slip_82 = (ImageButton)findViewById(R.id.slip_82);
        layoutParams_slip_82 = new RelativeLayout.LayoutParams(height*6/100,height*6/100);
        layoutParams_slip_82.topMargin=height*68/100;
        layoutParams_slip_82.leftMargin=width*59/100;
        slip_82.setLayoutParams(layoutParams_slip_82);
        slip_82.setOnClickListener(this);

        cat_91 = (ImageButton)findViewById(R.id.cat_91);
        layoutParams_cat_91 = new RelativeLayout.LayoutParams(height*8/100,height*8/100);
        layoutParams_cat_91.topMargin=height*77/100;
        layoutParams_cat_91.leftMargin=width*83/100;
        cat_91.setLayoutParams(layoutParams_cat_91);
        cat_91.setOnClickListener(this);

        cat_92 = (ImageButton)findViewById(R.id.cat_92);
        layoutParams_cat_92 = new RelativeLayout.LayoutParams(height*7/100,height*7/100);
        layoutParams_cat_92.topMargin=height*48/100;
        layoutParams_cat_92.leftMargin=width*66/100;
        cat_92.setLayoutParams(layoutParams_cat_92);
        cat_92.setOnClickListener(this);

        flower_101 = (ImageButton)findViewById(R.id.flower_101);
        layoutParams_flower_101 = new RelativeLayout.LayoutParams(height*6/100,height*6/100);
        layoutParams_flower_101.topMargin=height*58/100;
        layoutParams_flower_101.leftMargin=width*22/100;
        flower_101.setLayoutParams(layoutParams_flower_101);
        flower_101.setOnClickListener(this);

        flower_102 = (ImageButton)findViewById(R.id.flower_102);
        layoutParams_flower_102 = new RelativeLayout.LayoutParams(height*6/100,height*6/100);
        layoutParams_flower_102.topMargin=height*30/100;
        layoutParams_flower_102.leftMargin=width*11/100;
        flower_102.setLayoutParams(layoutParams_flower_102);
        flower_102.setOnClickListener(this);

        flower_103 = (ImageButton)findViewById(R.id.flower_103);
        layoutParams_flower_103 = new RelativeLayout.LayoutParams(height*4/100,height*4/100);
        layoutParams_flower_103.topMargin=height*31/100;
        layoutParams_flower_103.leftMargin=width*2/100;
        flower_103.setLayoutParams(layoutParams_flower_103);
        flower_103.setOnClickListener(this);

        flower_104 = (ImageButton)findViewById(R.id.flower_104);
        layoutParams_flower_104 = new RelativeLayout.LayoutParams(height*4/100,height*4/100);
        layoutParams_flower_104.topMargin=height*35/100;
        layoutParams_flower_104.leftMargin=width*0/100;
        flower_104.setLayoutParams(layoutParams_flower_104);
        flower_104.setOnClickListener(this);

        book_11 = (ImageButton)findViewById(R.id.book_11);
        layoutParams_book_11 = new RelativeLayout.LayoutParams(height*15/100,height*9/100);
        layoutParams_book_11.topMargin=height*67/100;
        layoutParams_book_11.leftMargin=width*66/100;
        book_11.setLayoutParams(layoutParams_book_11);
        book_11.setOnClickListener(this);

        kite_12 = (ImageButton)findViewById(R.id.kite_12);
        layoutParams_kite_12 = new RelativeLayout.LayoutParams(height*11/100,height*7/100);
        layoutParams_kite_12.topMargin=height*1/100;
        layoutParams_kite_12.leftMargin=width*61/100;
        kite_12.setLayoutParams(layoutParams_kite_12);
        kite_12.setOnClickListener(this);

        ids.add(R.id.earth_1);
        ids.add(R.id.sun_2);
        ids.add(R.id.owl_31);
        ids.add(R.id.owl_32);
        ids.add(R.id.monkey_4);
        ids.add(R.id.ant_51);
        ids.add(R.id.ant_52);
        ids.add(R.id.ant_53);
        ids.add(R.id.ant_54);
        ids.add(R.id.ant_55);
        ids.add(R.id.cater_6);
        ids.add(R.id.wing_7);
        ids.add(R.id.slip_81);
        ids.add(R.id.slip_82);
        ids.add(R.id.cat_91);
        ids.add(R.id.cat_92);
        ids.add(R.id.flower_101);
        ids.add(R.id.flower_102);
        ids.add(R.id.flower_103);
        ids.add(R.id.flower_104);
        ids.add(R.id.book_11);
        ids.add(R.id.kite_12);

    }

    @Override
    public void onClick(View v) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.found);
        mp.start();
        switch (v.getId())
        {
            case R.id.earth_1:
                earth_1.setEnabled(false);
                earth_1.setBackgroundResource(R.drawable.white_drawable);
                earth.setVisibility(View.GONE);
                ids.remove((Object)R.id.earth_1);

                break;

            case R.id.sun_2:
                sun_2.setEnabled(false);
                sun_2.setBackgroundResource(R.drawable.white_drawable);
                sun.setVisibility(View.GONE);
                ids.remove((Object)R.id.sun_2);
                break;

            case R.id.owl_31:
                if(owl==2) {
                    owl--;
                    owlV.setText("  1 Owl");
                    owl_31.setEnabled(false);

                }
                else
                {
                    owlV.setVisibility(View.GONE);
                    owl_31.setEnabled(false);
                }
                owl_31.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.owl_31);
                break;

            case R.id.owl_32:
                if(owl==2) {
                    owlV.setText("  1 Owl");
                    owl--;
                    owl_32.setEnabled(false);

                }
                else
                {
                    owlV.setVisibility(View.GONE);
                    owl_32.setEnabled(false);
                }
                owl_32.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.owl_32);
                break;

            case R.id.monkey_4:
                monkey_4.setEnabled(false);
                monkey_4.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.monkey_4);
                monkey.setVisibility(View.GONE);
                break;

            case R.id.ant_51:
                if(ant>1) {
                    antV.setText("  "+(ant-1)+" Ant(s)");
                }
                else {
                    antV.setVisibility(View.GONE);

                }
                ant--;
                ant_51.setBackgroundResource(R.drawable.white_drawable);
                ant_51.setEnabled(false);
                ids.remove((Object)R.id.ant_51);
                break;

            case R.id.ant_52:
                if(ant>1) {
                    antV.setText("  "+(ant-1)+" Ant(s)");
                }
                else {
                    antV.setVisibility(View.GONE);

                }
                ant--;
                ant_52.setBackgroundResource(R.drawable.white_drawable);
                ant_52.setEnabled(false);
                ids.remove((Object)R.id.ant_52);
                break;

            case R.id.ant_53:
                if(ant>1) {
                    antV.setText("  "+(ant-1)+" Ant(s)");
                }
                else {
                    antV.setVisibility(View.GONE);
                }
                ant--;
                ant_53.setBackgroundResource(R.drawable.white_drawable);
                ant_53.setEnabled(false);
                ids.remove((Object)R.id.ant_53);
                break;

            case R.id.ant_54:
                if(ant>1) {
                    antV.setText("  "+(ant-1)+" Ant(s)");
                }
                else {
                    antV.setVisibility(View.GONE);
                }
                ant--;
                ant_54.setBackgroundResource(R.drawable.white_drawable);
                ant_54.setEnabled(false);
                ids.remove((Object)R.id.ant_54);
                break;

            case R.id.ant_55:
                if(ant>1) {
                    antV.setText("  "+(ant-1)+" Ant(s)");
                }
                else {
                    antV.setVisibility(View.GONE);
                }
                ant--;
                ant_55.setBackgroundResource(R.drawable.white_drawable);
                ant_55.setEnabled(false);
                ids.remove((Object)R.id.ant_55);
                break;

            case R.id.cater_6:
                cater_6.setBackgroundResource(R.drawable.white_drawable);
                cater_6.setEnabled(false);
                ids.remove((Object)R.id.cater_6);
                cater.setVisibility(View.GONE);

                break;

            case R.id.wing_7:
                wing_7.setBackgroundResource(R.drawable.white_drawable);
                wing_7.setEnabled(false);
                wing.setVisibility(View.GONE);
                ids.remove((Object)R.id.wing_7);
                break;

            case R.id.slip_81:
                if(slipper==2) {
                    slipV.setText("  1 Slipper");
                    slipper--;
                    slip_81.setEnabled(false);

                }
                else
                {
                    slip_81.setEnabled(false);
                    slipV.setVisibility(View.GONE);

                }
                slip_81.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.slip_81);
                break;

            case R.id.slip_82:
                if(slipper==2) {
                    slipV.setText("  1 Slipper");
                    slipper--;
                    slip_82.setEnabled(false);

                }
                else
                {
                    slip_82.setEnabled(false);
                    slipV.setVisibility(View.GONE);

                }

                slip_82.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.slip_82);
                break;

            case R.id.cat_91:
                if(cat==2) {
                    catV.setText("  1 Cat");
                    cat--;
                    cat_91.setEnabled(false);

                }
                else
                {
                    cat_91.setEnabled(false);
                    catV.setVisibility(View.GONE);

                }
                cat_91.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.cat_91);
                break;


            case R.id.cat_92:
                if(cat==2) {
                    catV.setText("  1 Cat");
                    cat--;
                    cat_92.setEnabled(false);

                }
                else
                {
                    cat_92.setEnabled(false);
                    catV.setVisibility(View.GONE);

                }
                cat_92.setBackgroundResource(R.drawable.white_drawable);
                ids.remove((Object)R.id.cat_92);
                break;


            case R.id.flower_101:
                if(flower>1) {
                    flowerV.setText("  "+(flower-1)+" Flower(s)");
                }
                else {
                    flowerV.setVisibility(View.GONE);

                }
                flower--;
                flower_101.setBackgroundResource(R.drawable.white_drawable);
                flower_101.setEnabled(false);
                ids.remove((Object)R.id.flower_101);
                break;


            case R.id.flower_102:
                if(flower>1) {
                    flowerV.setText("  "+(flower-1)+" Flower(s)");
                }
                else {
                    flowerV.setVisibility(View.GONE);

                }
                flower--;
                flower_102.setBackgroundResource(R.drawable.white_drawable);
                flower_102.setEnabled(false);
                ids.remove((Object)R.id.flower_102);
                break;

            case R.id.flower_103:
                if(flower>1) {
                    flowerV.setText("  "+(flower-1)+" Flower(s)");
                }
                else {
                    flowerV.setVisibility(View.GONE);
                }
                flower--;
                flower_103.setBackgroundResource(R.drawable.white_drawable);

                flower_103.setEnabled(false);
                ids.remove((Object)R.id.flower_103);
                break;

            case R.id.flower_104:
                if(flower>1) {
                    flowerV.setText("  "+(flower-1)+" Flower(s)");
                }
                else {
                    flowerV.setVisibility(View.GONE);
                }
                flower_104.setBackgroundResource(R.drawable.white_drawable);
                flower_104.setEnabled(false);
                flower--;
                ids.remove((Object)R.id.flower_104);
                break;


            case R.id.book_11:
                book_11.setBackgroundResource(R.drawable.white_drawable);
                book_11.setEnabled(false);
                book.setVisibility(View.GONE);
                ids.remove((Object)R.id.book_11);
                break;


            case R.id.kite_12:
                kite_12.setBackgroundResource(R.drawable.white_drawable);
                kite_12.setEnabled(false);
                kite.setVisibility(View.GONE);
                ids.remove((Object)R.id.kite_12);
                break;

        }
        if(ids.size()==0)
        {
            Toast.makeText(getApplicationContext(),"Congrats! All objects have been found!!",Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("HighScore",MODE_PRIVATE);
            SharedPreferences.Editor editor;
            editor=sharedPreferences.edit();
            String HighScore =sharedPreferences.getString("BestTime","");
            if(HighScore.equals(""))
            {
                editor.putString("BestTime",time.getText().toString().trim());
                editor.commit();
            }
            else
            {
                 int minHigh = Integer.parseInt(HighScore.substring(0,2));
                 int secHigh = Integer.parseInt(HighScore.substring(3,5));
                String curTime = time.getText().toString().trim();
                int minCur = Integer.parseInt(curTime.substring(0,2));
                int secCur = Integer.parseInt(curTime.substring(3,5));
                if(minHigh>minCur)
                {
                    editor.putString("BestTime",curTime);
                    editor.commit();
                }
                else if(minHigh == minCur && secHigh>secCur)
                {
                    editor.putString("BestTime",curTime);
                    editor.commit();
                }
            }
            startActivity(new Intent(MainActivity.this,Introduction.class));
            finish();
        }
    }

    void hint()
    {
        if(hint==0)
        {
            Toast.makeText(getApplicationContext(),"You have used your hints",Toast.LENGTH_LONG).show();
        }
        else
        {
            hint--;
        int size  = ids.size();
        Random r = new Random();
        int  random = r.nextInt(5000)%size;
        switch (ids.get(random))
        {
            case R.id.earth_1:
                Toast.makeText(getApplicationContext(),"Earth:Hey I am Big Enough and I am the center of my world!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.sun_2:
                Toast.makeText(getApplicationContext(),"Sun:You can see me Rising from right",Toast.LENGTH_SHORT).show();
                break;

            case R.id.owl_31:
                Toast.makeText(getApplicationContext(),"Owl: I am flying in space",Toast.LENGTH_SHORT).show();
                break;

            case R.id.owl_32:
                Toast.makeText(getApplicationContext(),"Owl: I am flying in space",Toast.LENGTH_SHORT).show();
                break;

            case R.id.monkey_4:
                Toast.makeText(getApplicationContext(),"Monkey: You Can't See Me hiding in the trees somewhere up!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ant_51:
                Toast.makeText(getApplicationContext(),"Ant: Look for us in the leaves!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ant_52:
                Toast.makeText(getApplicationContext(),"Ant: Look for us in the leaves!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ant_53:
                Toast.makeText(getApplicationContext(),"Ant: Look for us in the leaves!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ant_54:
                Toast.makeText(getApplicationContext(),"Ant: Look for us in the leaves!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ant_55:
                Toast.makeText(getApplicationContext(),"Ant: Look for us in the leaves!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cater_6:
                Toast.makeText(getApplicationContext(),"Caterpillar: In my cocoon on a tree!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.wing_7:
                Toast.makeText(getApplicationContext(),"Butterfly: I am going down down down....!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.slip_81:
                Toast.makeText(getApplicationContext(),"Slipper: Somewhere near the girl!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.slip_82:
                Toast.makeText(getApplicationContext(),"Slipper: Somewhere near the girl!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cat_91:
                Toast.makeText(getApplicationContext(),"Cat: Playing Hide and Seek in the leaves!!",Toast.LENGTH_SHORT).show();
                break;


            case R.id.cat_92:
                Toast.makeText(getApplicationContext(),"Cat: Playing Hide and Seek in the leaves!!",Toast.LENGTH_SHORT).show();
                break;


            case R.id.flower_101:
                Toast.makeText(getApplicationContext(),"Flower: Take StarBoard from space!!",Toast.LENGTH_SHORT).show();
                break;


            case R.id.flower_102:
                Toast.makeText(getApplicationContext(),"Flower: Take StarBoard from space!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.flower_103:
                Toast.makeText(getApplicationContext(),"Flower: Take StarBoard from space!!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.flower_104:
                Toast.makeText(getApplicationContext(),"Flower: Take StarBoard from space!!",Toast.LENGTH_SHORT).show();
                break;


            case R.id.book_11:
                Toast.makeText(getApplicationContext(),"Book: Somebody is reading me!!",Toast.LENGTH_SHORT).show();
                break;


            case R.id.kite_12:
                Toast.makeText(getApplicationContext(),"Kite: High in the sky...Somewhere in the stars!!",Toast.LENGTH_SHORT).show();
                break;
        }}
    }

    @Override
    protected void onStart() {
        super.onStart();
        player = MediaPlayer.create(this, R.raw.game_tune);
        player.setLooping(true);
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }

    @Override
    public void onBackPressed() {
        if(secondLL.getVisibility()==View.VISIBLE)
        {
            secondLL.setVisibility(View.GONE);
        }
        else
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

            // Setting Dialog Title
            alertDialog.setTitle("Leave Current Game...");

            // Setting Dialog Message
            alertDialog.setMessage("Do you want to leave this Game??");

            // Setting Icon to Dialog

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {
                    startActivity(new Intent(MainActivity.this,Introduction.class));
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }
    }
}
