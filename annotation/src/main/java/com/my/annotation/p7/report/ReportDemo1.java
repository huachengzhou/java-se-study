package com.my.annotation.p7.report;

import com.my.annotation.p7.Demo7Annoation;
import com.my.annotation.p7.Demo7ReportAnnoation;
import com.my.annotation.p7.GroupTypeEnum;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/

@Demo7Annoation(typeEnum = GroupTypeEnum.GROUP_TYPE_TWO_ENUM)
@Demo7ReportAnnoation(title = "新闻xxx",strings = {""})
public class ReportDemo1 {
}
