package com.childApp.mobile;

import android.app.Application;

import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.IocFramework;

/**
 * Created by znxass on 16-6-29.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppBasicConfig.EnvInfo = true;
        IocFramework.getIocFramework().init(this);
    }

}
