package hashMapAndHeap;
import java.util.*;
public class LongestConsecutiveSequenceOfElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int val: a) {
            hm.put(val, true);
        }
        for(int val: a) {
            if(hm.containsKey(val - 1)) {
                hm.put(val, false);
            }
        }
        int msp = 0, ml = 0;
        for(int val: a) {
            if(hm.get(val) == true) {
                int tl = 1, tsp = val;
                
                while(hm.containsKey(tsp + tl)) {
                    tl++;
                }
                if(tl > ml) {
                    ml = tl;
                    msp = tsp;
                }
            }
        }
        for(int i = 0; i<ml; i++) {
            System.out.println(msp + i);
        }

	}

}
