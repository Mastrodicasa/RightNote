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
                    this.setText("It exits 12 notes from a Do to another Do (this difference is called an octave).  So an octave is divided in 12 equal parts called semi tones.");
                    break;
                case 12:
                    this.setText("The simplest chord is composed of 3 notes: the root, the minor(+1.5) or major third (+2) and the fifth (+3.5). \n" +
                            "Do major= Do+Mi+Sol.");
                        break;
                case 21:
                this.setText("A lot of different scales exist, for the moment let's focus on the \"happy\" major scale which is composed of 7 notes.\n"+
                        "MANQUE LE DESSIN DE LA GAMME\n"+"To have the same scale for another note, we keep the same spacing.\n"
                +"MANQUE LE DESSIN DE LA GAMME");
                break;

                case 22:
                    this.setText("Now that we have all the chords that we can play in the Do major scale, we can join some of them and the result is a cadence.\n"+
                            "A cadence is a progression of chords in the same scale, some of them are very common, and the most common is the V I cadence:\n"
                    +"");
                    break;

                case 31:
                    this.setText("An another very important and common note is the minor seventh with a major chord which gives a tense feeling.\n"
                    +"As with the basic Sol chord, if we want a Sol7, we just need to add the third that is imposed by the scale, so we harmonize the Do major scale with 4 notes instead of 3 now. ");
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
