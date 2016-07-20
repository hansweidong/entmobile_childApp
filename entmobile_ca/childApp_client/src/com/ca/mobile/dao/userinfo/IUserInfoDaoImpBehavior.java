package com.ca.mobile.dao.userinfo;

/**
 * Created by wuweidong on 16-7-12.
 * email:wwdhao163@163.com
 */
public interface IUserInfoDaoImpBehavior {

    int OPERATE_ACCOUT_PSW_IS_NULL = 1;//账号或者密码不能为空

    /**
     * 登陆发生错误
     * @param type
     */
    void LoginError(int type);

    void DebugBehavior(int type);
}
