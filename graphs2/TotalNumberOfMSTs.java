package graphs2;
import java.util.*;
public class TotalNumberOfMSTs {
	public static int[][] findCofactorMatrix(int[][] adjMatrix, int row, int col) {
		int size = adjMatrix.length - 1;
		int[][] cofactor = new int[size][];
		
		int colIdx = 0;
		for(int i=0; i<adjMatrix.length; i++) {
			if(i == row) {
				continue;
			}
			int[] cfRow = new int[size];
			int rowIdx = 0;
			for(int j=0; j<adjMatrix[i].length; j++) {
				if(j != col) {
					cfRow[rowIdx] = adjMatrix[i][j];
					rowIdx++;
				}
			}
			cofactor[colIdx] = cfRow;
			colIdx++;
		}
		return cofactor;
	}
	
	public static int findDeterminant(int[][] mat) {
		if(mat.length == 1) {
			//System.out.println("base det: " + mat[0][0]);
			return mat[0][0];																
		}
		int det = 0;
		int sign = 1;
		for(int i=0; i<mat[0].length; i++) {
			int num = mat[0][i];
			int[][] cf = findCofactorMatrix(mat, 0, i);
			det += (num * sign) * findDeterminant(cf);
			//System.out.println("det: " + det);
			sign = -sign;
		}
		return det;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = sc.nextInt();
		
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<>());
		}
		
		int e = sc.nextInt();
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			adj.get(v1).add(v2);
			adj.get(v2).add(v1);
		}
		sc.close();
		
		//creating adj matrix from the list
		int[][] adjMatrix = new int[v][v];
		for(int i=0; i<v; i++) {
			adjMatrix[i][i] = adj.get(i).size();
			for(int nbr: adj.get(i)) {
				adjMatrix[i][nbr] = -1;
				adjMatrix[nbr][i] = -1;
			}
		}
		
		int[][] cfMat = findCofactorMatrix(adjMatrix, 0, 0);
		System.out.println("The adj matrix is: ");
		for(int i=0; i<adjMatrix.length; i++) {
			for(int j=0; j<adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("the cofactor of 1, 1 is");
		for(int i=0; i<cfMat.length; i++) {
			for(int j=0; j<cfMat[i].length; j++) {
				System.out.print(cfMat[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("The determinant of cfm is: ");
		System.out.println(findDeterminant(cfMat));
	}

}
