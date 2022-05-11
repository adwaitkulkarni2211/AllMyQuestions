package hashMapsAndHeaps2;

import java.util.HashMap;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
	class Solution {
	    public int minSteps(String s, String t) {
	        int n = s.length(), m = t.length();
	        
	        HashMap<Character, Integer> fmap = new HashMap<>();
	        
	        for(int i = 0; i < n; i++) {
	            fmap.put(s.charAt(i), fmap.getOrDefault(s.charAt(i), 0) + 1);
	        }
	        
	        int unMatchedChars = 0;
	        
	        for(int i = 0; i < m; i++) {
	            char ch = t.charAt(i);
	            
	            if(fmap.containsKey(ch)) {
	                if(fmap.get(ch) == 1) {
	                    fmap.remove(ch);
	                } else {
	                    fmap.put(ch, fmap.get(ch) - 1);
	                }
	            } else {
	                unMatchedChars++;
	            }
	        }
	        
	        return unMatchedChars;
	    }
	}
}
