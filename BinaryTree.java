
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BinaryTreeNode insertRec(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }
        if (data < root.data) root.setLeft(insertRec(root.getLeft(), data));
        else if (data > root.data) root.setRight(insertRec(root.getRight(), data));
        return root;
    }

    public List<Integer> findLeaves(BinaryTreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null)
                leaves.add(node.data);
            else {
                leaves.addAll(findLeaves(node.getLeft()));
                leaves.addAll(findLeaves(node.getRight()));
            }
        }
        return leaves;
    }

    public int findMin(BinaryTreeNode node) {
        if (node == null) throw new IllegalArgumentException("Tree is empty.");
        while (node.getLeft() != null) node = node.getLeft();
        return node.getData();
    }

    public int findMax(BinaryTreeNode node) {
        if (node == null) throw new IllegalArgumentException("Tree is empty.");
        while (node.getRight() != null) node = node.getRight();
        return node.getData();
    }

    public void drawTree(Graphics g, int x, int y, BinaryTreeNode node, int depth) {
        if (node != null) {
            int radius = 20;

            int xOffset = 200 >> depth;
            if (xOffset < 30) xOffset = 30;
            int yOffset = 60;

            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(String.valueOf(node.data), x - 5, y + 5);

            if (node.getLeft() != null) {
                int childX = x - xOffset;
                int childY = y + yOffset;

                drawLineBetweenCircles(g, x, y, childX, childY, radius);
                drawTree(g, childX, childY, node.getLeft(), depth + 1);
            }

            if (node.getRight() != null) {
                int childX = x + xOffset;
                int childY = y + yOffset;

                drawLineBetweenCircles(g, x, y, childX, childY, radius);
                drawTree(g, childX, childY, node.getRight(), depth + 1);
            }
        }
    }
    private void drawLineBetweenCircles(Graphics g, int x, int y, int childX, int childY, int radius) {
        double dx = childX - x;
        double dy = childY - y;
        double dist = Math.sqrt(dx * dx + dy * dy);

        int startX = (int)Math.round(x + dx * radius / dist);
        int startY = (int)Math.round(y + dy * radius / dist);
        int endX   = (int)Math.round(childX - dx * radius / dist);
        int endY   = (int)Math.round(childY - dy * radius / dist);

        g.drawLine(startX, startY, endX, endY);
    }

}
