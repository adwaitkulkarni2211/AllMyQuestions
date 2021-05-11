package graphs2;
import java.util.*;

public class FindIfThereIsAPathOfMoreThanK {
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
			adj.get(v2).add(new Pair(v1, wt));
		}
		int k = sc.nextInt();
		sc.close();
		
		boolean[] visited = new boolean[v];
		dfs(adj, visited, 0, k, 0);
	}
	
	private static void dfs(ArrayList<ArrayList<Pair>> adj, boolean[] visited, int src, int k, int wsf) {
		visited[src] = true;
		
		if(wsf == k) {
			System.out.println("True.");
			return;
		}
		
		for(Pair nbr: adj.get(src)) {
			if(visited[nbr.src] == false) {
				dfs(adj, visited, nbr.src, k, wsf + nbr.wsf);
			}
		}
		
		visited[src] = false;
	}

}
