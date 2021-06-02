package recursionAndBacktracking;
import java.io.*;
import java.util.*;
public class Words_KLength3 {
	public static void solve(String str, HashMap<Character, Integer> map, int idx, Character[] spots, int ssf, int ts) {
        if(idx == str.length()) {
            if(ssf == ts) {
                for(int i=0; i<spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        
        char ch = str.charAt(idx);
        int lo = map.get(ch);
        
        for(int i = lo + 1; i<spots.length; i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                map.put(ch, i);
                solve(str, map, idx + 1, spots, ssf + 1, ts);
                map.put(ch, lo);
                spots[i] = null;
            }
        }
        
        if(lo == -1) {
            solve(str, map, idx + 1, spots, ssf, ts);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            map.put(str.charAt(i), -1);
        }
        
        solve(str, map, 0, new Character[k], 0, k);
    }
}
