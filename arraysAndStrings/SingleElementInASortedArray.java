package arraysAndStrings;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + right / 2;

            if(mid == 0) {
                if(nums[mid + 1] == nums[mid])
                    return nums[mid];
            }
            if(mid == nums.length - 1)
                if(nums[mid - 1] == nums[mid])
                    return nums[mid];


            if(nums[mid - 1] == nums[mid]) {
                if(mid % 2 != 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if(nums[mid + 1] == nums[mid]) {
                if(mid % 2 != 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return 0;
    }
}
