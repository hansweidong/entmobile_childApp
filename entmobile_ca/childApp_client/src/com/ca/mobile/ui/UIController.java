package com.ca.mobile.ui;

import android.content.Context;
import android.content.Intent;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UIController {

    /**
     * 跳转到登陆页面
     * @param from
     */
    public static void toLoginView(Context from){
        Intent intent = new Intent();
        intent.setClass(from,activity_login.class);
        from.startActivity(intent);
    }

}
