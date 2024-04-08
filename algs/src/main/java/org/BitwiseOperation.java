package org;

/**
 * 位运算
 */
public class BitwiseOperation {

    /*
|       |          |         |        |        |
| ----- | -------- | ------- | ------ | ------ |
| 含义    | Pascal语言 | C/C++语言 | Java   | Php    |
| 按位与   | a and b  | a & b   | a & b  | a & b  |
| 按位或   | a or b   | a \| b  | a \| b | a \| b |
| 按位异或  | a xor b  | a ^ b   | a ^ b  | a ^ b  |
| 按位取反  | not a    | ~a      | ~a     | ~a     |
| 左移    | a shl b  | a <<b   | a <<b  | a << b |
| 带符号右移 | a shr b  | a >> b  | a >> b | a >> b |
| 无符号右移 | /        | /       | a>>> b | /      |
    * */


    /**
     * 左移
     *
     * @param num
     * @param target
     * @return
     */
    public static int left(int target, int num) {
        return target << num;
    }


    /**
     * 带符号右移(大部分情况是用这个)
     *
     * @param num
     * @param target
     * @return
     */
    public static int rightSymbol(int target, int num) {
        return target >> num;
    }

    /**
     * 右移
     *
     * @param num
     * @param target
     * @return
     */
    public static int right(int target, int num) {
        return target >>> num;
    }


    /*
   带符号右移和无符号右移的主要区别在于处理负数时的不同方式。以下是详细介绍：

带符号右移（算术右移）。对于正数，带符号右移会在高位补充0，而对于负数，则会保留原来的二进制表示，但在右移时，会将最高位（符号位）保留不变，其余位进行右移，空出的位置补1。
无符号右移。无论处理的数是正数还是负数，无符号右移总是在高位补充0。
简而言之，带符号右移保持了数值的符号，而无符号右移则不区分正负数，总是以无符号的方式进行右移。
    * */

}
