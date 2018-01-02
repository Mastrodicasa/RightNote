package com.example.user.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class TheoryActivity extends AppCompatActivity {

    private static final String TAG="TheoryActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    //private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        Log.d(TAG,"onCreate:Starting");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter
        mViewPager= (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void setupViewPager (ViewPager viewPager)
    {
        SectionsPageAdapter adapter= new SectionsPageAdapter(getSupportFragmentManager());
        Tab1Fragment tab1Fragment=new Tab1Fragment();
        //Bundle bundle = new Bundle();
        //bundle.putInt("frag", 1);
        //tab1Fragment.setArguments(bundle);
        //tab1Fragment.setText("j ai tout sbraaaa");
        adapter.addFragment(tab1Fragment, "PAGE 1");
        Tab2Fragment tab2Fragment=new Tab2Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("frag", 1);
        tab2Fragment.setArguments(bundle);
        //tab2Fragment.setText("nichen ");
        adapter.addFragment(tab2Fragment, "PAGE 2");
        Tab3Fragment tab3Fragment=new Tab3Fragment();
        //tab3Fragment.setText("raaaaaaaa");
        adapter.addFragment(tab3Fragment, "PAGE 3");
        viewPager.setAdapter(adapter);

    }
}
