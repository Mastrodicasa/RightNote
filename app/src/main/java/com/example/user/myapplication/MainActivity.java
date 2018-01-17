package com.example.user.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;
    Handler handler;
    Long mInit;

    private Button mPlay;
    private Button mInfos;
    private Button mScores;
    private Button mCredits;
    private ImageView mPiano;

    //DECLARER TOOLBAR
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlay=(Button) findViewById(R.id.button_play);
        mInfos=(Button) findViewById(R.id.button_settings);
        mScores=(Button) findViewById(R.id.button_scores);
        mCredits=(Button) findViewById(R.id.button_credits);

        //On tag les boutons
        mPlay.setTag(1);
        mInfos.setTag(2);
        mScores.setTag(3);
        mCredits.setTag(4);

        mInfos.setOnClickListener(this);
        mScores.setOnClickListener(this);
        mCredits.setOnClickListener(this);
        mPlay.setOnClickListener(this);

        mPiano = (ImageView) findViewById(R.id.imageMain);

        mp= MediaPlayer.create(this, R.raw.cadence_v_i);
        handler=new Handler();
        mInit=System.currentTimeMillis();

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setIcon(getDrawable(R.drawable.home));

    }

    @Override
    public void onClick(View v) {
//        if (mp.isPlaying())
//                mp.stop();
//
//
//            mp= MediaPlayer.create(this, R.raw.v);
//            mp.start();
//

//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        //mEnableTouchEvents = true;
//                        //if (mp.isPlaying())
//                          //  mp.stop();
//                        //else {
//                            mp = MediaPlayer.create(MainActivity.this, R.raw.i);
//                            mp.start();
//                        //}
//                    }
//                }, 2000); // LENGTH_SHORT is usually 2 second long

        //Quel bouton actionné
        int responseIndex = (int) v.getTag();


        Long whenClicked=System.currentTimeMillis();
        Long diff=whenClicked-mInit;

        Log.i("TEST", Long.toString(diff));


        //ON LANCE L ACTIVITE

        if(responseIndex == 1) {
            Intent levelActivity = new Intent(MainActivity.this, LevelActivity.class);
            startActivity(levelActivity);
        }else if (responseIndex == 2) {
            Intent infoActivity = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(infoActivity);
        }else if (responseIndex == 3){
            Intent pianoActivity = new Intent(MainActivity.this, PianoRecordActivity.class);
            startActivity(pianoActivity);
        }else if (responseIndex == 4){
            Intent creditActivity = new Intent(MainActivity.this, CreditActivity.class);
            startActivity(creditActivity);
        }



    }
}
