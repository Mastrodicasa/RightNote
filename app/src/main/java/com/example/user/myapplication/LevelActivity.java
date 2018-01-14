package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity  {

   /* private Button bKeyboard;
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
            case 3:
            {
                Intent course = new Intent(LevelActivity.this, CourseLevel3Activity.class);
                startActivity(course);
                break;
            }
        }

    }
    */

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;
    //DECLARER TOOLBAR
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Levels");
        getSupportActionBar().setIcon(getDrawable(R.drawable.level));

        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new Product(
                        1,
                        "Novice",
                        R.drawable.maison));

        productList.add(
                new Product(
                        1,
                        "Easy",
                        R.drawable.petit_bar));

        productList.add(
                new Product(
                        1,
                        "Medium",
                        R.drawable.grand_bar));
        productList.add(
                new Product(
                        1,
                        "Hard",
                        R.drawable.orchestre));
        productList.add(
                new Product(
                        1,
                        "Expert",
                        R.drawable.stadedefoot));


        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
