package hashMapsAndHeaps2;
import java.util.*;

public class QuadrupletSum2 {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                
                sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;
        
        for(int i=0; i<nums3.length; i++) {
            for(int j=0; j<nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                
                if(sumFreq.containsKey(-sum)) {
                    count += sumFreq.get(-sum);
                }
            }
        }
        
        return count;
    }
}
