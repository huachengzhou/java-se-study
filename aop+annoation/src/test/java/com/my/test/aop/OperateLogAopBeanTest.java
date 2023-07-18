package com.my.test.aop;


import cn.hutool.core.lang.UUID;
import com.my.aop.service.OperateLogBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class OperateLogAopBeanTest {

    @Autowired
    private OperateLogBean operateLogBean;

    /**
     * aop+注解使用
     * @throws Exception
     */
    @Test
    public void testExecute()throws Exception{
        String uuid = UUID.fastUUID().toString();
        operateLogBean.delData(uuid);
    }

}
