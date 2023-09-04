package com.my_io.basic_usage;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.configuration.FileSystem;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FileDemo {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String getProjectPath() {
        String separator = File.separator;
        String baseDir = "src" + separator + "main" + separator + "java";
        String page = getClass().getPackage().getName();
        String[] strings = page.split("\\.");
        return System.getProperty("user.dir") + separator + baseDir + separator + String.join(separator, strings);
    }


    /**
     * 如果路径名存在且允许应用程序执行该文件，则为真
     * 实际它检测的是文件是否存在 文件权限是否满足执行  仅此而已
     */
    @Test
    public void canExecute() {
        String projectPath = getProjectPath();
        File file = new File(projectPath + File.separator + UUID.randomUUID().toString().substring(0, 12) + ".txt");
        //把下面注释就会返回false
        FileUtil.writeString(UUID.randomUUID().toString(), file, "UTF-8");
        System.out.println(file);
        System.out.println("Executable:" + file.canExecute());
    }

    /**
     * 方法按字典顺序比较两个抽象路径名。 此方法定义的顺序取决于操作系统
     */
    @Test
    public void compareTo() {
        String projectPath = getProjectPath();
        File aFile = new File(projectPath + File.separator + "a" + ".txt");
        File bFile = new File(projectPath + File.separator + "b" + ".txt");
        FileUtil.writeString(UUID.randomUUID().toString(), aFile, "UTF-8");
        FileUtil.writeString(UUID.randomUUID().toString(), bFile, "UTF-8");

        System.out.println(aFile);
        System.out.println(bFile);
        int compare = aFile.compareTo(bFile);
//        int compare = aFile.compareTo(aFile);
        /*
         * bFile.compareTo(aFile) = 1
         * aFile.compareTo(bFile) = -1
         * aFile.compareTo(aFile) = 0
         * */
        System.out.println(compare);

        new Thread(() -> {
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                logger.info(e.getMessage());
            }
            aFile.delete();
            bFile.delete();
            logger.info("delete finish file");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
        logger.info("end");
    }

    /**
     * 创建新文件
     * @throws IOException
     */
    @Test
    public void createNewFile() throws IOException {
        File file = new File(getProjectPath() + File.separator + "a" + ".txt");
        //假如已经存在这个文件那么会报错
        //创建出来的是空文件
        if (file.createNewFile()) {
            System.out.println("文件创建成功！");
        } else {
            System.out.println("出错了，该文件已经存在。");
        }
    }


    /**
     * 检测文件是否是隐藏文件
     * @throws IOException
     */
    @Test
    public void isHidden() throws IOException {

        /*
        The concept of hidden files/folders is very OS-specific and not accessible via the Java API.
        In Linux, files and folders whose name begins with a dot are hidden per default in many programs - doing that is easy.
        In Windows, "hidden" is a special flag stored in the file system. There is no Java API for changing it; you can use Runtime.exec() to run the attrib command.
        * */
        if (isWindows()) {
            File file = new File(getProjectPath() + File.separator + UUID.randomUUID().toString().substring(0, 12) + ".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("文件创建成功！");
            }
            // R ： 只读文件属性。A：存档文件属性。S：系统文件属性。H：隐藏文件属性。
            String sets = "attrib +H \"" + file.getAbsolutePath() + "\"";
            System.out.println(sets);
            // 运行命令
            Runtime.getRuntime().exec(sets);
            System.out.println(file);
        }

        if (isLinux()) {
            File file = new File(getProjectPath() + File.separator + "."+UUID.randomUUID().toString().substring(0, 12) + ".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("文件创建成功！");
            }
        /*
        例如，touch a.txt  则创建的文件不是隐藏文件，
　　touch .a.txt 则创建的文件是隐藏文件
        * */

        }

    }

    @Test
    public void test1(){
        Properties properties = System.getProperties();
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> objectEntry = iterator.next();
            System.out.println(objectEntry.getKey() + " "+ JSONUtil.toJsonStr(objectEntry.getValue()));
        }
    }

    @Test
    public void printProjectPath() {
        String projectPath = getProjectPath();
        System.out.println(projectPath);
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }



}
