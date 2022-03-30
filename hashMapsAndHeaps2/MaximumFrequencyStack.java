package hashMapsAndHeaps2;
import java.util.*;

public class MaximumFrequencyStack {
	class FreqStack {
	    HashMap<Integer, Integer> fmap;
	    HashMap<Integer, Stack<Integer>> fHistory;
	    int maxFreq;
	    
	    public FreqStack() {
	        fmap = new HashMap<>();
	        fHistory = new HashMap<>();
	        maxFreq = 0;
	    }
	    
	    public void push(int val) {
	        //insert val into fmap
	        fmap.put(val, fmap.getOrDefault(val, 0) + 1);
	        int freq = fmap.get(val);
	        
	        //insert val into its freq stack
	        Stack<Integer> st = fHistory.getOrDefault(freq, new Stack<>());
	        st.push(val);
	        fHistory.put(freq, st);
	        
	        if(freq > maxFreq) {
	            maxFreq = freq;
	        }
	    }
	    
	    public int pop() {
	        int val = fHistory.get(maxFreq).peek();
	        
	        //removing from fHistory
	        if(fHistory.get(maxFreq).size() == 1) {
	            fHistory.remove(maxFreq);
	            maxFreq--;
	        } else {
	            fHistory.get(maxFreq).pop();
	        }
	        
	        //removing from fmap
	        if(fmap.get(val) == 1) {
	            fmap.remove(val);
	        } else {
	            fmap.put(val, fmap.get(val) - 1);
	        }
	        
	        return val;
	    }
	}

}
