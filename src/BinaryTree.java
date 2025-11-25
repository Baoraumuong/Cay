
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) root.left = insertRec(root.left, data);
        else if (data > root.data) root.right = insertRec(root.right, data);
        return root;
    }

    public List<Integer> findLeaves(TreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        if (node != null) {
            if (node.left == null && node.right == null)
                leaves.add(node.data);
            else {
                leaves.addAll(findLeaves(node.left));
                leaves.addAll(findLeaves(node.right));
            }
        }
        return leaves;
    }

    public int findMin(TreeNode node) {
        if (node == null) throw new IllegalArgumentException("Tree is empty.");
        while (node.left != null) node = node.left;
        return node.data;
    }

    public int findMax(TreeNode node) {
        if (node == null) throw new IllegalArgumentException("Tree is empty.");
        while (node.right != null) node = node.right;
        return node.data;
    }

    public void drawTree(Graphics g, int x, int y, TreeNode node, int depth) {
        if (node != null) {
            int radius = 20;

            int xOffset = 200 >> depth;
            if (xOffset < 30) xOffset = 30;
            int yOffset = 60;

            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(String.valueOf(node.data), x - 5, y + 5);

            if (node.left != null) {
                int childX = x - xOffset;
                int childY = y + yOffset;

                drawLineBetweenCircles(g, x, y, childX, childY, radius);
                drawTree(g, childX, childY, node.left, depth + 1);
            }

            if (node.right != null) {
                int childX = x + xOffset;
                int childY = y + yOffset;

                drawLineBetweenCircles(g, x, y, childX, childY, radius);
                drawTree(g, childX, childY, node.right, depth + 1);
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
