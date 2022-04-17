package bitManipulation;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        int ans1 = bits(nums);
        int ans2 = sum(nums);
        System.out.println("ans1: " + ans1 + " ans2: " + ans2);
        return ans1;
    }
    
    private int bits(int[] nums) {
        //xor of all elements
        int xor = 0;
        for(int num: nums) {
            xor ^= num;
        }
        //xor whith the numbers in range [0, n]
        for(int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        
        return xor;
    }
    
    private int sum(int[] nums) {
        int n = nums.length;
        int sum = (n) * (n + 1) / 2;
        
        int tot = 0;
        for(int i=0; i<nums.length; i++) {
            tot += nums[i];
        }
        
        return sum - tot;
    }
}
