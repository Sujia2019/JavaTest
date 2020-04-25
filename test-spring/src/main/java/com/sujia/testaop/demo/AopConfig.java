package com.sujia.testaop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.sujia.testaop.demo")
@EnableAspectJAutoProxy
public class AopConfig {

}
