package searching;

public class SearchInSortedRotatedArray2 {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target) {
                return true;
            }
            
            if(nums[lo] < nums[mid]) {
                if(target < nums[lo] || target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if(nums[lo] > nums[mid]) {
                if(target < nums[mid] || target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                lo++;
            }
        }
        return false;
    }
}
