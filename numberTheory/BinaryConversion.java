package numberTheory;
import java.util.*;
public class BinaryConversion {
	 public static void toBinary(int q) {
	        List<Integer> r = new ArrayList<>();
	        for (int i = 0; ; i++)
	        {
	        	if(i==0) {
	        		System.out.println();
	        	}
	            r.add(q%2);
	            q = q / 2;
	            if (q == 0)
	                break;
	        }
	         int j=0,p=0;
	        for (int i = 0; i<r.size() ; i++) {        
	         if(r.get(i)==1) {
	             j++;
	         } else {
	             j=0;
	         }
	         if(j==0) continue;
	         if(j>p)
	         {
	             p=j;
	         }         
	        }
	        System.out.println(p);
	    }
}
