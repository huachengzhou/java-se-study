package com.my.test.jdkProxy;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class TargetProxyRun {


    @Test
    public void test1() {
        //创建目标对象
        final TargetExample target = new TargetExample();
        //获取增强对象
        MyAdvice advice = new MyAdvice();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象加载器
                target.getClass().getInterfaces(), //目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    @Override
                    //调用代理对象的任何方法，实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before(proxy, method, args);
                        BaseInvoke baseInvoke = new BaseInvoke();
                        //执行目标方法
                        Object invoke = advice.around(((b) -> {

                            try {
                                return method.invoke(target, args);
                            } catch (Exception e) {
                                //异常通知
                                advice.afterThrowing(e);
                                e.printStackTrace();
                                return null;
                            }
                        }), baseInvoke);
//                        Object invoke = method.invoke(target, args);//执行目标方法
                        //后置增强
                        advice.afterReturning(proxy, method, args, invoke);
                        return invoke;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save(new HashMap<>());

    }

    public static class BaseInvoke {
        private Object proxy;
        private Method method;
        private Object[] args;

        public Object getProxy() {
            return proxy;
        }

        public void setProxy(Object proxy) {
            this.proxy = proxy;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public Object[] getArgs() {
            return args;
        }

        public void setArgs(Object[] args) {
            this.args = args;
        }
    }


}
