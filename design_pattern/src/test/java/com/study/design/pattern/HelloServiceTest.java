package com.study.design.pattern;


import com.study.design.pattern.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//DesignPatternApplication
@SpringBootTest(classes = DesignPatternApplication.class)
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void hello() {
        System.out.println(helloService);
    }

}
