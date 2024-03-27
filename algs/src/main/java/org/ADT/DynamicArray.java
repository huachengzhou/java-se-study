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

    /**
     * 懒惰初始化
     */
    private int[] array = new int[0];
//    private int[] array = new int[capacity];

    /**
     * 添加元素到最后
     *
     * @param ele
     */
    public void addLast(int ele) {
        //容量检查
        checkAndGrow();
        array[size] = ele;
        size++;
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不在范围内!");
        }
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        //容量检查
        checkAndGrow();
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

    /**
     * 检查并扩容
     */
    private void checkAndGrow() {
        if (size == 0){
            array = new int[capacity] ;
        }else if (size == capacity) {
            //需要扩容
            //扩容1.5
            capacity += capacity >> 1;
            int[] newArray = new int[capacity] ;
            System.arraycopy(array,0,newArray,0,size);
            array = newArray ;
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
     *
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 获取数据流
     *
     * @return
     */
    public IntStream stream() {
        //有效流
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
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
