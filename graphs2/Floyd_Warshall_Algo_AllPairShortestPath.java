package graphs2;
import java.util.*;
public class Floyd_Warshall_Algo_AllPairShortestPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int[][] distMat = new int[v][v];
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				int dist = sc.nextInt();
				distMat[i][j] = dist;
			}
		}
		sc.close();
		
		floydWarshal(distMat);
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				System.out.print(distMat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floydWarshal(int[][] dist) {
		int v = dist.length;
        //evaluate path via each node
        for(int node=0; node<v; node++) {
            //iterating through distance matrix
            for(int i=0; i<v; i++) {
                for(int j=0; j<v; j++) {
                    if(dist[i][node] != -1 && dist[node][j] != -1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][node] + dist[node][j]);
                    }
                }
            }
        }
	}

}
