package hashMapsAndHeaps2;
import java.util.*;
public class MaximumConsecutiveOnes2 {
	public static int solution(int[] arr){
        HashMap<Integer, Integer> fmap = new HashMap<>();

        int i = 0, j = 0, ans = 0;

        while(j < arr.length) {
            //acquire
            while(j < arr.length && fmap.getOrDefault(0, 0) < 2) {
                fmap.put(arr[j], fmap.getOrDefault(arr[j], 0) + 1);
                j++;

                if(fmap.getOrDefault(0, 0) != 2)
                    ans = Math.max(ans, j - i);
            }

            if(i == 0 && j == arr.length) {
                return arr.length;
            }

            //release
            while(i < j && fmap.get(0) == 2) {
                if(fmap.get(arr[i]) == 1) {
                    fmap.remove(arr[i]);
                } else {
                    fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) - 1);
                }
                i++;
            }
        }

        return ans;
    }
}
