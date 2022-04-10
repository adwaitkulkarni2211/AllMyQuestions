package hashMapsAndHeaps2;
import java.util.*;

public class ThreeSumWithMultiplicity {
	public int threeSumMulti(int[] arr, int target) {
        long mod = 1000000007;
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        long count = 0;
        for(int i=0; i<arr.length - 2; i++) {
            if(!map.containsKey(arr[i])) {
                continue;
            }
            List<List<Integer>> pairs = twoSum(arr, target - arr[i], i + 1, arr.length - 1);
            
            for(List<Integer> pair: pairs) {
                int num1 = arr[i], freq1 = map.get(num1);
                int num2 = pair.get(0), freq2 = map.get(num2);
                int num3 = pair.get(1), freq3 = map.get(num3);
                
                if(num1 == num2 && num2 == num3) {
                    //nC3
                    count += (freq1 * (freq1 - 1) % mod * (freq1 - 2)) / 6;
                } else if(num1 == num2) {
                    //nC2
                    count += (freq1 * (freq1 - 1) % mod / 2) * freq3 % mod;
                } else if(num2 == num3) {
                    count += (freq2 * (freq2 - 1) % mod / 2) * freq1 % mod;
                } else if(num3 == num1) {
                    count += (freq3 * (freq3 - 1) % mod / 2) * freq2 % mod;
                } else {
                    count += map.get(num1) * map.get(num2) * map.get(num3);
                }
                count %= mod;
            }
            map.remove(arr[i]);
            
        }
        
        return (int)(count % mod);
    }
    
    private List<List<Integer>> twoSum(int[] arr, int target, int left, int right) {
        List<List<Integer>> pairs = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        while(left < right) {
            if(target > arr[left] + arr[right]) {
                left++;
            } else if(target < arr[left] + arr[right]) {
                right--;
            } else {
                List<Integer> p = new ArrayList<>();
                p.add(arr[left]);
                p.add(arr[right]);
                if(!set.contains(p)) {
                    set.add(p);
                    pairs.add(p);
                }
                left++;
                right--;
            }
        }
        
        return pairs;
    }
}
