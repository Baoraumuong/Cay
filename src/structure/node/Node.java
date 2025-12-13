package structure.node;

public abstract class Node {
	protected Node parent;
	protected NodeStatus status;
	public int data;
	//constructor
	public Node(int data) {
		this.data = data;
	}
	
	
	//getter & setter
	public int getData() {
		return this.data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getParent() {
		return this.parent;
	}
	public NodeStatus getStatus() {
		return this.status;
	}
	public void setStatus(NodeStatus s) {
		this.status = s;
	}
}