package com.ca.mobile.dao.userinfo;

import com.ca.mobile.entity.UserInfoEntity;
import com.ca.mobile.api.CAHttpApiManager;
import com.ca.mobile.net.PhoneNetworkManager;
import com.ca.mobile.utils.MD5;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UserInfoDaoImpl implements IUserInfoDao {

    private String Account;
    private String Password;

    private IUserInfoDaoImpBehavior mUserInfoDaoImpBehavior;

    @Override
    public void Login(UserInfoEntity entity,Object object) {
        Account = entity.getPhoneNumber();
        Password = entity.getPassword();
        if (CheckAccountInfo(Account, Password)) {
            Password =MD5.Md5(Password);
            CAHttpApiManager.newInstance().login(Account,Password,object);
        }else{
            if (mUserInfoDaoImpBehavior!=null){
                mUserInfoDaoImpBehavior.LoginError(IUserInfoDaoImpBehavior.OPERATE_ACCOUT_PSW_IS_NULL);
            }
        }
    }

    @Override
    public void Logout() {

    }

    @Override
    public void UpdateUserInfo(UserInfoEntity entity) {

    }

    @Override
    public void saveUserInfo(UserInfoEntity entity) {

    }


    /**
     * 判断密码和用户名是否为空
     *
     * @param userName
     * @param password
     * @return
     */
    private boolean CheckAccountInfo(String userName, String password) {
        boolean isRet = false;
        if (userName == null || userName.compareTo("") == 0 || password == null || password.compareTo("") == 0) {
            isRet = false;
        } else {
            isRet = true;
        }
        return isRet;
    }

    public void setIUserInfoDaoImpBehavior(IUserInfoDaoImpBehavior iUserInfoDaoImpBehavior) {
        this.mUserInfoDaoImpBehavior = iUserInfoDaoImpBehavior;
    }
}
