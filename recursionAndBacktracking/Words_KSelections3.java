package recursionAndBacktracking;

import java.io.*;
import java.util.*;

public class Words_KSelections3 {
    public static void solve(String uni, HashMap<Character, Integer> map, int idx, int k, String asf) {
        if(k < 0) {
            return;
        }
        if(idx == uni.length()) {
            if(k == 0) {
                System.out.println(asf);
            }
            return;
        }
        
        char ch = uni.charAt(idx);
        
        for(int i=map.get(ch); i>=0; i--) {
            String str = "";
            for(int j=0; j<i; j++) {
                str += ch;
            }
            solve(uni, map, idx + 1, k - i, asf + str);
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
        
        solve(ustr, unique, 0, k, "");
    }

}
