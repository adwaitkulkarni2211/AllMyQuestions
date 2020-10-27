package strings;
import java.util.*;
public class PrintAllPermutations {
	public static void solution(String str) {
        // write your code here
        int n = str.length(), fact = 1;
        for(int i=n; i>0; i--) {
            fact = fact * i;
        }
        for(int i=0; i<fact; i++) {
            StringBuilder sb = new StringBuilder(str);
            StringBuilder ans = new StringBuilder();
            int q = i;
            for(int j=str.length(); j>=1; j--) {
                int r = q % j;
                //System.out.println(q + " % " + j + " r: "+ r);
                q = q / j;
                ans.append(sb.charAt(r));
                //System.out.println("ans: "+ ans);
                sb.deleteCharAt(r);
                //System.out.println("sb: "+ sb);
            }
            System.out.println(ans);
            //System.out.println("sb1: "+ sb);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        solution(str);
    }
}
