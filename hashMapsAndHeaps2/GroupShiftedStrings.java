package hashMapsAndHeaps2;

import java.util.*;

public class GroupShiftedStrings {

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();

		for(String str: strs) {
			ArrayList<Integer> key = getKey(str);
			//System.out.println("str: " + str + " key: " + key);
			ArrayList<String> group = map.getOrDefault(key, new ArrayList<>());
			group.add(str);
			map.put(key, group);
		}

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		for(ArrayList<Integer> key: map.keySet()) {
			ans.add(map.get(key));
		}

		return ans;
	}

	private static ArrayList<Integer> getKey(String str) {
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i=0; i<str.length() - 1; i++) {
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i + 1);

			int diff = (int)(ch2 - ch1);

			if(diff < 0) {
				diff += 26;
			}
			
			ans.add(diff);
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
