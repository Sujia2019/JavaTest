package com.sujia.entity;


public class Student {
    public String id;
    public String Sname;
    public String Spwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSpwd() {
        return Spwd;
    }

    public void setSpwd(String spwd) {
        Spwd = spwd;
    }


    @Override
    public String toString(){
        return "Student(id:" +id+
                ",Sname:" +Sname+
                ",Spwd:" +Spwd+
                ")";
    }
}
