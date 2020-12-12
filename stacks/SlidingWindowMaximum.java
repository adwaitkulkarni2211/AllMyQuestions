package stacks;
import java.io.*;
import java.util.*;
public class SlidingWindowMaximum {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // code
        Stack < Integer > st = new Stack < > ();
        int[] ans = new int[a.length];
        st.push(0);
        for (int i = 1; i < a.length; i++) {
            while (st.size() != 0 && a[i] > a[st.peek()]) {
                int pos = st.peek();
                ans[pos] = i;
                st.pop();
            }
            st.push(i);
        }
        while (st.size() != 0) {
            int pos = st.peek();
            ans[pos] = Integer.MAX_VALUE;
            st.pop();
        }
        int j = 0;
        for(int i=0; i<=ans.length - k; i++) {
            if(j < i) {
                j = i;
            }
            while(ans[j] < i + k) {
                j = ans[j];
            }
            System.out.println(a[j]);
        }
    }
}
