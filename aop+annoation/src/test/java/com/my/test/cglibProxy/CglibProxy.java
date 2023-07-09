package com.my.test.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class CglibProxy implements MethodInterceptor {

    //MethodInterceptor 是net.sf.cglib.proxy.MethodInterceptor包下的，同时这个处理类实例化的时候就不需要再传参了

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 所以可以在这里  方法执行前写逻辑
        System.out.println("方法执行前执行");

        // 这个就是我们原本的方法执行
        Object o1 = methodProxy.invokeSuper(o, objects);

        // 所以可以在这里  方法执行后写逻辑
        System.out.println("方法执行后执行");
        return o1;
    }



}
