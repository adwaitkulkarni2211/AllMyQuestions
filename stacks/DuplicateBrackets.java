package stacks;
import java.util.*;
public class DuplicateBrackets {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Stack < Character > st = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                st.push(str.charAt(i));
            } else {
                if (st.peek() == '(') {
                    System.out.println("true");
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            }
            System.out.println(st);
        }
        System.out.println("false");
    }
}
