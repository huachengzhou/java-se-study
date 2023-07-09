package com.my.test.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class CglibTargetRun {

    //https://blog.csdn.net/weixin_44102992/article/details/128057243

    @Test
    public void test1(){
        // MethodInterceptor 方式
        CglibTarget cglibTarget = (CglibTarget) Enhancer.create(CglibTarget.class, new CglibProxy());
        cglibTarget.execute();

        // InvocationHandler 方式  与JDK一样，不需要类加载器了
//        Interface anInterface = (Interface) Enhancer.create(CglibProxyHandler.class, (new MyInterface()));
//        anInterface.execute();


    }

}
