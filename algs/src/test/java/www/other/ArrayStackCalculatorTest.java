package www.other;

import org.ArrayStackCalculator;
import org.junit.Test;

import java.util.List;

/**
 * @author : chengdu
 * @date :  2024/6/2-06
 **/
public class ArrayStackCalculatorTest {

    @Test
    public void test1() {
        final String text = "12.4246374+(32*3-2)";
        List<String> stringList = ArrayStackCalculator.convertNumberHelp(text);
        stringList.forEach(s -> System.out.println(s));
    }

    @Test
    public void test2() {
//        final String text = "12.4246374+(32*3-2)";
        final String text = "4+3*4-2";
        System.out.println(ArrayStackCalculator.calculator(text));
    }
}
