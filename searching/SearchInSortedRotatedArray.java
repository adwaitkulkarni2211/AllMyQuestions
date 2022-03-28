package searching;

public class SearchInSortedRotatedArray {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int lo = 0, hi = nums.length - 1;
        //find the pivot index
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        if(target >= nums[lo] && target <= nums[nums.length - 1]) {
            hi = nums.length - 1;
        } else {
            lo = 0;
        }
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if(target < nums[mid]) {
                hi = mid - 1;
            } else if(target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
        
    }
}
