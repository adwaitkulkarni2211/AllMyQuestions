package recursionAndBacktracking;

import java.io.*;
import java.util.*;

public class Words_KSelections4 {
    public static void solve(String uni, HashMap<Character, Integer> fmap, int cs, int ts, int lc, String asf) {
        if(cs == ts) {
            System.out.println(asf);
            return;
        }
        
        for(int i = lc; i<uni.length(); i++) {
            char ch = uni.charAt(i);
            
            if(fmap.get(ch) > 0) {
                fmap.put(ch, fmap.get(ch) - 1);
                solve(uni, fmap, cs + 1, ts, i, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        solve(ustr, unique, 0, k, 0, "");
    }

}
