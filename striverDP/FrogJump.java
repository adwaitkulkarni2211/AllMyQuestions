package striverDP;

public class FrogJump {
	class Solution {
	    private int binarySearch(int[] arr, int target) {
	        int left = 0, right = arr.length - 1;
	        
	        while(left <= right) {
	            int mid = left + (right - left) / 2;
	            
	            if(arr[mid] == target) {
	                return mid;
	            } else if(target < arr[mid]) {
	                right = mid - 1;
	            } else if(target > arr[mid]) {
	                left = mid + 1;
	            }
	        }
	        
	        return -1;
	    }
	    
	    private boolean solve(int[] stones, int idx, int jump, Boolean[][] dp) {
	        if(idx == -1 || jump == 0) 
	            return false;
	        
	        if(idx == stones.length - 1) 
	            return true;
	        
	        if(dp[jump][idx] != null) 
	            return dp[jump][idx];
	        
	        int nextStone1 = binarySearch(stones, stones[idx] + jump);
	        int nextStone2 = binarySearch(stones, stones[idx] + jump + 1);
	        int nextStone3 = binarySearch(stones, stones[idx] + jump - 1);
	        
	        return dp[jump][idx] = solve(stones, nextStone1, jump, dp) || 
	                solve(stones, nextStone2, jump + 1, dp) || 
	                solve(stones, nextStone3, jump - 1, dp);
	    }
	    
	    public boolean canCross(int[] stones) {
	        if(!(stones[0] == 0 && stones[1] == 1)) {
	            return false;
	        }
	        
	        Boolean[][] dp = new Boolean[stones.length + 1][stones.length + 1];
	        
	        return solve(stones, 1, 1, dp);
	    }
	}
}
