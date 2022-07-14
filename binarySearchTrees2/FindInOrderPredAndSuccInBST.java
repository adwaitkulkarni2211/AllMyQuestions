package binarySearchTrees2;

public class FindInOrderPredAndSuccInBST {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static int state;
    public static void findPreSuc(Node root, int key) {
        state = 0;
        pre = new Node(-1);
        suc = new Node(-1);
        //System.out.println("before call My pre: " + pre.data + " suc: " + suc.data);
        solve(root, key);
//        p.pre = pre;
//        s.succ = suc;
        //System.out.println("My pre: " + pre.data + " suc: " + suc.data);
    }
    @SuppressWarnings("unused")
	private static Node findGreater(Node root, int key) {
        Node temp = root, ans = null;
        
        while(temp != null) {
            if(temp.data <= key) {
                temp = temp.right;
            } else if(temp.data > key) {
                ans = temp;
                temp = temp.left;
            }
        }
        
        return ans == null ? new Node(-1) : ans;
    }
    
    @SuppressWarnings("unused")
	private static Node findSmaller(Node root, int key) {
        Node temp = root, ans = null;
        
        while(temp != null) {
            if(temp.data < key) {
                ans = temp;
                temp = temp.right;
            } else if(temp.data >= key) {
                temp = temp.left;
            }
        }
        
        return ans == null ? new Node(-1) : ans;
    }
    static Node pre;
    static Node suc;
    private static void solve(Node node, int key) {
        if(node == null) {
            return;
        }
        
        solve(node.left, key);
        
        boolean found = false;
        if(node.data == key) {
            found = true;
        }
        
        if(node.data >= key) {
            state++;
        }
        
        if(state == 0) {
            pre = node;
        } else if(state > 0) {
            if(!found) {
                suc = node;
                state = Integer.MIN_VALUE;
                return;
            }
        }

        solve(node.right, key);
    }
}
