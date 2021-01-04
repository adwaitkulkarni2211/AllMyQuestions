package binaryTrees;
import java.util.*;
public class BinaryTreeCreation {
	
	public static class Node {
		int data;
		Node left, right;
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
	
	public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    
    public static int size(Node node) {
        if(node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }
    
    public static int sum(Node node) {
        if(node == null) {
            return 0;
        }
        int sumLeft = sum(node.left);
        int sumRight = sum(node.right);
        int total = sumLeft + sumRight + node.data;
        return total;
    }

    public static int max(Node node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }
        int maxLeft = max(node.left);
        int maxRight = max(node.right);
        int cand = Math.max(maxRight, maxLeft);	//cand = candidate
        return Math.max(cand, node.data);
    }

    public static int height(Node node) {
        if(node == null) {
            return 0;	//-1 for height in terms of edges
            			//0 for height in terms of nodes
        }
        int hl = height(node.left);
        int hr = height(node.right);
        return Math.max(hr, hl) + 1;
    }
    
    public static void traversals(Node node) {
    	if(node == null) {
    		return;
    	}
    	System.out.println("pre: " + node.data);
    	
    	traversals(node.left);
    	System.out.println("in: " + node.data);
    	traversals(node.right);
    
    	System.out.println("post: " + node.data);
    }
    
    public static void levelOrder(Node node) {
        Queue<Node> mainq = new ArrayDeque<>();
        Queue<Node> childq = new ArrayDeque<>();
        
        mainq.add(node);
        while(mainq.size() > 0) {
            node = mainq.remove();
            System.out.print(node.data + " ");
            
            if(node.left != null) {
                childq.add(node.left);    
            }
            if(node.right != null) {
                childq.add(node.right);    
            }
            if(mainq.size() == 0) {
                mainq = childq;
                childq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    
    static class Pair1 {
        Node node;
        int state;
        Pair1(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void iterativePrePostInTraversal(Node node) {
        Stack < Pair1 > st = new Stack < > ();
        st.push(new Pair1(node, 1));
        String pre = "", in = "", post = "";

        while (st.size() > 0) {
            Pair1 top = st.peek();
            if (top.state == 1) {
                pre += top.node.data + " ";
                top.state++;
                if (top.node.left != null)
                    st.push(new Pair1(top.node.left, 1));
            } else if (top.state == 2) {
                in += top.node.data + " ";
                top.state++;
                if (top.node.right != null)
                    st.push(new Pair1(top.node.right, 1));
            } else {
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println( in );
        System.out.println(post);
    }
    
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        if (node.left != null) {
            boolean isFound = find(node.left, data);
            if (isFound) {
                return true;
            }
        }
        if (node.right != null) {
            boolean isFound = find(node.right, data);
            if (isFound) {
                return true;
            }
        }
        return false;
    } 

    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList < Integer > ret = new ArrayList < > ();
            ret.add(data);
            return ret;
        }

        if (node.left != null) {
            ArrayList < Integer > ans = nodeToRootPath(node.left, data);
            if (ans.size() > 0) {
                ans.add(node.data);
                return ans;
            }
        }
        if (node.right != null) {
            ArrayList < Integer > ans = nodeToRootPath(node.right, data);
            if (ans.size() > 0) {
                ans.add(node.data);
                return ans;
            }
        }

        return new ArrayList < > ();
    }
    //slightly modified find and node to root path:
    static ArrayList<Node> path;
    public static boolean find1(Node node, int data) {
        if(node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node);
            return true;
        }
        boolean filc = find1(node.left, data);
        if(filc) {
            path.add(node);
            return true;
        }
        boolean firc = find1(node.right, data);
        if(firc) {
            path.add(node);
            return true;
        }        
        return false;
    }
//uses the static array list path to fill nodes into using the find function and then returns it.
    public static ArrayList<Node> nodeToRootPath1(Node node, int data) {
    	path = new ArrayList<>();
    	if(find(node, data))
    		return path;
    	return new ArrayList<>();
    }
    
    //recommended approach:
    public static void printKLevelsDown(Node node, int k, Node block) {
        if(node == null || k < 0 || node == block) {
            return;
        }
        if(k == 0) {
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k - 1, block);
        printKLevelsDown(node.right, k - 1, block);
        
    }
    //my approach: (too long)
    public static void printKLevelsDown2(Node node, int k) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> c = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1, null, null));
        c.add(node);
        c.add(new Node(-1, null, null));
        while(q.size() > 0) {
            node = q.remove();
            if(node.data != -1) {
                if(node.left != null) {
                    q.add(node.left);
                    c.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                    c.add(node.right);
                }    
            } else {
                if(q.size() > 0) {
                    q.add(new Node(-1, null, null));
                    c.add(new Node(-1, null, null));
                }
            }
        }
        if(k == 0) {
            System.out.println(c.peek().data);
        } else {
            int count = 0;
            for(Node val: c) {
                if(val.data == -1) {
                    count++;
                }else if(count == k) {
                    if(val.data == -1) {
                        break;
                    }
                    System.out.println(val.data);
                }
            }
        }
    }
    
    public static void printKNodesFar(Node node, int data, int k) {
        path = new ArrayList<>();
        if(find1(node, data)) {
            for(int i=0; i<path.size(); i++) {
                printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1)); 
            }
        }        
    }
    
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            sum += node.data;;
            if(sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }
        
        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }
    
    public static Node createLeftCloneTree(Node node) {
        if(node == null) {
            return null;
        }
        
        Node l = createLeftCloneTree(node.left);
        Node r = createLeftCloneTree(node.right);
        
        Node temp = new Node(node.data, l, null);
        node.left = temp;
        node.right = r;
        return node;
    }
    
    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        Node l = transBackFromLeftClonedTree(node.left);
        Node r = transBackFromLeftClonedTree(node.right);
        if (l != null && node.data == l.data)
            node.left = l.left;
        node.right = r;
        return node;
    }
    
    //another method with a different euler path:
    public static Node transBackFromLeftClonedTree1(Node node) {
        if (node == null) {
            return null;
        }

        Node l = transBackFromLeftClonedTree(node.left.left);
        Node r = transBackFromLeftClonedTree(node.right);
        node.left = l;
        node.right = r;
        return node;
    }
    
    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);

        if (parent != null && parent.left == null && parent.right != null) {
            System.out.println(parent.right.data);
        } else if (parent != null && parent.right == null && parent.left != null) {
            System.out.println(parent.left.data);
        }
    }
    
    public static Node removeLeaves(Node node) {
        if(node == null) {
            return null;
        }
        if(node.left != null && node.left.left == null && node.left.right == null) {
            node.left = null;
        }
        if(node.right != null && node.right.left == null && node.right.right == null) {
            node.right = null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }
    //recommended:
    public static Node removeLeaves1(Node node) {
        if(node == null) {
            return null;
        }
        if(node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }
    
    static int dia = 0;
    public static int diameter1(Node node) {
        if(node == null) {
            return -1;
        }
        int l = diameter1(node.left);
        int r = diameter1(node.right);
        int h = height(node);
        if(l + r + 2 > dia) {
            dia = l + r + 2;
        }
        return h;
    }
    //Above method is O(n^2). O(n) method:
    static class DiaPair {
        int ht = -1, dia = 0;
    }
    public static DiaPair diameter(Node node) {
        if(node == null) {
            return new DiaPair();
        }
        DiaPair lp = diameter(node.left);
        DiaPair rp = diameter(node.right);
        DiaPair myp = new DiaPair();
        myp.ht = Math.max(lp.ht, rp.ht) + 1;
        myp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));
        return myp;
    }
    
    static int tilt = 0;
    public static int tilt(Node node) {
        if(node == null) {
            return 0;
        }
        
        //will return left's sum and change tilt for left side
        int ls = tilt(node.left);
        //will return right's sum and change tilt for right side
        int rs = tilt(node.right);
        
        int localTilt = Math.abs(ls - rs);
        tilt += localTilt;
        int ts = ls + rs + node.data;
        return ts;
    }
    
    //My approach:
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void lmax(Node node) {
        if(node == null) {
            return;
        }
        max = Math.max(node.data, max);
        //System.out.println("max: " + max);
        lmax(node.left);
        lmax(node.right);
    }
    
    public static void rmin(Node node) {
        if(node == null) {
            return;
        }
        min = Math.min(node.data, min);
        //System.out.println("min: " + min);
        rmin(node.left);
        rmin(node.right);
    }
    
    //similar approach using Pair class:
    public static boolean isBST(Node node) {
        lmax(node.left);
        rmin(node.right);
        if(max < node.data && min > node.data) {
            return true;
        } else {
            return false;
        }
    }
    
    static class BSTPair {
        int min, max;
        boolean isBST;
    }
    public static BSTPair isBST1(Node node) {
        if(node == null) {
            BSTPair b = new BSTPair();
            b.min = Integer.MAX_VALUE;
            b.max = Integer.MIN_VALUE;
            b.isBST = true;
            return b;
        }
        
        BSTPair l = isBST1(node.left);
        BSTPair r = isBST1(node.right);
        
        BSTPair my = new BSTPair();
        
        my.isBST = l.isBST && r.isBST && node.data >= l.max && node.data <= r.min;
        my.min = Math.min(node.data, Math.min(l.min, r.min));
        my.max = Math.max(node.data, Math.max(l.max, r.max));
        
        return my;
    }
    
    static boolean bal = true;
    public static int isBalanced(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);

        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            bal = false;
        }

        int th = Math.max(rh, lh) + 1;
        return th;
    }
    
    //using pair class:
    public static class balPair {
        int ht;
        boolean isBal;
    }
    public static balPair isBalanced1(Node node) {
        if(node == null) {
            balPair b = new balPair();
            b.ht = -1;
            b.isBal = true;
            return b;
        }
        
        balPair lp = isBalanced1(node.left);
        balPair rp = isBalanced1(node.right);
        
        balPair mp = new balPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        return mp;
    }
    
	public static void main(String[] args) {
		Integer[] a = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = construct(a);
		display(root);
		int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println("size: " + size);
        System.out.println("sum: " + sum);
        System.out.println("max: " + max);
        System.out.println("height: " + ht);
        //traversals(root);
	}

}
