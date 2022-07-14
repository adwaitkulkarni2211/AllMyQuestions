package binaryTrees2;
import java.util.*;

public class MaximumWidthOfBinaryTree {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
    class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
        public String toString() {
            return "node: " + node.val + " idx: " + idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size(), start = 0, end = 0;
            for(int i = 0; i < size; i++) {
                Pair rem = q.remove();
                
                if(i == 0) start = rem.idx;
                if(i == size - 1) end = rem.idx;
                
                if(rem.node.left != null) {
                    int childIdx = rem.idx * 2;
                    q.add(new Pair(rem.node.left, childIdx));
                }
                if(rem.node.right != null) {
                    int childIdx = rem.idx * 2 + 1;
                    q.add(new Pair(rem.node.right, childIdx));
                }
            }
            
            int dist = end - start + 1;
            ans = Math.max(ans, dist);
        }
        
        return ans;
    }
}
