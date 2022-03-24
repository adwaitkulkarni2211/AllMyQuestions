package hashMapsAndHeaps2;
import java.util.*;

public class FirstNonRepeatingCharacter {
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        int fnrc = -1;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            
            if(fmap.get(ch) == 1) {
                q.add(i);
            } else {
                while(!q.isEmpty() && fmap.get(s.charAt(q.peek())) > 1) {
                    q.remove();
                }
            }
            fnrc = q.isEmpty() ? -1 : q.peek();
        }
        
        return fnrc;
    }
}
