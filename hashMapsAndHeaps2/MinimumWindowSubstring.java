package hashMapsAndHeaps2;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        
        HashMap<Character, Integer> fmapT = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            fmapT.put(ch, fmapT.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> fmapS = new HashMap<>();
        //acquire and release modified
        int i = 0, j = -1, unmatchedChars = t.length();
        String ans = "";
        
        while(i < s.length()) {
            //acquire
            while(i < s.length() && unmatchedChars > 0) {
                char ch = s.charAt(i);
                fmapS.put(ch, fmapS.getOrDefault(ch, 0) + 1);
                i++;
                
                if(fmapS.getOrDefault(ch, 0) <= fmapT.getOrDefault(ch, 0)) {
                    unmatchedChars--;
                }
            }
            
            //release
            while(unmatchedChars == 0 && j <= i) {
                j++;
                //find the best ans
                String potentialAns = s.substring(j, i);
                if(ans.length() == 0 || potentialAns.length() < ans.length()) {
                    ans = potentialAns;
                }
                
                char ch = s.charAt(j);
                fmapS.put(ch, fmapS.getOrDefault(ch, 0) - 1);
                if(fmapS.getOrDefault(ch, 0) < fmapT.getOrDefault(ch, 0)) {
                    unmatchedChars++;
                }
            }
        }
        
        return ans;
    }
}
