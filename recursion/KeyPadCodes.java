package recursion;
import java.util.*;

public class KeyPadCodes {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        ArrayList<String> res = getKPC(s);
        System.out.println(res);

    }
    
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList < String > getKPC(String str) {
        if(str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        String ch = str.substring(0,1);
        int i = Integer.parseInt(ch);
        String rem = str.substring(1);
        ArrayList<String> rres = getKPC(rem);
        
        System.out.println("rres: "+ rres);
        ArrayList<String> mres = new ArrayList<>();
        
        int a = 0;
        while(a < codes[i].length()) {
            for(String rstr: rres) {
                //System.out.println("codes[i]: " +codes[i]+ " code[i].char: "+ codes[i].charAt(a));
                mres.add(codes[i].charAt(a) + rstr);
                //System.out.println("mres in loop: "+ mres);
            }
            a++;
        }
        //System.out.println("mres: "+ mres);
        return mres;
    }
}
