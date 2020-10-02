package com.sj.service.api;

import com.sj.model.User;
import com.sj.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 登录
     *
     * @return
     */
    public UserInfo doLogin(User user);

    /**
     * 注册
     *
     * @return
     */
    public boolean doRegister(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public User modifyUser(User user);

    /**
     * 验证权限
     *
     * @param user
     * @return
     */
    public int verify(User user);

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    public UserInfo getUserInfo(User user);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    public UserInfo setUserInfo(UserInfo userInfo);

    /**
     * 上传头像
     * @param account
     * @param url
     * @return
     */
    public boolean updatePhoto(String account,String url);
}
