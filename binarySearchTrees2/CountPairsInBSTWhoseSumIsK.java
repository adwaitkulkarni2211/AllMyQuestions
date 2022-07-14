 package binarySearchTrees2;

public class CountPairsInBSTWhoseSumIsK {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static int count;
    public static int countPairs(Node root1, Node root2, int x) {
        count = 0;
        preOrder(root1, root2, x);
        return count;
    }
    
    private static void preOrder(Node node, Node root2, int x) {
        if(node == null) {
            return;
        }
        
        findPair(node, root2, x);
        
        preOrder(node.left, root2, x);
        preOrder(node.right, root2, x);
    }
    
    private static void findPair(Node node1, Node node2, int x) {
        while(node2 != null) {
            if (x == node1.data + node2.data) {
                //System.out.println("Node1: " + node1.data + " Node2: " + node2.data);
                count++;
                break;
            } else if(x < node1.data + node2.data) {
                node2 = node2.left;
            } else {
                node2 = node2.right;
            }
        }
    }
}
