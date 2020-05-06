package com.sujia;

import com.sujia.config.ComponentConfig;
import com.sujia.entity.Student;
import com.sujia.mongo.GroupMsg;
import com.sujia.mongo.GroupService;
import com.sujia.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
//        StudentService studentService = context.getBean(StudentService.class);
//        studentService.regist("sujia","123456");
//        studentService.regist("test","2222");
//        Student student = studentService.login("test","2222");
//        System.out.println(student);
//
        GroupService groupService = context.getBean(GroupService.class);
//        groupService.createGroup(groupMsg);

        groupService.delManager("444","5");
    }
}
