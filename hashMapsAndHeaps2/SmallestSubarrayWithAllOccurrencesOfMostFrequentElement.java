package hashMapsAndHeaps2;
import java.util.*;

public class SmallestSubarrayWithAllOccurrencesOfMostFrequentElement {
	class Pair {
        int freq, first, last;
        
        Pair(int freq, int first, int last) {
            this.freq = freq;
            this.first = first;
            this.last = last;
        }
    }
  
    ArrayList<Integer> smallestSubsegment(int nums[], int n) {
        HashMap<Integer, Pair> fmap = new HashMap<>();
        
        int maxFreq = Integer.MIN_VALUE, maxNum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(fmap.containsKey(nums[i])) {
                fmap.put(nums[i], new Pair(fmap.get(nums[i]).freq + 1, fmap.get(nums[i]).first, i));
            } else {
                fmap.put(nums[i], new Pair(1, i, i));
            }
            
            if(fmap.get(nums[i]).freq == maxFreq) {
                int minLen = fmap.get(maxNum).last - fmap.get(maxNum).first + 1;
                int currLen = fmap.get(nums[i]).last - fmap.get(nums[i]).first + 1;
                //System.out.println("minLen: " + minLen + " currLen: " + currLen);
                if(currLen < minLen) {
                    maxNum = nums[i];
                    maxFreq = fmap.get(nums[i]).freq;
                } else if(currLen == minLen) {
                    if(fmap.get(nums[i]).first < fmap.get(maxNum).first) {
                        maxNum = nums[i];
                        maxFreq = fmap.get(nums[i]).freq;
                    }
                }
            } else if(fmap.get(nums[i]).freq > maxFreq) {
                maxNum = nums[i];
                maxFreq = fmap.get(nums[i]).freq;
            }
            
            //System.out.println("num: " + nums[i] + " maxNum: " + maxNum + " maxFreq: " + maxFreq + " map: " + displayMap(fmap));
        }
        
        //System.out.println("num: " + maxNum + " freq: " + fmap.get(maxNum).freq + " last: " + fmap.get(maxNum).last + " first: " + fmap.get(maxNum).first); 
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=fmap.get(maxNum).first; i<=fmap.get(maxNum).last; i++) {
            ans.add(nums[i]);
        }
        
        return ans;
    }
  
    String displayMap(HashMap<Integer, Pair> map) {
        String ans = "{";
        for(int key: map.keySet()) {
            ans += key + "=(" + map.get(key).freq + "," + map.get(key).first + "," + map.get(key).last + "), ";
        }
        
        ans += "}";
        
        return ans;
    }
}
