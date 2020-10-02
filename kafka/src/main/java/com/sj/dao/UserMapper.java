package com.sj.dao;

import com.sj.model.User;
import com.sj.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select * from user where user_account=#{account}")
    public User getUserByAccount(String account) throws Exception;
    @Select("select * from user where user_name=#{name}")
    public User getUserByName(String name) throws Exception;
    @Insert("insert into user(user_account,user_name,user_pwd,user_auth) " +
            "values(#{userAccount},#{userName},#{userPwd}m#{userAuth})")
    public void setUser(User user) throws Exception;

    @Update("update user set user_name=#{userName}," +
            "user_pwd=#{userPwd}," +
            "user_auth=#{userAuth}")
    public void updateUser(User user) throws Exception;

    @Insert("insert into user_info(user_account,user_name) values(#{userAccount},#{userName})")
    public UserInfo initUserInfo(User user) throws Exception;

    @Update("update user set user_name=#{userName}" +
            ",gender=#{gender}" +
            ",birth=#{birth}" +
            ",age=#{age}" +
            ",phoneNumber=#{phoneNumber}" +
            ",email=#{email}" +
            ",country=#{country}" +
            ",city=#{city}" +
            ",photoUrl=#{photoUrl} where user_account=#{userAccount}")
    public void updateUserInfo(UserInfo userInfo)throws Exception;

    @Update("update user_info set photoUrl=#{url} where user_account=#{account}")
    public void updatePhotoUrl(String url,String account) throws Exception;
}
