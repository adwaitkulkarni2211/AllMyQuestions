package arrays;
import java.util.*;
import java.io.*;
public class SumOfTwoNumbers {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int ans[] = new int[(Math.max(m, n))];
        m -= 1;
        n -= 1;
        int c = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) 
                ans[i] = a[n] + b[m] + c;
            else if (m < 0) 
                ans[i] = a[n] + c;
            else if (n < 0)
                ans[i] = b[m] + c;
            
        	c = ans[i] / 10;
            ans[i] %= 10;
            n--;
            m--;
        }
        if(c>0)
        	System.out.println(c);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+ "\n");
        }
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n1 = Integer.parseInt(br.readLine());
	    int[] a1 = new int[n1];
	    for(int i = 0; i < n1; i++){
	       a1[i] = Integer.parseInt(br.readLine());
	    }

	    int n2 = Integer.parseInt(br.readLine());
	    int[] a2 = new int[n2];
	    for(int i = 0; i < n2; i++){
	       a2[i] = Integer.parseInt(br.readLine());
	    }
	    sc.close();
	    int[] sum = new int[n1 > n2? n1: n2];
	    int i = n1 - 1;
	    int j = n2 - 1;
	    int k = sum.length - 1;
	    int l = 0;
	    while(i >= 0 || j >= 0){
	       int d = l;

	       if(i >= 0)
	         d += a1[i];

	      if(j >= 0)
	         d += a2[j];

	       l = d / 10;
	       d = d % 10;
	       sum[k] = d;

	       i--;
	       j--;
	       k--;
	    }

	    if(l > 0){
	       System.out.println(l);
	    }
	    for(int val: sum){
	       System.out.println(val);
	    }
	}

}
