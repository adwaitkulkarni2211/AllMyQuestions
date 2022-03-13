package hashMapsAndHeaps2;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithEqual0sAnd1s {
	public static int solution(int[] nums) {
        int sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            if(map.containsKey(sum)) {
                int currLength = i - map.get(sum);
                ans = Math.max(ans, currLength);
            } else {
                map.put(sum, i);
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
        scn.close();
        System.out.println(solution(arr));
    }
}
