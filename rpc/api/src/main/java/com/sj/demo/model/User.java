package com.sj.demo.model;

public class User {
    private String userName;
    private String account;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "{\"userName\":\""
                +userName+"\",\"account\":\""
                +account+"\",\"password\":\""
                +password+ "\"}";
    }
}
