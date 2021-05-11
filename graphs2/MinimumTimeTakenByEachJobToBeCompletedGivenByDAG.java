package graphs2;
import java.util.*;
public class MinimumTimeTakenByEachJobToBeCompletedGivenByDAG {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
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
		int[] indeg = new int[v];
		for(ArrayList<Integer> al: adj) {
			for(int vtx: al) {
				indeg[vtx]++;
			}
		}
		
		Queue<Pair> q = new ArrayDeque<>();
		for(int i=0; i<indeg.length; i++) {
			if(indeg[i] == 0) {
				q.add(new Pair(i, 1));
			}
		}
		
		int count = 0;
		int minTime[] = new int[v];
		while(q.size() > 0) {
			Pair rem = q.remove();
			
			count++;
			minTime[rem.v] = rem.time;
			for(int nbr: adj.get(rem.v)) {
				indeg[nbr]--;
				if(indeg[nbr] == 0) {
					//adding 1 to rem.time will make sure that all the vertices that will be added
					//to the queue after rem.v, have the same time.
					q.add(new Pair(nbr, rem.time + 1));
				}
			}
			
		}
		
		if(count != v) {
			System.out.println("Topological sort not possible, no answer");
			return;
		}
		for(int i=0; i<minTime.length; i++) {
			System.out.print(minTime[i] + " ");
		}
		System.out.println();
	}
	static class Pair {
		int v, time;
		Pair(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}
}
