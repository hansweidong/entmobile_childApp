package com.ca.mobile.ui.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ca.mobile.AppBasicConfig;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.BaseFragment;
import com.ca.mobile.dao.userinfo.IUserInfoDao;
import com.ca.mobile.dao.userinfo.IUserInfoDaoImpBehavior;
import com.ca.mobile.dao.userinfo.UserInfoDaoImpl;
import com.ca.mobile.entity.UserInfoEntity;
import com.ca.mobile.net.FastHttp;
import com.ca.mobile.net.IHttpResponse;
import com.ca.mobile.net.PhoneNetworkManager;
import com.ca.mobile.net.ResponseEntity;
import com.ca.mobile.ui.Activity_Login;
import com.ca.mobile.widget.CircularImage;
import com.ca.mobile.widget.TitleBarLayout;
import com.mobile.ca.R;

/**
 * Created by wuweidong on 16-7-12.
 * email:wwdhao163@163.com
 */
public class Fragment_Login extends BaseFragment implements IUserInfoDaoImpBehavior {

    public static final String FRAGMENT_TAG = "Fragment_Login";

    private CircularImage ca_icon;

    private TitleBarLayout titleBarLayout;

    private IUserInfoDao userInfoDao;

    private EditText accout_edt;

    private EditText psw_edt;

    private Button login_btn;

    private LoginOnResponse loginOnResponse;

    private View btn_forgetPsw;

    class TitleBarClickedListener implements TitleBarLayout.ITitleBarClickedListener{
        @Override
        public void onClickedTitleBar(int type) {
            if (type==TitleBarLayout.RIGHT){
                Message msg = new Message();
                msg.what = Activity_Login.Register_Code;
                ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
            }
        }
    }

    private TitleBarClickedListener titleBarClickedListener = new TitleBarClickedListener();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(R.layout.fragment_login,container,false);
        init();
        return mRootView;
    }

    private void init(){
        if (mRootView==null)
            return;
        initTitleBar();
        userInfoDao = new UserInfoDaoImpl();
        loginOnResponse = new LoginOnResponse();
        ca_icon = (CircularImage)mRootView.findViewById(R.id.ca_icon);
        ca_icon.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.ca_icon));
        ((UserInfoDaoImpl)userInfoDao).setIUserInfoDaoImpBehavior(this);
        accout_edt = (EditText)mRootView.findViewById(R.id.accout_edt);
        psw_edt = (EditText)mRootView.findViewById(R.id.password_edt);
        login_btn = (Button)mRootView.findViewById(R.id.login_btn);
        btn_forgetPsw = mRootView.findViewById(R.id.btn_forgetPsw);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PhoneNetworkManager.isNetworkAvailable(getActivity())){
                    String accout = accout_edt.getText().toString();
                    String psw = psw_edt.getText().toString();
                    UserInfoEntity entity = new UserInfoEntity(accout,psw);
                    userInfoDao.Login(entity,loginOnResponse);
                }else{
                    ((BaseActivity)getActivity()).ToastMessage("设备未连接网络");
                }
            }
        });
        btn_forgetPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = Activity_Login.ForgetPsw_Code;
                ((BaseActivity)getActivity()).getHandler().sendMessage(msg);
            }
        });
    }

    private void initTitleBar(){
        titleBarLayout = (TitleBarLayout)mRootView.findViewById(R.id.title_bar);
        titleBarLayout.setTitleBarTextInfo("登陆");
        titleBarLayout.setRightButtonTextInfo("注册");
        titleBarLayout.setITitleBarClickedListener(titleBarClickedListener);
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
    }

    @Override
    public void LoginError(int type) {
        if (type==IUserInfoDaoImpBehavior.OPERATE_ACCOUT_PSW_IS_NULL){
            ((BaseActivity)getActivity()).ToastMessage("账号或者密码不能为空");
        }
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
}
