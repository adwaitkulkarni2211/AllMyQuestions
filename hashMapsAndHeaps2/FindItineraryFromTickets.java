package hashMapsAndHeaps2;
import java.util.*;

public class FindItineraryFromTickets {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
		scn.close();

		HashMap<String, Boolean> psrc = new HashMap<>();
		for(String src: map.keySet()) {
			String dest = map.get(src);

			psrc.put(dest, false);

			if(!psrc.containsKey(src)) {
				psrc.put(src, true);
			}
		}

		String src = "";
		for(String str: psrc.keySet()) {
			if(psrc.get(str) == true) {
				src = str;
				break;
			}
		}

		String ans = "";

		while(true) {
			if(map.containsKey(src)) {
				ans += src + " -> ";
				src = map.get(src);
			} else {
				ans += src + ".";
				break;
			}
		}

		System.out.println(ans);
	}
}
