package hashMapsAndHeaps2;
import java.util.*;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int num, int den) {
        if(num == 0) {
            return 0 + "";
        }
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        
        if(num < 0 && den < 0) {
            //nothing to append
        } else if(num < 0 || den < 0) {
            str.append("-");
        }
        
        long num_long = Math.abs((long)num);
        long den_long = Math.abs((long)den);
        
        long rem = num_long % den_long;
        long quo = num_long / den_long;
        
        str.append(quo);
        if(rem != 0) {
            str.append(".");
        }
        
        map.put(rem, str.length());
        
        num_long = rem * 10;
        
        int si = -1;
        while(rem != 0) {
            rem = num_long % den_long;
            quo = num_long / den_long;
            
            str.append(quo);
            
            if(map.containsKey(rem)) {
                si = map.get(rem);
                break;    
            } else {
                map.put(rem, str.length());
            }
            
            num_long = rem * 10;
        }
        
        if(si == -1) {
            return str.toString();
        } else {
            return str.substring(0, si) + "(" + str.substring(si) + ")";
        }
    }
}
