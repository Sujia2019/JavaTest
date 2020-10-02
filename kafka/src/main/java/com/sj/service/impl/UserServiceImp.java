package com.sj.service.impl;

import com.sj.model.User;
import com.sj.model.UserInfo;
import com.sj.service.api.UserService;

public class UserServiceImp implements UserService {

    @Override
    public UserInfo doLogin(User user) {
        return null;
    }

    @Override
    public boolean doRegister(User user) {
        return false;
    }

    @Override
    public User modifyUser(User user) {
        return null;
    }

    @Override
    public int verify(User user) {
        return 0;
    }

    @Override
    public UserInfo getUserInfo(User user) {
        return null;
    }

    @Override
    public UserInfo setUserInfo(UserInfo userInfo) {
        return null;
    }

    @Override
    public boolean updatePhoto(String account, String url) {
        return false;
    }
}
