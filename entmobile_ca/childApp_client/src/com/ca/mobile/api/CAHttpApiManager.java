package com.ca.mobile.api;

import com.ca.mobile.net.FastHttpHander;

import java.util.LinkedHashMap;

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

    /**
     * 账号登陆
     * @param account
     * @param pwd
     * @param object
     */
    public void login(String account,String pwd,Object object){
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        params.put("phone",account);
        params.put("password", pwd);
        FastHttpHander.ajax(Port.loginUrl,params,object);
    }
}
