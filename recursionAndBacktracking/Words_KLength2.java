package recursionAndBacktracking;

import java.io.*;
import java.util.*;

public class Words_KLength2 {
    
    public static void solve(String uni, int k, int cb, String asf, HashSet<Character> hs) {
        if(cb == k) {
            System.out.println(asf);
            return;
        }
        
        for(int i=0; i<uni.length(); i++) {
            char ch = uni.charAt(i);
            if(!hs.contains(ch)) {
                hs.add(ch);
                solve(uni, k, cb + 1, asf + ch, hs);
                hs.remove(ch);
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }
        
        solve(ustr, k, 0, "", new HashSet<>());
    }

}
