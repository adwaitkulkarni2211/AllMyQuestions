package dynamicProgramming2;

public class MinimumCostTreeFromLeafValues {
	public int mctFromLeafValues(int[] arr) {
		solve_tab(arr);
        Pair[][] dp = new Pair[arr.length][arr.length];
        return solve(arr, 0, arr.length - 1, dp).ans;
    }
    
    class Pair {
        int ans, max;
        Pair(int ans, int max) {
            this.ans = ans;
            this.max = max;
        }
    }
    
    private Pair solve(int[] arr, int start, int end, Pair[][] dp) {
        if(start == end) return new Pair(0, arr[start]);
        
        if(dp[start][end] != null) return dp[start][end];
        
        int min = Integer.MAX_VALUE, maxNode = Integer.MIN_VALUE;
        for(int i = start; i < end; i++) {
            Pair left = solve(arr, start, i, dp);
            Pair right = solve(arr, i + 1, end, dp);
            
            int val = left.max * right.max;
            
            min = Math.min(min, left.ans + right.ans + val);
            
            maxNode = Math.max(maxNode, arr[i]);
        }
        maxNode = Math.max(maxNode, arr[end]);
        
        return dp[start][end] = new Pair(min, maxNode);
    }
    
    private int solve_tab(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        
        for(int start = arr.length - 1; start >= 0; start--) {
            for(int end = start; end <= arr.length - 1; end++) {
                if(start == end) {
                    dp[start][end] = 0;
                    continue;
                }
                
                int min = Integer.MAX_VALUE;
                for(int i = start; i < end; i++) {
                    int left = dp[start][i];
                    int right = dp[i + 1][end];

                    int leftMax = findLargest(arr, start, i);
                    int rightMax = findLargest(arr, i + 1, end);

                    int val = leftMax * rightMax;

                    min = Math.min(min, left + right + val);
                }

                dp[start][end] = min;
            }
        }
        
        return dp[0][arr.length - 1];
    }
    
    private int findLargest(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
