package com.sj.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private String msgCode;   //消息代码  用于分辨处理
    private Object obj;

    public Message() {

    }

    public Message(String code, Object obj) {
        this.msgCode = code;
        this.obj = obj;
    }

}
