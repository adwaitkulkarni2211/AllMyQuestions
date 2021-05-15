package recursionAndBacktracking;
import java.util.*;
public class PallindromicPartitioning {
	List<List<String>> pals = new ArrayList<>();
    public List<List<String>> partition(String s) {
        solution(s, new ArrayList<>());
        return pals;
    }
    List<String> out;
    public void solution(String str, List<String> asf) {
		if(str.length() == 0) {
            out = new ArrayList<>(asf);
		    pals.add(out);
		    return;
		}
		for(int i=0; i<str.length(); i++) {
		    String ss = str.substring(0, i+1);
		    if(pallindrome(ss)) {
                asf.add(ss);
		        String ros = str.substring(i+1);
		        solution(ros, asf);
                asf.remove(asf.size() - 1);
		    }
		}
		
	}
	public boolean pallindrome(String str) {
	    int i=0, j = str.length() - 1;
	    while(i <= j) {
	        if(str.charAt(i) != str.charAt(j)) {
	            return false;
	        }
	        i++;
	        j--;
	    }
	    return true;
	}
}
