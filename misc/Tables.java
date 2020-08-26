package misc;

public class Tables {
	public static void main(String[] args) 
	{
		int i=2,a=0,j;
		for(i=1;i<=10;i++)
		{
			for(j=1;j<=10;j++)
			{
				a = a + i;
				System.out.print("  " +a+ "  ");
			}
			a = 0;
			System.out.println();
		}
	}
}
