package com.ca.mobile.dao.userinfo;

import com.ca.mobile.entity.UserInfoEntity;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public interface IUserInfoDao  {
    /**
     * 登陆接口
     * @param entity
     * @param object 回调监听
     */
    public void Login(UserInfoEntity entity,Object object);

    /**
     * 账号注销
     */
    public void Logout();

    /**
     * 更新用户信息
     * @param entity
     */
    public void UpdateUserInfo(UserInfoEntity entity);

    /**
     * 保存用户信息
     * @param entity
     */
    public void saveUserInfo(UserInfoEntity entity);
}
