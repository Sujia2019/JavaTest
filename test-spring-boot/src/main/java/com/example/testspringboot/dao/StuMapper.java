package com.example.testspringboot.dao;

import com.example.testspringboot.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface StuMapper {

    @Insert("insert into student(stu_name,computer,math,english) " +
            "values (#{stu_name},#{computer},#{math},#{english})")
    public int insertStudent(Student student);

    @Select("select * from student where stu_name=#{name}")
    public Student searchStudent(String name);

}
