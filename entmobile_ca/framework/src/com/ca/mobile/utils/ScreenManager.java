package com.ca.mobile.utils;


import android.util.DisplayMetrics;
import com.ca.mobile.IocFramework;

/**
 * Created by wuweidong on 16-6-30.
 * email:wwdhao163@163.com
 * 类型的描述:
 * 设备屏幕信息
 */
public class ScreenManager {

    public static int ScreenWidth = 0;//屏幕宽

    public static int ScreenHeight = 0;//屏幕高

    public static float scale = 0f;//密度适配值

    public static void initScreenWidthAndHeight(){
        DisplayMetrics displayMetrics = IocFramework.getIocFramework().getApplication().getResources().getDisplayMetrics();
        scale = displayMetrics.density;
        ScreenWidth = displayMetrics.widthPixels;
        ScreenHeight = displayMetrics.heightPixels;
    }

    /**
     * dip转换为px
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue){
        return (int)(dipValue*scale+0.5f);
    }

    /**
     * px转换为dip
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue){
        return (int)(pxValue*scale+0.5f);
    }

}
