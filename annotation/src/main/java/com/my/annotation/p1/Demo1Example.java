package com.my.annotation.p1;

import lombok.Data;

@Data
public class Demo1Example {

    @Demo1Annotation(title = "名称",desc = "描述",num = 2)
    private String name;

    @Demo1Annotation(title = "其它",desc = "无",num = 3)
    private String other;

}
