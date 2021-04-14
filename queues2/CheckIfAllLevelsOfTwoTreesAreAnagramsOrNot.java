package queues2;
import java.util.*;
public class CheckIfAllLevelsOfTwoTreesAreAnagramsOrNot {
	
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static boolean checkForAnagram(Node root1, Node root2) {
		Queue<Node> q1 = new ArrayDeque<>();
		Queue<Node> q2 = new ArrayDeque<>();
		boolean ans = true;
		
		q1.add(root1);
		q2.add(root2);
		
		//level order for 1st tree
		while(true) {
			int cicl1 = q1.size();
			int cicl2 = q2.size();
			if(cicl1 != cicl2) {
				ans = false;
				break;
			}
			if(cicl1 == 0) {
				break;
			}
			ArrayList<Integer> temp1 = new ArrayList<>();
			ArrayList<Integer> temp2 = new ArrayList<>();
			for(int i=0; i<cicl1; i++) {
				//for 1st tree
				Node rem = q1.remove();
				temp1.add(rem.data);
				
				if(rem.left != null) {
					q1.add(rem.left);
				}
				if(rem.right != null) {
					q1.add(rem.right);
				}
				//for 2nd tree
				rem = q2.remove();
				temp2.add(rem.data);
				
				if(rem.left != null) {
					q2.add(rem.left);
				}
				if(rem.right != null) {
					q2.add(rem.right);
				}
			}
			//sort both to compare
			Collections.sort(temp1);
			Collections.sort(temp2);
			
			//compare
			if(!temp1.equals(temp2)) {
				ans = false;
				break;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
       
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(6);
        
        boolean res = checkForAnagram(root1, root2);
        System.out.println(res);
	}

}
