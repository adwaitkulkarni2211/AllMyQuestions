package hashMapsAndHeaps2;

import java.util.HashMap;

public class CountArrayPairsDivisibleByK {
	public static int countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<k; i++) {
            map.put(i, 0);
        }
        
        for(int i=0; i<arr.length; i++) {
            int rem = arr[i] % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            map.put(rem, map.get(rem) + 1);
        }
        
        int ans = 0;
        int zeroFreq = map.get(0);
        ans += (zeroFreq * (zeroFreq - 1) / 2);
        
        int left = 1, right = k - 1;
        
        while(left <= right) {
            if(left == right) {
                int freq = map.get(left);
                ans += (freq * (freq - 1) / 2);
            } else {
                ans += map.get(left) * map.get(right);
            }
            
            left++;
            right--;
        }
        
        return ans;
    }
}
