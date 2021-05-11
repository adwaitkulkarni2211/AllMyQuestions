package graphs2;
import java.util.*;
public class CreateADJMfromADDL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] adjm = new int[v][v];
		ArrayList<ArrayList<Integer>> adjl = new ArrayList<>();
		
		for(int i=0; i<v; i++) {
			adjl.add(new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			int src = sc.nextInt() - 1;
			int dest = sc.nextInt() - 1;
			
			adjm[src][dest] = 1;
			adjm[dest][src] = 1;
			
			adjl.get(src).add(dest);
			adjl.get(dest).add(src);
		}
		sc.close();
		System.out.println("adjm: ");
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				System.out.print(adjm[i][j] + ", ");
			}
			System.out.println();
		}
		
		System.out.println("adjl: ");
		for(int i=0; i<v; i++) {
			System.out.print("node: " + i + " -> ");
			for(int nbr: adjl.get(i)) {
				System.out.print(nbr + " ");
			}
			System.out.println();
		}
	}

}
