package com.wdcloud.personroom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.wdcloud.personroom.MainActivity;
import com.wdcloud.personroom.R;
import com.wdcloud.personroom.util.glide.GlideEngine;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Administrator on 2018/6/2.
 */

public class AFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        view.findViewById(R.id.bt_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(getActivity())
                        .openGallery(PictureMimeType.ofVideo())
                        .loadImageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        return view;
//        view.findViewById(R.id.bt_click)
    }


}
