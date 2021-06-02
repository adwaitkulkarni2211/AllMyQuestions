package recursionAndBacktracking;
import java.util.*;
public class VerbalArithmaticPuzzle {
	public boolean isSolvable(String[] words, String result) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> starts = new HashSet<>();
        String uniqueChars = "";
        for(String str: words) {
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                
                if(i == 0) {
                    starts.add(ch);
                }
                
                if(!map.containsKey(ch)) {
                    map.put(ch, -1);
                    uniqueChars += ch;
                }
            }
        }
        for(int i=0; i<result.length(); i++) {
            char ch = result.charAt(i);
            
            if(i == 0) {
                starts.add(ch);
            }
            
            if(!map.containsKey(ch)) {
                map.put(ch, -1);
                uniqueChars += ch;
            }
        }
        //System.out.println(uniqueChars);
        return solve(words, result, map, new boolean[10], uniqueChars, 0, starts);
    }
    
    private boolean solve(String[] words, String result, HashMap<Character, Integer> map,               boolean[] used, String uniqueChars, int idx, HashSet<Character> starts) {
        
        if(idx == uniqueChars.length()) {
            int sum = 0;
            for(String str: words) {
                sum += findNum(str, map);
            }
            if(sum == findNum(result, map)) {
                return true;
            }
            return false;
        }
        
        char ch = uniqueChars.charAt(idx);
        for(int i=0; i<=9; i++) {
            if(i == 0 && starts.contains(ch)) {
                continue;
            }
            if(used[i] == false) {
                used[i] = true;
                map.put(ch, i);

                boolean res = solve(words, result, map, used, uniqueChars, idx + 1, starts);
                if(res) return true;

                map.put(ch, -1);
                used[i] = false;
            }
        }
        
        return false;
    }
    
    private int findNum(String word, HashMap<Character, Integer> map) {
        int num = 0;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            num = num * 10;
            num = num + map.get(ch);
        }
        return num;
    }
}
