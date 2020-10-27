package strings;
import java.util.*;
public class ToggleCase {
	public static String toggleCase(String str) {
        //write your code here
        StringBuilder sb = new StringBuilder(str);
        for(int i=0; i<sb.length(); i++) {
            char lc = 0, uc = 0;
            if(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
                lc = sb.charAt(i);
            } else if(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
                uc = sb.charAt(i);
            }
            if(uc == sb.charAt(i)) {
                lc = (char)(uc - 'A' + 'a');
                sb.setCharAt(i, lc);
            } else if(lc == sb.charAt(i)) {
                uc = (char)(lc - 'a' + 'A');
                sb.setCharAt(i, uc);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        System.out.println(toggleCase(str));
    }
}
