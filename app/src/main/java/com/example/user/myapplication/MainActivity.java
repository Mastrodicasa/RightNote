package com.example.user.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;
    private Button bPlay;
    Handler handler;
    Long mInit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPlay=(Button) findViewById(R.id.button);
        bPlay.setOnClickListener(this);
        mp= MediaPlayer.create(this, R.raw.cadence_v_i);
        handler=new Handler();
        mInit=System.currentTimeMillis();

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
        Long whenClicked=System.currentTimeMillis();
        Long diff=whenClicked-mInit;

        Log.i("TEST", Long.toString(diff));

        Intent levelActivity = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(levelActivity);


    }
}
