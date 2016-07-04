package com.ca.mobile.dao.userinfo;

import com.ca.mobile.entity.UserInfoEntity;
import com.ca.mobile.httpApi.CAHttpApiManager;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UserInfoDaoImpl implements IUserInfoDao {

    @Override
    public void Login(UserInfoEntity entity,Object object) {
        CAHttpApiManager.newInstance().login(entity.getPhoneNumber(),entity.getPassWard(),object);
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


}
