package graphs2;
import java.util.*;

class OliverAndTheGame_EulerTour {
    public static void main(String args[] ) throws Exception {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        @SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList [v];
        
        for(int i=0; i<v-1; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;

            if(adj[v1] == null) {
                adj[v1] = new ArrayList<>();
            }
            if(adj[v2] == null) {
                adj[v2] = new ArrayList<>();
            }
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        int q = sc.nextInt();

        while(q-- > 0) {
            time = 0;
            int toKing = sc.nextInt();
            int oli = sc.nextInt() - 1;
            int bob = sc.nextInt() - 1;
            
            int[] in = new int[v];
            int[] out = new int[v];
            boolean[] visited = new boolean[v];

            dfs(adj, in, out, visited, 0);

            if(toKing == 0) {
                if(in[bob] > in [oli] && out[bob] < out[oli]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                if(in[oli] > in [bob] && out[oli] < out[bob]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static int time;

    private static void dfs(ArrayList<Integer>[] adj, int[] in, int[] out, boolean visited[], int src) {
        visited[src] = true;

        time++;
        in[src] = time;

        for(int nbr: adj[src]) {
            if(visited[nbr] == false) {
                dfs(adj, in, out, visited, nbr);
            }
        }

        time++;
        out[src] = time;
    }
}

