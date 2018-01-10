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

public class Tab2Fragment extends Fragment {
    private static final String TAG="Tab2Fragment";

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab2_fragment, container, false);
        mTextView=(TextView) view.findViewById(R.id.textTab2);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("frag");
            switch(myInt)
            {
                case 11:
                    this.setText("On a piano the 7 so called natural notes are the white ones (Do/Re/Mi/FA/Sol/La/Si) and the 5 altered notes ( C#/D#/F#/G#/A#) are the black ones.");
                    break;
                case 12:
                    this.setText("Relatively to the root, different notes give different feelings:\n" +
                            "Minor third: Sad\n" +
                            "Major third: Happy\n" +
                            "Fifth: Gives body");
                    break;
                case 21:
                    this.setText("Notice that:\n"+
                            "1) The notes in roman numeral above denote the function of that note in that scale. We have already seen the fundamental, the third, the fifth.\n "
                            +"2) The Do major chord 's notes are present in the Do major scale\n"
                    +"=>To form all the chords of a scale (process called harmonizing), one adds thirds. Major or minor? The scale imposes it.");
                    break;
                case 22:
                    this.setText("The V I cadence gives this impression of finished sentence, a back to normal situation.\n"
                    +"We will try to play the notes of these chords while they are played in the background. At each question, it will be specified which note should be played.");
                    break;
                case 31:
                    this.setText("Instead of harmonizing the whole scale, one can directly learn that V chord is the only major chord that adds a minor seventh in the scale, giving this tense feeling.\n"
                    +"Other combinations give other feelings: If we add a major seventh on a major chord (what happens for the I chord), the resulting chord is very warm. DoMaj7 is an exemple.");
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
