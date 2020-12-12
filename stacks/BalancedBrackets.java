package stacks;
import java.util.*;
public class BalancedBrackets {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        
        //recommended method: 
        Stack<Character> st2 = new Stack<>();
        for(int i=0; i<str.length(); i++) {
        	if(str.charAt(i) == ')') {
        		if(st2.size() == 0) {
        			System.out.println("false");
        			return;
        		} else if(st2.peek() != '(') {
        			System.out.println("false");
        			return;
        		} else {
        			st2.pop();
        		}
        	} else if(str.charAt(i) == '}') {
        		if(st2.size() == 0) {
        			System.out.println("false");
        			return;
        		} else if(st2.peek() != '{') {
        			System.out.println("false");
        			return;
        		} else {
        			st2.pop();
        		}
        	} else if(str.charAt(i) == ']') {
        		if(st2.size() == 0) {
        			System.out.println("false");
        			return;
        		} else if(st2.peek() != '[') {
        			System.out.println("false");
        			return;
        		} else {
        			st2.pop();
        		}
        	} else if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
        		st2.push(str.charAt(i));
        	}
        	System.out.println(st2);
        }
        if(st2.size() == 0) {
        	System.out.println("true");
        } else {
        	System.out.println("false");
        }
        
      //My attempt:
        Stack < Character > st = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '}') {
                if (st.size() == 0) {
                    System.out.println("false");
                    return;
                }
                while (st.peek() != '{') {
                    if (st.peek() == '(' || st.peek() == '[') {
                        System.out.println("false");
                        return;
                    }
                    st.pop();
                }
                st.pop();

            } else if (str.charAt(i) == ']') {
                if (st.size() == 0) {
                    System.out.println("false");
                    return;
                }
                while (st.peek() != '[') {
                    if (st.peek() == '(' || st.peek() == '{') {
                        System.out.println("false");
                        return;
                    }
                    st.pop();
                }
                st.pop();

            } else if (str.charAt(i) == ')') {
                if (st.size() == 0) {
                    System.out.println("false");
                    return;
                }
                while (st.peek() != '(') {
                    if (st.peek() == '{' || st.peek() == '[') {
                        System.out.println("false");
                        return;
                    }
                    st.pop();
                }
                st.pop();

            } else {
                st.push(str.charAt(i));
            }
            //System.out.println(st);
        }
        //System.out.println("After loop:");
        if (st.size() == 0) {
            System.out.println("true");
        } else {
            while (st.size() != 0) {
                if (st.peek() == '{' || st.peek() == '(' || st.peek() == '[') {
                    System.out.println("false");
                    return;
                }
                st.pop();
                //System.out.println(st);
            }
            if (st.size() == 0) {
                System.out.println("true");
            }
        }
    }
}
