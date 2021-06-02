package recursionAndBacktracking;
import java.util.*;
public class Words_KSelections {
	public static void solve(int n, String uni, String asf, int idx) {
        if(idx == uni.length()) {
            if(asf.length() == n) {
                System.out.println(asf);
            }
            return;
        }
        char ch = uni.charAt(idx);
        solve(n, uni, asf + ch, idx + 1);
        solve(n, uni, asf, idx + 1);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        sc.close();
        HashSet<Character> set = new HashSet<>();
        String uni = "";
        for(char ch: str.toCharArray()) {
            if(!set.contains(ch)) {
                set.add(ch);
                uni += ch;
            }
        }
        
        solve(n, uni, "", 0);
    }
}
