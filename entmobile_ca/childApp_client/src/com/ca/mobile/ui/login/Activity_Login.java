package com.ca.mobile.ui.login;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.ui.UIController;
import com.ca.mobile.ui.fragment.Fragment_Login;
import com.ca.mobile.ui.fragment.Fragment_PlatformPotocol;
import com.ca.mobile.ui.fragment.Fragment_Register;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-10.
 * email:wwdhao163@163.com
 */
public class Activity_Login extends BaseActivity{

    public static final short Login_Code = 0;//登陆页
    public static final short ForgetPsw_Code = 1; //忘记密码
    public static final short Register_Code = 2;//注册
    public static final short PlatFormProtocol_code = 3;//平台协议
    public static final short Login_Success = 4;//登陆成功
    private Fragment_Login fragment_login;
    private int curCode = Login_Code;
    private int preCode = Login_Code;
    @Override
    protected void HandlerMessage(Message msg) {
        super.HandlerMessage(msg);
        if (msg.what==ForgetPsw_Code){
            curCode = ForgetPsw_Code;
            Log.d(AppBasicConfig.APPTag,"code="+ForgetPsw_Code);
            BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_Register.FRAGMENT_TAG);
            if (fragment == null){
                fragment = Fragment_Register.newInstance();
            }
            if (fragment.getArguments()!=null){
                fragment.getArguments().putInt("type",ForgetPsw_Code);
            }else{
                Bundle bundle = new Bundle();
                bundle.putInt("type",ForgetPsw_Code);
                fragment.setArguments(bundle);
            }
            preCode = Login_Code;
            switchContent(fragment_login,fragment,R.id.login_contaier_rl,Fragment_Register.FRAGMENT_TAG,true);
        }else if(msg.what==Register_Code){
            curCode = Register_Code;
            Log.d(AppBasicConfig.APPTag,"code="+Register_Code);
            BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_Register.FRAGMENT_TAG);
            if (fragment == null){
                fragment = Fragment_Register.newInstance();
            }
            boolean agreeProtocol = false;
            if (msg.obj!=null){
                agreeProtocol = (boolean)msg.obj;
            }
            if (fragment.getArguments()!=null){
                fragment.getArguments().putInt("type",Register_Code);
                fragment.getArguments().putBoolean("agreeProtocol",agreeProtocol);
            }else{
                Bundle bundle = new Bundle();
                bundle.putInt("type",Register_Code);
                bundle.putBoolean("agreeProtocol",agreeProtocol);
                fragment.setArguments(bundle);
            }
            preCode = Login_Code;
            BaseFragment from = fragment_login;
            if (msg.arg1==Register_Code){
                getSupportFragmentManager().popBackStack();
            }else {
                switchContent(from, fragment, R.id.login_contaier_rl, Fragment_Register.FRAGMENT_TAG, true);
            }
        }else if (msg.what==Login_Success){
            Log.d(AppBasicConfig.APPTag,"code="+Login_Success);
            UIController.toSelectedRole(mContext);
            finish();
        } else if (msg.what==Login_Code) {
            curCode = Login_Code;
            getSupportFragmentManager().popBackStack();
        } else if (msg.what==PlatFormProtocol_code){
            curCode = PlatFormProtocol_code;
            Log.d(AppBasicConfig.APPTag,"code="+PlatFormProtocol_code);
            BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(Fragment_PlatformPotocol.FRAGMENT_TAG);
            if (fragment == null){
                fragment = Fragment_PlatformPotocol.newInstance();
            }
            BaseFragment from = (BaseFragment)getSupportFragmentManager().findFragmentByTag(Fragment_Register.FRAGMENT_TAG);
            if (from == null){
                from = Fragment_Register.newInstance();
            }
            preCode = Register_Code;
            switchContent(from,fragment,R.id.login_contaier_rl,Fragment_PlatformPotocol.FRAGMENT_TAG,true);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment_login = Fragment_Login.newInstance();
        transaction.add(R.id.login_contaier_rl, fragment_login, Fragment_Login.FRAGMENT_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (Login_Code==curCode){
            finish();
        }else{
            super.onBackPressed();
            if (curCode == PlatFormProtocol_code){
                curCode = Register_Code;
                preCode = Login_Code;
            }else
                curCode = preCode;
        }
    }
}
