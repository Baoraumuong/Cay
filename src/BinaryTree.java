
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

    public void drawTree(Graphics g, int x, int y, TreeNode node) {
        if (node != null) {
            int radius = 20;
            int xOffset = 50;
            int yOffset = 50;

            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(String.valueOf(node.data), x - 5, y + 5);

            if (node.left != null) {
                g.drawLine(x, y, x - xOffset, y + yOffset);
                drawTree(g, x - xOffset, y + yOffset, node.left);
            }
            if (node.right != null) {
                g.drawLine(x, y, x + xOffset, y + yOffset);
                drawTree(g, x + xOffset, y + yOffset, node.right);
            }
        }
    }
}
