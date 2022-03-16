package hashMapsAndHeaps2;
import java.util.*;

public class NumberOfEmployeesUnderEveryManager {
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();

	    HashMap<String, ArrayList<String>> map = new HashMap<>();

	    String root = "";
	    
	    for(int i=0; i<n; i++) {
	      String emp = sc.next();
	      String man = sc.next();

	      if(emp.equals(man)) {
	        root = man;
	        continue;
	      }

	      ArrayList<String> emps = map.getOrDefault(man, new ArrayList<>());
	      emps.add(emp);

	      map.put(man, emps);
	    }
	    
	    sc.close();

	    ans = new ArrayList<>();

	    getSize(map, root);

	    Collections.sort(ans);

	    for(String str: ans) {
	      System.out.println(str);
	    }

	  }

	  static ArrayList<String> ans;

	  private static int getSize(HashMap<String, ArrayList<String>> map, String root) {

	    int size = 0;
	    for(String str: map.getOrDefault(root, new ArrayList<>())) {
	      size += getSize(map, str);
	    }

	    String s = root + " " + size;

	    ans.add(s);

	    return size + 1;

	  }
}
