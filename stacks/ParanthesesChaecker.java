package stacks;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesesChaecker {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- !=0) {
		    String s = sc.nextLine();
		    Stack<Character> st = new Stack<>();
		    boolean isBalanced = true;
		    for(int i=0;i<s.length();i++) {
		        char ch = s.charAt(i);
		        if(ch == '['|| ch == '{' || ch == '(' ) {
		            st.push(ch);
		            continue;
		        }
		        
		         if(st.isEmpty()) {
		        isBalanced = false;
		        break;
		    }
		    
		        if(ch==')') {
		            if(st.peek() == '(') {
		                st.pop();
		            } else {
		                isBalanced = false;
		                break;
		            }
		        }
		        if(ch==']') {
		            if(st.peek() == '[') {
		                st.pop();
		            } else {
		                isBalanced = false;
		                break;
		            }
		        }if(ch=='}') {
		            if(st.peek() == '{') {
		                st.pop();
		            } else {
		                isBalanced = false;
		                break;
		            }
		        }
		    }
		    if(!st.isEmpty()) {
		        isBalanced = false;
		    }
		    if(isBalanced) {
		        System.out.println("balanced");
		    } else {
		        System.out.println("not balanced");
		    }
		    
		}
	}

}
