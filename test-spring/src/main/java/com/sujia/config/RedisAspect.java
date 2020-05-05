package com.sujia.config;

import com.sujia.dao.mapper.StudentMapper;
import com.sujia.entity.Student;
import io.lettuce.core.api.sync.RedisCommands;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RedisAspect {

    @Autowired
    RedisCommands<String,String> redisCommands;


    @Autowired
    StudentMapper mapper;

    @Pointcut("execution(* com.sujia.dao.mapper..*.*(..))")
    public void CachePointCut(){

    }

    @Around("execution(* com.sujia.dao.mapper.StudentMapper.findByNameAndPassword(..))")
    private Object addBeforePrint(ProceedingJoinPoint joinPoint) {
        /*
        search redis
         */
        System.out.println("add----before");
//        Signature signature = joinPoint.getSignature();
//        //获得方法签名
//        MethodSignature methodSignature = (MethodSignature)signature;
//        //获得参数名
//        String[] params = methodSignature.getParameterNames();
        Object args[] = joinPoint.getArgs();
        //参数
        if(args[0].getClass().equals(Student.class)){
            System.out.println("ok");
            Student student = (Student) args[0];
            String name = student.getSname();

            if(redisCommands.exists(name)>0){
                System.out.println("redis");
                String res = redisCommands.get(name);
                if(res!=null && res.equals(student.getSpwd())){
                    return student;
                }else{
                    student.setSpwd("");
                    System.out.println("密码错误");
                    return student;
                }
            }else{
                //从mysql中查
                 student = mapper.findByNameAndPassword(student);

                 return student;
            }
//            redisCommands.get(name);
        }
        System.out.println("no");
        return null;
    }

    @After("execution(* com.sujia.dao.mapper.StudentMapper.insertUser(..))")
    public void addAfterPoint(JoinPoint joinPoint){
        Object args[] = joinPoint.getArgs();
        //参数
        if(args[0].getClass().equals(Student.class)){
            Student student = (Student) args[0];
            System.out.println("insert to redis");
            redisCommands.set(student.Sname,student.Spwd);
        }
    }

}
