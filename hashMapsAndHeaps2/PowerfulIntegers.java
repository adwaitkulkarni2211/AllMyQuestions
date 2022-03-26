package hashMapsAndHeaps2;
import java.util.*;

public class PowerfulIntegers {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int maxi = findBound(x, bound);
        int maxj = findBound(y, bound);
        
        if(bound <= 1) {
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<=maxi; i++) {
            for(int j=0; j<=maxj; j++) {
                int val = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                
                if(val <= bound && !set.contains(val)) {
                    ans.add(val);
                    set.add(val);
                }
            }
        }
        
        return ans;
    }
    
    private int findBound(int val, int bound) {
        if(val == 1) return 1;
        
        int ans = 0;
        
        while((int)Math.pow(val, ans) <= bound) {
            ans++;
        }
        
        return ans - 1;
    }
}
