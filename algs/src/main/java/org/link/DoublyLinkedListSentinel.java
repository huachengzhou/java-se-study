package org.link;

import java.util.function.Consumer;

/**
 * 环形链表
 * @author : chengdu
 * @date :  2024/7/4-07
 **/
public class DoublyLinkedListSentinel {

    private long len;

    private Node sentinel = new Node(-1D,null,null) ;

    public long getSize(){
        return len;
    }

    public void loop(Consumer<Double> consumer){
        for (Node p = sentinel.next;p != sentinel;p = p.next){
            consumer.accept(p.getValue());
        }
    }


    public void addFirst(double v){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(v, a, b);
        a.setNext(added);
        b.setPrev(added);
        len++;
    }



    public DoublyLinkedListSentinel(){
        sentinel.next = sentinel ;
        sentinel.prev = sentinel ;
    }

    private static class Node {
        private double value;
        private Node prev;
        private Node next;

        public Node(double value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
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
