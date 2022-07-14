package binaryTrees2;
import java.util.*;

public class KSumPaths {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	//O(N)
	public int sumK(Node root, int tar) {
        ans = 0;
        HashMap<Integer, Integer> psumFreq = new HashMap<>();
        psumFreq.put(0, 1);
        
        solve(root, tar, 0, psumFreq);
        
        return ans; 
    }
    
    int ans;
    
    private void solve(Node root, int tar, int sum, HashMap<Integer, Integer> psumFreq) {
        if(root == null) return;
        
        sum += root.data;
        
        ans += psumFreq.getOrDefault(sum - tar, 0);
        
        psumFreq.put(sum, psumFreq.getOrDefault(sum, 0) + 1);
        
        solve(root.left, tar, sum, psumFreq);
        solve(root.right, tar, sum, psumFreq);
        
        if(psumFreq.get(sum) == 1) {
            psumFreq.remove(sum);
        } else {
            psumFreq.put(sum, psumFreq.get(sum) - 1);
        }
    }
	
  //O(N^2)
	int count;
    public int pathSum(Node root, int tar) {
        count = 0;
        traverse(root, tar);
        return count;
    }
    
    private void traverse(Node node, int tar) {
        if(node == null) {
            return;
        }
        solve(node, tar, 0);
        traverse(node.left, tar);
        traverse(node.right, tar);
    }
    
    private void solve(Node node, int tar, int sum) {
        if(node == null) {
            return;
        }
        
        if(sum + node.data == tar) {
            count++;
        }
        
        solve(node.left, tar, sum + node.data);
        solve(node.right, tar, sum + node.data);
    }
}
