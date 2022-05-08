package linkedList2;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	public Node connect(Node root) {
        if(root == null || (root.right == null && root.left == null)) {
            return root;
        }
        
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(root);
        
        Node prev = new Node(-1001);
        
        while(mq.size() > 0) {
            Node rem = mq.remove();
            
            prev.next = rem;
            prev = rem;
            
            if(rem.left != null)
                cq.add(rem.left);
            if(rem.right != null)
                cq.add(rem.right);
            
            if(mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                prev = new Node(-1001);
            }
        }
        
        return root;
    }
}
