package com.sj.controller;

import com.sj.model.Response;
import com.sj.model.User;
import com.sj.service.api.UserService;
import com.sj.statics.ReturnHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("岚贝贝");
        user.setUserAuth(0);
        user.setUserAccount("test");
        user.setUserPwd("123456");
        return user;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Response register(@RequestParam User user) {
        if(userService.doRegister(user)){
            return ReturnHelp.success();
        }
        return ReturnHelp.error();
    }

    /**
     * 校验账号是否被使用过
     * @param userAccount
     * @return
     */
    @RequestMapping("/account")
    @ResponseBody
    public Response account(@RequestParam String userAccount) {

        return ReturnHelp.error();
    }
}
