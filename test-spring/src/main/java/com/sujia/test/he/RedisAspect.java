//package com.sujia.testaop.test.he;
//
//import com.itweb.Cache.RedisCache;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Aspect
//@Component
//public class RedisAspect {
//
//    @Autowired
//    private RedisCache redisCache;
//
//    /**
//     * 定义切入点
//     */
//    @Pointcut("execution(* com.itweb.Cache.RedisCache(..))")
//    public void CachePointCut(){
//
//    }
//
//    /**
//     * 环绕处理，先从Redis中获取缓存，查询不到，就查询mysql
//     * 然后再保存到Redis缓存里
//     * @param joinPoint
//     * @throws Throwable
//     */
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
//
//
//
//
//}
