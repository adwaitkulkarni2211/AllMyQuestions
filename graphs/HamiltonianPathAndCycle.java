package graphs;
import java.io.*;
import java.util.*;
public class HamiltonianPathAndCycle {
	static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int count = 1;
        boolean[] visited = new boolean[vtces];
        hamiltonianPathAndCycle(graph, visited, count, src, src, src + "");
    }
    
    public static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, boolean[] visited, int count, int src, int origsrc, String psf) {
        if(count == visited.length) {
            boolean flag = false;
            for(Edge e: graph[src]) {
                if(e.nbr == origsrc) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println(psf + "*");
            } else{
                System.out.println(psf + ".");
            }
            return;
        } else if(visited[src] == true) {
            return;
        }
        
        visited[src] = true;
        for(Edge e: graph[src]) {
            if(visited[e.nbr] == false) {
                hamiltonianPathAndCycle(graph, visited, count + 1, e.nbr, origsrc, psf + e.nbr);
            }
        }
        visited[src] = false;
    }
}
