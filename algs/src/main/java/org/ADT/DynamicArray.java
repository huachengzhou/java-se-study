package org.ADT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 *
 * @author : chengdu
 * @date :  2024/3/26-03
 **/
public class DynamicArray implements Iterable<Integer> {
    /**
     * 逻辑大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity = 8;

    private int[] array = new int[capacity];

    /**
     * 添加元素到最后
     *
     * @param ele
     */
    public void addLast(int ele) {
        array[size] = ele;
        size++;
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        } else if (index == size) {
            //addLast
            array[size] = element;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        return array[index];
    }

    /**
     * 遍历
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 获取数据流
     * @return
     */
    public IntStream stream(){
        //有效流
        return IntStream.of(Arrays.copyOfRange(array,0,size)) ;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int i = 0;

            /**
             * 有没有下一个元素
             * @return
             */
            @Override
            public boolean hasNext() {
                return i != size;
            }

            /**
             * 返回当前元素，并移动到下一个元素
             * @return
             */
            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }
}
