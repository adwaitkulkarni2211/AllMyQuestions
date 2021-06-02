package recursionAndBacktracking;
import java.util.*;
public class Words_KSelections2 {
	public static void solve(String uni, int cs, int ts, int lc, String asf) {
		//cs = current selection
		//ts = total selection
		//lc = last character
        if(cs > ts) {
            System.out.println(asf);
            return;
        }
        
        for(int i=lc + 1; i<uni.length(); i++) {
            char ch = uni.charAt(i);
            solve(uni, cs + 1, ts, i, asf + ch);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        sc.close();
        HashSet<Character> hs = new HashSet<>();
        String uni = "";
        for(char ch: str.toCharArray()) {
            if(!hs.contains(ch)) {
                hs.add(ch);
                uni += ch;
            }
        }
        
        solve(uni, 1, k, -1, "");
    }
}
