package hashMapAndHeap;
import java.util.*;
public class HashMapBasic {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("India", 135);
		hm.put("UK", 20);
		hm.put("USA", 30);
		hm.put("Brazil", 50);
		hm.put("China", 170);
		System.out.println(hm);
		
		hm.put("Nigeria", 5);
		hm.put("USA", 35);
		System.out.println(hm);
		
		System.out.println(hm.get("India"));
		System.out.println(hm.get("Japan"));
		
		System.out.println(hm.containsKey("India"));
		System.out.println(hm.containsKey("Japan"));
		
		Set<String> keys = hm.keySet();
		System.out.println(keys);
		
		for(String key: hm.keySet()) {
			int val = hm.get(key);
			System.out.println(key + " - " + val);
		}
	}
}
