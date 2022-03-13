package hashMapsAndHeaps2;

import java.util.HashMap;
import java.util.Scanner;

public class CountOfSubarraysWithSumDivisibleByK {
	public static int solution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }
            
            if(map.containsKey(rem)) {
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }
}
