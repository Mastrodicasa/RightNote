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
            int myInt = bundle.getInt("frag", 1);
            if (myInt==1)
            {
                this.setText("It exits 12 notes from a Do to another Do (this difference is called an octave).  So an octave is divided in 12 equal parts called semi tones.");
            }
        }
        return view;
    }

    public void setText(String text)
    {
        mTextView.setText(text);

    }
}
