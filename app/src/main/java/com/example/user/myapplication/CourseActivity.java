package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bKeyboard;
    private Button bEx1;
    private Button bChord;
    private Button bEx2;
    private Button bEx3;

    public static final String BUNDLE_EXERCICE= "BUNDLE_EXERCICE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

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
                Intent theory1 = new Intent(CourseActivity.this, TheoryActivity.class);
                startActivity(theory1);
                break;
            case 2:
                Intent piano1 = new Intent(CourseActivity.this, PianoActivity.class);
                piano1.putExtra(BUNDLE_EXERCICE, 1);
                startActivity(piano1);
                break;
            case 4:
                Intent piano2 = new Intent(CourseActivity.this, PianoActivity.class);
                piano2.putExtra(BUNDLE_EXERCICE, 2);
                startActivity(piano2);
                break;
            case 5:
                Intent piano3 = new Intent(CourseActivity.this, PianoActivity.class);
                piano3.putExtra(BUNDLE_EXERCICE, 3);
                startActivity(piano3);
                break;

        }

    }
}
