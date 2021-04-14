package queues2;
import java.util.*;
public class FirstNonRepeatingCharacterInAStream {
	
	public static String FirstNonRepeating(String str) {
        Queue<Character> q = new ArrayDeque<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        q.add(str.charAt(0));
        hm.put(str.charAt(0), 1);
        StringBuilder ans = new StringBuilder(str.charAt(0) + "");
        
        for(int i=1; i<str.length(); i++) {
            if(!hm.containsKey(str.charAt(i))) {
                q.add(str.charAt(i));
                hm.put(str.charAt(i), 1);
            } else {
                hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);    
            }
            
            while(q.size() > 0 && hm.get(q.peek()) > 1) {
                q.remove();
            }
            if(q.size() > 0) {
                ans.append(q.peek());
            } else {
                ans.append("#");
            }
        }
        return ans.toString();
    }
	
	public static void main(String[] args) {
		String str = "adwait";
		System.out.println(FirstNonRepeating(str));
	}

}
