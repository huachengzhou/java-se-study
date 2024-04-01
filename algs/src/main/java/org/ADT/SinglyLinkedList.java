package org.ADT;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 单向链表
 *
 * @author : chengdu
 * @date :  2024/4/1-04
 **/
public class SinglyLinkedList implements Iterable<Integer> {
    /**
     * 元素个数
     */
    private int size = 0;
    /**
     * 头指针
     */
    private Node head;

    @Deprecated
    public void addFirst_(int v) {
        //1:链表为null
        if (head == null) {
            //先创建节点
            Node node = new Node(v, null);
            //然后赋值给head
            this.head = node;
            size++;
            return;
        }
        //2:链表非空 (相当于往后推移了 以前的head变成了next)
        //先创建节点
        Node node = new Node(v, head);
        //然后赋值给head
        this.head = node;
        size++;
    }

    /**
     * 添加元素到第一个节点
     *
     * @param v
     */
    public void addFirst(int v) {
        //1:链表为null
        //2:链表非空
        //先创建节点 然后赋值给head
        this.head = new Node(v, head);
        size++;
    }

    /**
     * 循环遍历 (while)
     *
     * @param consumer
     */
    public void loop(Consumer<Integer> consumer) {
        if (consumer == null) {
            return;
        }
        //指针
        Node pointer = head;
        //不断往后移动 移动到null就结束
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    /**
     * 循环遍历 (for)
     *
     * @param consumer
     */
    public void loopFor(Consumer<Integer> consumer) {
        if (consumer == null) {
            return;
        }
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    /**
     * java8 stream
     * @return
     */
    public Stream<Integer> stream() {
        Stream.Builder<Integer> builder = Stream.builder();
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            builder.add(pointer.value);
        }
        return builder.build();
    }


    /**
     * 增强for循环
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            //指针
            Node pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    /**
     * 节点类
     */
    private static class Node {
        /**
         * 值
         */
        private int value;

        /**
         * 下一个节点
         */
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public int getSize() {
        return size;
    }

}

