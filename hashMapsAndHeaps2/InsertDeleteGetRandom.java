package hashMapsAndHeaps2;
import java.util.*;

public class InsertDeleteGetRandom {
	class RandomizedSet {
	    
	    HashMap<Integer, Integer> map;
	    ArrayList<Integer> list;

	    public RandomizedSet() {
	        map = new HashMap<>();
	        list = new ArrayList<>();
	    }
	    
	    public boolean insert(int val) {
	        if(map.containsKey(val)) {
	            return false;
	        } else {
	            list.add(val);
	            map.put(val, list.size() - 1);
	            return true;
	        }
	    }
	    
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) {
	            return false;
	        }
	        
	        int valIdx = map.get(val);
	        
	        int temp = list.get(list.size() - 1);
	        list.set(valIdx, temp);
	        list.set(list.size() - 1, val);
	        
	        map.put(temp, valIdx);
	        
	        list.remove(list.size() - 1);
	        map.remove(val);
	        
	        return true;
	    }
	    
	    public int getRandom() {
	        Random rand = new Random();
	        int idx = rand.nextInt(list.size());
	        
	        return list.get(idx);
	    }
	}
}
