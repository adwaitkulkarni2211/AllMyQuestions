package binaryTrees2;

import java.util.*;

public class BoundaryTraversalOfABinaryTree {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	ArrayList <Integer> ans;
	ArrayList <Integer> printBoundary(Node root) {
	    ans = new ArrayList<>();
	    
	    ans.add(root.data);
	    left(root.left);
	    leaf(root);
	    right(root.right);
	    
	    return ans;
	}
	
	void left(Node root) {
	    if(root == null) {
	        return;
	    }
	    if(root.left != null) {
	        ans.add(root.data);
	        left(root.left);
	    } else if(root.right != null) {
	        ans.add(root.data);
	        left(root.right);
	    }
	}
	
	void leaf(Node node) {
	    if(node == null) {
	        return;
	    }
	    if(node.left == null && node.right == null) {
	        ans.add(node.data);
	    }
	    leaf(node.left);
	    leaf(node.right);
	}
	
	void right(Node root) {
	    if(root == null) {
	        return;
	    }
	    if(root.right != null) {
	        right(root.right);
	        ans.add(root.data);
	    } else if(root.left != null) {
	        right(root.left);
	        ans.add(root.data);
	    }
	}
}
