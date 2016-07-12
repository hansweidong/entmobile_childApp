package com.ca.mobile.splash;

import android.os.Bundle;
import android.util.Log;
import com.ca.mobile.BaseActivity;
import com.ca.mobile.dao.userinfo.IUserInfoDaoImpBehavior;
import com.ca.mobile.net.FastHttp;
import com.ca.mobile.net.IHttpResponse;
import com.ca.mobile.dao.userinfo.IUserInfoDao;
import com.ca.mobile.dao.userinfo.UserInfoDaoImpl;
import com.ca.mobile.entity.UserInfoEntity;
import com.ca.mobile.net.PhoneNetworkManager;
import com.ca.mobile.net.ResponseEntity;
import com.ca.mobile.ui.UIController;
import com.ca.mobile.utils.FileManager;
import com.mobile.ca.R;

/**
 * Created by znxass on 16-5-15.
 */
public class SplashActivity extends BaseActivity implements IUserInfoDaoImpBehavior {

    private UserInfoEntity userInfoEntity;

    private static final int DelayTime = 3*1000;

    private IUserInfoDao mIUserInfoDao;

    private SplashOnResponse splashOnResponse;

    Runnable DelayRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d("wwd","SplashActivity DealyRunnable");
            UIController.toLoginView(mContext);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        userInfoEntity = FileManager.getObject(this,"");
        splashOnResponse = new SplashOnResponse();
        boolean netOk = PhoneNetworkManager.isNetworkAvailable(this);
        if (userInfoEntity!=null&&netOk){
            mIUserInfoDao = new UserInfoDaoImpl();
            ((UserInfoDaoImpl)mIUserInfoDao).setIUserInfoDaoImpBehavior(null);
            mIUserInfoDao.Login(userInfoEntity,splashOnResponse);
        }else {
            getHandler().postDelayed(DelayRunnable,DelayTime);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIUserInfoDao!=null){
            ((UserInfoDaoImpl)mIUserInfoDao).setIUserInfoDaoImpBehavior(null);
        }
    }

    @Override
    public void LoginError(int type) {

    }

    static class SplashOnResponse implements IHttpResponse{
        @Override
        public void onResponse(ResponseEntity entity) {
            if (entity.getStatus()== FastHttp.result_ok){

            }
        }
    }
}
