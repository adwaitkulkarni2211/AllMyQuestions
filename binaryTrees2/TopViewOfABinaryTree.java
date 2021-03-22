package binaryTrees2;

import java.util.*;

public class TopViewOfABinaryTree {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//Working on gfg but Time complexity: O(n + 2nh + n), Space: O(n + 2h) 
	static ArrayList<Integer> topView(Node root) {
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
        return nodeWithHd;
    }
    
    //not working on gfg but Time complexity: O(n + 2h + hLog(h) + h)
    static HashMap<Integer, Pair1> hm;
    static class Pair1 {
        Node node;
        int ht;
    }
    
    static ArrayList<Integer> topView2(Node root) {
        hm = new HashMap<>();
        Pair1 p = traverse(root, 0);
        System.out.println(p);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int key: hm.keySet()) {
            temp.add(key);
        }
        Collections.sort(temp);
        
        for(int n: temp) {
            ans.add(hm.get(n).node.data);
        }
        
        return ans;
    }

    static Pair1 traverse(Node node, int hd) {
        if(node == null) {
            Pair1 ret = new Pair1();
            ret.node = null;
            ret.ht = 0;
            return ret;
        }
        
        Pair1 l = traverse(node.left, hd - 1);
        Pair1 r = traverse(node.right, hd + 1);
        
        Pair1 p = new Pair1();
        p.node = node;
        p.ht = l.ht + r.ht + 1;
        
        if(hm.containsKey(hd)) {
            if(p.ht > hm.get(hd).ht) {
                hm.put(hd, p);
            }
        } else {
            hm.put(hd, p);
        }
        
        return p;
    }
}
