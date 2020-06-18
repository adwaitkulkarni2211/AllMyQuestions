package strings;

import java.util.Scanner;

public class LongestName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int b = 0,k;
		do {
			int i, big=0,j;
			int n = sc.nextInt();
			String s[]= new String[n];
			int a[] = new int[n];
			for(i=0;i<n;i++)
				s[i] = sc.next();
			for(i=0;i<n;i++)
			{
				k = s[i].length();
				a[i]=k;
			}
			for(i=0;i<n;i++)
			{
				if(a[i]>a[big])
					big=i;
			}
			System.out.println(s[big]);
			
			b++;
		}while(b<t);

	}

}
