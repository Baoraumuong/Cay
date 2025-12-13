package structure.redblacktree;
import structure.node.*;

class BinaryTreeNode extends Node {
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    
    public BinaryTreeNode getLeft() {
    	return this.left;
    }
    public BinaryTreeNode getRight() {
    	return this.right;
    }
    public void setLeft(BinaryTreeNode left) {
    	this.left = left;
    	if (left != null) {
    		left.parent = this;
    	}
    }
    public void setRight(BinaryTreeNode right) {
    	this.right = right;
    	if (right != null) {
    		right.parent = this;
    	}
    }
    public BinaryTreeNode(int data) {
        super(data);
        this.left = null;
        this.right = null;
    }
}
