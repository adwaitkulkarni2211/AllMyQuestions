package misc;

import java.util.Scanner;

public class ReverseANumberWithoutArrays {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		long n = sc.nextInt(), temp = n, num = 0;
		while(temp != 0) {
			int r = (int)temp % 10;
			num = (num * 10) + r;
			temp = temp / 10;
		}
		System.out.println(num);
		sc.close();
    }
}
