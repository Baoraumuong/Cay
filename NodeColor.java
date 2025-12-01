
public class NodeColor {
	public static final NodeColor RED = new NodeColor("RED");
	public static final NodeColor BLACK = new NodeColor("BLACK");
	private final String name;
	private NodeColor(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
