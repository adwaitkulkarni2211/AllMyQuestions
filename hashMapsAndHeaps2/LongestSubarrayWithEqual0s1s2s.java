package hashMapsAndHeaps2;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithEqual0s1s2s {
	public static int solution(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        int ans = 0, c1 = 0, c0 = 0, c2 = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                c0++;
            } else if(arr[i] == 1) {
                c1++;
            } else {
                c2++;
            }

            String str = (c1 - c0) + "#" + (c2 - c1);

            if(map.containsKey(str)) {
                int currLength = i - map.get(str);
                ans = Math.max(ans, currLength);
            } else {
                map.put(str, i);
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
