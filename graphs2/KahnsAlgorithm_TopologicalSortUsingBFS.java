package graphs2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KahnsAlgorithm_TopologicalSortUsingBFS {

	static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
		ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }
        int indegree[] = new int[vtces];
        //filling the in degree array by finding each vertex's in degree
        
        for(int v=0; v<vtces; v++) {
        	for(Edge e: graph[v]) {
        		indegree[e.nbr]++;
        	}
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int v=0; v<indegree.length; v++) {
        	if(indegree[v] == 0) {
        		q.add(v);
        	}
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        while(q.size() > 0) {
        	int rem = q.remove();
        	count++;
        	ans.add(rem);
        	for(Edge e: graph[rem]) {
        		indegree[e.nbr]--;
        		if(indegree[e.nbr] == 0) {
        			q.add(e.nbr);
        		}
        	}
        	
        }
        if(count != vtces) {
        	System.out.println("Not a DAG, cycle detected.");
        } else {
        	System.out.println(ans);
        }
    }

}
