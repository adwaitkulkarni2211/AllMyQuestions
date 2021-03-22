package binaryTrees2;
import java.util.*;

public class ConstructBTFormStringBracketRepresentation {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static void preOrder(Node node) {
        if (node == null)
          return;
        System.out.printf("%d ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public static void main (String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = solve(str);
        preOrder(root);
        
    }
    static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static Node solve(String str) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(str.charAt(0) - '0');
        st.push(new Pair(root, 0));
        
        for(int i=1; i<str.length(); i++) {
            char ch = str.charAt(i);
            Pair top = st.peek();
            
            if(ch >= '0' && ch <= '9') {
                Node child = new Node(ch - '0');
                if(top.state == 1) {
                    top.node.left = child;    
                } else if(top.state == 2){
                    top.node.right = child;
                }
                st.push(new Pair(child, 0));
            } else if(ch == '(') {
                top.state++;
            } else if(ch == ')') {
                st.pop();
            }
        }
        return root;
    }
}
