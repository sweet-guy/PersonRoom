package com.wdcloud.personroom.activity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wdcloud.personroom.R;
import com.wdcloud.personroom.activity.present.HomePresent;
import com.wdcloud.personroom.activity.view.view.HomeView;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresent homePresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //初始化present绑定view
        initPrensent();
        //请求
        homePresent.getUser("","");
    }
    private void initPrensent(){
        homePresent = new HomePresent();
        homePresent.initData();
        homePresent.attachView(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresent.detachView();
    }

    @Override
    public void HomeSuccess(String s) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dissProgress() {

    }
}
