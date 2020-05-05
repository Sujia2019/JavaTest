package com.sujia.dao.mapper;

import com.sujia.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("SELECT * FROM student WHERE Sname=#{Sname,jdbcType=VARCHAR} AND Spwd=#{Spwd,jdbcType=VARCHAR}")
    public Student findByNameAndPassword(Student student);

    @Insert("INSERT INTO student (Sname,Spwd) VALUES (#{Sname},#{Spwd})")
    public int insertUser(Student user);

}
