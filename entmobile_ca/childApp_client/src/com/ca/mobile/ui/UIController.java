package com.ca.mobile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;

import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.ui.login.Activity_Login;
import com.ca.mobile.ui.login.Activity_SelectedRole;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UIController {

    /**
     * activity的切换方式
     * @param context
     * @param intent
     */
    public static void slideActivity(Context context, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(context,
                R.anim.slide_in_from_right, R.anim.slide_out_from_left);
        try {
            ActivityCompat.startActivity((Activity) context, intent, options.toBundle());
        } catch (Throwable e) {
            Log.d(AppBasicConfig.APPTag, e.toString());
        }
    }

    /**
     * 跳转到登陆页面
     *
     * @param from
     */
    public static void toLoginView(Context from) {
        Intent intent = new Intent();
        intent.setClass(from, Activity_Login.class);
        slideActivity(from,intent);
    }

    /**
     * 跳转到角色选择页面
     *
     * @param from
     */
    public static void toSelectedRole(Context from){
        Intent intent = new Intent();
        intent.setClass(from, Activity_SelectedRole.class);
        slideActivity(from,intent);
    }
}
