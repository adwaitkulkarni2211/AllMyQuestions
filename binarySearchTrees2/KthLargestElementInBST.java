package binarySearchTrees2;

import java.util.*;

public class KthLargestElementInBST {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	int ans;
    public int kthLargest(Node root, int k) {
        int length = size(root);
        if(k > length || k < 1) {
            return -1;
        }
        int dest = length - k;
        LinkedList<Node> stack = new LinkedList<Node>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.right;
            }
            root = stack.removeLast();
            if (--dest == 0) 
                return root.data;
            root = root.left;
        }
    }
    
    private int size(Node root) {
        if(root == null) {
            return 0;
        }
        int l = size(root.left);
        int r = size(root.right);
        return l + r + 1;
    }
}
