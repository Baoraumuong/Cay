public class RedBlackTreeNode extends BinaryTreeNode {

    private NodeColor color = NodeColor.RED; // mặc định đỏ khi mới insert

    public RedBlackTreeNode(int value) {
        super(value);
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" +
               "value=" + value +
               ", color=" + color +
               '}';
    }
}
