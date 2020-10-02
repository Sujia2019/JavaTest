package com.sj.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private int userId;
    private String userAccount;
    private String userName;
    private int age;
    private String phoneNumber;
    private String email;
    private String photoUrl;
    private short gender;
    private String country;
    private String city;
    private Date birth;
}
