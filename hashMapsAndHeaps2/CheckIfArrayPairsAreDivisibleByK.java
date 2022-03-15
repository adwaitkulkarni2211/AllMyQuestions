package hashMapsAndHeaps2;

import java.util.HashMap;
import java.util.Scanner;

public class CheckIfArrayPairsAreDivisibleByK {
	public static boolean solution(int[] arr, int k){
HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<=k-1; i++) {
            map.put(i, 0);
        }
        
        for(int i=0; i<arr.length; i++) {
            int rem = arr[i] % k;
            if(rem < 0) {
                rem += k;
            }
            
            map.put(rem, map.get(rem) + 1);
        }
        
        //zero frequency
        if(map.get(0) % 2 != 0) {
            return false;
        }
        
        //other rems
        int left = 1, right = k - 1;
        while(left <= right) {
            if(left == right) {
                if(map.get(left) % 2 != 0) {
                    return false;
                }
            } else {
                int freq1 = map.get(left);
                int freq2 = map.get(right);
                
                if(freq1 != freq2){
                    return false;
                }
            }
            left++;
            right--;
        }
        
        return true;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		scn.close();
		System.out.println(solution(arr,k));
	}
}
