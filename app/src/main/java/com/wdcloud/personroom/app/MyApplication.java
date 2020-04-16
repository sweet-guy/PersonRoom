package com.wdcloud.personroom.app;

import android.app.Application;

/**
 * Info:
 * Created by Umbrella.
 * CreateTime: 2020/4/13 11:29
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApplication getInstance() {
        return instance;
    }
}
