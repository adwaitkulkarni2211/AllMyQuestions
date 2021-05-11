package graphs2;
import java.util.*;

public class NumberOfTriangleInAGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<>());
		}
		int e = sc.nextInt();
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			adj.get(v1).add(v2);
		}
		sc.close();
		count = 0;
		triangles = new HashSet<>();
		for(int i=0; i<v; i++) {
			boolean[] visited = new boolean[v];
			dfs(adj, i, i, visited, 1, i + "");
		}
		
		System.out.println("\ncount: " + count);
		System.out.println("triangles: " + triangles);
	}
	static int count;
	static HashSet<String> triangles;
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, int origSrc, 
							boolean[] visited, int it, String psf) {
		visited[src] = true;
		char[] psf1 = psf.toCharArray();
		Arrays.sort(psf1);
		String psf2 = String.valueOf(psf1);
		System.out.println("psf: " + psf2 + " it: " + it);
		if(it == 3) {
			for(int nbr: adj.get(src)) {
				if(nbr == origSrc) {
					if(!triangles.contains(psf2)) {
						count++;
						triangles.add(psf2);
					}
					break;
				}
			}
			return;
		}
		for(int nbr: adj.get(src)) {
			if(visited[nbr] == false)
				dfs(adj, nbr, origSrc, visited, it + 1, psf + nbr + "");
		}
	}

}
