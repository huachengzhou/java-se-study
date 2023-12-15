package regex.code1;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author noatn
 * @description 雷波县人民医院
 * @date 2023-12-14
 */
public class TemplateDemo {

    @Test
    public void test2(){
        DecimalFormat df4 = new DecimalFormat("#,##0.00");//格式化成有千分号的样式
        System.out.println(df4.format(new BigDecimal("13402.56")));
    }

    @Test
    public void test1() throws Exception {
        String regex = "[-+]?\\d+(\\.\\d+)?";

        String input = "+--------------+-------------+------------------------------------------+\n" +
                "| 全部采购     | 带量采购    | ROUND(SUM(带量采购)/SUM(全部采购),4)*100 |\n" +
                "+--------------+-------------+------------------------------------------+\n" +
                "| 8803852.6400 | 125302.4600 | 1.4200                                   |\n" +
                "+--------------+-------------+------------------------------------------+\n" +
                "1 row in set (0.05 sec)\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        DecimalFormat df4 = new DecimalFormat("#,##0.00");//格式化成有千分号的样式
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, df4.format(new BigDecimal(matcher.group())));
        }
        System.out.println(stringBuffer.toString());

    }
}
