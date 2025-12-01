public class RedBlackTreeNode extends BinaryTreeNode {
	private NodeColor color;
	private RedBlackTreeNode parent;
	private RedBlackTreeNode left;
	private RedBlackTreeNode right;
	
	public RedBlackTreeNode(int data) {
		super(data);
		this.parent =null;
		this.left = null;
		this.right = null;
		this.color= NodeColor.RED;
	}
	
	public NodeColor getColor() {
		return this.color;
	}
	public RedBlackTreeNode getParent() {
		return this.parent;
	}
	public RedBlackTreeNode getLeft() {
		return this.left;
	}
	public RedBlackTreeNode getRight() {
		return this.right;
	}
	public void setColor(NodeColor color) {
		this.color = color;
	}
	public void setParent(RedBlackTreeNode parent) {
		this.parent = parent;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = (RedBlackTreeNode) left;
		if (left != null) {
			((RedBlackTreeNode) left).parent = this;
		}
	}
	public void setRight(BinaryTreeNode right) {
		this.right = (RedBlackTreeNode) right;
		if (right != null) {
			((RedBlackTreeNode) right).parent = this;
		}
	}
	public boolean isRed() {
		return this.color == NodeColor.RED;
	}
	public boolean isBlack() {
		return this.color == NodeColor.BLACK;
	}

}
