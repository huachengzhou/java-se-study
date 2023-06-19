package com.study;

import com.study.design.pattern.annotation.PkgAnnotation;
import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author : chengdu
 * @date :  2023/6/19-06
 **/
public class ClientDemoPage {

    public static void main(String[] args) {
        new ClientDemoPage().test1();
    }

    @Test
    public void test1(){
        //可以通过I/O操作或配置项获得包名
        String pkgName = "com.study.design.pattern";
        Package pkg = Package.getPackage(pkgName);
        //获得包上的注解
        Annotation[] annotations = pkg.getAnnotations();
        //遍历注解数组
        for(Annotation an:annotations){
            if(an instanceof PkgAnnotation){
                System.out.println("Hi,I'm the PkgAnnotation");

            }
        }
    }
}
