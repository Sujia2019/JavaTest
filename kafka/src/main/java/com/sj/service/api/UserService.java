package com.sj.service.api;

import com.sj.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 登录
     *
     * @return
     */
    public User doLogin();

    /**
     * 注册
     *
     * @return
     */
    public boolean doRegister();

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public User modifyUserInfo(User user);

    /**
     * 验证权限
     *
     * @param user
     * @return
     */
    public int verify(User user);
}
