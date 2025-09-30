package org.tree;

import entity.TreeSimpleNode;

public class TreeDemoB {

    //https://www.cnblogs.com/ysocean/p/8032642.html#_label6

    private TreeSimpleNode root;


    /**
     * 二叉树查找
     *
     * @param key 　查找某个节点，我们必须从根节点开始遍历。
     *            　①、查找值比当前节点值大，则搜索右子树；
     *            　②、查找值等于当前节点值，停止搜索（终止条件）；
     *            　③、查找值小于当前节点值，则搜索左子树；
     * @return
     */
    public TreeSimpleNode find(Object key) {
        TreeSimpleNode current = root;
        while (current != null) {
            //当前值比查找值大，搜索左子树
            if (current.hashCode() > key.hashCode()) {
                current = current.getLeftChild();
                //当前值比查找值小，搜索右子树
            } else if (current.hashCode() < key.hashCode()) {
                current = current.getRightChild();
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * 要插入节点，必须先找到插入的位置。与查找操作相似，
     * 由于二叉搜索树的特殊性，待插入的节点也需要从根节点开始进行比较，
     * 小于根节点则与根节点左子树比较，反之则与右子树比较，直到左子树为空或右子树为空，则
     * 插入到相应为空的位置，在比较的过程中要注意保存父节点的信息
     * 及 待插入的位置是父节点的左子树还是右子树，才能插入到正确的位置。
     *
     * @param key
     * @return
     */
    public boolean insert(Object key) {
        TreeSimpleNode newNode = new TreeSimpleNode(key);
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeSimpleNode current = root;
        TreeSimpleNode parentNode = null;
        while (true) {
            parentNode = current;
            //当前值比插入值大，搜索左子节点
            if (current.hashCode() > key.hashCode()) {
                current = current.getLeftChild();
                //左子节点为空，直接将新值插入到该节点
                if (current == null) {
                    parentNode.setLeftChild(newNode);
                    return true;
                }
                //当前值比插入值小，搜索右子节点
            } else if (current.hashCode() < key.hashCode()) {
                current = current.getRightChild();
                //右子节点为空，直接将新值插入到该节点
                if (current == null) {
                    parentNode.setRightChild(newNode);
                    return true;
                }
            }
        }
    }

    /**
     *删除节点
     1、该节点是叶节点（没有子节点）
     2、该节点有一个子节点
     3、该节点有两个子节点
     * @param key
     * @return
     */
    public boolean delete(Object key){


        return false;
    }

}
