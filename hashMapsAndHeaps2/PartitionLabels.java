package hashMapsAndHeaps2;
import java.util.*;
public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
        //map stores the last occurrences of chars
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        List<Integer> ans = new ArrayList<>();
        int i=0;
        
        while(i < s.length()) {
            int currPartitionSize = 0;
            char ch = s.charAt(i);
            int lastOccurrence = map.get(ch);

            while(i <= lastOccurrence) {
                ch = s.charAt(i);
                lastOccurrence = Math.max(lastOccurrence, map.get(ch));
                i++;
                currPartitionSize++;
            }
            
            ans.add(currPartitionSize);
        }
        
        return ans;
    }
}
