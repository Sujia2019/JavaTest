package com.sujia.test.he;

import org.springframework.stereotype.Component;

@Component
public class RedisCache {

    //从缓存获取数据
    public Object getDataFromRedis(String redisKey){
        return null;
    }


    //保存数据到redis
    public String saveDataToRedis(String redisKey,Object obj){

        return "";
    }
}
