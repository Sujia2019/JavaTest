package com.sj.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private Object data;
    private String code;
    private String errorMsg;
}
