package binarySearchTrees2;

public class CountBSTNodesThatLieInAGivenRange {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	int getCount(Node root, int lo, int hi) {
        if(root == null) return 0;
        
        if(root.data < lo) {
            return getCount(root.right, lo, hi);
        }
        if(root.data > hi) {
            return getCount(root.left, lo, hi);
        }
        
        int lCount = getCount(root.left, lo, hi);
        int rCount = getCount(root.right, lo, hi);
        
        return lCount + rCount + 1;
    }
}
