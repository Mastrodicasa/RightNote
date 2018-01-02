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
        return view;
    }

    public void setText(String text)
    {
        mTextView.setText(text);
    }
}
