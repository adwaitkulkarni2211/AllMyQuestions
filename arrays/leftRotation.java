package arrays;
import java.util.*;
public class leftRotation {

    public static void leftRotate(int a[], int d)
    {
        int temp[] = new int[d];
        for(int i=0;i<d;i++)
        {
            temp[i] = a[i];
        }
        for(int i=d;i<a.length;i++)
        {
            a[i-d] = a[i];
        }
        for(int i= a.length - d; i<a.length; i++)
        {
            a[i] = temp[i-a.length+d];
        }
        
        for(int i=0; i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		a[i] = sc.nextInt();
    	}
    	int d = sc.nextInt();
    	leftRotate(a,d);
    }

}
