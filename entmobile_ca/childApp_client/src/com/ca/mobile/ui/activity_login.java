package com.ca.mobile.ui;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.ui.fragment.Fragment_Login;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-10.
 * email:wwdhao163@163.com
 */
public class Activity_Login extends BaseActivity{

    public static final short ForgetPsw_Code = 1; //忘记密码
    public static final short Register_Code = 2;//注册
    public static final short Login_Success = 3;//登陆成功

    @Override
    protected void HandlerMessage(Message msg) {
        super.HandlerMessage(msg);
        if (msg.what==ForgetPsw_Code){
            Log.d(AppBasicConfig.APPTag,"code="+ForgetPsw_Code);
        }else if(msg.what==Register_Code){
            Log.d(AppBasicConfig.APPTag,"code="+Register_Code);
        }else if (msg.what==Login_Success){
            Log.d(AppBasicConfig.APPTag,"code="+Login_Success);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment_Login fragment_login = new Fragment_Login();
        transaction.add(R.id.login_contaier_rl, fragment_login, Fragment_Login.FRAGMENT_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
