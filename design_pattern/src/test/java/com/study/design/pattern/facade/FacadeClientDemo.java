package com.study.design.pattern.facade;

import org.junit.Test;

/**
 * @author noatn
 * @description
 * @date 2023-06-27
 */
public class FacadeClientDemo {

    @Test
    public void testA(){
        FacadeClient client = new FacadeClient();
        client.execute();
    }

}
