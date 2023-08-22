package www.databases;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2018 {

    public static final String NUMBER = "2018";
    public List<String> tableNameList = new LinkedList<>();
    public List<String> tableNameIgnoreList = Lists.newArrayList("001", "002", "003");
    public List<String> tableNameUseList = Lists.newArrayList("668");


    @Before
    public void updateTableName() {
        String path = "H:\\line\\2018";
        List<String> stringList = FileUtil.listFileNames(path);
        for (String pathA : stringList) {
            String[] strings = pathA.split("_");
            if (strings.length == 0) {
                continue;
            }
            String string = strings[0];
            if (!NumberUtil.isNumber(string)) {
                continue;
            }
            tableNameList.add(string);
        }
        tableNameList.addAll(tableNameUseList) ;
        if (CollUtil.isNotEmpty(tableNameList)) {
            tableNameList = tableNameList.stream().distinct().filter(s -> !tableNameIgnoreList.contains(s)).sorted().collect(Collectors.toList());
        }
//        tableNameList.forEach(s -> System.out.println(s));
    }

    @Test
    public void execute() {

    }

    @Test
    public void countCheck(){
        final String template = " select  '{line}' as line,count(distinct DATE_FORMAT(`交易时间`,'%y年-%m月') ) as count    FROM line_{line}_{year}  ;";

        for (String tablePar:tableNameList){
            String replace = StrUtil.replace(template, "{line}", tablePar);
            replace = StrUtil.replace(replace, "{year}", NUMBER);

            System.out.println(replace);
            System.out.println();
        }
    }

    @Test
    public void selectCheck(){
        final String template = "\n" +
                "# 校验数据是否正确 {line} \n" +
                " select  distinct DATE_FORMAT(`交易时间`,'%y年-%m月') as trade_time  FROM line_{line}_{year}  order by trade_time;";

        for (String tablePar:tableNameList){
            String replace = StrUtil.replace(template, "{line}", tablePar);
            replace = StrUtil.replace(replace, "{year}", NUMBER);

            System.out.println(replace);
            System.out.println();
        }
    }

    @Test
    public void checkUpdate(){
        final String template = "\n" +
                "# 校验数据是否正确\n" +
                "-- select  distinct DATE_FORMAT(`交易时间`,'%y年-%m月') as trade_time  FROM line_{line}_{year}  order by trade_time;\n" +
                "# 删除卡号=卡号\n" +
                "delete from line_{line}_{year} where 1=1 and  卡号 = '卡号' ;\n" +
                "# 查询卡号=卡号\n" +
                "-- select * from line_{line}_{year} where   卡号 = '卡号' ;\n" ;

        for (String tablePar:tableNameList){
            String replace = StrUtil.replace(template, "{line}", tablePar);
            replace = StrUtil.replace(replace, "{year}", NUMBER);

            System.out.println(replace);
            System.out.println();
        }
    }

    @Test
    public void printTableName() {
        final String template = "CREATE TABLE `line_{line}_{year}` (\n" +
                "  `卡号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `卡类型编号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `卡类型名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易时间` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `卡交易序号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `线路` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `车辆` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `终端` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `终端交易序号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `SAM卡交易序号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易金额` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易票价` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易后卡余额` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易类型` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易小类` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易类型名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `交易小类名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `上下行` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `站点编号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `站点名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL,\n" +
                "  `时间戳` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_as_cs DEFAULT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_as_cs;";

        for (String tablePar:tableNameList){
            String replace = StrUtil.replace(template, "{line}", tablePar);
            replace = StrUtil.replace(replace, "{year}", NUMBER);

            System.out.println(replace);
            System.out.println();
        }
    }


}
