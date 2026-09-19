import java.util.Arrays;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        
        String input = "4-1+2x3+2";
        String[] lines = input.split("((?=[:\\+/x()\\-])|(?<=[:\\+/x()\\-]))");
        System.out.println(Arrays.toString(lines));
        Map<String, Integer> map = Map.of("+", 1, "-", 1, "x", 2, "/", 2, "(", 5, ")", 5);
        int index = 3;
        int priority = 0;
        Node root = new Node(lines[1], null, new Node(lines[0]), new Node(lines[2]));
        ExpressionTree answer = new ExpressionTree(root);
        Node pointer = root;
        answer.printInOrder();
        System.out.println("\nloop begins");
        while(input.length() - 1 > index)
        {
            int newPriority = map.get(lines[index]);
            if(newPriority < priority)
            {
                Node temp = new Node(lines[index], null, root, new Node(lines[++index]));
                root.setParent(temp);
                root = temp;
                answer.updateRoot();
                System.out.println("activated");
            }else{
                pointer.setRchild(new Node(lines[index], pointer, pointer.getRchild(), new Node(lines[++index])));
                pointer = root.getRchild();
            }
            index++;
            priority = newPriority;
        }

        System.out.println(Arrays.toString(lines));//change
        System.out.println("look");
        answer.printInOrder();
        System.out.println("\nfinal answer: " + answer.resolve());
        /*
        System.out.println("");
        answer.printPostOrder();
        System.out.println("");
        answer.printPreOrder();
        */

        //tree resolver to solve equation is next
        //add in parenthesis support (also valid parenthesis scanner)
    }  
}

