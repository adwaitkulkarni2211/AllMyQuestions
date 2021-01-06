package hashMapAndHeap;
import java.util.*;
public class HighestFrequesncyCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                int old = hm.get(c);
                old++;
                hm.put(c, old);
            }
        }
        char mfc = str.charAt(0);
        for(Character key: hm.keySet()) {
            if(hm.get(key) > hm.get(mfc)) {
                mfc = key;
            }
        }
        System.out.println(mfc);
	}

}
