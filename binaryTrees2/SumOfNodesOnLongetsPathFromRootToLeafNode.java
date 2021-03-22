package binaryTrees2;

import java.util.*;

public class SumOfNodesOnLongetsPathFromRootToLeafNode {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	ArrayList<Integer> path;
    int maxPathSize, ans;
    public int sumOfLongRootToLeafPath(Node node) {
        path = new ArrayList<>();
        maxPathSize = 0;
        ans = 0;
        solve(node, 0);
        return ans;
    }
    
    private void solve(Node node, int sum) {
        if(node == null) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            path.add(node.data);
            if(path.size() >= maxPathSize) {
                maxPathSize = path.size();
                ans = Math.max(sum + node.data, ans);
            }
            path.remove(path.size() - 1);
        }
        path.add(node.data);
        solve(node.left, sum + node.data);
        solve(node.right, sum + node.data);
        path.remove(path.size() - 1);
    }
}
