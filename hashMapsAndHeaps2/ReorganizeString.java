package hashMapsAndHeaps2;
import java.util.*;

public class ReorganizeString {
	class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch: map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }
        
        char[] ans = new char[s.length()];
        
        Pair prev = new Pair('.', -1);
        
        for(int i=0; i<ans.length; i++) {
            if(pq.size() == 0) {
                return "";
            }
            Pair curr = pq.remove();
            
            ans[i] = curr.ch;
            curr.freq--;
            
            if(prev.freq > 0)
                pq.add(prev);
            
            prev = curr;
        }
        
        return String.valueOf(ans);
    }
}
