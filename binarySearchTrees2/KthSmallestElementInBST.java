package binarySearchTrees2;

import java.util.*;

public class KthSmallestElementInBST {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//best:
	public int kthSmallest(Node root, int k) {
        LinkedList<Node> stack = new LinkedList<Node>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) 
                return root.data;
            root = root.right;
        }
    }
	
	//okay-ish
	int ans;
    public int kthSmallest2(Node root, int k) {
        ans = -1;
        count = 0;
        inOrder(root, k);
        return ans;
    }
    int count;
    private void inOrder(Node node, int k) {
        if(node == null || count >= k){
            return;
        }
        
        inOrder(node.left, k);
        count++;
        if(count == k) {
            ans = node.data;
            return;
        }
        
        inOrder(node.right, k);
    }
    
    //easiest / worst:
    ArrayList<Integer> nums;
    public int kthSmallest3(Node root, int k) {
        nums = new ArrayList<>();
        inOrder(root);
        return nums.get(k - 1);
    }
    
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        nums.add(node.data);
        inOrder(node.right);
    }
}
