package org;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简易计算器
 *
 * @author : chengdu
 * @date :  2024/6/2-06
 **/
public class ArrayStackCalculator {

    /**
     * 扫描字符串类型
     */
    private enum MathType {
        NUMBER(1, "数字"),
        OPERATOR(2, "操作符"),
        ;

        MathType(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static MathType createMathType(int value) {
            MathType[] mathTypes = MathType.values();
            for (MathType mathType : mathTypes) {
                if (mathType.getValue() == value) {
                    return mathType;
                }
            }
            return null;
        }

        private int value;
        private String desc;

        public int getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }
    }


    /**
     * 简易计算器
     *
     * @param expression
     * @return
     */
    public static double calculator(String expression) {
        expression = expression.trim();
        final List<String> stringList = convertNumberHelp(expression);
        //数值栈
        final Stack<Double> numberStack = new Stack<>();
        //运算符栈
        final Stack<String> operatorStack = new Stack<>();
        //1:通过一个 index  值（索引），来遍历我们的表达式
        for (String str : stringList) {
            MathType mathType = getMathType(str);
            switch (mathType) {
                case NUMBER: {
                    //如果我们发现是一个数字, 就直接入数栈
                    numberStack.push(Double.parseDouble(str));
                    break;
                }
                case OPERATOR: {
                    //如果发现扫描到是一个符号,  就分如下情况
                    if (operatorStack.empty()) {
                        //如果发现当前的符号栈为 空，就直接入栈
                        operatorStack.push(str);
                    } else {
                        //如果符号栈有操作符，就进行比较
                        final int currentLevel = getOperatorLevel(str);
                        final int topLevel = getOperatorLevel(operatorStack.peek());
                        if (currentLevel <= topLevel) {
                            //如果当前的操作符的优先级小于或者等于栈中的操作符
                            // 需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，
                            // 然后将当前的操作符入符号栈，
                            Double a1 = numberStack.pop(), a2 = numberStack.pop();
                            double res = calculator(a1, a2, operatorStack.pop());
                            numberStack.push(res);
                            operatorStack.push(str);
                        } else {
                            //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                            operatorStack.push(str);
                        }
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        //2:处理最后的表达式
        while (!operatorStack.empty()) {
            final String operator = operatorStack.pop();
            final Double a1 = numberStack.pop(), a2 = numberStack.pop();
            final double res = calculator(a2, a1, operator);
            numberStack.push(res);
        }
        return numberStack.pop();
    }

    /**
     * 判断 字符类型
     *
     * @param str
     * @return
     */
    private static MathType getMathType(String str) {
        if (NumberUtils.isCreatable(str)) {
            return MathType.NUMBER;
        }
        return MathType.OPERATOR;
    }


    /**
     * 分割  计算表达式
     *
     * @param text
     * @return
     */
    public static List<String> convertNumberHelp(String text) {
        List<String> stringList = Lists.newArrayList();
        if (StringUtils.isEmpty(text.trim())) {
            return stringList;
        }
        StringBuilder stringBuilder = new StringBuilder(8);
        stringBuilder.append(text);
        final String regEx = "[^0-9\\.?]";
        final Pattern p = Pattern.compile(regEx);
        final Matcher m = p.matcher(text);
        while (m.find()) {
            String string = stringBuilder.toString();
            int index = string.indexOf(m.group());
            String number = string.substring(0, index);
            if (NumberUtils.isCreatable(number)) {
                stringList.add(number);
            }
            stringList.add(m.group());
            string = string.substring(index + 1, stringBuilder.toString().length());
            stringBuilder.delete(0, stringBuilder.toString().length());
            stringBuilder.append(string);
        }
        if (NumberUtils.isNumber(stringBuilder.toString())) {
            stringList.add(stringBuilder.toString());
        }
        return stringList;
    }

    /**
     * 获取操作符优先级
     *
     * @param str
     * @return
     */
    private static Integer getOperatorLevel(String str) {
        Map<String, Integer> integerHashMap = new HashMap<>(20);
        final int firstIndex = 100;
        final int secondIndex = 10;
        final int thirdIndex = 1;
        integerHashMap.put("(", 1 * firstIndex);
        integerHashMap.put(")", 1 * firstIndex);
        integerHashMap.put("[", 1 * firstIndex);
        integerHashMap.put("]", 1 * firstIndex);
        integerHashMap.put("/", 3 * secondIndex);
        integerHashMap.put("*", 3 * secondIndex);
        integerHashMap.put("+", 4 * thirdIndex);
        integerHashMap.put("-", 4 * thirdIndex);
        return integerHashMap.getOrDefault(str, 0);
    }


    /**
     * 根据符号计算值
     *
     * @param a1
     * @param a2
     * @param operator
     * @return
     */
    private static double calculator(final double a1, final double a2, final String operator) {
        double res = 0L;
        switch (operator) {
            case "+": {
                res = a1 + a2;
                break;
            }
            case "-": {
                res = a1 - a2;
                break;
            }
            case "/": {
                res = a1 / a2;
                break;
            }
            case "*": {
                res = a1 * a2;
                break;
            }
            default: {
                break;
            }
        }
        return res;
    }

}
