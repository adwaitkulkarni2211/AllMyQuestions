package stacks2;
import java.util.*;

public class NextGreaterElement2 {
	class Solution {
	    public int[] nextGreaterElements(int[] nums) {
	        return nge(nums, nums.length);
	    }
	    
	    private int[] nge(int[] nums, int n) {
	        Stack<Integer> st = new Stack<>();
	        st.push(0);
	        
	        int[] nge = new int[n];
	        
	        for(int i = 1; i < 2 * n; i++) {
	            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
	                nge[st.pop()] = nums[i % n];
	            }
	            
	            if(i < n)
	                st.push(i % n);
	            //System.out.println("St: " + st + " i: " + i);
	        }
	        
	        while(!st.isEmpty()) {
	            nge[st.pop()] = -1;
	        }
	        
	        return nge;
	    }
	}
}
