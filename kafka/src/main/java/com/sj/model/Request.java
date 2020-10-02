package com.sj.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {
    private Object data;
    private String code;
}
