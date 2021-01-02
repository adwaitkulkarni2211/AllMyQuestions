package genericTrees;
import java.util.*;
import java.io.*;
public class GenericTreeCreation {		
	public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }
	
	public static void printGenericTree (Node node) {
		String str = node.data + " -> ";
		for(Node child: node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		
		for(Node child: node.children) {
			printGenericTree(child);
		}
	}
	
	public static int size(Node node) {
        int sum = 0;
        for(Node child: node.children) {
            int childSize = size(child);
            sum += childSize;
        }
        sum += 1;
        return sum;
    }
	
	//My initial Approach using maxChild as a parameter:
	public static int max(Node node, int maxChild) {        
        if(node.data > maxChild) {
            maxChild = node.data;
        }
        for(Node child: node.children) {
            maxChild = max(child, maxChild);
        }
        
        return maxChild;
    }
	
	//No additional parameter, pepcoding's method:
	public static int max(Node node) {
        int maxData = Integer.MIN_VALUE;
        
        for(Node child: node.children) {
            int maxChild = max(child);
            maxData = Math.max(maxChild, maxData);
        }
        
        maxData = Math.max(node.data, maxData);
        
        return maxData;
    }
	
	public static int height(Node node) {
        int count = -1;		//initialized with -1 because height is expected in terms of edges not nodes
        					//if it was expected in terms of nodes, initialize with 0
        					//no. of edges = no. of nodes - 1
        for(Node child: node.children) {
            int subCount = height(child);
            count = Math.max(subCount, count);
        }
        count++;
        return count;
    }
	
	public static void traversals(Node node) {
		//area 
        System.out.println("Node Pre " + node.data);
        for (Node child: node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }
	
	public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children) {
                q.add(child);
            }
        }
        System.out.print(".");
    }
	
	public static void levelOrderLinewise(Node node) {
        Queue < Node > q = new ArrayDeque < > ();
        Queue < Node > childQ = new ArrayDeque < > ();
        q.add(node);
        while(q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children) {
                childQ.add(child);
            }
            
            if(q.size() == 0) {
                q = childQ;
                childQ = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
	
	public static void levelOrderLinewise2(Node node) {
		Queue <Node> q = new ArrayDeque<>();
		q.add(node);
		q.add(new Node(-1));
		
		while(q.size() > 0) {
			node = q.remove();
			
			if(node.data != -1) {
				System.out.print(node.data + " ");
				for(Node child: node.children) {
					q.add(child);
				}
			} else {
				if(q.size() > 0) {
					q.add(new Node(-1));
					System.out.println();
				}
			}
		}
	}
	
	public static void levelOrderLinewise3 (Node node) {
		Queue <Node> q = new ArrayDeque<>();
		q.add(node);
		while(q.size() > 0) {
			int cicl = q.size();
			for(int i=0; i<cicl; i++) {
				//RPA:
				node = q.remove();
				System.out.print(node.data + " ");
				
				for(Node child: node.children) {
					q.add(child);
				}
			}
			System.out.println();
		}
	}
	
	static class Pair {
		int level;
		Node node;
		Pair() {
			
		}
		Pair(Node node, int level) {
			this.level = level;
			this.node = node;
		}
	}
	public static void levelOrderLinewise4(Node node) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(node, 1));
		int level = 1;
		while(q.size() > 0) {
			Pair p = q.remove();
			if(p.level > level) {
				level = p.level;
				System.out.println();
			}
			System.out.print(p.node.data + " ");
			for(Node child: p.node.children) {
				Pair cp = new Pair(child, p.level + 1);
				q.add(cp);
			}
		}
	}
	
	public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> st = new Stack<>();
        Stack<Node> childSt = new Stack<>();
        st.push(node);
        int level = 1;
        while(st.size() > 0) {
            node = st.pop();
            System.out.print(node.data + " ");
            
            if(level % 2 == 0) {
                for(int i=node.children.size() - 1; i>=0; i--) {
                    Node child = node.children.get(i);
                    childSt.add(child);
                }
            } else {
                for(int i=0; i<node.children.size(); i++) {
                    Node child = node.children.get(i);
                    childSt.add(child);
                }
            }
            if(st.size() == 0) {
                st = childSt;
                childSt = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
	
	public static void mirror(Node node) {
        for(Node child: node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }
	
	public static void removeLeaves(Node node) {
        for(int i=node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if(child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        
        for(Node child: node.children) {
            removeLeaves(child);
        }
    }
	
	public static void linearize(Node node) {        
        for(Node child: node.children) {
            linearize(child);
        }
        
        while(node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secLast = node.children.get(node.children.size() - 1);
            Node tail = getTail(secLast);
            tail.children.add(last);
        }
    }
    private static Node getTail(Node node) {
        while(node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }
    
    //optimized linearize:
//    public static Node linearize2(Node node) {
//    	if(node.children.size() == 0) {
//    		return node;
//    	}
//    	Node lkt = linearize2(node.children.get(node.children.size() - 1));
//    	while(node.children.size() > 1) {
//    		Node last = node.children.remove(node.children.size() - 1);
//    		Node sl = node.children.get(node.children.size() - 1);
//    		Node slkt = linearize2(sl);
//    	}
//    	return lkt;
//    }
    
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child: node.children) {
            boolean isFound = find(child, data);
            if (isFound == true) {
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList < Integer > nodeToRootPath(Node node, int data){
        if(node.data == data) {
            ArrayList<Integer> toReturn = new ArrayList<>();
            toReturn.add(data);
            return toReturn;
        }
        for(Node child: node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            if(pathTillChild.size() > 0) {
            	pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }
    
    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> pathD1 = nodeToRootPath(node, d1);
        ArrayList<Integer> pathD2 = nodeToRootPath(node, d2);
        
        int i = pathD1.size() - 1, j = pathD2.size() - 1;
        while(i >= 0 && j >= 0 && (pathD1.get(i) == pathD2.get(j))) {
            i--;
            j--;
        }
        return pathD1.get(i+1);
    }
    
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList < Integer > p1 = nodeToRootPath(node, d1);
        ArrayList < Integer > p2 = nodeToRootPath(node, d2);

        while (p1.size() > 0 && p2.size() > 0 && (p1.get(p1.size() - 1) == p2.get(p2.size() - 1))) {
            p1.remove(p1.size() - 1);
            p2.remove(p2.size() - 1);
        }
        return p1.size() + p2.size();
    }
    
    public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }
        
        for(int i=0; i<n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if(areSimilar(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }
        
        for(int i=0, j=n2.children.size() - 1; i<n1.children.size() && j>=0; i++,j--) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if(areMirror(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }
    
    static int size;
    static int height;
    static int max;
    static int min;
    public static void multisolver (Node node, int depth) {
    	size++;
    	height = Math.max(depth, height);
    	min = Math.min(min, node.data);
    	max = Math.max(max, node.data);
    	
    	for(Node child: node.children) {
    		multisolver(child, depth + 1);
    	}
    }
    
    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data) {
        if(state == 0) {
            if(node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if(state == 1) {
            successor = node;
            state = 2;
        }

        for (Node child: node.children) {
            predecessorAndSuccessor(child, data);
        }
    }
    
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    
    public static void ceilAndFloor(Node node, int data) {
        if(node.data > data) {
            ceil = Math.min(ceil, node.data);
        } else if(node.data < data) {
            floor = Math.max(floor, node.data);
        }

        for (Node child: node.children) {
            ceilAndFloor(child, data);
        }
    }
    
    static int maxSum = Integer.MIN_VALUE;
    static int maxSumNode = 0;
    public static int maxSumSubtree(Node node) {
        int sum = 0;
        
        for(Node child: node.children) {
            int csum = maxSumSubtree(child);
            sum += csum;
        }
        sum += node.data;
        
        if(sum > maxSum) {
            maxSumNode = node.data;
            maxSum = sum;
        }
        
        return sum;
    }
    
    static int dia = 0;
    public static int diameter(Node node) {
        int dch = -1, sdch = -1; //deepest and second deepest child
        
        for(Node child: node.children) {
            int ch = diameter(child);
            if(ch >= dch) {
                sdch = dch;
                dch = ch;
            } else if(ch >= sdch) {
                sdch = ch;
            }
        }
        
        if(dch + sdch + 2 > dia) {
            dia = dch + sdch + 2;
        }
        
        dch++;
        return dch;
    }
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        System.out.println(root);
        size = 0;
        height = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        multisolver(root, 0);
        System.out.println("size: " + size);
        System.out.println("height: " + height);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        predecessor = null;
        successor = null;
        state = 0;
        predecessorAndSuccessor(root, 90);
        
	}
}
class Node {
	int data;
	ArrayList<Node> children = new ArrayList<>();
	
	Node() {
		
	}
	Node(int data) {
		this.data = data;
	}
}
