import java.util.Arrays;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {

        String input = "4-1+2x3+2";
        String[] lines = input.split("((?=[:\\+/x()\\-])|(?<=[:\\+/x()\\-]))");
        System.out.println(Arrays.toString(lines));
        Map<String, Integer> map = Map.of("+", 1, "-", 1, "x", 2, "/", 2, "(", 5, ")", 5);
        int index = 3;
        int priority = -1;
        Stack<Node> nodes = new Stack<Node>(8);
        Stack<Node> ops = new Stack<Node>(8);

        // wonder what the index jumping for this logic would look like like i really
        // wonder #IMPORTANT
        for (String token : lines) {
            if (map.get(token) == null) {
                nodes.push(new Node(token));
            } else {
                    while (map.get(token) <= priority && !ops.isEmpty()) {
                        Node temp = nodes.pop();
                        Node operator = ops.pop();
                        nodes.push(new Node(operator.getValue(), null, nodes.pop(), temp));// if this was a swapped constructor could save mem
                        priority = ops.isEmpty() ? -1 : map.get((String) ops.peek().getValue());
                        
                    }
                    priority = map.get(token);
                    ops.push(new Node(token));
            }
        }

        while (!ops.isEmpty()) {
            Node temp = nodes.pop();
            Node operator = ops.pop();
            nodes.push(new Node(operator.getValue(), null, nodes.pop(), temp));// if this was a swapped constructor
            priority = map.get((String) operator.getValue());
        }

        ExpressionTree result = new ExpressionTree(nodes.pop());
        result.printInOrder();
        System.out.println(result.resolve());

    }
}
