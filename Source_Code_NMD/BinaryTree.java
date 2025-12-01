import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void insert(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
            return;
        }
        root = insertRecursive(root, value);
    }

    private BinaryTreeNode insertRecursive(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        if (value < node.getValue()) {
            BinaryTreeNode left = insertRecursive(node.getLeftChild(), value);
            node.setLeftChild(left);
        } else if (value > node.getValue()) {
            BinaryTreeNode right = insertRecursive(node.getRightChild(), value);
            node.setRightChild(right);
        }
        return node;
    }

    public List<Integer> findLeaves(BinaryTreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        collectLeaves(node, leaves);
        return leaves;
    }

    private void collectLeaves(BinaryTreeNode node, List<Integer> leaves) {
        if (node == null) return;

        if (node.getLeftChild() == null && node.getRightChild() == null) {
            leaves.add(node.getValue());
        } else {
            collectLeaves(node.getLeftChild(), leaves);
            collectLeaves(node.getRightChild(), leaves);
        }
    }

    public int findMin(BinaryTreeNode node) {
        if (node == null) throw new IllegalStateException("Tree is empty");

        BinaryTreeNode cur = node;
        while (cur.getLeftChild() != null) {
            cur = cur.getLeftChild();
        }
        return cur.getValue();
    }

    public int findMax(BinaryTreeNode node) {
        if (node == null) throw new IllegalStateException("Tree is empty");

        BinaryTreeNode cur = node;
        while (cur.getRightChild() != null) {
            cur = cur.getRightChild();
        }
        return cur.getValue();
    }

    public void drawTree(Graphics g, int x, int y, BinaryTreeNode node, int depth) {
        if (node == null) return;

        int nodeRadius = 18;
        int verticalGap = 60;
        int horizontalGap = 140 / (depth + 1);

        if (node.getLeftChild() != null) {
            int childX = x - horizontalGap;
            int childY = y + verticalGap;
            g.drawLine(x, y, childX, childY);
            drawTree(g, childX, childY, node.getLeftChild(), depth + 1);
        }

        if (node.getRightChild() != null) {
            int childX = x + horizontalGap;
            int childY = y + verticalGap;
            g.drawLine(x, y, childX, childY);
            drawTree(g, childX, childY, node.getRightChild(), depth + 1);
        }

        g.setColor(Color.WHITE);
        g.fillOval(x - nodeRadius, y - nodeRadius, nodeRadius * 2, nodeRadius * 2);

        g.setColor(Color.BLACK);
        g.drawOval(x - nodeRadius, y - nodeRadius, nodeRadius * 2, nodeRadius * 2);

        String text = String.valueOf(node.getValue());
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textAscent = fm.getAscent();

        g.drawString(text, x - textWidth / 2, y + textAscent / 4);
    }
}
