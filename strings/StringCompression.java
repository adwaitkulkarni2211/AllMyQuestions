package strings;
import java.util.*;
public class StringCompression {
	//my approach
	public static String compression10(String str) {
        // write your code here
        String com = "";
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) == str.charAt(i)) {
                //System.out.println(str.charAt(i));
                j++;
                if (j == str.length())
                    break;
            }
            com += str.charAt(i);
            i = j;
        }
        return com;
    }
    public static String compression20(String str) {
        // write your code here
        String com = "";
        int i = 0;
        while (i < str.length()) {
            int j = i, count = 0;
            while (str.charAt(j) == str.charAt(i)) {
                //System.out.println(str.charAt(i));
                j++;
                count++;
                if (j == str.length())
                    break;
            }
            com += str.charAt(i);
            if(count > 1) 
            	com += count;
            i = j;
        }
        return com;
    }
	//sumeet's
	public static String compression1(String str) {
        // write your code here
        String com = "";
        com += str.charAt(0);
        for(int i=1; i<str.length(); i++) {
        	char cur = str.charAt(i), prev = str.charAt(i - 1);
        	if(cur != prev) {
        		com+= cur;
        	}
        }        
        return com;
    }

    public static String compression2(String str) {
        // write your code here
    	String com = "";
        com += str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++) {
        	char cur = str.charAt(i), prev = str.charAt(i - 1);
        	if(cur == prev) {
        		count++;
        	} else {
        		if(count > 1)
        			com += count;
        		count = 1;
        		com += cur;
        	}
        }
        if(count > 1)
        	com += count;
        return com;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        double start = System.currentTimeMillis();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
        double end = System.currentTimeMillis();
        System.out.println("Sumeet's method: " + (end - start));
        start = System.currentTimeMillis();
        System.out.println(compression10(str));
        System.out.println(compression20(str));
        end = System.currentTimeMillis();
        System.out.println("My method: " + (end - start));
    }
}
