package org.link;

import java.util.function.Consumer;

/**
 * 双链表 (非哨兵模式)
 *
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public final class DoubleLinkedDemo1 {
    /**
     * ----------
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
        insert(0, v);
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
        remove(0);
    }

    /**
     * 删除节点
     *
     * @param index
     */
    public void remove(int index) {
        if (index == 0) {
            if (this.head != null) {
                this.head = this.head.next;
                this.tail = this.tail.prev;
                length--;
            }
        } else {
            Node node = findNode(index);
            if (node != null) {
                Node prev = node.getPrev();
                Node next = node.getNext();
                //设置节点关联
                prev.setNext(next);
                if (next != null) {
                    next.setPrev(prev);
                }
                this.tail = findLastNode();
                length--;
            } else {
                throw new IllegalArgumentException("元素为空或者删除的元素不存在!");
            }
        }
    }

    /**
     * 插入数据
     * @param value
     * @param index
     */
    public void insert(int value, int index) {
        if (index == 0) {
            //第一次插入  相当于插入到头指针上
            if (this.head == null) {
                Node node = new Node(value, null, null);
                this.head = node;
                this.tail = node;
            } else {
                Node node = new Node(value, this.head, null);
                this.head.setPrev(node);
                this.head = node;
                this.tail = findLastNode();
            }
            length++;
        } else {
            //找到前一个
            Node prevNode = findNode(index - 1);
            if (prevNode != null) {
                //前一个元素的上一个和下一个都先取出来
                Node next = prevNode.getNext();
                //创建当前元素
                Node node = new Node(value, null, prevNode);
                //前一个元素的下一个节点是当前元素
                prevNode.setNext(node);
                //前一个节点的下一个节点的前一个节点是当前元素
                if (next != null) {
                    next.setPrev(node);
                }
                //当前元素的下一个节点是(前一个节点的下一个节点)
                node.setNext(next);
                this.tail = findLastNode();
            } else {
                throw new IllegalArgumentException("元素为空或者插入的索引不存在!");
            }
        }
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
        if (index < 0) {
            throw new IllegalArgumentException("元素索引不合法!");
        }
        Node node = findNode(index);
        if (node == null){
            throw new IllegalArgumentException("元素为空或者索引元素不存在!");
        }
        return node.getValue();
    }

    /**
     * 根据索引寻找节点
     *
     * @param index
     * @return
     */
    private Node findNode(final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("元素索引不合法!");
        }
        if (head == null) {
            return null;
        }
        int i = 0;
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            if (index == i) {
                return pointer;
            }
            i++;
        }
        return null;
    }


    /**
     * 获取最后一个节点
     *
     * @return
     */
    private Node findLastNode() {
        for (Node pointer = this.head; pointer != null; pointer = pointer.next) {
            if (pointer.next == null) {
                return pointer;
            }
        }
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
