package misc;

public class ReverseANumberWithoutArrays {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int i, j,mul = 0;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		while(n>0)
		{
			j = n % 10;
			n = n / 10;
			mul = mul*10 + j;
		}
		System.out.println(mul);
    }
}
