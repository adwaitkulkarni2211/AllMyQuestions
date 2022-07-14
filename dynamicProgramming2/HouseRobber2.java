package dynamicProgramming2;
import java.util.*;

public class HouseRobber2 {
	public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        List<Integer> temp1 = new ArrayList<>(), temp2 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i != 0) temp1.add(nums[i]);
            if(i != nums.length - 1) temp2.add(nums[i]);
        }
        
        return Math.max(solve_so(temp1), solve_so(temp2));
    }
    
    
    private int solve_so(List<Integer> nums) {
        int prev2 = 0, prev1 = nums.get(0);
        
        for(int i = 1; i < nums.size(); i++) {
            int steal = nums.get(i);
            if(i > 1) steal += prev2;
            
            int leave = prev1;
            
            int curr = Math.max(steal, leave);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
