package com.childApp.mobile.httpApi;

/**
 * Created by wuweidong on 16-6-29.
 * email:wwdhao163@163.com
 * Http的操作管理
 */
public class CAHttpApiManager {

    private static CAHttpApiManager mCAHttpApiManager = null;

    private CAHttpApiManager(){}

    public static CAHttpApiManager newInstance(){
        if (mCAHttpApiManager==null){
            mCAHttpApiManager = new CAHttpApiManager();
        }
        return mCAHttpApiManager;
    }

}
