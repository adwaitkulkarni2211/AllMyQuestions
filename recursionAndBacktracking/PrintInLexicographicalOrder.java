package recursionAndBacktracking;
import java.util.*;
public class PrintInLexicographicalOrder {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        scn.close();
        for(int i=1; i<=9; i++) {
            solve(n, i);
        }
        for(int i=1; i<=9; i++) {
        	solve1(n, i+ "");
        }
	}
	
	private static void solve(int n, int num) {
	    if(num > n) {
	        return;
	    }
	    
	    System.out.println(num);
	    for(int i=0; i<=9; i++) {
	        solve(n, num * 10 + i);
	    }
	}
	//using string
	private static void solve1(int n, String num) {
	    if(Integer.parseInt(num) > n) {
	        return;
	    }
	    
	    System.out.println(num);
	    for(int i=0; i<=9; i++) {
	        num += i;
	        solve1(n, num);
	        num = num.substring(0, num.length() - 1);
	    }
	}
}
