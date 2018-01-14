package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    private static int time = 2000;
    private ImageView mImageView;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        /*EasySplashScreen config = new EasySplashScreen(WelcomeActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withLogo(R.drawable.piano)
                .withHeaderText("Welcome on RightNote");
        View view = config.create();
        setContentView(view);

        config.getHeaderTextView().setTextSize();
*/


        mImageView = (ImageView) findViewById(R.id.imageWelcome);
        mTextView = (TextView) findViewById(R.id.textWelcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainactivity = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(mainactivity);
                finish();
            }
        }, time);

    }
}
