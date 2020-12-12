package stacks;
import java.util.*;
import java.io.*;
public class StockSpan {
	public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] a) {
        // solve
        Stack < Integer > st = new Stack < > ();
        int[] ans = new int[a.length];
        st.push(0);
        ans[0] = 1;
        for (int i = 1; i < a.length; i++) {
            while (st.size() != 0 && a[i] > a[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[i] = i + 1;
                st.push(i);
            } else {
                ans[i] = i - st.peek();
                st.push(i);
            }
        }

        return ans;
    }
}
