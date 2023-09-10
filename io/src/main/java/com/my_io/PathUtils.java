package com.my_io;

import java.io.File;

/**
 * @author : chengdu
 * @date :  2023/9/9-09
 **/
public class PathUtils {

    public static String getProjectPath() {
        String separator = File.separator;
        String baseDir = "src" + separator + "main" + separator + "java";
        String page = PathUtils.class.getPackage().getName();
        String[] strings = page.split("\\.");
        return System.getProperty("user.dir") + separator + baseDir + separator + String.join(separator, strings);
    }


}
