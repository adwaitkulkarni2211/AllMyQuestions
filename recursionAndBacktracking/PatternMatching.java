package recursionAndBacktracking;
import java.util.*;
public class PatternMatching {
	public static void solution(String str, String pattern, HashMap<Character, String> map, String origStr, String origPat) {
        if (pattern.length() == 0) {
            String res = "";
            for (int i = 0; i < origPat.length(); i++) {
                res += map.get(origPat.charAt(i));
            }
            
            HashMap<Character, String> temp = new HashMap<>(map);
            
            if (res.equals(origStr)) {
                for (int i = 0; i < origPat.length(); i++) {
                    char ch = origPat.charAt(i);
                    if(temp.containsKey(ch)) {
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                    }
                    temp.remove(ch);
                }
                System.out.print(".\n");
            }
            return;
        }
        
        char ch = pattern.charAt(0);
        String ros = pattern.substring(1);
        
        if (!map.containsKey(ch)) {
            for (int i = 0; i < str.length(); i++) {
                map.put(ch, str.substring(0, i + 1));
                solution(str.substring(i + 1), ros, map, origStr, origPat);
                map.remove(ch);
            }
        } else {
            solution(str, ros, map, origStr, origPat);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        scn.close();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, str, pattern);
    }
}
