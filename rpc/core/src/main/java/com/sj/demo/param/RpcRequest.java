package com.sj.demo.param;

import lombok.Data;

@Data
public class RpcRequest {
    // 请求id
    private String requestId;
    // 请求创建时间
    private long createMillisTime;
    // token
    private String accessToken;
    // 类名全限定名
    private String className;
    // 方法名
    private String methodName;
    // 参数列表
    private Class<?>[] parameterTypes;
    // 参数
    private Object[] parameters;
    // 版本号
    private String version;
}
