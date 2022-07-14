package binaryTrees2;
import java.util.*;

public class CheckCompletenessOfBinaryTree {
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
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size(), idx = 0, count = 0;
            for(int i = 0; i < size; i++) {
                Pair rem = q.remove();
                
                if(rem.idx != idx) return false;
                
                int leftIdx = rem.idx * 2, rightIdx = (rem.idx * 2) + 1;
                
                if(rem.node.left != null) q.add(new Pair(rem.node.left, leftIdx));
                if(rem.node.right != null) q.add(new Pair(rem.node.right, rightIdx));
                
                idx++;
                count++;
            }
            
            //if q.size() is 0 here, it means its the last level
            if(q.size() != 0 && count != (int)Math.pow(2, level)) return false;
            level++;
        }
        
        return true;
    }
}
