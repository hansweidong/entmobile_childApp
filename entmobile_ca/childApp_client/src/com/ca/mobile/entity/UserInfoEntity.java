package com.ca.mobile.entity;

import java.io.Serializable;

/**
 * Created by wuweidong on 16-7-5.
 * email:wwdhao163@163.com
 */
public class UserInfoEntity implements Serializable {

    private String account;

    private String phoneNumber;

    private String passWard;

    private String Identity;

    private boolean isCacheAvatar;//是否缓存了本地头像

    private String username;

    private int role;

    private String avatar;

    private String id;

    private String showId;

    private String password;

    private String token;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String identity) {
        Identity = identity;
    }

    public boolean isCacheAvatar() {
        return isCacheAvatar;
    }

    public void setCacheAvatar(boolean cacheAvatar) {
        isCacheAvatar = cacheAvatar;
    }

    public String getPassWard() {
        return passWard;
    }

    public void setPassWard(String passWard) {
        this.passWard = passWard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
