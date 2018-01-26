package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ProductAdapterInfo adapter;

    List<ProductInfo> productList;
    //DECLARER TOOLBAR
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //DEFINIR TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Infos");
        getSupportActionBar().setIcon(getDrawable(R.drawable.info));

        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewInfo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList.add(
                new ProductInfo(
                        1,
                        "What is RightNote?",
                        R.mipmap.testquestion,
                        "RightNote is a music application equipped with a piano keyboard to " +
                                "simulate at best the reality. This keyboard represents " +
                                "the fourth Octave of a real piano. In other words, it is the " +
                                "center part where the notes are classic. " +
                                "The main goal of RightNote is to teach to people how to " +
                                "chose the good notes. For this, different types of exercises " +
                                "are available trough five levels of difficulty. Moreover, " +
                                "Recording enables you to play notes with a song in the background. " +
                                "You can save it, replay it and even share it! "));
        productList.add(

                new ProductInfo(
                        1,
                        "Why would you use this application?",
                        R.mipmap.testquestion,
                        "You don't need to be an expert in music because RightNote is a progressive " +
                                "learning application. Moreover, theoretical aspects are recalled for each level. " +
                                "This application goes further than simply recognise the music notes. Indeed, " +
                                "you will have to find the good notes that would come after the notes played. "));
        productList.add(

                new ProductInfo(
                        1,
                        "Who are the developpers?",
                        R.mipmap.who,
                        "RightNote has been created by Simon Mastrodicasa and Bertrand Thoumsin.                                                                             "));

        productList.add(
                new ProductInfo(
                        1,
                        "Which version is it?",
                        R.mipmap.update,
                        "This is the first version of RigthNote v1.1                                                                                                          "));

        productList.add(
                new ProductInfo(
                        1,
                        "Little tip",
                        R.mipmap.idea,
                        "If you want to play freely with the piano without having any score, any question or whatever" +
                                ", go to Recording and don't put on Record. It is a good way to remember or to " +
                                "learn the notes on a piano keyboard. "));




        adapter = new ProductAdapterInfo(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
