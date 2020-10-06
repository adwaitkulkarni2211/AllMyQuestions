package arrays;
import java.util.*;
public class leftRotation {

	public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static int[] reverse(int a[], int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            
            right--;
            left++;
        }
        return a;
    }

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0)
            k = k + a.length;
        a = reverse(a, 0, a.length - k - 1);
        a = reverse(a, a.length - k, a.length - 1);
        a = reverse(a, 0, a.length - 1);
    }
	
    public static void leftRotate(int[] a, int k) {
    	k = k % a.length;
    	int temp[] = new int[k];
    	for(int i=0; i<k; i++) {
    		temp[i] = a[i];
    	}
    	for(int i=0; i<a.length - k; i++) {
    		a[i] = a[i+k]; 
    	}
    	for(int i = a.length - k; i<a.length; i++) {
    		a[i] = temp[i - a.length + k];
    	}
    	for(int i=0; i<a.length; i++) {
    		System.out.print(a[i]+ " ");
    	}
    }
    
    public static void rightRotate(int[] a, int k) {
    	k = k % a.length;
    	System.out.println("k:"+ k);
    	int temp[] = new int[k];
    	for(int i = a.length - k; i < a.length; i++) {
    		temp[i - a.length + k] = a[i];
    	}
    	System.out.print("Temp: ");
    	for(int i=0; i<temp.length; i++)
    		System.out.print(temp[i]+ " ");
    	System.out.println();
    	
    	for(int i = 0; i < k; i++) {
    		a[a.length - k + i] = a[i]; 
    	}
    	
    	System.out.print("A: ");
    	for(int i=0; i<a.length; i++)
    		System.out.print(a[i]+ " ");
    	System.out.println();
    	
    	for(int i = 0; i < k; i++) {
    		a[i] = temp[i];
    	}
    	
    	for(int i=0; i<a.length; i++) {
    		System.out.print(a[i]+ " ");
    	}
    }
    
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of elements in the array: ");
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	//System.out.println("Enter the array elements: ");
    	
    	for(int i=0; i<n; i++)
    		a[i] = i+1;
    	for(int i=0; i<n; i++)
    		System.out.print(a[i]+ " ");
    	
    	int b[] = new int[n];
    	for(int i=0; i<b.length; i++) {
    		b[i] = i+1;
    	}
    	System.out.println();
    	
    	System.out.println("Number of places you want to rotate the array by: ");
    	int d = sc.nextInt();
    	
    	long start = System.currentTimeMillis();
    	if(d>=0)
    		rightRotate(a,d);
    	else
    		leftRotate(a,-d);
    	long end = System.currentTimeMillis();
    	System.out.println("\ntime taken for my function: "+ (end - start) + "\n\n");
    	
    	start = System.currentTimeMillis();
    	rotate(b,d);
    	display(b);
    	end = System.currentTimeMillis();
    	System.out.println("time taken for sumeet's method: "+ (end - start));
    	
    	sc.close();
    }
}
