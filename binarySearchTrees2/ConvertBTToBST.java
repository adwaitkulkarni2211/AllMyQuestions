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
    //method 2:
    Node binaryTreeToBST1(Node root) {
        List<Integer> nodes = new ArrayList<>();
        getNodes(root, nodes);
        
        Collections.sort(nodes);
        
        return construct(nodes, 0, nodes.size() - 1);
    }
    
    private void getNodes(Node root, List<Integer> nodes) {
        if(root == null) return;
        nodes.add(root.data);
        getNodes(root.left, nodes);
        getNodes(root.right, nodes);
    }
    
    private Node construct(List<Integer> nodes, int lo, int hi) {
        if(lo > hi) return null;
        
        int mid = (lo + hi) / 2;
        
        Node nn = new Node(nodes.get(mid));
        
        nn.left = construct(nodes, lo, mid - 1);
        nn.right = construct(nodes, mid + 1, hi);
        
        return nn;
    }
}
