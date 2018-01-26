package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;

import static java.lang.Math.floorDiv;

public class CourseLevel1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button bKeyboard;
    private Button bEx1;
    private Button bChord;
    private Button bEx2;
    private Button bEx3;

    private static final int SCORE_EX11_REQUEST_CODE = 41;
    private static final int SCORE_EX12_REQUEST_CODE = 42;
    private static final int SCORE_EX13_REQUEST_CODE = 43;
    private static final int SCORE_TH11_REQUEST_CODE = 44;
    private static final int SCORE_TH12_REQUEST_CODE = 45;

    //DECLARER TOOLBAR
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_level_1);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Novice");
        getSupportActionBar().setIcon(getDrawable(R.drawable.course));

        bKeyboard=(Button) findViewById(R.id.button2);
        bEx1=(Button) findViewById(R.id.button3);
        bChord=(Button) findViewById(R.id.button4);
        bEx2=(Button) findViewById(R.id.button5);
        bEx3=(Button) findViewById(R.id.button6);


        bKeyboard.setOnClickListener(this);
        bEx1.setOnClickListener(this);
        bChord.setOnClickListener(this);
        bEx2.setOnClickListener(this);
        bEx3.setOnClickListener(this);

        bKeyboard.setTag(1);
        bEx1.setTag(2);
        bChord.setTag(3);
        bEx2.setTag(4);
        bEx3.setTag(5);

    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        switch(responseIndex){
            case 1:
                Intent theory1 = new Intent(CourseLevel1Activity.this, TheoryActivity.class);
                theory1.putExtra("BUNDLE_THEORY", 11);
                startActivityForResult(theory1, SCORE_TH11_REQUEST_CODE);
                break;
            case 2:
                Intent piano1 = new Intent(CourseLevel1Activity.this, PianoActivity.class);
                piano1.putExtra("BUNDLE_EXERCICE", 11);
                startActivityForResult(piano1,SCORE_EX11_REQUEST_CODE);
                break;
            case 3:
                Intent theory2 = new Intent(CourseLevel1Activity.this, TheoryActivity.class);
                theory2.putExtra("BUNDLE_THEORY", 12);
                startActivityForResult(theory2, SCORE_TH12_REQUEST_CODE);
                break;
            case 4:
                Intent piano2 = new Intent(CourseLevel1Activity.this, PianoActivity.class);
                piano2.putExtra("BUNDLE_EXERCICE", 12);
                startActivityForResult(piano2,SCORE_EX12_REQUEST_CODE);
                break;
            case 5:
                Intent piano3 = new Intent(CourseLevel1Activity.this, PianoActivity.class);
                piano3.putExtra("BUNDLE_EXERCICE", 13);
                startActivityForResult(piano3,SCORE_EX13_REQUEST_CODE);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (SCORE_EX11_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 1 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx1.setText(text);
        }
        else if (SCORE_EX12_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 2 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx2.setText(text);
        }
        else if (SCORE_EX13_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 3 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx3.setText(text);
        }
        else if (SCORE_TH11_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            Spanned text = Html.fromHtml("Keyboard \t \t \t <small> Read " );
            bKeyboard.setText(text);
        }
        else if (SCORE_TH12_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            Spanned text = Html.fromHtml("Chord \t \t  \n  \t \t \t  \t \t <small> \t \t \t \t  Read" );
            bChord.setText(text);
        }


    }
}
