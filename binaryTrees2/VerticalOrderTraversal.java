package binaryTrees2;
import java.util.*;
public class VerticalOrderTraversal {
	class Solution {
		class TreeNode {
			TreeNode left, right;
			int val;
		}
	    class Pair implements Comparable<Pair>{
	        TreeNode node;
	        int row, col;
	        Pair(TreeNode node, int row, int col) {
	            this.node = node;
	            this.row = row;
	            this.col = col;
	        }
	        
	        public int compareTo(Pair o) {
	            if(this.col != o.col)
	                return this.col - o.col;
	            else if(this.row != o.row)
	                return this.row - o.row;
	            else
	                return this.node.val - o.node.val;
	        }
	        
	        public String toString() {
	            return "(" + node.val + ", " + row + ", " + col + ")";
	        }
	    }
	    
	    private void fillList(TreeNode root, int row, int col, List<Pair> nodes) {
	        if(root == null) {
	            return;
	        }
	        
	        nodes.add(new Pair(root, row, col));
	        
	        fillList(root.left, row + 1, col - 1, nodes);
	        fillList(root.right, row + 1, col + 1, nodes);
	    }
	    
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        List<Pair> nodes = new ArrayList<>();
	        
	        fillList(root, 0, 0, nodes); 
	        
	        Collections.sort(nodes);
	        //System.out.println(nodes);
	        
	        List<List<Integer>> ans = new ArrayList<>();
	        
	        int i = 0;
	        while(i < nodes.size()) {
	            List<Integer> temp = new ArrayList<>();
	            int col = nodes.get(i).col;
	            
	            while(i < nodes.size() && nodes.get(i).col == col) {
	                temp.add(nodes.get(i).node.val);
	                i++;
	            }
	            
	            ans.add(temp);
	        }
	        
	        return ans;
	    }
	}
}
