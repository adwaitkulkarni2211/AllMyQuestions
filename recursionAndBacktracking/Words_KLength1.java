package recursionAndBacktracking;

import java.io.*;
import java.util.*;

public class Words_KLength1 {
    public static void solve(String uni, int k, int idx, int ssf, Character[] spots) {
        if(idx == uni.length()) {
            if(ssf == k) {
                for(int i=0; i<spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        
        char ch = uni.charAt(idx);
        
        for(int i=0; i<spots.length; i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                solve(uni, k, idx + 1, ssf + 1, spots);   
                spots[i] = null;
            }
        }
        
        solve(uni, k, idx + 1, ssf, spots);
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
        
        solve(ustr, k, 0, 0, new Character[k]);
    }

}
