package recursionAndBacktracking;
import java.util.*;
public class WordBreak {
	HashMap<String, Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        
        HashSet<String> dict = new HashSet<>();
        for(String str: wordDict) {
            dict.add(str);
        }
        
        return solve(s, dict);
    }
    
    private boolean solve(String str, HashSet<String> dict) {
        if(str.length() == 0) {
            return true;
        }
        
        if(dp.containsKey(str)) {
            return dp.get(str);
        }
        
        for(int i=0; i<str.length(); i++) {
            String word = str.substring(0, i + 1);
            
            if(dict.contains(word)) {
                String ros = str.substring(i + 1);
                if(solve(ros, dict)) {
                    dp.put(ros, true);
                    return true;
                }
            }
        }
        
        dp.put(str, false);
        return false;
    }
}
