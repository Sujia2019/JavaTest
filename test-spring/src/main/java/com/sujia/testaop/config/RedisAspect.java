package com.sujia.testaop.config;

import com.sujia.testaop.dao.mapper.StudentMapper;
import com.sujia.testaop.entity.Student;
import io.lettuce.core.api.sync.RedisCommands;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RedisAspect {

    @Autowired
    RedisCommands<String,String> redisCommands;


    @Autowired
    StudentMapper mapper;

    @Pointcut("execution(* com.sujia.testaop.dao.mapper..*.*(..))")
    public void CachePointCut(){

    }

    @Around("execution(* com.sujia.testaop.dao.mapper.StudentMapper.findByNameAndPassword(..))")
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

    @After("execution(* com.sujia.testaop.dao.mapper.StudentMapper.insertUser(..))")
    public void addAfterPoint(JoinPoint joinPoint){
        Object args[] = joinPoint.getArgs();
        args[0]
        redisCommands
    }


//    @Around("CachePointCut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
//        //前置： 从Redis中获取缓存
//
//        long startTime = System.currentTimeMillis();
//        String applId = null;
//        Object[] args = joinPoint.getArgs();
//        if (args != null && args.length > 0) {
//            applId = String.valueOf(args[0]);
//        }
//
//        //获取目标方法所在类
//        String target = joinPoint.getTarget().toString();
//        String className = target.split("@")[0];
//
//        //获取目标方法的方法名称
//        String methodName = joinPoint.getSignature().getName();
//
//        //redis中key格式：    applId:方法名称
//        String redisKey = applId + ":" + className + "." + methodName;
//        Object obj = redisCache.getDataFromRedis(redisKey);
//        if (obj!=null){
//           // Logger.info("Redis查到了数据");
//            //Logger.info("Key:" +redisKey);
//            //Logger.info("Value:" +obj.toString());
//            return obj;
//        }
//        //Logger.info("Redis没有查到了数据");
//        try{
//            obj = joinPoint.proceed();
//        }catch(Throwable e){
//            e.printStackTrace();
//        }
//        //LOGGER.info("**********开始从MySQL查询数据**********");
//        //后置：将数据库查到的数据保存到Redis
//        String code = redisCache.saveDataToRedis(redisKey,obj);
//        if(code.equals("OK")){
//           // LOGGER.info("**********数据成功保存到Redis缓存!!!**********");
//          //  LOGGER.info("Redis的KEY值:"+redisKey);
//          //  LOGGER.info("REDIS的VALUE值:"+obj.toString());
//        }
//        return obj;
//    }
}
