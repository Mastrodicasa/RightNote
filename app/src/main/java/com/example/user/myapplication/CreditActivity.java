package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
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
    private TextView Text8;
    private TextView Text9;
    private TextView Text10;
    private TextView Text11;
    private TextView Text12;
    private TextView Text13;
    private TextView Text19;

    private ImageView mImageView1;
    private ImageView mImageView2;


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
        Spanned text = Html.fromHtml("- Notes: <small> <i>Freesound</i>, <b>Jobro</b> ");
        Text1.setText(text);

        Text2 = (TextView) findViewById(R.id.creditsound2);
        Spanned text2 = Html.fromHtml("- Sequence of notes: <small> <i>Freesound</i>, <b>Jobro</b> ");
        Text2.setText(text2);

        Text3 = (TextView) findViewById(R.id.creditsound3);
        Spanned text3 = Html.fromHtml("- Backtrack: <small> <i>Freesound</i>, <b>Luis Hernandez Juminez</b> \n \n \n \n ");
        Text3.setText(text3);

        Text8 = (TextView) findViewById(R.id.creditsound8);
        Spanned text4 = Html.fromHtml("- Piano Home: <small> <i>Piano (c)</i>, <b>Brooke Weber</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text8.setText(text4);

        Text9 = (TextView) findViewById(R.id.creditsound9);
        Spanned text5 = Html.fromHtml("- Novice: <small> <i>Let's be Gypsies at Wijning (c)</i>, <b>Wijn & Beleving</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text9.setText(text5);

        Text10 = (TextView) findViewById(R.id.creditsound10);
        Spanned text6 = Html.fromHtml("- Easy: <small> <i>Room (c)</i>, <b>Megan</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text10.setText(text6);

        Text11 = (TextView) findViewById(R.id.creditsound11);
        Spanned text7 = Html.fromHtml("- Medium: <small> <i>Little Feat Rocking' The House @ the El Rey Theatre in Los Angeles California (c)</i>, <b>Pete Davis</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text11.setText(text7);

        Text12 = (TextView) findViewById(R.id.creditsound12);
        Spanned text8 = Html.fromHtml("- Hard: <small> <i>Orchestre Metropolitain (c)</i>, <b>LeStudio1</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text12.setText(text8);

        Text13 = (TextView) findViewById(R.id.creditsound13);
        Spanned text9 = Html.fromHtml("- Expert: <small> <i>Russia U2 (c)</i>, <b>Pawel Gelovkin</b>, Flic.kr, CC BY-NC-SA 2.0 \n \n \n \n");
        Text13.setText(text9);

        Text19 = (TextView) findViewById(R.id.creditsound19);


        mImageView1= (ImageView) findViewById(R.id.credisimagesound);
        mImageView2 = (ImageView) findViewById(R.id.credisimagesound2);





    }


}
