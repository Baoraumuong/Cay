class GeneralTreeNode extends Node {

    private GeneralTreeNode firstChild;
    private GeneralTreeNode nextSibling;

    public GeneralTreeNode(int data) {
        super(data);
        firstChild = null;
        nextSibling = null;
    }
    public GeneralTreeNode getFirstChild() {
        return firstChild;
    }
    public GeneralTreeNode getNextSibling() {
        return nextSibling;
    }
    public void setFirstChild(GeneralTreeNode child) {
    	this.firstChild = child;
    	if (child != null) {
    		child.parent = this;
    	}
    }
    public void setNextSibling(GeneralTreeNode sibling) {
    	this.nextSibling = sibling;
    	if (sibling != null) {
    		sibling.parent = this.parent;
    	}
    }
    
    public void addChild(GeneralTreeNode child) {
        if (child == null) return;

        child.parent = this;
        if (this.firstChild == null) {
            this.firstChild = child;
        } 
        else {
            GeneralTreeNode current = this.firstChild;
            while (current.nextSibling != null) {
                current = current.nextSibling;
            }
            current.nextSibling = child;
        }
    }
    public void removeChild(GeneralTreeNode child) {
        if (child == null || firstChild == null) return;
        
        if (firstChild == child) {
            firstChild = child.nextSibling;
            child.nextSibling = null;
            child.parent = null;
            return;
        }
        GeneralTreeNode current = firstChild;
        while (current.nextSibling != null) {
            if (current.nextSibling == child) {
                current.nextSibling = child.nextSibling;
                child.nextSibling = null;
                child.parent = null;
                return;
            }
            current = current.nextSibling;
        }
    }

}

