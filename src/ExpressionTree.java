public class ExpressionTree {
    private Node root;
    
    public ExpressionTree(Node root)
    {
        this.root = root;
    }

    public void updateRoot()
    {
        root = root.getParent() != null ? root.getParent() : root;
    }
    
    public void printInOrder() {
        System.out.print("InOrder: ");
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
        System.out.println("PostOrder: ");
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
        System.out.println("PreOrder: ");
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
