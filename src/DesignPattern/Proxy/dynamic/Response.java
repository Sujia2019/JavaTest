package DesignPattern.Proxy.dynamic;

import lombok.Data;

@Data
public class Response {
    private String responseId;
    //返回实体
    private Object res;

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }
}
