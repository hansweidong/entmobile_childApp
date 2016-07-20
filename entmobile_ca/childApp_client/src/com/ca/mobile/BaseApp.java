package com.ca.mobile;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by weidong_wu on 16-6-29.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppBasicConfig.EnvInfo = true;
        LeakCanary.install(this);
        IocFramework.getIocFramework().init(this);
    }


}
