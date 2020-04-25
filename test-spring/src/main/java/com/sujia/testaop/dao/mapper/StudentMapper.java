package com.sujia.testaop.dao.mapper;

import com.sujia.testaop.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("SELECT * FROM student WHERE Sname=#{Sname,jdbcType=VARCHAR} AND Spwd=#{Spwd,jdbcType=VARCHAR}")
    public Student findByNameAndPassword(Student student);

    @Insert("INSERT INTO student (Sname,Spwd) VALUES (#{Sname},#{Spwd})")
    public int insertUser(Student user);

}
