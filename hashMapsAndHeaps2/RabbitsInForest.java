package hashMapsAndHeaps2;

import java.util.HashMap;
import java.util.Scanner;

public class RabbitsInForest {
	public static int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        int ans = 0;
        for(int key: map.keySet()) {
            int groupSize = key + 1;
            int reportees = map.get(key);
            int groups = (int)Math.ceil(reportees * 1.0 / groupSize * 1.0);
            ans += groupSize * groups;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
		System.out.println(solution(arr));
	}
}
