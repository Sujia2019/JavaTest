package DesignPattern.BuilderPattern.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;

    public User(String name){
        this.name = name;
    }
}
