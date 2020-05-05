package com.sujia.dao;

import org.springframework.stereotype.Component;

@Component
public class StudentDao {

    public void search(String name){
        System.out.println("search:"+name);
    }
}
