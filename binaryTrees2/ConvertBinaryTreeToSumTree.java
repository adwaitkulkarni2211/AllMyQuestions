package binaryTrees2;

//import java.util.*;

public class ConvertBinaryTreeToSumTree {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	public void toSumTree(Node root) {
        int s = solve(root);
        System.out.println(s);
    }
    
    private int solve(Node node) {
        if(node == null) {
            return 0;
        }
        
        int l = solve(node.left);
        int r = solve(node.right);
        
        int data = node.data;
        node.data = l + r;
        
        return data + l + r;
    }
}
