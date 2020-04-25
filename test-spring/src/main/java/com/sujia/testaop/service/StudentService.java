package com.sujia.testaop.service;

import com.sujia.testaop.dao.StudentDao;
import com.sujia.testaop.dao.mapper.StudentMapper;
import com.sujia.testaop.entity.Student;
import com.sujia.testaop.test.CacheFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    StudentDao dao;

    @Autowired
    private StudentMapper mapper;


    public Student login(String name,String pwd){
//        dao.search(name);
        Student student = new Student();
        student.setSname(name);
        student.setSpwd(pwd);
        return mapper.findByNameAndPassword(student);
//        System.out.println("name:"+name);
    }

    public void regist(String name,String pwd){
        Student student = new Student();
        student.setSname(name);
        student.setSpwd(pwd);
        mapper.insertUser(student);
    }
}
