package org.link;

import java.util.function.Consumer;

/**
 * 单链表 (非哨兵模式)
 *
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public final class SinglyLinkedDemo1 {
    /**
     * 元素个数
     */
    private int nodeSize;

    /**
     * 头指针
     */
    private Node head;

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
        if (head == null) {
            head = new Node(v, null);
        } else {
            head = new Node(v, head);
        }
        nodeSize++;
    }


    /**
     * 添加元素到最后一个节点
     *
     * @param val
     */
    public void addLast(int val) {
        Node last = findLast();
        if (last == null) {
            this.addFirst(val);
        } else {
            last.setNext(new Node(val, null));
            nodeSize++;
        }
    }

    public void loop(Consumer<Integer> consumer) {
        if (head == null) {
            return;
        }
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.getValue());
            pointer = pointer.next;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        if (head == null) {
            return;
        }
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.getValue());
        }
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException("无任何元素,因此删除第一个元素失败!");
        }
        this.head = head.next;
        nodeSize--;
    }

    /**
     * 删除节点
     *
     * @param index
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IllegalArgumentException("无任何元素,因此删除第一个元素失败!");
            }
            this.head = head.next;
        } else {
            //获取到前一个节点
            Node prevNode = findNode(index - 1);
            if (prevNode != null) {
                //待删除节点(当前节点)
                Node currentNode = prevNode.next;
                //前一个节点的next = 待删除节点的next 这样当前节点就从链表中移除了 等待jvm垃圾回收器收回即可
                prevNode.next = currentNode.next;
            } else {
                throw new IllegalArgumentException("元素为空或者删除的元素不存在!");
            }
        }
        nodeSize--;
    }

    public void insert(int value, int index) {
        //分析插入到这一个位置  那么我们就获取前一个节点  然后这个节点的next就是我们这个
        if (index == 0) {
            this.head = new Node(value, this.head);
        } else {
            //获取到前一个节点
            Node prevNode = findNode(index - 1);
            if (prevNode != null) {
                //实际节点node
                Node currentNode = prevNode.next;
                //新节点的下一个节点的next是实际节点
                Node newNode = new Node(value, currentNode);
                prevNode.setNext(newNode);
            } else {
                throw new IllegalArgumentException("插入的位置异常!");
            }
        }
        nodeSize++;
    }

    public int getSize() {
        return nodeSize;
    }

    /**
     * 根据索引获取元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException("元素为空或者索引位置的元素不存在!");
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
        Node pointer = null;
        int count = 0;
        for (pointer = head; pointer != null; pointer = pointer.next) {
            if (count == index) {
                return pointer;
            }
            count++;
        }
        return null;
    }

    /**
     * 获取最后一个节点
     *
     * @return
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        return pointer;
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

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
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
    }


}
