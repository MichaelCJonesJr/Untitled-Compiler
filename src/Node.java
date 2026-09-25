public class Node {
    private Node lchild;
    private Node rchild;
    private Node parent;
    private String value;

    public Node(String value, Node parent, Node lchild, Node rchild) {
        this.value = value;
        this.parent = parent;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public Node(String value) {
        this.value = value;
        this.parent = null;
        this.lchild = null;
        this.rchild = null;
    }

    // this is done so improperly its kind of crazy
    public String evaluate() { 
        String result = null;
        if(!(lchild != null && rchild != null))
        {
                return value;
        }

        int l = Integer.parseInt(lchild.evaluate().trim());
        int r = Integer.parseInt(rchild.evaluate().trim());

        switch ((String)value) {
            case "+" -> result = l + r + "";
            case "-" -> result = l - r + "";
            case "*" -> result = l * r + "";
            case "/" -> result = l / r + "";
            case "=" -> result = l + " = " + r;
            default -> System.out.println("\nevaulation tree compiler error:" + value);
        }
        return result; 
    }  

    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
        lchild.setParent(this);
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
        rchild.setParent(this);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "(L:" + lchild + ") " + "V:" + value + " (R:" + rchild + ")";
    }
}
