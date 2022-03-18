package hashMapsAndHeaps2;

import java.util.HashMap;

public class CheckIfTwoStringsAreKAnagrams {
	boolean areKAnagrams(String s1, String s2, int k) {
        int n = s1.length(), m = s2.length();
        if(n != m) {
            return false;
        }
        
        HashMap<Character, Integer> fmap = new HashMap<>();
        
        for(int i=0; i<s1.length(); i++) {
            char ch1 = s1.charAt(i);
            fmap.put(ch1, fmap.getOrDefault(ch1, 0) + 1);
        }
        
        int unmatchedChars = 0;
        
        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            
            if(fmap.containsKey(ch)) {
                if(fmap.get(ch) == 1) {
                    fmap.remove(ch);
                } else {
                    fmap.put(ch, fmap.get(ch) - 1);    
                }
            } else {
                unmatchedChars++;
            }
        }
        
        int totFreq = 0;
        for(char key: fmap.keySet()) {
            totFreq += fmap.get(key);
        }
        
        if(totFreq <= k && totFreq == unmatchedChars) {
            return true;
        } else {
            return false;
        }
        
    }
}
