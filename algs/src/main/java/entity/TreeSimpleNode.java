package entity;

public class TreeSimpleNode {

    private Object data;    //节点数据
    private TreeSimpleNode leftChild; //左子节点的引用
    private TreeSimpleNode rightChild; //右子节点的引用

    //打印节点内容
    public void display() {
        System.out.println(data);
    }

    public TreeSimpleNode(Object data) {
        this.data = data;
    }

    public TreeSimpleNode(Object data, TreeSimpleNode leftChild, TreeSimpleNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeSimpleNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeSimpleNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeSimpleNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeSimpleNode rightChild) {
        this.rightChild = rightChild;
    }
}
