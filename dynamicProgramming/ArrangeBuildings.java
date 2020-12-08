package dynamicProgramming;
import java.util.*;
public class ArrangeBuildings {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        int[] ezero = new int[n+1];
        int[] eone = new int[n+1];
        ezero[1] = 1;
        eone[1] = 1;
        for(int i=2; i<ezero.length; i++) {
            ezero[i] = eone[i-1];
            eone[i] = ezero[i-1] + eone[i-1];
        }
        System.out.println(ezero[n] + eone[n]);
        long oldB = 1, oldS = 1;
        for (int i = 2; i <= n; i++) {
            long newB = oldS;
            long newS = oldB + oldS;
            oldB = newB;
            oldS = newS;
        }
        System.out.println(oldB + oldS);
        System.out.println((oldB + oldS) * (oldB + oldS));
        System.out.println((long)Math.pow((oldB + oldS), 2)); //gives wrong answers above 38
    }
}
