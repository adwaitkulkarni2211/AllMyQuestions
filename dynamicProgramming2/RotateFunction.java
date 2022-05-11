package dynamicProgramming2;

public class RotateFunction {
	public int maxRotateFunction(int[] nums) {
        int sum = 0, sfs = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sfs += (i * nums[i]);
        }
        
        int max = sfs;
        for(int i = 0; i < nums.length - 1; i++) {
            int nextSum = sfs - sum + (nums.length * nums[i]);
            max = Math.max(max, nextSum);
            sfs = nextSum;
        }
        
        return max;
    }
}
