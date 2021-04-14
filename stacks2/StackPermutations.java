package stacks2;
import java.util.*;
public class StackPermutations {

	public static void main(String[] args) {
		int input[] = { 1, 2, 3 };
        int output[] = { 2, 1, 3 };
        int n = 3;
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
	}
	
	public static boolean checkStackPermutation(int[] in, int[] out, int n) {
		Queue<Integer> input = new ArrayDeque<>();
		for(int i=0; i<in.length; i++) {
			input.add(in[i]);
		}
		
		Queue<Integer> output = new ArrayDeque<>();
		for(int i=0; i<in.length; i++) {
			output.add(out[i]);
		}
		
		Stack<Integer> st = new Stack<>();
		while(input.size() > 0) {
			int ele = input.remove();
			
			if(ele == output.peek()) {
				output.remove();
				
				while(st.size() > 0) {
					if(st.peek() == output.peek()) {
						st.pop();
						output.remove();
					} else {
						break;
					}
				}
				
			} else {
				st.push(ele);
			}
		}
		return (st.isEmpty() && input.isEmpty());
	}
}
