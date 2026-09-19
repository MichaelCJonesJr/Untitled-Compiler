public class Node {
    private Node lchild;
    private Node rchild;
    private Node parent;
    private Object value;

    public Node(Object value, Node parent, Node lchild, Node rchild) {
        this.value = value;
        this.parent = parent;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public Node(Object value) {
        this.value = value;
        this.parent = null;
        this.lchild = null;
        this.rchild = null;
    }

    // this is done so improperly its kind of crazy
    public Object evaluate() {
        Object result = null;
        if(!(lchild != null && rchild != null))
        {
            try {
                //System.out.println(Integer.valueOf((String)value) + " value");
                return Integer.valueOf((String)value + "");
            } catch (NumberFormatException e) {
            
            }
        }
        int l = Integer.parseInt(lchild.evaluate() + "");
        int r = Integer.parseInt(rchild.evaluate() + "");
        switch ((String)value) {
            case "+" -> result = l + r;
            case "-" -> result = l - r;
            case "x" -> result = l * r;
            case "/" -> result = l / r;
            default -> System.out.println("\nevaulation tree compiler error:" + value);
        }
        System.out.println("operator: " + value + " left: " + l + " right: " + r);
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

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return "(L:" + lchild + ") " + "V:" + value + " (R:" + rchild + ")";
    }
}
