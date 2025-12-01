public class BinaryTreeNode extends Node {

    protected BinaryTreeNode leftChild;
    protected BinaryTreeNode rightChild;
    protected int value;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            leftChild.setParent(this);
        }
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            rightChild.setParent(this);
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" + "value=" + value + '}';
    }
}
