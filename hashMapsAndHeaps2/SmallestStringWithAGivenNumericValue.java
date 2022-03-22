package hashMapsAndHeaps2;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        
        k -= n;
        if(k == 0) {
            return String.valueOf(ans);
        }
        
        for(int i=ans.length - 1; i>=0; i--) {
            k += 1;
            if(k >= 26) {
                ans[i] = 'z';
                k -= 26;
            } else {
                ans[i] = (char)(k + 96);
                k -= k;
            }
            
            if(k == 0) {
                return String.valueOf(ans);
            }
        }
        
        return String.valueOf(ans);
    }
}
