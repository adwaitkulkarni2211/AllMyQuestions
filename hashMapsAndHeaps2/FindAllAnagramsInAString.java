package hashMapsAndHeaps2;

import java.util.*;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return new ArrayList<>();
        }
        
        HashMap<Character, Integer> fmapS = new HashMap<>();
        HashMap<Character, Integer> fmapP = new HashMap<>();
        
        for(int i=0; i<p.length(); i++) {
            fmapP.put(p.charAt(i), fmapP.getOrDefault(p.charAt(i), 0) + 1);
            fmapS.put(s.charAt(i), fmapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        //System.out.println(fmapS + "  " + fmapP);
        
        //acquire and release;
        for(int i=p.length(); i<s.length(); i++) {
            if(fmapS.equals(fmapP)) {
                //System.out.println(fmapS + "  " + fmapP + " i: " + i);
                ans.add(i - p.length()); 
            }
            //acquire
            fmapS.put(s.charAt(i), fmapS.getOrDefault(s.charAt(i), 0) + 1);
            
            //release
            if(fmapS.get(s.charAt(i - p.length())) == 1) {
                fmapS.remove(s.charAt(i - p.length()));
            } else {
                fmapS.put(s.charAt(i - p.length()), fmapS.get(s.charAt(i - p.length())) - 1);
            }
        }
        
        if(fmapS.equals(fmapP)) {
                //System.out.println(fmapS + "  " + fmapP);
                ans.add(s.length() - p.length()); 
            }
        
        return ans;
        
    }
}
