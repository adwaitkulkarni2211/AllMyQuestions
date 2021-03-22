package binaryTrees2;
import java.util.*;

public class RightViewOfABinaryTree {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static ArrayList<Integer> rightView(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        ArrayList<Integer> level = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        mainQ.add(root);
        
        while(mainQ.size() > 0) {
            root = mainQ.remove();
            level.add(root.data);
            
            if(root.right != null) {
                childQ.add(root.right);
            }
            if(root.left != null) {
                childQ.add(root.left);
            }
            
            if(mainQ.size() == 0) {
                ans.add(level.get(0));
                level = new ArrayList<>();
                mainQ = childQ;
                childQ = new ArrayDeque<>();
            }
        }
        return ans;
    }
}
