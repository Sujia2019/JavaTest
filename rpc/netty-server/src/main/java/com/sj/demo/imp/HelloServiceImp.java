package com.sj.demo.imp;

import com.sj.demo.HelloService;

public class HelloServiceImp implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("["+name+"] say Hello");
    }

    @Override
    public void sayHello() {
        System.out.println("default say hello");
    }
}
