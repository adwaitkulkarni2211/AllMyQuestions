package hashMapsAndHeaps2;
import java.util.*;

public class CountOfSubstringWithEqual0s1s2s {
	public static int solution(int[] str) {
        HashMap<String, Integer> map = new HashMap<>();
        int c0 = 0, c1 = 0, c2 = 0;
        String key = "0#0";
        map.put(key, 1);
        
        int ans = 0;
        
        for(int i=0; i<str.length; i++) {
            int ch = str[i];
            
            if(ch == 0) {
                c0++;
            } else if(ch == 1) {
                c1++;
            } else {
                c2++;
            }
            
            key = (c1 - c0) + "#" + (c2 - c1);
            
            if(map.containsKey(key)) {
                int val = map.get(key);
                ans += val;
                map.put(key, val + 1);
            } else {
                map.put(key, 1);
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
