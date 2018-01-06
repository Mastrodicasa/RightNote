package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bKeyboard;
    private Button bEx1;
    private Button bChord;
    private Button bEx2;
    private Button bEx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        bKeyboard=(Button) findViewById(R.id.button7);
        bEx1=(Button) findViewById(R.id.button8);
        bChord=(Button) findViewById(R.id.button9);
        bEx2=(Button) findViewById(R.id.button10);
        bEx3=(Button) findViewById(R.id.button11);


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
           case 1:{
                Intent course=new Intent(LevelActivity.this, CourseLevel1Activity.class);
                startActivity(course);
                break;}
            case 2:
            {
                Intent course = new Intent(LevelActivity.this, CourseLevel2Activity.class);
                startActivity(course);
                break;
            }
        }

    }
}
