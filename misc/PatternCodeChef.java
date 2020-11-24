package misc;
import java.util.*;
public class PatternCodeChef {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int n = sc.nextInt();
		    for(int i = 1; i<=4; i++) {
		        int temp = i;
		        int dif = 3;
		        if(i <= 2) {
		            for(int j = 0; j<n; j++) {
		                System.out.print(temp + " ");
		                temp += dif;
		                dif *= 2;
		            }
    		        System.out.println();
		        } else if (i == 4){
		            dif = 6;
		            for(int j = 1; j <=n; j++) {
		                System.out.print(temp + " ");
		                temp += dif;
		                dif *= 2;
		            }
		            System.out.println();
		        }
		    }
		    int mul = 3;
		    for(int i = 1; i <= n; i++) {
		        System.out.print(mul + " ");
		        mul *= 2;
		    }
		    System.out.println();
		}
		
	}
}
