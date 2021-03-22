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
	
	int getCount(Node root,int l, int h) {
        return countNodes(root, l, h);
    }
    
    int countNodes(Node node, int lo, int hi) {
        if(node == null) {
            return 0;
        }

        if(node.data >= lo && node.data <= hi) {
            return countNodes(node.left, lo, hi) + countNodes(node.right, lo, hi) + 1;
        } else if(node.data < lo) {
            return countNodes(node.right, lo, hi);
        } else {
            return countNodes(node.left, lo, hi);
        }
    }
}
