package stacks;
import java.io.*;
import java.util.*;
public class PrefixEvaluationAndCoversion {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        Stack < Integer > value = new Stack < > ();
        Stack < String > in = new Stack < > ();
        Stack < String > pre = new Stack < > ();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                int upVal = value.pop();
                int lowVal = value.pop();
                int op = operation(ch, upVal, lowVal);
                value.push(op);

                String upIn = in .pop();
                String lowIn = in .pop(); 
                in.push('(' + upIn + ch + lowIn + ')');

                String upPre = pre.pop();
                String lowPre = pre.pop();
                pre.push(upPre + lowPre + ch);

            } else {
                value.push((int) ch - '0'); in .push(ch + "");
                pre.push(ch + "");
            }
        }
        System.out.println(value.pop());
        System.out.println( in .pop());
        System.out.println(pre.pop());
    }
    public static int operation(char ch, int v1, int v2) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else if (ch == '/') {
            return v1 / v2;
        } else {
            return 0;
        }
    }
}
