package com.example.user.myapplication;

import android.content.Intent;
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
    public static final String BUNDLE_EXTRA_READ = "BUNDLE_EXTRA_READ";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    private Toolbar mToolbar;

    //private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        Log.d(TAG,"onCreate:Starting");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        //On récupère de Course activity quel bouton a été appuyé:
        // car différents boutons envoient vers des cours théoriques différents
        Bundle extras=getIntent().getExtras();
        int nbTh;
        if (extras!=null)
        {
            //Ce nombre correspond au quantième groupe
            nbTh=extras.getInt("BUNDLE_THEORY");
            if (nbTh == 11){
                getSupportActionBar().setTitle("Keyboard");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }else if(nbTh == 12){
                getSupportActionBar().setTitle("Chord");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }else if(nbTh == 21){
                getSupportActionBar().setTitle("Scale");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }else if(nbTh == 22){
                getSupportActionBar().setTitle("Cadence");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }else if(nbTh == 31){
                getSupportActionBar().setTitle("Seventh");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }else if(nbTh == 32){
                getSupportActionBar().setTitle("Backtrack");
                getSupportActionBar().setIcon(getDrawable(R.drawable.theory));
            }
        }
        else
        {
            //N'importe quoi pour dire que y a une erreur
            nbTh=1000;
        }

        //Set up the ViewPager with the sections adapter
        mViewPager= (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager, nbTh);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(BUNDLE_EXTRA_READ, true);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    private void setupViewPager (ViewPager viewPager, int nbTh)
    {
        SectionsPageAdapter adapter= new SectionsPageAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putInt("frag", nbTh);

        Tab1Fragment tab1Fragment=new Tab1Fragment();
        tab1Fragment.setArguments(bundle);
        adapter.addFragment(tab1Fragment, "PAGE 1");

        Tab2Fragment tab2Fragment=new Tab2Fragment();
        tab2Fragment.setArguments(bundle);
        adapter.addFragment(tab2Fragment, "PAGE 2");


        Tab3Fragment tab3Fragment=new Tab3Fragment();
        tab3Fragment.setArguments(bundle);
        adapter.addFragment(tab3Fragment, "PAGE 3");

        viewPager.setAdapter(adapter);

    }
}
