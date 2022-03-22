package hashMapsAndHeaps2;
import java.util.*;

public class LongestSubarrayWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0, j = 0;
        while(j < s.length()) {
            //acquire
            while(j < s.length()) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                //System.out.println("Including " + ch + " i: " + i + " j: " + j + " map: " + map);
                j++;
                
                if(map.get(ch) > 1) {
                    break;
                } else {
                    int len = j - i;
                    ans = Math.max(ans, len);
                    //System.out.println("ans: " + ans);
                }
            }
            
            //release
            while(i < j) {
                char ch = s.charAt(i);
                if(map.get(ch) == 1) {
                    map.remove(ch); 
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                //System.out.println("removing " + ch + " i: " + i + " j: " + j + " map: " + map);
                i++;
                
                if(map.getOrDefault(ch, 0) == 1) {
                    int len = j - i;
                    ans = Math.max(ans, len);
                    //System.out.println("ans: " + ans);
                    break;
                }
            }
        }
        
        return ans;
    }
}
