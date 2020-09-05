package com.example.testspringboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("student")
public class Student {

    @Field("name")
    private String stu_name;
    private int computer;
    private int math;
    private int english;

}
