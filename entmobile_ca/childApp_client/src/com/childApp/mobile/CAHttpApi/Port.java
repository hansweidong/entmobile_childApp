package com.childApp.mobile.CAHttpApi;

import com.ca.mobile.AppBasicConfig;

/**
 * Created by wuweidong on 16-6-29.
 * email:wwdhao163@163.com
 * 类型的描述:
 * 请求接口
 */
public class Port {
    /**
     * @note 登陆接口
     */
    public static final String loginUrl = AppBasicConfig.URL() + "/users/login";

    /**
     * @note 注册接口
     */
    public static final String RegisterUrl = AppBasicConfig.URL() + "/users/register";

    /**
     * @NOTE 手机验证码接口
     */
    public static final String VerifyPhoneUrl = AppBasicConfig.URL() + "/users/verifyPhone";

    /**
     * @note 密码重置接口
     */
    public static final String PasswordResetUrl = AppBasicConfig.URL() + "/users/reset";

    /**
     * @NOTE 更新个人信息接口
     */
    public static final String updateUserInfoUrl = AppBasicConfig.URL() + "/users/updateInfo";

    /**
     * @note 注销接口
     */
    public static final String logOutUrl = AppBasicConfig.URL() + "/users/logout";

    /**
     * @note 获得机构id
     */
    public static final String getOrgsUrl = AppBasicConfig.URL() + "/organizations/getOrgs";

    /**
     * @note 获得老师列表
     */
    public static final String getTeacherList = AppBasicConfig.URL() + "/organizations/members";

    /**
     * @note 机构负责人手动添加教师
     */
    public static final String AddTeacherURrl = AppBasicConfig.URL() + "/organizations/addTeacher";

    /**
     * @note 改变权限
     */
    public static final String ChangePermissionUrl = AppBasicConfig.URL() + "/organizations/changePermission?";

    /**
     * @note 创建一个机构
     */
    public static final String CreateOrgUrl = AppBasicConfig.URL() + "/organizations/createOrg";

    /**
     * @note 申请成为机构老师
     */
    public static final String JoinReqUrl = AppBasicConfig.URL() + "/organizations/joinReq";

    /**
     * @note 获得教师申请列表
     */
    public static final String JoinReqListUrl = AppBasicConfig.URL() + "/organizations/joinReqList";

    /**
     * @note 操作加入机构的申请
     */
    public static final String OptionJoinReqUrl = AppBasicConfig.URL() + "/organizations/optionJoinReq";

    /**
     * @note 删除老师
     */
    public static final String RemoveTeacherUrl = AppBasicConfig.URL() + "/organizations/removeTeacher";

    /**
     * @note 更新机构信息
     */
    public static final String getUpdateUserInfoUrl = AppBasicConfig.URL() + "/organizations/updateinfo";

    /**
     * @note 设置身份
     */
    public static final String setRoleUrl = AppBasicConfig.URL() + "/users/setRole";

    /**
     * @note 获取验证码
     */
    public static final String sendSmsCodeUrl = AppBasicConfig.URL() + "/sms/sendSmsCode";

    /**
     * @note 上传图片
     */
    public static final String uploadPicturesUrl = AppBasicConfig.URL() + "/pictures/uptoken";
}
