package com.kingtvarshin.apogee2017.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingtvarshin.apogee2017.R;


/**
 * Created by lenovo on 14-09-2016.
 */
public class Fragment_about extends Fragment {

//    Typeface tf1;
    TextView t1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

//        t1 = (TextView)rootView.findViewById(R.id.textViewabout);

//        tf1 = Typeface.createFromAsset(getContext().getAssets(),"fonts/RobotoReguler.ttf");

//        t1.setTypeface(tf1);

        return rootView;
    }

}