package stacks;
import java.io.*;
import java.util.*;
public class InfixEvaluation {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        Stack < Integer > operand = new Stack < > ();
        Stack < Character > operator = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(ch - '0');
            } else if (ch == ')') {
                while (operator.size() != 0 && operator.peek() != '(') {
                    char optor = operator.pop();
                    int upper = operand.pop();
                    int lower = operand.pop();

                    int opv = operation(lower, upper, optor);
                    operand.push(opv);
                }
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //ch is wanting higher priority operators to solve first
                while (operator.size() != 0 && operator.peek() != '(' &&
                    (precedence(ch) <= precedence(operator.peek()))) {
                    char optor = operator.pop();
                    int upper = operand.pop();
                    int lower = operand.pop();

                    int opv = operation(lower, upper, optor);
                    operand.push(opv);
                }
                //ch is pushing itself now
                operator.push(ch);
            }

        }
        while (operator.size() != 0) {
            char optor = operator.pop();
            int upper = operand.pop();
            int lower = operand.pop();

            int opv = operation(lower, upper, optor);
            operand.push(opv);
        }
        System.out.println(operand.peek());

    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int val1, int val2, char op) {
        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else if (op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

}
