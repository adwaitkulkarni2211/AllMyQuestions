package hashMapAndHeap;
import java.util.*;
public class GetCommonElements2 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i < n; i++) {
            if(hm.containsKey(a[i])) {
                int f = hm.get(a[i]);
                f++;
                hm.put(a[i], f);
            } else {
                hm.put(a[i], 1);
            }
        }
        for(int i=0; i < m; i++) {
            if(hm.containsKey(b[i])) {
                int f = hm.get(b[i]);
                if(f != 0) {
                    f--;
                    hm.put(b[i], f);
                    System.out.println(b[i]);    
                }
            }
        }
    }
}
