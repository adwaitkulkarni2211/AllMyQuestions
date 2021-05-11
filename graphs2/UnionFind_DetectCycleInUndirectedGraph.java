package graphs2;
import java.util.*;
public class UnionFind_DetectCycleInUndirectedGraph {	
	public static int find(int[] set, int node) {
		if(set[node] == -1) {
			return node;
		} else {
			return find(set, set[node]);
		}
	}
	
	public static void union(int[] set, int node1, int node2) {
		int par1 = find(set, node1);
		int par2 = find(set, node2);
		set[par1] = par2;
	}
	
	public static boolean isCyclic(Edge[] edgeList, int[] set) {
		//start processing edges:
		for(int i=0; i<edgeList.length; i++) {
			//storing parents of both vertices into par1 and par2
			int par1 = find(set, edgeList[i].v1);
			int par2 = find(set, edgeList[i].v2);
			
			if(par1 == par2) {
				//cycle detected
				System.out.println("cycle detected");
				return true;
			} else {
				union(set, par1, par2);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//creating the adj list and the edge list.
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = sc.nextInt();
		
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<>());
		}
		
		int e = sc.nextInt();
		Edge edgeList[] = new Edge[e];
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			adj.get(v1).add(v2);
			adj.get(v2).add(v1);
			edgeList[i] = new Edge(v1, v2);
		}
		sc.close();
		//in the set array, the idx will denote the node and set[idx] will denote its parent
		//before processing any edge, all nodes' parents are unknown so the array is filled with -1
		int set[] = new int[v];
		Arrays.fill(set, -1);
		System.out.println(isCyclic(edgeList, set));
	}
	
	public static class Edge {
		int v1, v2;
		Edge(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}

}
