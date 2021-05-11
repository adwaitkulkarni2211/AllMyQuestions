package graphs2;
import java.util.*;
public class UnionFind_Rank_PathCompression_DetectCycleInUndirectedGraph {
	public static int find(Pair[] set, int node) {
		if(set[node].par == -1) {
			return node;
		}
		int par = find(set, set[node].par);
		set[node].par = par;
		return par;
	}
	
	public static void union(Pair[] set, int node1, int node2) {
		int absr1 = find(set, node1);
		int absr2 = find(set, node2);
		
		if(set[absr1].rank < set[absr2].rank) {
			set[absr1].par = absr2;
		} else if(set[absr2].rank < set[absr1].rank){
			set[absr2].par = absr1;
		} else {
			set[absr2].par = absr1;
			set[absr1].rank++;
		}
	}
	
	public static boolean isCyclic(Pair[] set, Edge[] edgeList) {
		//start processing the edges, absr = absolute root
		for(int i=0; i<edgeList.length; i++) {
			int absr1 = find(set, edgeList[i].v1);
			int absr2 = find(set, edgeList[i].v2);
			
			if(absr1 == absr2) {
				return true;
			}
			union(set, absr1, absr2);
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
		
		Pair[] set = new Pair[v];
		//initially rank = 0 and parent = -1
		for(int i=0; i<set.length; i++) {
		    set[i] = new Pair(-1, 0);
		}
		
		System.out.println(isCyclic(set, edgeList));
	}
	public static class Edge {
		int v1, v2;
		Edge(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	public static class Pair {
		int rank, par;
		Pair(int par, int rank) {
			this.rank = rank;
			this.par = par;
		}
	}
}
