package stacks;
import java.io.*;
import java.util.*;
public class InfixConversions {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack < String > post = new Stack < > ();
        Stack < String > pre = new Stack < > ();
        Stack < Character > ops = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                ops.push(ch);

            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    char op = ops.pop();
                    String upperPost = post.pop();
                    String lowerPost = post.pop();
                    String postVal = lowerPost + upperPost + op;
                    post.push(postVal);

                    String upperPre = pre.pop();
                    String lowerPre = pre.pop();
                    String preVal = op + lowerPre + upperPre;
                    pre.push(preVal);
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() != 0 && ops.peek() != '(' &&
                		precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();
                    String upperPost = post.pop();
                    String lowerPost = post.pop();
                    String postVal = lowerPost + upperPost + op;
                    post.push(postVal);

                    String upperPre = pre.pop();
                    String lowerPre = pre.pop();
                    String preVal = op + lowerPre + upperPre;
                    pre.push(preVal);
                }
                ops.push(ch);
            }
            System.out.println(ops);
        }

        while (ops.size() != 0) {
            char op = ops.pop();
            String upperPost = post.pop();
            String lowerPost = post.pop();
            String postVal = lowerPost + upperPost + op;
            post.push(postVal);

            String upperPre = pre.pop();
            String lowerPre = pre.pop();
            String preVal = op + lowerPre + upperPre;
            pre.push(preVal);
            System.out.println(ops);
        }
        System.out.println("post: " + post);
        
        System.out.println(post.pop());
        System.out.println(pre.pop());
    }

    public static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
