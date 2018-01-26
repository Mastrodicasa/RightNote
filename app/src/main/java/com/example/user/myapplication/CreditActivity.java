package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreditActivity extends AppCompatActivity {

    //DECLARER TOOLBAR

    private TextView Text0;
    private TextView Text1;
    private TextView Text2;
    private TextView Text3;
    private TextView Text4;
    private TextView Text5;
    private TextView Text6;
    private TextView Text7;
    private TextView Text8;
    private TextView Text9;
    private TextView Text10;
    private TextView Text11;
    private TextView Text12;
    private TextView Text13;
    private TextView Text14;
    private TextView Text15;
    private TextView Text16;


    private Toolbar mToolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);


        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setIcon(getDrawable(R.drawable.credits_tool));

        Text0 = (TextView) findViewById(R.id.creditsound);
        Text1 = (TextView) findViewById(R.id.creditsound1);
        Text2 = (TextView) findViewById(R.id.creditsound2);
        Text3 = (TextView) findViewById(R.id.creditsound3);
        Text4 = (TextView) findViewById(R.id.creditsound4);
        Text5 = (TextView) findViewById(R.id.creditsound5);
        Text6 = (TextView) findViewById(R.id.creditsound6);
        Text7 = (TextView) findViewById(R.id.creditsound7);
        Text8 = (TextView) findViewById(R.id.creditsound8);
        Text9 = (TextView) findViewById(R.id.creditsound9);
        Text10 = (TextView) findViewById(R.id.creditsound10);
        Text11 = (TextView) findViewById(R.id.creditsound11);
        Text12 = (TextView) findViewById(R.id.creditsound12);
        Text13 = (TextView) findViewById(R.id.creditsound13);
        Text14 = (TextView) findViewById(R.id.creditsound14);
        Text15 = (TextView) findViewById(R.id.creditsound15);
        Text16 = (TextView) findViewById(R.id.creditsound16);



    }


}
