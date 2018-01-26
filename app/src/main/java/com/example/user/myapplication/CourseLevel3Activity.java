package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;

public class CourseLevel3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button bKeyboard;
    private Button bEx1;
    private Button bChord;
    private Button bEx2;
    private Button bEx3;
   // private Button bRecording;

    private static final int SCORE_TH31_REQUEST_CODE= 54;
    private static final int SCORE_TH32_REQUEST_CODE= 55;
    private static final int SCORE_EX31_REQUEST_CODE = 56;
    private static final int SCORE_EX32_REQUEST_CODE = 57;
    private static final int SCORE_EX33_REQUEST_CODE = 58;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_level_3);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Medium");
        getSupportActionBar().setIcon(getDrawable(R.drawable.course));

        bKeyboard=(Button) findViewById(R.id.button2);
        bEx1=(Button) findViewById(R.id.button3);
        bChord=(Button) findViewById(R.id.button5);
        bEx2=(Button) findViewById(R.id.button4);
        bEx3=(Button) findViewById(R.id.button6);
     //   bRecording=(Button) findViewById(R.id.button7);


        bKeyboard.setOnClickListener(this);
        bEx1.setOnClickListener(this);
        bChord.setOnClickListener(this);
        bEx2.setOnClickListener(this);
        bEx3.setOnClickListener(this);
       // bRecording.setOnClickListener(this);

        bKeyboard.setTag(1);
        bEx1.setTag(2);
        bChord.setTag(4);
        bEx2.setTag(3);
        bEx3.setTag(5);
      //  bRecording.setTag(6);

    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        switch(responseIndex){
            case 1:
                Intent theory1 = new Intent(CourseLevel3Activity.this, TheoryActivity.class);
                theory1.putExtra("BUNDLE_THEORY", 31);
                startActivityForResult(theory1, SCORE_TH31_REQUEST_CODE);
                break;
            case 2:
                Intent piano1 = new Intent(CourseLevel3Activity.this, PianoCadenceActivity.class);
                piano1.putExtra("BUNDLE_EXERCICE", 31);
                startActivityForResult(piano1,SCORE_EX31_REQUEST_CODE);
                break;
            case 3:
                Intent piano2 = new Intent(CourseLevel3Activity.this, PianoCadenceActivity.class);
                piano2.putExtra("BUNDLE_EXERCICE", 32);
                startActivityForResult(piano2,SCORE_EX32_REQUEST_CODE);
                break;
            case 4:
                Intent theory2 = new Intent(CourseLevel3Activity.this, TheoryActivity.class);
                theory2.putExtra("BUNDLE_THEORY", 32);
                startActivityForResult(theory2, SCORE_TH32_REQUEST_CODE);
                break;

            case 5:
                Intent piano3 = new Intent(CourseLevel3Activity.this, PianoCadenceActivity.class);
                piano3.putExtra("BUNDLE_EXERCICE", 33);
                startActivityForResult(piano3,SCORE_EX33_REQUEST_CODE);
                break;
           /* case 6:
                Intent recording=new Intent(CourseLevel3Activity.this, PianoRecordActivity.class);
                startActivity(recording);
            break;
          */
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (SCORE_EX31_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 1 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx1.setText(text);
        }
        else if (SCORE_EX32_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 2 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx2.setText(text);
        }
        else if (SCORE_EX33_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(PianoActivity.BUNDLE_EXTRA_SCORE, 0);
            Spanned text = Html.fromHtml("Exercise 3 \n <small> Score \t" +   Integer.toString(score) + "%");
            bEx3.setText(text);
        }
        else if (SCORE_TH31_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            Spanned text = Html.fromHtml("Seventh \t \t \t <small> Read " );
            bKeyboard.setText(text);
        }
        else if (SCORE_TH32_REQUEST_CODE== requestCode && RESULT_OK == resultCode) {
            boolean read = data.getBooleanExtra(TheoryActivity.BUNDLE_EXTRA_READ, false);
            Spanned text = Html.fromHtml("Backtrack \t \t \t <small> Read " );
            bChord.setText(text);
        }
    }
}
