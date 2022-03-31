package hashMapsAndHeaps2;
import java.util.*;

public class RandomPickWithBlacklist {
	class Solution {
	    HashMap<Integer, Integer> map;
	    int top;
	    Random rand;
	    public Solution(int n, int[] blacklist) {
	        this.map = new HashMap<>();
	        this.top = n - blacklist.length;
	        this.rand = new Random();
	        
	        for(int val: blacklist) {
	            map.put(val, -1);
	        }
	        
	        //removing the last blacklist.length nums from consideration and map them to the blacklisted nums 
	        n--;
	        for(int i=0; i<blacklist.length; i++) {
	            if(blacklist[i] < top) {
	                while(map.containsKey(n)) {
	                    n--;
	                }
	                map.put(blacklist[i], n);
	                n--;
	            }
	        }
	        
	    }
	    
	    public int pick() {
	        int num = rand.nextInt(top);
	        if(map.containsKey(num)) {
	            num = map.get(num);
	        }
	        return num;
	    }
	}

}
