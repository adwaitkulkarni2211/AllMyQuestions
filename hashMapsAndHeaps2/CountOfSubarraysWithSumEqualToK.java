package hashMapsAndHeaps2;

import java.util.*;

public class CountOfSubarraysWithSumEqualToK {
	public static int solution(int[] nums, int k){
		int sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        System.out.println(solution(arr,target));
	}
}
