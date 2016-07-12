package com.ca.mobile;

/**
 * Created by wuweidong on 16-6-29.
 * email:wwdhao163@163.com
 * 模块的配置信息
 */
public class AppBasicConfig {

    public static final String APPTag = "ca_app_wwd";//app 标签

    /**
     * 环境状态
     * true 为线上环境
     * false 为开发环境
     */
    public static boolean EnvInfo = false;

    private static final String ProjectUrl = "http://52.74.215.121:3000/api";//线上的URL地址

    private static final String DevUrl = "http://192.168.7.51:3000/api";//开发环境的URL地址

    /**
     * 获得app的URL地址
     * @return
     */
    public static String URL(){
        if (EnvInfo){
            return ProjectUrl;
        }else{
            return DevUrl;
        }
    }


}
