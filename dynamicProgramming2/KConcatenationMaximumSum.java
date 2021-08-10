package dynamicProgramming2;

public class KConcatenationMaximumSum {
	int mod = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1) {
            int ans = (int)(kadanes(arr) % mod);
            return ans > 0 ? ans : 0;
        }
        
        long sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        
        if(sum < 0) {
            int ans = (int) (kadanesOfTwo(arr) % mod);
            return ans > 0 ? ans : 0;
        } else {
            int ans = (int) ((kadanesOfTwo(arr) + (k - 2) * sum) % mod);
            return ans > 0 ? ans : 0;
        }
    }
    
    private long kadanes(int[] nums) {
        long ob = nums[0], cb = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(cb < 0) {
                cb = nums[i];
            } else {
                cb = cb + nums[i];
            }
            ob = Math.max(ob, cb);
        }
        return ob;
    }
    
    public long kadanesOfTwo(int arr[]) {
        int[] nums = new int[2 * arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = arr[i];
            nums[i + arr.length] = arr[i];
        }
        
        return kadanes(nums);
    }
}
