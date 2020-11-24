package recursion;
import java.util.*;
public class GetSubsequenceOfString {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        ArrayList<String> res = gss(s);
        System.out.println(res);
    }

    public static ArrayList < String > gss(String str) {
        if(str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        ArrayList<String> rres = gss(ros);
        
        ArrayList<String> mres = new ArrayList<>();
        for(String rstr: rres) {
            mres.add("" + rstr);
        }
        for(String rstr: rres) {
            mres.add(ch + rstr);
        }
        return mres;
    }
}
