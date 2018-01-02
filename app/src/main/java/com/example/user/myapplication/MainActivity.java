package com.example.user.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPlay=(Button) findViewById(R.id.button);
        bPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent levelActivity = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(levelActivity);

    }
}
