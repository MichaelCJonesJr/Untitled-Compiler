public class ExpressionTree {
    private Node root;
    private int priority;

    public ExpressionTree(Node root)
    {
        this.root = root;
    }

    public void updateRoot()
    {
        root = root.getParent() != null ? root.getParent() : root;
    }
    
    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node node) {
        if(node != null) {
            printInOrder(node.getLchild());   
            System.out.print(node.getValue());
            printInOrder(node.getRchild());  
        }
    }

    public Object resolve()
    {
        return root.evaluate();
    }
    
    public void printPostOrder() {
        printPostOrder(root);
    }
    private void printPostOrder(Node node) {
        if(node != null) {
            printPostOrder(node.getLchild());   
            printPostOrder(node.getRchild());  
            System.out.print(node.getValue());
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(Node node) {
        if(node != null) {
            System.out.print(node.getValue());
            printPreOrder(node.getLchild());   
            printPreOrder(node.getRchild());  
        }
    }
}
