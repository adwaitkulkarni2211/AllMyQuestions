package stacks;
import java.util.*;
import java.io.*;
public class SmallestNumberFollowingPattern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == 'd') {
                st.push(count);
                count++;
            } else if(ch == 'i') {
                st.push(count);
                count++;
                
                while(st.size() != 0) {
                    System.out.print(st.pop());
                }
            }
                
        }
        st.push(count);
        while(st.size() != 0) {
            System.out.print(st.pop());
        }
	}

}
