package com.sj.demo.param;

import lombok.Data;

@Data
public class Address {
    private String host;
    private String port;

    public Address() {

    }

    public Address(String url) {
        host = url.split(":")[0];
        port = url.split(":")[1];
    }
}
