package com.my.test.cglibProxy;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class CglibProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 所以可以在这里  方法执行前写逻辑
        System.out.println("方法执行前执行");

        // 这个就是我们原本的方法执行
        Object invoke = method.invoke(o, objects);

        // 所以可以在这里  方法执行后写逻辑
        System.out.println("方法执行后执行");
        return invoke;
    }
}
