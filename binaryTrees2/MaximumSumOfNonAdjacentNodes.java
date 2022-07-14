package binaryTrees2;

public class MaximumSumOfNonAdjacentNodes {
	class Node {
		int data;
		Node left, right;
	}
	static class Pair {
        int incSum, excSum;
        Pair(int incSum, int excSum) {
            this.incSum = incSum;
            this.excSum = excSum;
        }
    }
    
    private static Pair solve(Node root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        int incSum = root.data + lp.excSum + rp.excSum;
        int excSum;
        
        int sum1 = lp.incSum + rp.incSum;
        int sum2 = lp.incSum + rp.excSum;
        int sum3 = lp.excSum + rp.incSum;
        int sum4 = lp.excSum + rp.excSum;
        
        excSum = Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4)));
        
        max = Math.max(max, Math.max(incSum, excSum));
        
        return new Pair(incSum, excSum);
        
    }
    
    static int max;
    static int getMaxSum(Node root) {
        max = 0;
        
        solve(root);
        
        return max;
    }
}
