package org;

import java.util.function.Consumer;

/**
 * 简单栈
 *
 * @author : chengdu
 * @date :  2024/5/19-05
 **/
public class StackArrayDemo {

    private int[] array;

    /**
     * 容量
     */
    private int capacity;


    /**
     * 栈顶
     */
    private int top = 0;

    public StackArrayDemo(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == capacity;
    }


    public void push(int value) {
        if (isFull()) {
            System.out.printf("元素%d已经满了", value);
            return;
        }
        array[this.top++] = value;
    }

    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("数据已经到底了!") ;
        }
        return array[--this.top];
    }

    public void loop(Consumer<Integer> consumer){
        for (int i = 0; i < top; i++) {
            consumer.accept(array[i]);
        }
    }


}
