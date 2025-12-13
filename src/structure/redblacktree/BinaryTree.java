package structure.redblacktree;


import java.awt.*;
import java.util.*;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }
    
    //create a new tree
    public BinaryTreeNode getRoot() {
        return root;
    }
    
    //Insert node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BinaryTreeNode insertRec(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }
        if (data < root.getData()) root.setLeft(insertRec(root.getLeft(), data));
        else if (data > root.getData()) root.setRight(insertRec(root.getRight(), data));
        return root;
    }
    
    //Search node
    public BinaryTreeNode search(int data) {
    	return searchRec(root, data);
    }
    private BinaryTreeNode searchRec(BinaryTreeNode node, int data) {
    	if (node == null) return null;
    	if (data == node.getData()) return node;
    	if (data < node.getData()) {
    		return searchRec(node.getLeft(), data);
    	} else {
    		return searchRec(node.getRight(), data);
    	}
    }
    
    //Delete node
    public void delete(int data) {
    	root = deleteRec(root, data);
    }
    private BinaryTreeNode deleteRec(BinaryTreeNode node, int data) {
    	if (node == null) return null;
    	if (data < node.getData()) {
    		node.setLeft(deleteRec(node.getLeft(), data));
    	} else if (data > node.getData()) {
    		node.setRight(deleteRec(node.getRight(), data));
    	} else {
    		if (node.getLeft() == null && node.getRight() == null) {
    			return null;
    		} else if (node.getLeft() == null) {
    			return node.getRight();
    		} else if (node.getRight() == null) {
    			return root.getLeft();
    		} else {
    			int minVal = findMin(node.getRight());
    			node.setData(minVal);
    			node.setRight(deleteRec(node.getRight(), minVal));
    		}
    	}
    	return node;
    }
 
    
    //Update node
    public boolean update(int oldVal, int newVal) {
    	BinaryTreeNode node = search(oldVal);
    	if (node == null) return false;
    	delete(oldVal);
    	insert(newVal);
    	return true;
    }
    
    //Traversal
    public List<Integer> dfsInOrder() {
    	List<Integer> list = new ArrayList<>();
    	dfsInOrderRec(root, list);
    	return list;
    }
    private void dfsInOrderRec(BinaryTreeNode node, List<Integer> list) {
    	if (node == null) return;
    	dfsInOrderRec(node.getLeft(), list);
    	list.add(node.getData());
    	dfsInOrderRec(node.getRight(), list);
    }
    
    public List<Integer> dfsPreOrder() {
    	List<Integer> list = new ArrayList<>();
    	dfsPreOrderRec(root, list);
    	return list;
    }
    private void dfsPreOrderRec(BinaryTreeNode node, List<Integer> list) {
    	if (node == null) return;
    	list.add(node.getData());
    	dfsPreOrderRec(node.getLeft(), list);
    	dfsPreOrderRec(node.getRight(), list);
    }
    
    public List<Integer> dfsPostOrder() {
    	List<Integer> list = new ArrayList<>();
    	dfsPostOrderRec(root, list);
    	return list;
    }
    private void dfsPostOrderRec(BinaryTreeNode node, List<Integer> list) {
    	if (node == null) return;
    	dfsPostOrderRec(node.getLeft(), list);
    	dfsPostOrderRec(node.getRight(), list);
    	list.add(node.getData());
    }
    
    public List<Integer> bfs() {
    	List<Integer> list = new ArrayList<>();
    	if (root == null) return list;
    	Queue<BinaryTreeNode> q =new LinkedList<>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		BinaryTreeNode node = q.poll();
    		list.add(node.getData());
    		if (node.getLeft() != null) q.add(node.getLeft());
    		if (node.getRight() != null) q.add(node.getRight());
    	}
    	return list;
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
    public List<Integer> findLeaves(BinaryTreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null)
                leaves.add(node.getData());
            else {
                leaves.addAll(findLeaves(node.getLeft()));
                leaves.addAll(findLeaves(node.getRight()));
            }
        }
        return leaves;
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