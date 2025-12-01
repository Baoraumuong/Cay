public class GeneralTreeNode extends Node {

    private GeneralTreeNode firstChild;
    private GeneralTreeNode nextSibling;
    private int value;

    public GeneralTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public GeneralTreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(GeneralTreeNode firstChild) {
        this.firstChild = firstChild;
        if (firstChild != null) {
            firstChild.setParent(this);
        }
    }

    public GeneralTreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(GeneralTreeNode nextSibling) {
        this.nextSibling = nextSibling;
        if (nextSibling != null) {
            nextSibling.setParent(this.parent); 
        }
    }

    @Override
    public String toString() {
        return "GeneralTreeNode{" + "value=" + value + '}';
    }
}
