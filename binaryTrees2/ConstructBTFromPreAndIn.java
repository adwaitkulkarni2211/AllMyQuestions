package binaryTrees2;

import java.util.*;

public class ConstructBTFromPreAndIn {
	
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }	
	
	static int preOrderIdx;
    static Map<Integer, Integer> inorderIndexMap;
    public static Node buildTree(int inorder[], int preorder[], int n)  {
        preOrderIdx = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        Node root = solve(inorder, preorder, 0, inorder.length - 1);
        return root;
    }
    
    private static Node solve(int inorder[], int preorder[], int start, int end) {
        if(start > end || preOrderIdx > preorder.length - 1) {
            return null;
        }
        
        int rootValue = preorder[preOrderIdx++];
        Node nn = new Node(rootValue);

        nn.left = solve(inorder, preorder, start, inorderIndexMap.get(rootValue) - 1);
        nn.right = solve(inorder, preorder, inorderIndexMap.get(rootValue) + 1, end);
        
        return nn;
    }
}
