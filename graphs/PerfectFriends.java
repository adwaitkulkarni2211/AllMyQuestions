package graphs;
import java.io.*;
import java.util.*;
public class PerfectFriends {
	static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
		ArrayList < Edge >[] graph = new ArrayList[vtces];
        for (int v = 0; v < vtces; v++) {
            graph[v] = new ArrayList < > ();
        }

        for (int e = 0; e < edges; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();
        boolean[] visited = new boolean[vtces];

        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                ArrayList < Integer > comp = new ArrayList < > ();
                drawTreeAndGenerateComp(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for(int i=0; i<comps.size(); i++) {
            for(int j=i + 1; j<comps.size(); j++) {
                pairs = pairs + (comps.get(i).size() * comps.get(j).size());
            }
        }
        System.out.println(pairs);
    }
    public static void drawTreeAndGenerateComp(ArrayList < Edge > [] graph, int src, ArrayList < Integer > comp, boolean[] visited) {

        visited[src] = true;
        comp.add(src);
        for (Edge e: graph[src]) {
            if (visited[e.n] == false) {
                drawTreeAndGenerateComp(graph, e.n, comp, visited);
            }
        }
    }
}
