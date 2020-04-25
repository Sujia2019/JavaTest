package com.sujia.testaop.dao;

import org.springframework.stereotype.Component;

@Component
public class StudentDao {

    public void search(String name){
        System.out.println("search:"+name);
    }
}
