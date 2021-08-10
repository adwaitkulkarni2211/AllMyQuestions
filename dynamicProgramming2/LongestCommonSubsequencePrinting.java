package dynamicProgramming2;
import java.util.*;
public class LongestCommonSubsequencePrinting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		char[] s1 = text1.toCharArray();
		char[] s2 = text2.toCharArray();
		sc.close();
		
		int[][] lcs = solve(s1, s2, text1.length(), text2.length());
		
		System.out.println("The array after finding length of lcs is: ");
		for(int i=0; i<lcs.length; i++) {
			for(int j=0; j<lcs[i].length; j++) {
				System.out.print(lcs[i][j] + " ");
			}
			System.out.println();
		}
		
		//printing lcs
		String ans = "";
		int i = lcs.length - 1, j = lcs[0].length - 1;
		
		while(i > 0 || j > 0) {
			if(s1[i-1] == s2[j-1]) {
				ans = s1[i-1] + ans;
				i--;
				j--;
			} else {
				if(lcs[i-1][j] > lcs[i][j-1]) {
					i--;
				} else {
					j--;
				}
				
			}
			System.out.println(ans);
		}
		System.out.println("The lcs is: " + ans);
	}
	
	private static int[][] solve(char[] s1, char[] s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(s1[i-1] == s2[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp;
    }
}
