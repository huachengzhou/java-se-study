package org.link;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 环形链表
 *
 * @author : chengdu
 * @date :  2024/7/4-07
 **/
public class LoopLinkedListSentinel implements Iterable<Object> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            Node pointer = sentinel;

            @Override
            public boolean hasNext() {
                return pointer.next != sentinel;
            }

            @Override
            public Object next() {
                pointer = pointer.next;
                return pointer.getValue();
            }
        };
    }

    private long len;

    private Node sentinel = new Node(-1D, null, null);

    public long getSize() {
        return len;
    }

    public void loop(Consumer<Object> consumer) {
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            consumer.accept(p.getValue());
        }
    }

    public void forIteration(Consumer<Object> consumer) {
        Node p = sentinel.next;
        while (p != sentinel) {
            consumer.accept(p.getValue());
            p = p.next;
        }
    }

    private Node findNode(final int index) {
        if (index < -1) {
            throw new IllegalArgumentException("元素索引不合法!");
        }
        if (index == -1) {
            return sentinel;
        }
        int count = 0;
        Node p = sentinel.next;
        while (p != sentinel) {
            if (index == count) {
                return p;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    /**
     * 插入到某个位置中去
     *
     * @param index
     * @param v
     */
    public void insert(int index, Object v) {
        Node node = findNode(index - 1);
        if (node == null) {
            throw new IllegalArgumentException("元素为空或者插入的索引不存在!");
        }
        Node added = new Node(v, node, node.next);
        node.setNext(added);
        added.setPrev(node);
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        remove((int) len - 1);
    }

    public Object get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException("元素索引不存在!");
        }
        return node.getValue();
    }

    /**
     * 偷看第一个
     *
     * @return
     */
    public Object peekFirst() {
        return get(0);
    }

    /**
     * 根据索引删除某个位置
     *
     * @param index
     */
    public void remove(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException("元素为空或者删除的索引不存在!");
        }
        Node nodePrev = node.getPrev();
        Node nodeNext = node.getNext();
        nodePrev.setNext(nodeNext);
        nodeNext.setPrev(nodePrev);
        len--;
    }


    /**
     * 将对象值  添加到开头
     *
     * @param v
     */
    public void addFirst(Object v) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(v, a, b);
        a.setNext(added);
        b.setPrev(added);
        len++;
    }

    /**
     * 将对象值  添加结尾
     *
     * @param v
     */
    public void addLast(Object v) {
        Node lastNode = sentinel.prev;
        Node added = new Node(v, lastNode, sentinel);
        lastNode.setNext(added);
        sentinel.setPrev(added);
        len++;
    }


    public LoopLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    private static class Node {
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
