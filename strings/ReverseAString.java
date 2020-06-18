package strings;

import java.util.*;

public class ReverseAString {

//	public static void main(String[] args) { USING STRING BUILDER
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		int b = 0;
//		do {
//		    String s=sc.next();
//	        StringBuilder sb=new StringBuilder(s);
//	        sb=sb.reverse();
//	        System.out.println(sb);
//			b++;
//		}while(b<t)
//
//	}
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			int b = 0;
			do {
				int i,k,j,l;
				String s;
				s = sc.next();
				char c[] = s.toCharArray();
				for(i=s.length()-1;i>=0;i--)
				{
					System.out.print(c[i]);
				}
				b++;
			}while(b<t);
	}

}
