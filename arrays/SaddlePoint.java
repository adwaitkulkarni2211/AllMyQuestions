package arrays;
import java.util.*;
public class SaddlePoint {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();;
            }
        }
        sc.close();
        long start = System.currentTimeMillis();
        int small[] = new int[n], saddle = 0;
        for(int i=0; i<n; i++) {
            int least = 0;
            for(int j=0; j<n; j++) {
                if(a[i][j] < a[i][least]) 
                    least = j;
            }
            small[i] = least;
            System.out.print( small[i] + " ");
        }
        System.out.println();
        boolean isFound = false;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
	        	if(a[i][small[i]] < a[j][small[i]]) {
	        		isFound = false;
	        		break;
	        	} else {
	        		isFound = true;
	        		saddle = a[i][small[i]];
	        	}
        	}
        	if(isFound == true) {
        		break;
        	}
        }
        if(isFound == true) {
        	System.out.println(saddle);
        } else {
        	System.out.println("Invalid input");
        }
        long end = System.currentTimeMillis();
        System.out.println("My method: "+ (end - start));
        
        
        //sumeet's method
        start = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            int least = 0;
            for(int j=0; j<n; j++) {
                if(a[i][j] < a[i][least]) 
                    least = j;
            }
            
            boolean flag = true;
            for(int k=0; k<a.length; k++) {
            	if(a[k][least] > a[i][least]) {
            		flag = false;
            		break;
            	}
            }
            
            if(flag == true) {
            	System.out.println(a[i][least]);
            	end = System.currentTimeMillis();
                System.out.println("Sumeet's method: "+ (end - start));
            	return;
            }
        }
        System.out.println("Invalid input");

        end = System.currentTimeMillis();
        System.out.println("sumeet's method: "+ (end - start));
    }
}
















