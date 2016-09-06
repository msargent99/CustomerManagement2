package com.bignerdranch.android.customermanagment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Matthew on 9/5/2016.
 */
public class UserFragment extends android.app.Fragment {
    private User mUser;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mUser = new User();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        mTextView = (TextView)v.findViewById(R.id.fragment_user);
        return v;
    }
}
