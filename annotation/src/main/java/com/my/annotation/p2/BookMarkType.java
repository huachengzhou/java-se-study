package com.my.annotation.p2;

/**
 * 书签类型
 */
public enum BookMarkType {
    TEXT("书签文本"),
    IMAGE("图像"),
    PARAGRAPH("段落"),
    TABLE("表格"),
    DATE_TIME("日期-时间"),
    DATE("日期"),
    ;

    BookMarkType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
