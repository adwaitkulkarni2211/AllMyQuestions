package graphs2;
import java.util.*;

public class LongestPathInDAG {
	static class Pair {
		int src, wsf;
		Pair(int src, int wsf) {
			this.src = src;
			this.wsf = wsf;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<>());
		}
		int e = sc.nextInt();
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			
			adj.get(v1).add(new Pair(v2, wt));
		}
		int src = sc.nextInt();
		sc.close();
		
		int[] dist = new int[v];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[src] = 0;
		
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[v];
		topoSort(adj, st, 0, visited);
		System.out.println("topo sort: " + st);
		
		while(st.size() > 0) {
			int vtx = st.pop();
			if(dist[vtx] != Integer.MIN_VALUE) {
				bfs(adj, vtx, dist);
				break;
			}
		}
		for(int i=0; i<dist.length; i++) {
			System.out.println("for " + i + ": " + dist[i]);
		}
	}
	
	private static void bfs(ArrayList<ArrayList<Pair>> adj, int src, int[] dist) {
		Queue<Pair> q = new ArrayDeque<>();
		boolean[] visited = new boolean[adj.size()];
		q.add(new Pair(src, 0));
		
		while(q.size() > 0) {
			Pair rem = q.remove();
			System.out.println("removed: " + rem.src + " wsf: " + rem.wsf);
			
			if(visited[rem.src] == true) {
				continue;
			}
			visited[rem.src] = true;
			
			for(Pair nbr: adj.get(rem.src)) {
				dist[nbr.src] = Math.max(dist[nbr.src], dist[rem.src] + nbr.wsf);
				if(visited[nbr.src] == false) {
					q.add(new Pair(nbr.src, dist[nbr.src]));
				}
			}
		}
	}
	
	private static void topoSort(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int src, boolean visited[]) {
		visited[src] = true;
		
		for(Pair nbr: adj.get(src)) {
			if(visited[nbr.src] == false) {
				topoSort(adj, st, nbr.src, visited);
			}
		}
		st.push(src);
	}

}
