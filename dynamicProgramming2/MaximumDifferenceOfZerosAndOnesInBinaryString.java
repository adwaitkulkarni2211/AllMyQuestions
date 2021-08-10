package dynamicProgramming2;

public class MaximumDifferenceOfZerosAndOnesInBinaryString {
	int maxSubstring(String str) {
        int ans = -1, csum = 0;
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int val;
            if(ch == '0') {
                val = 1;
            } else {
                val = -1;
            }
            
            if(csum < 0) {
                csum = val;
            } else {
                csum += val;
            }
            
            ans = Math.max(ans, csum);
        }
        
        return ans;
    }
}
