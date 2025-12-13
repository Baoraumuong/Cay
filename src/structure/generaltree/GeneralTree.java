package structure.generaltree;

import java.util.*;

public class GeneralTree {

    private GeneralTreeNode root;

    /* =====================
       BASIC OPERATIONS
       ===================== */

    public void clear() {
        root = null;
    }

    public GeneralTreeNode getRoot() {
        return root;
    }

    public GeneralTreeNode insertRoot(int data) {
        if (root != null)
            throw new IllegalStateException("Root already exists");
        root = new GeneralTreeNode(data);
        return root;
    }

    public GeneralTreeNode insertChild(GeneralTreeNode parent, int data) {
        if (parent == null)
            throw new IllegalArgumentException("Parent cannot be null");

        GeneralTreeNode child = new GeneralTreeNode(data);
        parent.addChild(child);
        return child;
    }

    /* =====================
       SEARCH
       ===================== */

    public GeneralTreeNode search(int value) {
        return searchRec(root, value);
    }

    private GeneralTreeNode searchRec(GeneralTreeNode node, int value) {
        if (node == null) return null;
        if (node.getData() == value) return node;

        GeneralTreeNode child = node.getFirstChild();
        while (child != null) {
            GeneralTreeNode found = searchRec(child, value);
            if (found != null) return found;
            child = child.getNextSibling();
        }
        return null;
    }

    /* =====================
       UPDATE
       ===================== */

    public boolean update(int oldValue, int newValue) {
        GeneralTreeNode node = search(oldValue);
        if (node == null) return false;

        node.setData(newValue);
        return true;
    }

    /* =====================
       DELETE
       ===================== */

    public boolean delete(int value) {
        if (root == null) return false;

        if (root.getData() == value) {
            clear();
            return true;
        }
        return deleteRec(root, value);
    }

    private boolean deleteRec(GeneralTreeNode parent, int value) {
        GeneralTreeNode child = parent.getFirstChild();

        while (child != null) {
            if (child.getData() == value) {
                parent.removeChild(child);
                return true;
            }
            if (deleteRec(child, value)) return true;
            child = child.getNextSibling();
        }
        return false;
    }

    /* =====================
       TRAVERSAL
       ===================== */

    public List<Integer> dfs() {
        List<Integer> result = new ArrayList<>();
        dfsRec(root, result);
        return result;
    }

    private void dfsRec(GeneralTreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.getData());

        GeneralTreeNode child = node.getFirstChild();
        while (child != null) {
            dfsRec(child, list);
            child = child.getNextSibling();
        }
    }

    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<GeneralTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            GeneralTreeNode node = queue.poll();
            result.add(node.getData());

            GeneralTreeNode child = node.getFirstChild();
            while (child != null) {
                queue.add(child);
                child = child.getNextSibling();
            }
        }
        return result;
    }
}
