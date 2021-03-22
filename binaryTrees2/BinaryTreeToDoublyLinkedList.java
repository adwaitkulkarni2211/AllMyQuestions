package binaryTrees2;

public class BinaryTreeToDoublyLinkedList {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	Node bToDLL(Node root) {
        flag = 0;
        inOrder(root);
        return head;
    }
    int flag;
    Node head = null, prev = null;
    void inOrder(Node node) {
        if(node == null) {
            return;
        }
        
        inOrder(node.left);
        
        if(flag == 0) {
            flag = 1;
            head = node;
            prev = node;
        } else {
            prev.right = node;
            node.left = prev;
            prev = node;
        }
        //System.out.println("Head: " + head.data);
        
        inOrder(node.right);
    }
}
