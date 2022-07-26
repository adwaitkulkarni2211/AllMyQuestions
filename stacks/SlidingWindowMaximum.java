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
        
        System.out.println(maxSlidingWindow(a, k));
    }
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = nge(nums);
        
        int[] msw = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++) {
            int window = i + k, ng = i;
            while(nge[ng] != -1 && nge[ng] < window) {
                ng = nge[ng];
            }
            
            msw[i] = nums[ng];
        }
        
        return msw;
    }
    
    private static int[] nge(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i = 1; i < nums.length; i++) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()]) {
                nge[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            nge[st.pop()] = -1;
        }
        
        return nge;
    }
}
