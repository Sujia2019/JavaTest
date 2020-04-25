package com.sujia.testaop.demo;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {


    @Pointcut("execution(* com.sujia.testaop.demo..*.*(..))") // the pointcut expression
    private void anyOldTransfer() {

    } // the pointcut signature


    @Before("com.sujia.testaop.demo.AopTest.anyOldTransfer()")
//    @After()
//    @Around()
    private void addBeforePrint() {
        /*
        search redis
         */
        System.out.println("add----before");
    }
}
