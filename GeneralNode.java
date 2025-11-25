package MiniProject;

import java.util.*;

public class GeneralNode<T> extends Node<T> {
	private List<Node<T>> children = new ArrayList<>();
	
	public GeneralNode(T value) {
		super(value);
	}
	
	public List<Node<T>> getChildren() {
		return children;
	}
	public void addChild(Node<T> child) {
		children.add(child);
		child.setParent(this);
	}
	public void removeChild(Node<T> child) {
		children.remove(child);
		child.setParent(null);
	}
}
