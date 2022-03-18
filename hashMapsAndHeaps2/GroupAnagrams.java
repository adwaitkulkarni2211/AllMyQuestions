package hashMapsAndHeaps2;
import java.util.*;
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] list) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(int i=0; i<list.length; i++) {
            char[] str = list[i].toCharArray();
            Arrays.sort(str);
            String temp = String.valueOf(str);
            
            if(map.containsKey(temp)) {
                map.get(temp).add(list[i]);
            } else {
                map.put(temp, new ArrayList<>());
                map.get(temp).add(list[i]);
            }
        }
        
        for(String str: map.keySet()) {
            ans.add(map.get(str));
        }
        
        return ans;
    }
}
