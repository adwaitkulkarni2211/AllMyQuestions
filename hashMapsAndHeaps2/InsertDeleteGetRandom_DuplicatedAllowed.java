package hashMapsAndHeaps2;
import java.util.*;

public class InsertDeleteGetRandom_DuplicatedAllowed {
	class RandomizedCollection {
	    
	    HashMap<Integer, HashSet<Integer>> map;
	    ArrayList<Integer> list;

	    public RandomizedCollection() {
	        map = new HashMap<>();
	        list = new ArrayList<>();
	    }
	    
	    private void add(int val) {
	        //add to arraylist
	        list.add(val);
	        //add to map
	        HashSet<Integer> indices = map.getOrDefault(val, new HashSet<>());
	        indices.add(list.size() - 1);
	        map.put(val, indices);
	        //System.out.println("in add, map: " + displayMap(map) + " list: " + list + " val added: " + val);
	    }
	    
	    public boolean insert(int val) {
	        if(map.containsKey(val)) {
	            add(val);
	            return false;
	        } else {
	            add(val);
	            return true;
	        }
	    }
	    
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) {
	            return false;
	        }
	        
	        //getting the index of val
	        int valIdx = -1;
	        HashSet<Integer> valIndices = map.get(val);
	        for(int idx: valIndices) {
	            valIdx = idx;
	            valIndices.remove(idx);
	            break;
	        }
	        
	        //swapping with the last number in the list
	        int lastVal = list.get(list.size() - 1);
	        list.set(list.size() - 1, val);
	        list.set(valIdx, lastVal);
	        
	        //changing indices in the set for both val and last val
	        valIndices.remove(valIdx);
	        
	        HashSet<Integer> lastValIndices = map.get(lastVal);
	        lastValIndices.add(valIdx);
	        lastValIndices.remove(list.size() - 1);
	        
	        //removing val from map if its indices hashset is empty
	        if(valIndices.size() == 0) {
	            map.remove(val);
	        }
	        
	        //removing val from the end of list
	        list.remove(list.size() - 1);
	        
	        return true;
	    }
	    
	    public int getRandom() {
	        Random rand = new Random();
	        int idx = rand.nextInt(list.size());
	        return list.get(idx);
	    }
	}

}
