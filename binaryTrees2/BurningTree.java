package binaryTrees2;
import java.util.*;

public class BurningTree {
	static class Node {
		Node left, right;
		int data;
	}
	static class Pair {
        Node par, child;
        Pair(Node par, Node child) {
            this.par = par;
            this.child = child;
        }
    }
    
    static Node start;
    
    public static int minTime(Node root, int tar) {
        start = null;
        HashMap<Node, Node> map = mapChildToPar(root, tar);
        
        return bfs(root, map);
    }
    
    private static int bfs(Node root, HashMap<Node, Node> map) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        
        int seconds = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node rem = q.remove();
                rem.data = -1;
                
                if(rem.left != null && rem.left.data != -1) q.add(rem.left);
                if(rem.right != null && rem.right.data != -1) q.add(rem.right);
                Node par = map.get(rem);
                if(par != null && par.data != -1) q.add(par);
            }
            seconds++;
        }
        
        return seconds;
    }
    
    private static HashMap<Node, Node> mapChildToPar(Node root, int tar) {
        HashMap<Node, Node> map = new HashMap<>() ;  //child vs parent
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(null, root));
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair rem = q.remove();
                
                map.put(rem.child, rem.par);
                if(rem.child.data == tar) start = rem.child;
                
                if(rem.child.left != null) {
                    q.add(new Pair(rem.child, rem.child.left));
                }
                if(rem.child.right != null) {
                    q.add(new Pair(rem.child, rem.child.right));
                }
            }
        }
        
        return map;
    }
}
