package collegeQuestions;
import java.util.*;
public class StrongNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int m,num=n,sum=0;
		while(n>0) {
			int fact=1;
			m = n % 10;
			for(int i=m;i>0;i--) {
				fact = fact * i;
			}
			System.out.println( "the fact of " + n + " is: " + fact);
			sum = sum + fact;
			n = n/10;
		}
		if(sum==num) {
			System.out.println("strong");
		} else {
			System.out.println("not");
		}
	}

}
