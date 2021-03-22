package binaryTrees2;
import java.util.*;
public class isValidBST {
	class Node {
		int data;
		Node left, right;
	}
	
	//Using in order traversal:
	static ArrayList<Integer> a = new ArrayList<>();
	static boolean ans = true;
	public static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		if(a.size() != 0 && a.get(a.size() - 1) < node.data) {
			a.add(node.data);
		} else {
			ans = false;
			return;
		}
		inOrder(node.right);
	}
	
	//using stack
	public static boolean isBST(Node node) {
		Stack<Node> st = new Stack<>();
		double left_val = Double.MIN_VALUE;
		
		while(st.size() > 0 || node != null) {
			while(node != null) {
				st.push(node);
				node = node.left;
			}
			
			node = st.pop();
			if(node.data <= left_val) {
				return false;
			}
			left_val = node.data;
			node = node.right;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
