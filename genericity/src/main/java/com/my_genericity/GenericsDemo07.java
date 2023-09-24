package com.my_genericity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class GenericsDemo07 {

    static class AClass implements Comparable {
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        private Integer id;
        private String title;

        public AClass(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        @Override
        public String toString() {
            return "AClass{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         *
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        public int compareTo(Object o) {
            AClass aClass = (AClass) o;
            return this.id.compareTo(aClass.getId());
        }
    }

    static class DataValue<E> {
        public static <E extends Comparable<? super E>> E max(List<? extends E> e1) {
            if (e1 == null) {
                return null;
            }
            //迭代器返回的元素属于 E 的某个子类型
            Iterator<? extends E> iterator = e1.iterator();
            E result = iterator.next();
            while (iterator.hasNext()) {
                E next = iterator.next();
                if (next.compareTo(result) > 0) {
                    result = next;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        List<AClass> aClassList = new ArrayList<>(8) ;
        for (int i = 0; i < 8; i++) {
            AClass aClass = new AClass(i, UUID.randomUUID().toString());
            aClassList.add(aClass);
        }
        AClass max = DataValue.max(aClassList);
        System.out.println(max);
    }

}
