package hashMapsAndHeaps2;
import java.util.*;

public class QuadrupletSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

		List<List<Integer>> ans = new ArrayList<>();
		HashSet<ArrayList<Integer>> set = new HashSet<>();

		for(int i=0; i<nums.length - 3; i++) {
			for(int j=i + 1; j<nums.length - 2; j++) {
				int pairTar = target - (nums[i] + nums[j]);
				ArrayList<ArrayList<Integer>> pairs = twoSum(nums, j + 1, nums.length - 1, pairTar);

				for(ArrayList<Integer> pair: pairs) {
					ArrayList<Integer> quadruplet = new ArrayList<>();
					quadruplet.add(nums[i]);
					quadruplet.add(nums[j]);
					quadruplet.add(pair.get(0));
					quadruplet.add(pair.get(1));

					if(!set.contains(quadruplet)) {
						set.add(quadruplet);
						ans.add(quadruplet);
					}
				}
			}
		}

		return ans;
    }
    
    private ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int end, int target) {
		int left = start, right = end;

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		while(left < right) {
			if(nums[left] + nums[right] < target) {
				left++;
			} else if(nums[left] + nums[right] > target) {
				right--;
			} else {
				ArrayList<Integer> pair = new ArrayList<>();
				pair.add(nums[left]);
				pair.add(nums[right]);
				ans.add(pair);
				left++;
				right--;
			}
		}

		return ans;
	}
}
