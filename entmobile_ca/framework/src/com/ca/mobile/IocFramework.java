package com.ca.mobile;

import android.app.Application;

import com.ca.mobile.utils.ScreenManager;
import com.qiniu.android.common.Zone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;

/**
 * Created by wuweidong on 2016/3/9.
 */
public class IocFramework {
    /**
     * Application对象
     */
    private Application application;

    private static IocFramework iocFramework;

    private UploadManager uploadManager;//七牛图片上传

    public Application getApplication() {
        return application;
    }

    public static IocFramework getIocFramework() {
        if (iocFramework == null) {
            iocFramework = new IocFramework();
        }
        return iocFramework;
    }

    public void init(Application app) {
        application = app;
        initUploadConfig();
        ScreenManager.initScreenWidthAndHeight();
    }


    /**
     * 获得七牛图片上传的配置信息
     * @return
     */
    public UploadManager getImageUploadManager() {
        return uploadManager;
    }

    private void initUploadConfig(){
        Configuration configuration = new Configuration.Builder()
                .chunkSize(256*1024)
                .putThreshhold(512*1024)
                .connectTimeout(10)
                .responseTimeout(60)
                .zone(Zone.zone0)
                .build();
        uploadManager = new UploadManager(configuration);
    }
}
