import java.util.*;

public class GeneralTree {
	private GeneralTreeNode root;
	
	//Create new tree
	public void clear() {
		root = null;
	}
	public GeneralTreeNode getRoot() {
		return root;
	}
	
	//Insert node
	public GeneralTreeNode insertRoot(int data) {
		root = new GeneralTreeNode(data);
		return root;
	}
	public GeneralTreeNode insertChild(GeneralTreeNode parent, int data) {
		if (parent == null) {
			throw new IllegalArgumentException("Parent cannot be null");
		}
		GeneralTreeNode child = new GeneralTreeNode(data);
		parent.addChild(child);
		return child;
	}
	
	//Search node
    public GeneralTreeNode search(int value) {
        return searchRec(root, value);
    }

    private GeneralTreeNode searchRec(GeneralTreeNode node, int value) {
        if (node == null) return null;
        if (node.getData() == value) return node;

        // search children
        GeneralTreeNode child = node.getFirstChild();
        while (child != null) {
            GeneralTreeNode found = searchRec(child, value);
            if (found != null) return found;
            child = child.getNextSibling();
        }
        return null;
    }
    
    //Update node
    public boolean update(int oldVal, int newVal) {
        GeneralTreeNode node = search(oldVal);
        if (node == null) return false;

        node.data = newVal; 
        return true;
    }
    
    //Delete node
    public boolean delete(int value) {
        if (root == null) return false;
        if (root.getData() == value) {
            clear();
            return true;
        }

        return deleteRec(root, value);
    }
    private boolean deleteRec(GeneralTreeNode parent, int data) {
    	if (parent == null || parent.getFirstChild() == null) return false;
    	GeneralTreeNode child = parent.getFirstChild();
    	if (child.getData() == data) {
    		child.setNextSibling(null);
    		return true;
    	}
    	while (child.getNextSibling() != null) {
    		GeneralTreeNode next = child.getNextSibling();
    		if (next.getData() == data) {
    			child.setNextSibling(next.getNextSibling());
    			next.setNextSibling(null);
    			return true;
    		}
    		child = next;
    	}
    	child = parent.getFirstChild();
    	while (child != null) {
    		if (deleteRec(child, data)) return true;
    		child = child.getNextSibling();
    	}
    	return false;
    }
    
    //Traversal
    public List<Integer> dfs() {
        List<Integer> list = new ArrayList<>();
        dfsRec(root, list);
        return list;
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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<GeneralTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            GeneralTreeNode node = q.poll();
            res.add(node.getData());
            GeneralTreeNode child = node.getFirstChild();
            while (child != null) {
                q.add(child);
                child = child.getNextSibling();
            }
        }
        return res;
    }
}
