package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CourseLevel2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button bKeyboard;
    private Button bEx1;
    private Button bChord;
    private Button bEx2;
    private Button bEx3;

    private static final int SCORE_TH21_REQUEST_CODE= 49;
    private static final int SCORE_TH22_REQUEST_CODE= 50;
    private static final int SCORE_EX21_REQUEST_CODE = 51;
    private static final int SCORE_EX22_REQUEST_CODE = 52;
    private static final int SCORE_EX23_REQUEST_CODE = 53;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_level_2);

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
                Intent theory1 = new Intent(CourseLevel2Activity.this, TheoryActivity.class);
                theory1.putExtra("BUNDLE_THEORY", 21);
                startActivityForResult(theory1, SCORE_TH21_REQUEST_CODE);
                break;
            case 2:
                Intent piano1 = new Intent(CourseLevel2Activity.this, PianoActivity.class);
                piano1.putExtra("BUNDLE_EXERCICE", 21);
                startActivityForResult(piano1,SCORE_EX21_REQUEST_CODE);
                break;
            case 3:
                Intent theory2 = new Intent(CourseLevel2Activity.this, TheoryActivity.class);
                theory2.putExtra("BUNDLE_THEORY", 22);
                startActivityForResult(theory2, SCORE_TH22_REQUEST_CODE);
                break;
            case 4:
                Intent piano2 = new Intent(CourseLevel2Activity.this, PianoCadenceActivity.class);
                piano2.putExtra("BUNDLE_EXERCICE", 22);
                startActivityForResult(piano2,SCORE_EX22_REQUEST_CODE);
                break;
            case 5:
                Intent piano3 = new Intent(CourseLevel2Activity.this, PianoCadenceActivity.class);
                piano3.putExtra("BUNDLE_EXERCICE", 23);
                startActivityForResult(piano3,SCORE_EX23_REQUEST_CODE);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (SCORE_EX21_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            bEx1.setText(Integer.toString(score));
        }
        else if (SCORE_EX22_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            bEx2.setText(Integer.toString(score));
        }
        else if (SCORE_EX23_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            bEx3.setText(Integer.toString(score));
        }
        else if (SCORE_TH21_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            bKeyboard.setText(Boolean.toString(read));
        }
        else if (SCORE_TH22_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            bChord.setText(Boolean.toString(read));
        }
    }
}
