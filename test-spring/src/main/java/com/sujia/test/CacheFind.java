package com.sujia.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
AOP缓存注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheFind {
    String key() default "";//存到缓存中的key，用户可以不写，如果为空串，表示自动生成key
    int seconds() default 0;//过期时间
}
