package hashMapAndHeap;
import java.util.*;
public class GetCommonElements1 {

	public static void main(String[] args) {
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
        HashMap<Integer, Character> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(!hm.containsKey(a[i])) {
                hm.put(a[i], 'a');
            }
        }
        
        for(int i=0; i<m; i++) {
            if(hm.containsKey(b[i])) {
                System.out.println(b[i]);
                hm.remove(b[i]);
            }
        }

	}

}
