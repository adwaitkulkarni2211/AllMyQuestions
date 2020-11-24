package recursion;
import java.util.*;
public class PrintPermutationsFOfString {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        printPermutations(s, "");

    }

    public static void printPermutations(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        for(int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i).concat(ques.substring(i + 1));
            printPermutations(roq, ans + ch);
        }        
    }
}
