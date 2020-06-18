package strings;

import java.util.Scanner;

public class PrintCharsAtEvenAndOddIndexSeperately {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			String s = sc.next();
			String even = "";
			String odd = "";
			for(int i=0;i<s.length();i+=2)
			{
				even = even.concat(s.substring(i,i+1)); 
				if(i==s.length()-2)
				{
					break;
				}
			}
			for(int i=1;i<s.length();i+=2)
			{
				odd = odd.concat(s.substring(i,i+1)); 
				if(i==s.length()-2)
				{
					break;
				}
			}
			System.out.println(even + " " + odd);
		}

	}

}
