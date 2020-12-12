package stacks;
import java.io.*;
import java.util.*;
public class CelebrityProblem {
	public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] a) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < a.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if (a[i][j] == 1) {
                //if i knows j, i is not a celebrity
                st.push(j);
            } else if (a[i][j] == 0) {
                //if i does not know j, j is not a celebrity
                st.push(i);
            }
        }
        int potential = st.pop();
        //System.out.println("potential: " + potential);
        for (int i = 0; i < a.length; i++) {
            if (potential == i) {
                continue;
            } else {
                if (a[i][potential] == 0 || a[potential][i] == 1) {
                    //if there's an i that knows pot, or if there's an i 
                    //that is known by potential, then potential is not a celeb
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);
    }
}
