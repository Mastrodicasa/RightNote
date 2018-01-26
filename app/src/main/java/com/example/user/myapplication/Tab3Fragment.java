package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 31/12/2017.
 */

public class Tab3Fragment extends Fragment {
    private static final String TAG="Tab3Fragment";

    private TextView mTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab3_fragment, container, false);
        mTextView=(TextView) view.findViewById(R.id.textTab3);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("frag");
            switch(myInt)
            {
                case 11:
                    this.setText("Those 12 keys are repeated approximatively 8 times in a piano in order to cover higher and lower pitches.\n");
                    break;
                case 12:
                    this.setText("Let's hear the difference when a major third is replaced with a minor third.");
                    break;
                case 21:
                    this.setText("I (Do) - II (Re) - III (Mi) - IV (Fa) - V (Sol) - VI (La) - VII (Si) - I (Do)\n \n"+"II Re? Re + Fa + La (minor)\n"
                    +"V Sol? Sol + Si + Re (major)\n \n"+
                    "All the chords are either minor or major, only the VII chord is different. But because it is an exception and it is rarely used, let's skip it at least for the moment. \n \n \n \n");
                    break;
                case 22:
                    this.setText("This cadence will be played two times when you click on the button Next.\n" +
                            "The first cadence is played only to prepare you, then at the second one you will have a point if you play the requested note when the chord starts to be played.\n"
                            +"Except those moments, you can play any note you want.\n \n \n \n \n");
                    break;
                case 31:
                    this.setText("Because the V I cadence gives this end of sentence impression, we can reinforce that feeling by making the V more tense by transforming into a V7 chord.\n"
                        +"For the next exercice, you will emphazise the tense feeling and the one after that you will discover the soft IMajor7.");
                    break;
                case 32:
                    this.setText("The backtrack is slow, hence the time between 2 different chords is long in order to push you to start improvising as you wish, and then play a target note. The application is made to teach theoretical tools, not to force you to learn a fixed melody.\n "
                    +"When you feel relax with that tune, why not record your improvisation and send it to your friends? :)");

                default:
                    this.setText("ERROR of myInt");
                    break;
            }
        }
        return view;
    }

    public void setText(String text)
    {

        mTextView.setText(text);
    }
}
