package MiniProject;

import java.util.*;
public abstract class Node<T> {
	protected T value;
	protected Node<T> parent;
	
	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getParent() {
		return parent;
	}
	protected void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public abstract List<Node<T>> getChildren();
}
