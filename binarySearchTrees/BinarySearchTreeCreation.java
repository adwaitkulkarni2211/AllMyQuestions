package binarySearchTrees;
import java.util.*;
public class BinarySearchTreeCreation {
	public static class Node {
		int data;
		Node left, right;
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static Node construct(int[] a, int lo, int hi) {
		if(lo > hi) {
			return null;
		}
		
		int mid = (lo + hi) / 2;
		
		int data = a[mid];
		Node lc = construct(a, lo, mid - 1);
		Node rc = construct(a, mid + 1, hi);
		
		Node node = new Node(data, lc, rc);
		return node;
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
        int l = size(node.left);
        int r = size(node.right);
        return l + r + 1;
    }

    public static int sum(Node node) {
        if(node == null) {
            return 0;
        }
        int l = sum(node.left);
        int r = sum(node.right);
        return l + r + node.data;
    }

    public static int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if(node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(data > node.data) {
            return find(node.right, data);
        } else if(data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }
    
    public static Node add(Node node, int data) {
        if(node == null) {
            return new Node(data, null, null);
        }
        
        if(data > node.data) {
            node.right = add(node.right, data);
        } else if(data < node.data) {
            node.left = add(node.left, data);
        } else {
            
        }
        return node;
    }
    
    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            if(node.left != null && node.right != null) {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax); 
                return node; 
            } else if(node.left != null) {
                return node.left;
            } else if(node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }
    
    static int sum = 0;
    public static void rwsol(Node node) {
        if(node == null) {
            return;
        }
        rwsol(node.right);
        int temp = sum; 
        sum += node.data;
        node.data = temp;
        rwsol(node.left);
    }
    
    public static int lca(Node node, int d1, int d2) {
        if(node == null) {
            return 0;
        }
        
        if(d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        } else if(d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        } else {
            return node.data;
        }
    }
    
    public static void pir(Node node, int d1, int d2) {
        if(node == null) {
            return;
        }
        if(d1 < node.data && d2 < node.data) {
            pir(node.left, d1, d2);    
        } else if(d1 > node.data && d2 > node.data) {
            pir(node.right, d1, d2);    
        } else {
            pir(node.left, d1, d2);
            System.out.println(node.data);
            pir(node.right, d1, d2);
        }
    }
    //O(n*logn) solution for target sum pair:
    public static void tsp(Node root, Node node, int tar) {
        if(node == null) {
            return;
        }
        tsp(root, node.left, tar);
        int complement = tar - node.data;
        if(complement > node.data) {
            if(find(root, complement) == true) {
                System.out.print(node.data + " " + complement);
                System.out.println();
            }    
        }
        tsp(root, node.right, tar);
    }
    //O(n) time complexity:
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void twoSum(int tar) {
        int i = 0, j = ans.size() - 1;
        while(i < j) {
            if(ans.get(i) + ans.get(j) > tar) {
                j--;
            } else if(ans.get(i) + ans.get(j) < tar) {
                i++;
            } else {
                System.out.println(ans.get(i) + " " + ans.get(j));
                i++;
                j--;
            }
        }
    }
    public static void tsp(Node node) {
        if(node == null) {
            return;
        }
        tsp(node.left);
        ans.add(node.data);
        tsp(node.right);
    }
    
    //best approach for tsp:
    static class ITPair {
        int state = 0;
        Node node;
        ITPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void bestApproach(Node node, int tar) {
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();
        
        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));
        
        Node left = getNextFromNormalInOrder(ls);
        Node right = getNextFromReverseInOrder(rs);
        
        while(left.data < right.data) {
            if(left.data + right.data < tar) {
                left = getNextFromNormalInOrder(ls);
            } else if(left.data + right.data > tar) {
                right = getNextFromReverseInOrder(rs);
            } else {
                System.out.println(left.data + " "  + right.data);
                left = getNextFromNormalInOrder(ls);
                right = getNextFromReverseInOrder(rs);
            }
        }
    }
    
    public static Node getNextFromNormalInOrder(Stack<ITPair> st) {
        while(st.size() > 0) {
            ITPair top = st.peek();
            if(top.state == 0) {
                if(top.node.left != null) {
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
            } else if(top.state == 1) {
                if(top.node.right != null) {
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
                return top.node;
            } else if(top.state == 2) {
                st.pop();
            }
        }
        return null;
    }
    
    public static Node getNextFromReverseInOrder(Stack<ITPair> st) {
        while(st.size() > 0) {
            ITPair top = st.peek();
            if(top.state == 0) {
                if(top.node.right != null) {
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
            } else if(top.state == 1) {
                if(top.node.left != null) {
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
                return top.node;
            } else if(top.state == 2) {
                st.pop();
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		int[] a = {12, 25, 37, 50, 62, 75, 87};
		Node root  = construct(a, 0, a.length - 1);
		display(root);
	}
}
