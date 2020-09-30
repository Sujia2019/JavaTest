package com.sj.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userAccount;
    private String userName;
    private String userPwd;
    private int userAuth;
}
