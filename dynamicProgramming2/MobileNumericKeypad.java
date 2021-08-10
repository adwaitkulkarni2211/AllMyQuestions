package dynamicProgramming2;
import java.util.*;

public class MobileNumericKeypad {
	public static long solution(int n) {
		long[][] dp = new long[n+1][10];
	    
	    int[][] data = {
	        {0, 8},
	        {1, 2, 4},
	        {1, 2, 3, 5},
	        {2, 3, 6},
	        {1, 4, 5, 7},
	        {2, 4, 5, 6, 8},
	        {3, 5, 6, 9},
	        {4, 7, 8},
	        {5, 7 , 8, 9, 0},
	        {6, 8 , 9}
	    };
	    
	    for(int i=1; i<dp.length; i++) {
	        for(int j=0; j<dp[0].length; j++) {
	            if(i == 1) {
	                dp[i][j] = 1;
	            } else {
	                for(int k=0; k<data[j].length; k++) {
	                    dp[i][j] += dp[i-1][data[j][k]];
	                }
	            }
	        }
	    }
	    
	    long ans = 0;
	    
	    for(int i=0; i<dp[0].length; i++) {
	        ans += dp[dp.length - 1][i];
	    }
	    return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(solution(scn.nextInt()));
		scn.close();
	}

}
