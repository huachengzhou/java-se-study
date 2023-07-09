package com.my.aop.aspest;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/

@Component
@Aspect
public class DemoAspest1 {


    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Pointcut(value = "execution(* com.my.aop.service.HelloWorld.*(..))")
    public void point(){
        logger.info(this.getClass().getSimpleName()+"point()");
    }

    @Before(value = "point()")
    public void aspBefore(){
        logger.info(this.getClass().getSimpleName()+"aspBefore()");
    }

    @After(value = "point()")
    public void aspAfter(){
        logger.info(this.getClass().getSimpleName()+"aspAfter()");
    }

    @AfterReturning(value = "point()",returning = "o")
    public void aspAfterReturning(Object o){
        logger.info(this.getClass().getSimpleName()+"aspAfterReturning params:"+o);
    }

    @AfterThrowing(value = "point()",throwing = "e")
    public void aspAfterThrowing(Exception e){
        logger.log(Level.ALL,this.getClass().getSimpleName()+"aspAfterThrowing()",e);
    }

}
