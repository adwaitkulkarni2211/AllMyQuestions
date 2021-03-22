package binaryTrees2;

import java.util.*;

public class BottomViewOfABinaryTree {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public ArrayList <Integer> bottomView(Node root) {
        ArrayList<Pair> vot = verticalOrder(root);
        ArrayList<Integer> ans = new ArrayList<>();
        
        Collections.sort(vot, new sortByHd());
        
        int i=0;
        while(i<vot.size()) {
            int j = i;
            ans.add(vot.get(i).node.data);
            while(j < vot.size() && vot.get(i).hd == vot.get(j).hd) {
                j++;
            }
            i = j;
        }
        return ans;
    }
    
    static class Pair {
        int hd;
        Node node;
        Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
    
    static class sortByHd implements Comparator<Pair> {
	    public int compare(Pair a, Pair b) { 
	        return a.hd - b.hd; 
	    } 
	}
    
    static ArrayList<Pair> verticalOrder(Node node) {
        Queue<Pair> mq = new ArrayDeque<>();
        Queue<Pair> cq = new ArrayDeque<>();
        ArrayList<Pair> nodeWithHd = new ArrayList<>();
        mq.add(new Pair(0, node));
        while(mq.size() > 0) {
            Pair nhd = mq.remove();
            nodeWithHd.add(new Pair(nhd.hd, nhd.node));
            
            if(nhd.node.left != null) {
                int hd = nhd.hd - 1;
                cq.add(new Pair(hd, nhd.node.left));
            }
            if(nhd.node.right != null) {
                int hd = nhd.hd + 1;
                cq.add(new Pair(hd, nhd.node.right));
            }
            
            if(mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
            }
        }
        Collections.reverse(nodeWithHd);
        return nodeWithHd;
    }
    
    //similar method to 2nd method of top view can be used for this, but its not passing
    //all test cases on gfg.
}
