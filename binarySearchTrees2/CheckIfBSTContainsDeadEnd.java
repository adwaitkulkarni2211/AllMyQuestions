package binarySearchTrees2;

public class CheckIfBSTContainsDeadEnd {	
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static boolean ans;
    public static boolean isDeadEnd(Node node) {
        ans = false;
        solve(node, 1, Integer.MAX_VALUE);
        return ans;
    }
    
    private static void solve(Node node, int min, int max) {
        if(node == null || ans == true) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            if(max == min) {
                ans = true;
                return;
            }
        }
        
        //System.out.println("at node: " + node.data + " min: " + min + " max: " + max + " ans:" + ans);
        solve(node.left, min, node.data - 1);
        solve(node.right, node.data + 1, max);
    }
}
