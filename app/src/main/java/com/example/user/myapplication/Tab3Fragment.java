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
                    this.setText("MANQUE LA GAMME\n"+"II Re? Re+Fa+La (minor)\n"
                    +"V Sol? Sol+Si+Re (major)\n"+
                    "All the chords are either minor or major, only the VII chord is different. But because it is an exeption and it is rarely used, let's skip it at least for the moment.");
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
