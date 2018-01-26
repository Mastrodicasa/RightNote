package com.example.user.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 31/12/2017.
 */

public class Tab1Fragment  extends Fragment{
    private static final String TAG="Tab1Fragment";
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tab1_fragment, container, false);
        mTextView=(TextView) view.findViewById(R.id.textTab1);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("frag");
            switch(myInt)
            {
                case 11:
                    this.setText("It exits 12 notes from a Do to another Do. This difference is called an octave. \n \nSo an octave is divided in 12 equal parts called semi tones.\n \n \n ");
                    break;
                case 12:
                    this.setText("The simplest chord is composed of 3 notes: \n \nThe root, the minor (+1.5) or major third (+2) and the fifth (+3.5 from the root). \n \nWhen written with a point in between, we talked about tones, so as a reminder +1.5 tones = +3 semi-tones.\n \n From now on, everything will be written in tones.\n \n \n \n \n" +
                            "Do major = Do + Mi + Sol.");
                    break;
                case 21:
                    this.setText("A lot of different scales exist, for the moment let's focus on the \"happy\" major scale which is composed of 7 notes.\n \n"+
                            "Do (1) - Re (1) - Mi (0.5) - Fa (1) - Sol (1) - La (1) - Si (0.5) - Do \n \n"+"To have the same scale for another note, we keep the same spacing.\n \n"
                            +"Sol (1) - La (1) - Si (0.5) - Do (1) - Re (1) - Mi (1) - Fa# (0.5) - Sol \n \n \n \n");
                    break;

                case 22:
                    this.setText("Now that we have all the chords that we can play in the Do major scale, we can join some of them and the result is a cadence.\n"+
                            "A cadence is a progression of chords in the same scale, some of them are very common, and the most common is the V I cadence." );
                    break;

                case 31:
                    this.setText("An another very important and common note is the minor seventh with a major chord which gives a tense feeling.\n"
                            +"As with the basic Sol chord, if we want a Sol7, we just need to add the third that is imposed by the scale, so we harmonize the Do major scale with 4 notes instead of 3 now. \n \n \n \n \n");
                    break;

                case 32:
                    this.setText("Now that you the rudiments of improvising, we can try our first real backtrack! \nA backtrack is cycle of chords in a certain scale made on purpose without vocal or melody above so that someone can improvise on it.\n \n \n");
                    break;
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
