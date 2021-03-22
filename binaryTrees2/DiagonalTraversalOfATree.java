package binaryTrees2;

import java.util.*;

public class DiagonalTraversalOfATree {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0) {
            root = q.remove();
            while(root != null) {
                if(root.left != null) {
                    q.add(root.left);
                }
                ans.add(root.data);
                root = root.right;
            }
        }
        return ans;
    }
}
