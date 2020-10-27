package recursion;
import java.util.*;
public class TowerOfHanoi {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t1 = "A", t2 = "B", t3 = "C";
        sc.close();
        toh(n, t1, t2, t3);
        System.out.println();
    }

    public static void toh(int n, String t1id, String t2id, String t3id) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1id, t3id, t2id); //print the instructions 
        //to move m-1 disks from 
        //t1 to t3 using t2
        System.out.println(n + " [" + t1id + " -> " + t2id + "]");
        toh(n - 1, t3id, t2id, t1id);
    }
}
