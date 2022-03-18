package hashMapsAndHeaps2;

import java.util.*;

public class FindAnagramMappings {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		HashMap<Integer, Queue<Integer>> map = new HashMap<>();

		for(int i=0; i<arr2.length; i++) {
			Queue<Integer> q = map.getOrDefault(arr2[i], new ArrayDeque<>());
			q.add(i);
			map.put(arr2[i], q);
		}

		int[] ans = new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			ans[i] = map.get(arr1[i]).remove();
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		s.close();
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}
}
