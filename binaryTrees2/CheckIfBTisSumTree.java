package binaryTrees2;

//import java.util.*;

public class CheckIfBTisSumTree {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	boolean isSumTree(Node root) {
	    Pair ans = sum(root);
	    return ans.sumTree;
	}
	
    class Pair {
        Node node;
        boolean sumTree;
        int sum;
    }	
	
	Pair sum(Node node) {
	    if(node == null) {
	        Pair ret = new Pair();
	        ret.node = null;
	        ret.sumTree = true;
	        ret.sum = 0;
	        return ret;
	    }
	    
	    Pair lp = sum(node.left);
	    Pair rp = sum(node.right);
	    
	    Pair mp = new Pair();
	    
	    mp.node = node;
	    mp.sum = lp.sum + rp.sum + node.data;
	    mp.sumTree = (lp.sumTree && rp.sumTree && rp.sum + lp.sum == node.data) || (node.left == null && node.right == null);
	    
	    return mp;
	}
}
