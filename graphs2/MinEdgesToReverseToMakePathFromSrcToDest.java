package graphs2;
import java.util.*;
public class MinEdgesToReverseToMakePathFromSrcToDest {

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
		
		//constructing the alternate graph:
		ArrayList<ArrayList<Pair>> mod = new ArrayList<>();		
		for(int i=0; i<adj.size(); i++) {
			mod.add(new ArrayList<>());
		}
		for(int i=0; i<adj.size(); i++) {
			for(int j=0; j<adj.get(i).size(); j++) {
				mod.get(i).add(new Pair(adj.get(i).get(j), 0, ""));
				mod.get(adj.get(i).get(j)).add(new Pair(i, 1, ""));
			}
		}
		
		System.out.println("\nmodded graph:");
		for(int i=0; i<mod.size(); i++) {
			System.out.print(i + ": ");
			for(int j=0; j<mod.get(i).size(); j++) {
				System.out.print(mod.get(i).get(j).src + " ");
			}
			System.out.println();
		}
		
		int src = sc.nextInt();
		int dest = sc.nextInt();
		sc.close();
		
		dijkstras(mod, src, dest);
	}
	
	private static void dijkstras(ArrayList<ArrayList<Pair>> mod, int src, int dest) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[mod.size()];		
		pq.add(new Pair(src, 0, src + ""));
		
		while(pq.size() > 0) {
			Pair rem = pq.remove();
			
			if(visited[rem.src] == true) {
				continue;
			}
			visited[rem.src] = true;
			
			System.out.println("src: " + rem.src + " wsf: " + rem.wsf + " path: " + rem.psf);
			
			if(rem.src == dest) {
				System.out.println(rem.wsf);
				return;
			}
			
			for(Pair nbr: mod.get(rem.src)) {
				if(visited[nbr.src] == false)
					pq.add(new Pair(nbr.src, nbr.wsf + rem.wsf, rem.psf + nbr.src + ""));
			}
		}
		System.out.println("Not found");
	}
	
	static class Pair implements Comparable<Pair>{
		int src, wsf;
		String psf;
		Pair(int src, int wsf, String psf) {
			this.src = src;
			this.wsf = wsf;
			this.psf = psf;
		}
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

}
