package hashMapsAndHeaps2;
import java.util.*;
public class NumberOfMatchingSequences {
	public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, LinkedList<String>> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++)
            map.put(c, new LinkedList<>());
        
        for(String word: words) {
            char startChar = word.charAt(0);
            map.get(startChar).add(word);
        }
        
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Queue<String> q = map.get(c);
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String rem = q.remove();
                if(rem.length() == 1)
                    ans++;
                else {
                    String ss = rem.substring(1);
                    map.get(ss.charAt(0)).add(ss);
                }
            }
        }
        
        return ans;
    }
}
