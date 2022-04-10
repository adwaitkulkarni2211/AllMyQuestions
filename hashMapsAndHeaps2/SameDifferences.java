package hashMapsAndHeaps2;
import java.util.*;

public class SameDifferences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) { 
				arr[i] = sc.nextInt();
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int i=0; i<n; i++) {
				int val = arr[i] - i;
				
				if(map.containsKey(val)) {
					map.put(val, map.get(val) + 1);
				} else {
					map.put(val, 1);
				}
			}
			
			int count = 0;
			for(int key: map.keySet()) {
				int freq = map.get(key);
				count += freq * (freq - 1) / 2;
			}
			
			System.out.println("\nmap: " + map);
			System.out.println(count);
		}
		sc.close();
		
	}
}
