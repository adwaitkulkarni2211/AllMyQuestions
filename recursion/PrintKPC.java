package recursion;
import java.util.*;
public class PrintKPC {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        printKPC(s, "");
    }

    static String[] codes = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void printKPC(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        for (int i = 0; i < codes[ch - 48].length(); i++) {
            printKPC(roq, ans + codes[ch - 48].charAt(i));
        }

    }
}
