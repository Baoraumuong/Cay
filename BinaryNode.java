package MiniProject;

import java.util.*;

public class BinaryNode<T> extends Node<T> {
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T value) {
		super(value);
	}
	public BinaryNode<T> getLeft() {
		return left;
	}
	public BinaryNode<T> getRight() {
		return right;
	}
	
	public void setLeft(BinaryNode<T> left) {
		this.left = left;
		if (left != null) {
			left.setParent(this);
		}
	}
	public void setRight(BinaryNode<T> right) {
		this.right = right;
		if (right != null) {
			right.setParent(this);
		}
	}
	
	public List<Node<T>> getChildren() {
		List<Node<T>> list = new ArrayList<>();
		if (left != null) list.add(left);
		if (right != null) list.add(right);
		return list;
	}
}
