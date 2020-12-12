package stacks;
import java.io.*;
import java.util.*;
public class NextGreaterElementToTheRight {
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

        int[] nge = solve(a);
        display(nge);
        
        //alternate
        int[] nge2 = alternateSolve(a);
        display(nge2);
    }

    public static int[] solve(int[] a) {
        // solve
        Stack <Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        ans[ans.length - 1] = -1;
        st.push(a[a.length - 1]);
        for(int i = a.length - 2; i>=0; i--) {
            while(st.size() != 0 && a[i] >= st.peek()) {
                st.pop();
            }
            if(st.size() == 0) {
                ans[i] = -1;
            } else if(st.peek() > a[i]) {
                ans[i] = st.peek();
            }
            st.push(a[i]);
        }
        return ans;
    }
    
    //alternate method, same time complexity
    public static int[] alternateSolve(int[] a) {
    	
    	Stack<Integer> st = new Stack<>();
    	int[] ans = new int[a.length];
    	st.push(0);
    	for(int i=1; i<a.length; i++) {
    		while(st.size() !=0 && a[i] > a[st.peek()]) {
    			int pos = st.peek();
    			ans[pos] = a[i];
    			st.pop();
    		}
    		st.push(i);
    	}
    	while(st.size() != 0) {
    		int pos = st.peek();
    		ans[pos] = -1;
    		st.pop();
    	}
    	
    	return ans;
    }
}



























