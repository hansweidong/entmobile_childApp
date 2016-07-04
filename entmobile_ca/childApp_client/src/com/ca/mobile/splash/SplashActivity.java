package com.ca.mobile.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ca.mobile.BaseActivity;
import com.ca.mobile.net.FastHttp;
import com.ca.mobile.net.IHttpResponse;
import com.ca.mobile.dao.userinfo.IUserInfoDao;
import com.ca.mobile.dao.userinfo.UserInfoDaoImpl;
import com.ca.mobile.entity.UserInfoEntity;
import com.ca.mobile.net.NetConfig;
import com.ca.mobile.net.PhoneNetworkManager;
import com.ca.mobile.net.ResponseEntity;
import com.ca.mobile.utils.FileManager;
import com.mobile.ca.R;

/**
 * Created by znxass on 16-5-15.
 */
public class SplashActivity extends BaseActivity implements IHttpResponse {

    private UserInfoEntity userInfoEntity;

    private static final int DelayTime = 3*1000;

    IUserInfoDao mIUserInfoDao;

    Runnable DelayRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d("wwd","SplashActivity DealyRunnable");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initInnerHandler();
        userInfoEntity = FileManager.getObject(this,"");
        boolean netOk = PhoneNetworkManager.isNetworkAvailable(this);
        if (userInfoEntity!=null&&netOk){
            mIUserInfoDao = new UserInfoDaoImpl();
            mIUserInfoDao.Login(userInfoEntity,this);
        }else {
            getHandler().postDelayed(DelayRunnable,DelayTime);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getHandler().removeCallbacks(DelayRunnable);
    }

    @Override
    public void onResponse(ResponseEntity entity) {
        if (entity.getStatus()== FastHttp.result_ok){

        }
    }
}
