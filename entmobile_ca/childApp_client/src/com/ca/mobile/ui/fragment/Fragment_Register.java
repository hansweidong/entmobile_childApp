package com.ca.mobile.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.dao.userinfo.IUserInfoDao;
import com.ca.mobile.dao.userinfo.IUserInfoDaoImpBehavior;
import com.ca.mobile.dao.userinfo.UserInfoDaoImpl;
import com.ca.mobile.net.FastHttp;
import com.ca.mobile.net.IHttpResponse;
import com.ca.mobile.net.ResponseEntity;
import com.ca.mobile.ui.login.Activity_Login;
import com.ca.mobile.utils.ScreenManager;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-12.
 * email:wwdhao163@163.com
 */
public class Fragment_Register extends BaseFragment implements IUserInfoDaoImpBehavior {

    public static final String FRAGMENT_TAG = "Fragment_Register";


    private TitleBarLayout titleBarLayout;

    private IUserInfoDao userInfoDao;

    private EditText accout_edt;

    private EditText psw_edt;

    private EditText yzm_edt;

    private Button register_btn;

    private TextView user_protocol_tv;

    private LoginOnResponse loginOnResponse;

    private int UIType = Activity_Login.Login_Code;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            if (type==TitleBarLayout.LEFT){
                Message msg = new Message();
                msg.what = Activity_Login.Login_Code;
                ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
            }
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

    public static Fragment_Register newInstance(){
        Fragment_Register fragment_register = new Fragment_Register();
        return fragment_register;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (bundle!=null)
            UIType = bundle.getInt("type");
        mRootView = inflater.inflate(R.layout.fragment_register,container,false);
        init();
        return mRootView;
    }

    private void init(){
        if (mRootView==null)
            return;
        initTitleBar(UIType);
        userInfoDao = new UserInfoDaoImpl();
        loginOnResponse = new LoginOnResponse();
        ((UserInfoDaoImpl)userInfoDao).setIUserInfoDaoImpBehavior(this);
        accout_edt = (EditText)mRootView.findViewById(R.id.accout_edt);
        yzm_edt = (EditText)mRootView.findViewById(R.id.yzm_edt);
        psw_edt = (EditText)mRootView.findViewById(R.id.password_edt);
        register_btn = (Button)mRootView.findViewById(R.id.register_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UIType == Activity_Login.ForgetPsw_Code){

                }else if (UIType == Activity_Login.Register_Code){

                }
            }
        });
        user_protocol_tv = (TextView)mRootView.findViewById(R.id.user_protocol_tv);
        user_protocol_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = Activity_Login.PlatFormProtocol_code;
                ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
            }
        });
        setUIInfo();
    }

    private void initTitleBar(int type){
        titleBarLayout = (TitleBarLayout)mRootView.findViewById(R.id.title_bar);
        if (Activity_Login.Register_Code==type) {
            titleBarLayout.setTitleBarTextInfo("注册");
        }else if (Activity_Login.ForgetPsw_Code==type){
            titleBarLayout.setTitleBarTextInfo("重置密码");
        }
        titleBarLayout.setLeftButtonInfo();
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
    }

    private void setUIInfo(){
        if (UIType == Activity_Login.Register_Code){
            register_btn.setText("注册");
            user_protocol_tv.setVisibility(View.VISIBLE);
            Drawable drawable = null;
            if (bundle.getBoolean("agreeProtocol")){
                drawable = getResources().getDrawable(R.drawable.checkbox_selected);
            }else {
                drawable = getResources().getDrawable(R.drawable.checkbox_normal);
            }
            if (drawable!=null) {
                int w = ScreenManager.dip2px(12);
                int h = ScreenManager.dip2px(12);
                int paddingleft = ScreenManager.dip2px(5);
                drawable.setBounds(0, 0, w, h);
                user_protocol_tv.setCompoundDrawablePadding(paddingleft);
                user_protocol_tv.setCompoundDrawables(drawable, null, null, null);
            }
            user_protocol_tv.setText(R.string.user_protocol);
        }else if (UIType == Activity_Login.ForgetPsw_Code){
            register_btn.setText("重置");
            user_protocol_tv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (userInfoDao!=null){
            ((UserInfoDaoImpl)userInfoDao).setIUserInfoDaoImpBehavior(null);
            userInfoDao = null;
        }
        if (loginOnResponse!=null)
            loginOnResponse = null;
        titleBarClickedListener = null;
    }

    @Override
    public void LoginError(int type) {

    }

    @Override
    public void DebugBehavior(int type) {

    }

    class LoginOnResponse implements IHttpResponse {
        @Override
        public void onResponse(ResponseEntity entity) {
            if (entity.getStatus()== FastHttp.result_ok){
                Log.d(AppBasicConfig.APPTag,entity.getContentAsString());
            }else if (entity.getStatus() == FastHttp.TimeOut){
                ((BaseActivity)getActivity()).ToastMessage("网络连接超时");
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
           int curType = bundle.getInt("type");
           if (curType!=UIType){
               UIType = curType;
               initTitleBar(UIType);
           }
            setUIInfo();
        }
    }

    /**
     * 注册按钮的处理事件
     */
    private void registerClickedEvent(){

    }

    /**
     * 重置密码的处理事件
     */
    private void resetPswClickedEvent(){

    }
}
