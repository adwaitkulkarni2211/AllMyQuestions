package graphs2;
import java.util.*;

public class Bellman_Ford_Algo_SingleSourceShortestPath {
	public static class Edge {
		int v1, v2, wt;
		
		Edge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}
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
			int wt = sc.nextInt();
			
			adj.get(v1).add(v2);
			//adj.get(v2).add(v1); Directed Graph
			edgeList[i] = new Edge(v1, v2, wt);
		}
		System.out.println("accepted all values!!");
		
		//initializing path array with infinity because we don't know the shortest paths
		int startingPoint = sc.nextInt();
		int[] path = new int[v];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[startingPoint] = 0;
		sc.close();
		
		//bellman ford:
		for(int i=0; i<v-1; i++) {
			int flag = 0;
			for(int j=0; j<edgeList.length; j++) {
				int src = edgeList[j].v1;
				int dest = edgeList[j].v2;
				int wt = edgeList[j].wt;
				
				if(path[src] != Integer.MAX_VALUE && path[src] + wt < path[dest]) {
					path[dest] = path[src] + wt;
					flag = 1;
				}
			}
			printArr(path);
			if(flag == 0) {
				//2 consecutive same shortest paths, no point in searching more
				break;
			}
		}
		
		//checking for -ve cycle
		int flag = 0;
		for(int j=0; j<edgeList.length; j++) {
			int src = edgeList[j].v1;
			int dest = edgeList[j].v2;
			int wt = edgeList[j].wt;
			
			if(path[src] != Integer.MAX_VALUE && path[src] + wt < path[dest]) {
				path[dest] = path[src] + wt;
				flag = 1;
			}
			
		}
		System.out.println();
		if(flag == 1) {
			System.out.println("Negative cycle detected, shortest path not possible");
		} else {
			for(int i=0; i<path.length; i++) {
				System.out.println("from "  + startingPoint + " to " + i + ": " + path[i] + " ");
			}
			System.out.println();
		}
	}
	
	private static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
