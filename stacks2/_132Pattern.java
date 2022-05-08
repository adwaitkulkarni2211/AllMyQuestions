package stacks2;

import java.util.Stack;

public class _132Pattern {
	class Solution {
	    public boolean find132pattern(int[] nums) {
	        int[] minArr = new int[nums.length];
	        minArr[0] = nums[0];
	        for(int i = 1; i < nums.length; i++) {
	            minArr[i] = Math.min(minArr[i - 1], nums[i]);
	        }
	        
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = nums.length - 1; i >= 0; i--) {
	            if(nums[i] > minArr[i]) {
	                while(!st.isEmpty() && st.peek() <= minArr[i]) {
	                    st.pop();
	                }
	                if(!st.isEmpty() && st.peek() < nums[i]) {
	                    return true;
	                }
	                st.push(nums[i]);    
	            }
	        }
	        
	        return false;
	    }
	}
}
