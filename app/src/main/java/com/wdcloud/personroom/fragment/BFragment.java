package com.wdcloud.personroom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.wdcloud.personroom.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Jue on 2018/6/2.
 */

public class BFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container,false);
        return view;
    }
}
