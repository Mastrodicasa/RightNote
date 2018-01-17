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
                        R.mipmap.update,
                        "RightNote is a music application equiped with a piano keyboard to " +
                                "simulate at best the reality. This keyboard represents " +
                                "the fourth Octave of a real piano. In other words, it is the" +
                                "center part where the notes are classic. " +
                                "The main goal of RightNote is to teach to people how to  " +
                                "chose the good notes. For this, different types of exercises  \t" +
                                " are available trough five levels of difficulty. "));
        productList.add(

                new ProductInfo(
                1,
                "Why would you use this application?",
                        R.mipmap.update,
                "You don't need to be an expert in music because RightNote is a progressive \t" +
                        "learn application. Moreover, theoretical aspects are recalled for each level.\t" +
                        " This application goes further than simply recognise the music notes. Indeed, \t" +
                        "you will have to imagine the following of the song. "));
        productList.add(

                new ProductInfo(
                1,
                "Who are the developers?",
                        R.mipmap.who,
                "RightNote has been created by Simon Mastrodicasa and Bertrand Thoumsin."));

        productList.add(
                new ProductInfo(
                1,
                "Which version is it?",
                R.mipmap.update,
                "This is the first version of RigthNote v1.1"));

        productList.add(
                new ProductInfo(
                        1,
                        "Little tip",
                        R.mipmap.update,
                        "If you want to play freely with the piano without having any score, any question or whatever \t" +
                                ", you should "));





        adapter = new ProductAdapterInfo(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
