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
	
	public static void floydWarshal(int[][] matrix) {
		int n = matrix.length;
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue;
                    if(matrix[i][j] == -1)
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    else
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);    
                }
            }
        }
	}

}
