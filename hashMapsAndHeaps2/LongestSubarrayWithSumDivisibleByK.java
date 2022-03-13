package hashMapsAndHeaps2;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithSumDivisibleByK {
	public static int solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, ans = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }

            if(map.containsKey(rem)) {
                int currLength = i - map.get(rem);
                ans = Math.max(ans, currLength);
            } else {
                map.put(rem, i);
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
