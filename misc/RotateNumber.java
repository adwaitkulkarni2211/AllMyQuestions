package misc;
import java.util.*;
public class RotateNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      long n = sc.nextInt(), temp = n, k = sc.nextInt();
	      int count = 0; 
	      sc.close();
	      while(temp!=0){
	          temp = temp/10;
	          count++;
	      }
	      if(k>0) {
		      if(k>count) {
		          k = k % count;
		      }
		      temp = n;
		      while(k-- >0) {
			      int r = (int)temp % 10;
			      temp = temp / 10;
			      for(int i=0; i<count-1; i++) {
			    	  r = r * 10;
			      }
			      long ans = r + temp;
			      temp = ans;
		      }
		      System.out.println(temp);
	      }
	      else {
	    	  if(k < ((-1)*count)) {
	    		  k = ((-1 * k)) % count;
	    		  k = -k;
	    	  }
	    	  System.out.println("k: "+k);
	    	  int j = 1;
	    	  for(int i=0; i<count-1; i++) {
	    		  j = j * 10;
	    	  }
	    	  

	    	  temp = n;
	    	  while(k++ < 0) {
	    		  int r = ((int)temp % j);

	    		  temp = temp / j;
	    
	    		  r = r * 10;
			      
	    		  long ans = r + temp;
	    		  temp = ans;
	    	  }
	    	  System.out.println(temp);
	      }
	}

}
