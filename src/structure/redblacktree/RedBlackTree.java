package structure.redblacktree;


public class RedBlackTree extends BinaryTree {
    private RedBlackTreeNode root;

    //Create new tree
    public RedBlackTree() {
        root = null;
    }
    public RedBlackTreeNode getRoot() {
        return root;
    }

    //Insert node
    public void insert(int data) {
        RedBlackTreeNode newNode = new RedBlackTreeNode(data);
        root = bstInsert(root, newNode);
        fixInsert(newNode);
    }
    
    private RedBlackTreeNode bstInsert(RedBlackTreeNode root, RedBlackTreeNode node) {
        if (root == null)
            return node;
        if (node.getData() < root.getData()) {
            root.setLeft(bstInsert(root.getLeft(), node));
        } else if (node.getData() > root.getData()) {
            root.setRight(bstInsert(root.getRight(), node));
        }
        return root;
    }
    
    //Recover RBTree property
    private void fixInsert(RedBlackTreeNode node) {
        while (node != root && node.getParent().isRed()) {
            RedBlackTreeNode parent = node.getParent();
            RedBlackTreeNode grand = parent.getParent();
            if (parent == grand.getLeft()) {
                RedBlackTreeNode uncle = grand.getRight();
                if (uncle != null && uncle.isRed()) {
                    parent.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grand.setColor(NodeColor.RED);
                    node = grand;
                }
                else {
                    if (node == parent.getRight()) {
                        node = parent;
                        leftRotate(node);
                    }
                    parent.setColor(NodeColor.BLACK);
                    grand.setColor(NodeColor.RED);
                    rightRotate(grand);
                }
            }
            else {
                RedBlackTreeNode uncle = grand.getLeft();
                if (uncle != null && uncle.isRed()) {
                    parent.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grand.setColor(NodeColor.RED);
                    node = grand;
                }
                else {
                    if (node == parent.getLeft()) {
                        node = parent;
                        rightRotate(node);
                    }
                    parent.setColor(NodeColor.BLACK);
                    grand.setColor(NodeColor.RED);
                    leftRotate(grand);
                }
            }
        }
        root.setColor(NodeColor.BLACK);
    }

    //Left rotate
    private void leftRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != null)
            y.getLeft().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null)
            root = y;
        else if (x == x.getParent().getLeft())
            x.getParent().setLeft(y);
        else
            x.getParent().setRight(y);
        y.setLeft(x);
        x.setParent(y);
    }

    //Right rotate
    private void rightRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != null)
            y.getRight().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null)
            root = y;
        else if (x == x.getParent().getRight())
            x.getParent().setRight(y);
        else
            x.getParent().setLeft(y);
        y.setRight(x);
        x.setParent(y);
    }

    //Search node
    public RedBlackTreeNode search(int value) {
        return searchRec(root, value);
    }
    private RedBlackTreeNode searchRec(RedBlackTreeNode node, int value) {
        if (node == null) return null;
        if (value == node.getData()) return node;
        if (value < node.getData())
            return searchRec(node.getLeft(), value);
        else
            return searchRec(node.getRight(), value);
    }
}
