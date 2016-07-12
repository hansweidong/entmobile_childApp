package com.ca.mobile.ui;

import android.content.Context;
import android.content.Intent;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UIController {

    public class UIControllerUtils{

    }

    /**
     * 跳转到登陆页面
     * @param from
     */
    public static void toLoginView(Context from){
        Intent intent = new Intent();
        intent.setClass(from,Activity_Login.class);
        from.startActivity(intent);
    }

}
