package com.example.rajk.puzzle_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Introduction extends AppCompatActivity implements View.OnClickListener {
Button startGame,bestTime,rules;
    RelativeLayout relLayout;
    int height,width;
    RelativeLayout.LayoutParams layoutParams_startGame,layoutParams_bestTime,layoutParams_relLayout,layoutParams_textView,layoutParams_rules;
    TextView textView;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;

        relLayout= (RelativeLayout) findViewById(R.id.relLayout);
        layoutParams_relLayout = new RelativeLayout.LayoutParams(width*50/100,height*80/100);
        layoutParams_relLayout.topMargin = height*10/100;
        layoutParams_relLayout.leftMargin = width*25/100;
        relLayout.setLayoutParams(layoutParams_relLayout);


        textView = (TextView) findViewById(R.id.textView);
        textView.setTextSize(width*4/100);
        layoutParams_textView = new RelativeLayout.LayoutParams(width*40/100,height*25/100);
        layoutParams_textView.topMargin = height*11/100;
        layoutParams_textView.leftMargin = width*38/100;
        textView.setLayoutParams(layoutParams_textView);

        startGame = (Button)findViewById(R.id.startGame);
        layoutParams_startGame = new RelativeLayout.LayoutParams(width*40/100,height*15/100);
        layoutParams_startGame.topMargin = height*35/100;
        layoutParams_startGame.leftMargin = width*30/100;
        startGame.setLayoutParams(layoutParams_startGame);
        startGame.setOnClickListener(this);

        bestTime = (Button)findViewById(R.id.bestTime);
        layoutParams_bestTime = new RelativeLayout.LayoutParams(width*40/100,height*15/100);
        layoutParams_bestTime.topMargin = height*52/100;
        layoutParams_bestTime.leftMargin = width*30/100;
        bestTime.setLayoutParams(layoutParams_bestTime);
        bestTime.setOnClickListener(this);

        rules = (Button)findViewById(R.id.rules);
        layoutParams_rules = new RelativeLayout.LayoutParams(width*40/100,height*15/100);
        layoutParams_rules.topMargin = height*69/100;
        layoutParams_rules.leftMargin = width*30/100;
        rules.setLayoutParams(layoutParams_rules);
        rules.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startGame:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.bestTime:
                AlertDialog alertDialog = new AlertDialog.Builder(
                        Introduction.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Best Time");
                SharedPreferences sharedPreferences = getSharedPreferences("HighScore",MODE_PRIVATE);
                String HighScore =sharedPreferences.getString("BestTime","No Best Time yet!!");


                // Setting Dialog Message
                alertDialog.setMessage("Best Time: "+HighScore);

                // Setting OK Button
                alertDialog.setButton(RESULT_OK,"OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                    }
                });
                // Showing Alert Message
                alertDialog.show();
                break;

            case R.id.rules:
                AlertDialog alertDialogRules = new AlertDialog.Builder(
                        Introduction.this).create();

                // Setting Dialog Title
                alertDialogRules.setTitle("Rules");
                // Setting Dialog Message
                alertDialogRules.setMessage("1) There are 22 items that have to be identified.\n2) The items " +
                        "can be hidden anywhere in the scenery.\n3) Once an item is marked it gets encircled.\n4) Use the button on " +
                        "screen to find the item remaining.\n5) Carefully read the hints.Only 3 per game .\n6)Try to beat your best time!!\n\n\tBest Of Luck!!!");

                // Setting OK Button
                alertDialogRules.setButton(RESULT_OK,"OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                    }
                });
                // Showing Alert Message
                alertDialogRules.show();
                break;

        }
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

}
