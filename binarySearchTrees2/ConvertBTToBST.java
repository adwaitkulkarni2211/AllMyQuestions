package binarySearchTrees2;

import java.util.*;

public class ConvertBTToBST {
	
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	ArrayList<Integer> nums;
    Node binaryTreeToBST(Node root) {
       nums = new ArrayList<>();
       inOrder(root, 0);
       Collections.sort(nums);
       inOrder(root, 1);
       return root;
    }
    void inOrder(Node node, int f) {
        if(node == null) {
            return;
        }
        
        inOrder(node.left, f);
        if(f == 0) {
            nums.add(node.data);    
        } else {
            int rem = nums.remove(0);
            node.data = rem;
        }
        inOrder(node.right, f);
    }
}
