package binaryTrees2;

import java.util.HashMap;

public class CountNodesEqualToAverageOfSubtree {
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
	class Pair {
        int size, sum;
        HashMap<Integer, Integer> children;
        Pair(int size, int sum, HashMap<Integer, Integer> children) {
            this.size = size;
            this.sum = sum;
            this.children = children;
        }
    }
    
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        Pair ss = solve(root);   
        System.out.println(ss);
        return count;
    }
    
    private Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0, new HashMap<>());
        }
        
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        int sum = lp.sum + rp.sum + root.val;
        int size = lp.size + rp.size + 1;
        int avg = sum / size;
        
        if(lp.children.containsKey(avg)) {
            count += lp.children.get(avg);
        }
        if(rp.children.containsKey(avg)) {
            count += rp.children.get(avg);
        }
        if(avg == root.val) {
            count++;
        }
        
        HashMap<Integer, Integer> children = new HashMap<>();
        for(int key: lp.children.keySet()) {
            children.put(key, children.getOrDefault(key, 0) + lp.children.get(key));
        }
        for(int key: rp.children.keySet()) {
            children.put(key, children.getOrDefault(key, 0) + rp.children.get(key));
        }
        
        return new Pair(size, sum, children);
    }
}
