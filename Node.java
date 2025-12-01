public abstract class Node {
	protected Node parent;
	protected NodeStatus status;
	protected int data;
	
	public Node(int data) {
		this.data = data;
	}
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
