package com.sj.demo.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcResponse implements Serializable {
    private static final long serialVersionUID = 32L;
    private String responseId;
    private Object retObject;
    private String errorMsg;
}
