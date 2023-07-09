package com.my.test.jdkProxy;

import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class MyAdvice {

    /**
     * 前置通知
     */
    public void before(Object proxy, Method method, Object[] args){

    }

    /**
     * 后置通知
     */
    public void afterReturning(Object proxy, Method method, Object[] args,Object returnObj) {


    }

    /**
     * 环绕通知
     * @param function
     * @param invoke
     * @return
     * @throws Throwable
     */
    public Object around(Function<TargetProxyRun.BaseInvoke,Object> function,TargetProxyRun.BaseInvoke invoke) throws Throwable{
       return function.apply(invoke) ;
    }


    /**
     * 异常通知
     * @param ex
     */
    public void afterThrowing(Exception ex){

    }
}
