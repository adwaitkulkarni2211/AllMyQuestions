package dynamicProgramming2;

public class CountNumberOfTexts {
	public int countTexts(String pressedKeys) {
        int[] nums = new int[]{0,0,3,3,3,3,3,4,3,4};
        
        return solve(pressedKeys, nums, 0, new int[pressedKeys.length()]);
    }
    
    private int solve(String pressedKeys, int[] nums, int startIdx, int[] dp) {
        if(startIdx == pressedKeys.length()) {
            return 1;
        }
        
        if(dp[startIdx] != 0) {
            return dp[startIdx];
        }
        
        int combinations = 0, key1 = pressedKeys.charAt(startIdx) - '0', mod = 1000000007;
        
        for(int i = 0; startIdx + i < pressedKeys.length() && i < nums[key1]; i++) {
            int key2 = pressedKeys.charAt(startIdx + i) - '0';
            if(key1 != key2) break;
            
            combinations = (combinations % mod) + (solve(pressedKeys, nums, startIdx + i + 1, dp) % mod);
        }
        
        return dp[startIdx] = combinations % mod;
    }
}
