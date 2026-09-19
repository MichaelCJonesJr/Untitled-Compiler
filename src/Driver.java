import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class Driver {
    static BufferedReader stdin;
    static BufferedWriter stdout;
    public static void main(String[] args) throws Exception{//horrible coding practice i think fix it later
        System.out.println("enter the filepath of the file you wish to compile:\n");
        stdin = new BufferedReader (new InputStreamReader(System.in));
        String filepath = stdin.readLine().trim();
        stdin = new BufferedReader (new FileReader(filepath));
        stdout = new BufferedWriter(new FileWriter(filepath.substring(0, filepath.lastIndexOf(".")) + ".java"));
        String line = stdin.readLine();
        while(line != null)
        {
            line = line.trim();
            stdout.write(evaluateExpression(line));
            stdout.newLine();
            line = stdin.readLine();
        }
        stdout.flush();
    }

    public static String evaluateExpression(String line) {
        try {
            String[] lines = line.split("((?=[:\\+/x()\\-])|(?<=[:\\+/x()\\-]))");
            System.out.println(Arrays.toString(lines));
            Map<String, Integer> map = Map.of("+", 1, "-", 1, "x", 2, "/", 2, "(", 5, ")", 5);
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
                        nodes.push(new Node(operator.getValue(), null, nodes.pop(), temp));// if this was a swapped
                                                                                           // constructor could save
                                                                                           // memory #IMPORTANT
                        priority = ops.isEmpty() ? -1 : map.get((String) ops.peek().getValue());

                    }
                    priority = map.get(token);
                    ops.push(new Node(token));
                }
            }

            while (!ops.isEmpty()) {
                Node temp = nodes.pop();
                Node operator = ops.pop();
                nodes.push(new Node(operator.getValue(), null, nodes.pop(), temp));
                priority = map.get((String) operator.getValue());
            }

            ExpressionTree result = new ExpressionTree(nodes.pop());
            result.printInOrder();
            return result.resolve() + "";
        } catch (Exception e) {
            return "compilation error on this line: " + line;
        }
    }
}
