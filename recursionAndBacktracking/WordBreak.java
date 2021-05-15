package recursionAndBacktracking;
import java.util.*;
public class WordBreak {
	List<String> toReturn;
    public List<String> wordBreak(String s, List<String> wordDict) {
        toReturn = new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        for(String str: wordDict) {
            dict.add(str);
        }
        solve(s, dict, new ArrayList<>());
        return toReturn;
    }
    
    public void solve(String s, HashSet<String> dict, List<String> ans) {
        if(s.length() == 0) {
            String sentence = "";
            for(int i=0; i<ans.size(); i++) {
                String str = ans.get(i);
                if(i == ans.size() - 1) {
                    sentence += str;
                } else {
                    sentence += str + " ";    
                }
            }
            toReturn.add(sentence);
            return;
        }
        
        for(int i=0; i<s.length(); i++) {
            String word = s.substring(0, i+1);
            if(dict.contains(word)) {
                String ros = s.substring(i+1);
                ans.add(word);
                solve(ros, dict, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
