package binarySearchTrees2;
import java.util.*;
public class TwoSum4Leetcode {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//best:
	boolean ans;
    ArrayList<Integer> nums;
    public boolean findTarget(Node root, int x) {
        ans = false;
        nums = new ArrayList<>();
        inOrder(root);
        int start = 0, end = nums.size() - 1;
        while(start < end) {
            if(nums.get(start) + nums.get(end) > x) {
                end--;
            } else if(nums.get(start) + nums.get(end) < x) {
                start++;
            } else {
                ans = true;
                break;
            }
        }
        return ans;
    }
    
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        
        inOrder(node.left);
        nums.add(node.data);
        inOrder(node.right);
    }
    
    //okay-ish / slower:
    HashSet<Integer> set;
    public boolean findTarget1(Node root, int k) {
        set = new HashSet<>();
        return inOrder(root, k);
    }
    
    private boolean inOrder(Node node, int k) {
        if(node == null) {
            return false;
        }
        
        if(set.contains(k - node.data)) {
            return true;
        }
        set.add(node.data);
        
        boolean l = inOrder(node.left, k);        
        boolean r = inOrder(node.right, k);
        
        return l || r;
    }
}
