package hashMapsAndHeaps2;
import java.util.*;
public class GroupAnagrams {
	public List<List<String>> groupAnagramsBetter(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        
        for(String str: strs) {
            HashMap<Character, Integer> fmap = getFmap(str);
            List<String> group = map.getOrDefault(fmap, new ArrayList<>());
            group.add(str);
            map.put(fmap, group);
        }
        
        for(HashMap<Character, Integer> key: map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
    
    private HashMap<Character, Integer> getFmap(String str) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        
        return fmap;
    }
    
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
