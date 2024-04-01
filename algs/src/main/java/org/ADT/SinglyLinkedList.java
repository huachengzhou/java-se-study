package org.ADT;

import java.util.function.Consumer;

/**
 * 单向链表
 *
 * @author : chengdu
 * @date :  2024/4/1-04
 **/
public class SinglyLinkedList {
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
     * 循环遍历
     * @param consumer
     */
    public void loop(Consumer<Integer> consumer) {
        //指针
        Node pointer = head;
        //不断往后移动 移动到null就结束
        while (pointer != null) {
            if (consumer != null){
                consumer.accept(pointer.value);
            }
            pointer = pointer.next;
        }
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

