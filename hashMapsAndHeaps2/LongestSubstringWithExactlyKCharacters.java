package hashMapsAndHeaps2;

import java.util.HashMap;

public class LongestSubstringWithExactlyKCharacters {
	public int longestkSubstr(String s, int k) {
        if(k > s.length()) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0, j = 0, ans = -1;
        while(j < s.length()) {
            //acquire
            while(j < s.length() && map.size() <= k) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                j++;
                
                if(map.size() <= k) 
                    ans = Math.max(ans, j - i);
                
                //System.out.println("Included " + ch + " map: " + map + " ans: " + ans);
            }
            
            if(j == s.length() && map.size() < k) {
                return -1;
            }
            
            //release
            while(i < j && map.size() > k) {
                char ch = s.charAt(i);
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                i++;
                //System.out.println("Removed " + ch + " map: " + map + " ans: " + ans);
            }
        }
        
        return ans;
    }
}
