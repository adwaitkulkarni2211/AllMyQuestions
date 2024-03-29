package graphs;
import java.io.*;
import java.util.*;
public class hasPath {
	static class Edge {
        int src;    //source
        int nbr;    //neighbour
        int wt;     //weight

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
		ArrayList<Edge>[] graph = new ArrayList[vtces];
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
        int dest = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[vtces];
        boolean ans = hasPath1(graph, src, dest, visited);
        System.out.println(ans);
    }
    
    public static boolean hasPath1(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(Edge edge: graph[src]) {
            if(visited[edge.nbr] == false) {
                boolean hasNbrPath = hasPath1(graph, edge.nbr, dest, visited);
                if(hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }
}
