package stacks;

import java.util.*;
public class SlidingWindowMaximum {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        // code
        Stack < Integer > st = new Stack < > ();
        int[] nge = new int[a.length];
        st.push(0);
        for (int i = 1; i < a.length; i++) {
            while (st.size() != 0 && a[i] > a[st.peek()]) {
                int pos = st.peek();
                nge[pos] = i;
                st.pop();
            }
            st.push(i);
        }
        
        while (st.size() != 0) {
            int pos = st.peek();
            nge[pos] = a.length;
            st.pop();
        }
        System.out.println("nge: ");
        for(int x: nge) {
        	System.out.print(x + " ");
        }
        System.out.println();
        //a:   [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6]
        //nge: [1 6 3 6 5 6 8 8 10 10 -1 12 13 -1 15 -1 -1]
        int j = 0;
        for(int i=0; i<=nge.length - k; i++) {
            if(j < i) {
                j = i;
            }
            while(nge[j] < i + k) {
                j = nge[j];
            }
            System.out.println("swm for window: " + i + " is: " + a[j] + " j: " + j);
        }
    }
}
