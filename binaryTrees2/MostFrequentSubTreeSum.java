package binaryTrees2;

import java.util.*;

public class MostFrequentSubTreeSum {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	public int[] findFrequentTreeSum(Node root) {
        sumFreq = new HashMap<>();
        int sum = solve(root);
        System.out.println(sum);
        int mfs = Integer.MIN_VALUE;
        ArrayList<Integer> temp = new ArrayList<>();;
        for(int key: sumFreq.keySet()) {
            if(sumFreq.get(key) > mfs) {
                mfs = sumFreq.get(key);
                temp = new ArrayList<>();
                temp.add(key);
            } else if(sumFreq.get(key) == mfs) {
                temp.add(key);
            }
        }
        
        int[] ans = new int[temp.size()];    
        for(int i=0; i<ans.length; i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
    
    HashMap<Integer, Integer> sumFreq;
    
    private int solve(Node node) {
        if(node == null) {
            return 0;
        }
        
        int l = solve(node.left);
        int r = solve(node.right);
        
        int sum = l + r + node.data;
        
        if(sumFreq.containsKey(sum)) {
            sumFreq.put(sum, sumFreq.get(sum)+1);
        } else {
            sumFreq.put(sum, 1);
        }
        
        return sum;
    }
}
