package com.my.annotation.p2;


import lombok.Data;

@Data
public class Demo2Example {

    @Demo2Annotation(types = BookMarkType.TEXT)
    private String name;

    @Demo2Annotation(types = BookMarkType.TABLE)
    private String sheet ;


}
