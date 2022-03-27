package hashMapsAndHeaps2;
import java.util.*;

public class CountOfSunstringsWithAtMostKUniqueCharacters {
	public static int solution(String s, int k) {
		if(k > s.length()) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0, j = 0, ans = 0;
        while(j < s.length()) {
            //acquire
            while(j < s.length() && map.size() <= k) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                j++;
                
                if(map.size() <= k) {
					int len = j - i;
					ans += len;
				}
				//System.out.println("Included " + ch + " map: " + map + " ans: " + ans);
            }
            
            //release
            while(i < j && map.size() > k) {
                char ch = s.charAt(i);
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                i++;

				if(map.size() == k) {
					int len = j - i;
					ans += len;
				}
                //System.out.println("Removed " + ch + " map: " + map + " ans: " + ans);
            }
        }
        
        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
		System.out.println(solution(str,k));
	}
}
