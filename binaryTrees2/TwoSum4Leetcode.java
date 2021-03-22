package binaryTrees2;

import java.util.*;

public class TwoSum4Leetcode {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	HashSet<Integer> set;
    public boolean findTarget(Node root, int k) {
        set = new HashSet<>();
        System.out.println(set);
        return inOrder(root, k);
    }
    
    private boolean inOrder(Node node, int k) {
        if(node == null) {
            return false;
        }
        
        if(set.contains(k - node.data)) {
            return true;
        }
        set.add(node.data);
        
        boolean l = inOrder(node.left, k);        
        boolean r = inOrder(node.right, k);
        
        return l || r;
    }
}
