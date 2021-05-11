package graphs;
import java.io.*;
import java.util.*;

public class IsGraphCyclilc {
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

        boolean[] visited = new boolean[vtces];
        for(int v=0; v<vtces; v++) {
            if(visited[v] == false) {
                boolean cycle = isCyclic(graph, visited, v);
                if(cycle == true) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
    
    static class Pair {
        int v;
        String psf;
        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    
    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));
        //System.out.println("q: " + queue);
        while(queue.size() > 0) {
            Pair rem  = queue.removeFirst();
            
            if(visited[rem.v] == true) {
                return true;
            }
            visited[rem.v] = true;
            
            for(Edge e: graph[rem.v]) {
                if(visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
            for(Pair p: queue) {
            	System.out.print(p.v + " ");
            }
            System.out.println();
        }
        return false;
    }
}
