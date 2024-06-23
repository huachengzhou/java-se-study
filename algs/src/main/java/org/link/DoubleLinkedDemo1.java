package org.link;

import java.util.function.Consumer;

/**
 * 双链表 (非哨兵模式)
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public final class DoubleLinkedDemo1 {
    /**----------
     * 元素个数
     */
    private int length;

    /**
     * 头指针
     */
    private Node head;
    /**
     * 尾指针
     * 指向最后一个元素
     */
    private Node tail;

    /**
     * 偷看第一个
     *
     * @return
     */
    public int peekFirst() {
        if (head == null) {
            throw new IllegalArgumentException("无任何元素");
        }
        return head.value;
    }


    /**
     * 添加元素到第一个节点
     *
     * @param v
     */
    public void addFirst(int v) {
        if (this.head == null) {
            Node node = new Node(v, null, null);
            this.head = node;
            this.tail = node;
        } else {
            Node node = new Node(v, this.head, null);
            this.head.setPrev(node);
            this.head = node;
            for (Node pointer = this.head; pointer != null; pointer = pointer.next) {
                if (pointer.next == null) {
                    this.tail = pointer;
                }
            }
        }
        length++;
    }


    /**
     * 添加元素到最后一个节点
     *
     * @param val
     */
    public void addLast(int val) {
        //this.tail == null 相当于 this.head == null
        if (this.tail == null) {
            addFirst(val);
        } else {
            Node node = new Node(val, null, null);
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
            length++;
        }
    }

    public void loop(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        if (this.head != null) {
            this.head = this.head.next;
            this.tail = this.tail.prev;
            length--;
        }
    }

    /**
     * 删除节点
     *
     * @param index
     */
    public void remove(int index) {

    }

    public void insert(int value, int index) {

    }

    public int getSize() {
        return length;
    }

    /**
     * 根据索引获取元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        return 0;
    }

    /**
     * 根据索引寻找节点
     *
     * @param index
     * @return
     */
    private Node findNode(final int index) {
        return null;
    }

    /**
     * 获取最后一个节点
     *
     * @return
     */
    private Node findLast() {
        return null;
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
        /**
         * 上一个节点
         */
        private Node prev;

        private Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Node getPrev() {
            return prev;
        }

        private void setPrev(Node prev) {
            this.prev = prev;
        }
    }


}
