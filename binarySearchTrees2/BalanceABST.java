package binarySearchTrees2;

import java.util.*;

public class BalanceABST {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	ArrayList<Node> nodes;
    public Node balanceBST(Node root) {
        nodes = new ArrayList<>();
        inOrder(root);
        Node ans = buildBalancedTree(0, nodes.size() - 1);
 
        return ans;
    }
    
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        nodes.add(node);
        inOrder(node.right);
        
    }
    
    private Node buildBalancedTree(int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        Node node = new Node(nodes.get(mid).data);
        
        node.left = buildBalancedTree(start, mid - 1);
        node.right = buildBalancedTree(mid + 1, end);
        
        return node;
    }
}
