package binaryTrees2;

import java.util.*;

public class CHeckIfAllLeavesAreAtSameLevel {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	boolean check(Node node) {
	    Queue<Node> mq = new ArrayDeque<>();
	    Queue<Node> cq = new ArrayDeque<>();
	    int level = 1, leafOnLevel = 1, leafCount = 0;
	    boolean ans = true;
	    mq.add(node);
	    
	    while(mq.size() > 0) {
	        node = mq.remove();
	        
	        if(node.left == null && node.right == null) {
	            leafCount++;
	            if(leafCount != 1 && leafOnLevel != level) {
	                ans = false;
	                break;
	            }
	            leafOnLevel = level;
	        }
	        
	        if(node.left != null) {
	            cq.add(node.left);
	        }
	        if(node.right != null) {
	            cq.add(node.right);
	        }
	        
	        if(mq.size() == 0) {
	            mq = cq;
	            cq = new ArrayDeque<>();
	            level++;
	        }
	    }
	    
	    return ans;
    }
}
