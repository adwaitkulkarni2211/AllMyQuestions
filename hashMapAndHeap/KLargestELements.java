package hashMapAndHeap;
import java.io.*;
import java.util.*;
public class KLargestELements {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(a[i]);
        }
        for(int i=k; i<a.length; i++) {
            if(a[i] > pq.peek()) {
                pq.remove();
                pq.add(a[i]);
            } else {
                
            }
        }
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
