package com.study.design.pattern.template_pattern;

import com.study.design.pattern.template_pattern.v1.CaffeineBeverageClient;
import org.junit.Test;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class CaffeineBeverageClientDemo {

    @Test
    public void test1(){
        CaffeineBeverageClient client = new CaffeineBeverageClient();
        client.execute();
    }
}
