package graphs;
import java.io.*;

public class NumberOfIslands {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 0 && visited[i][j] == false) {
                    drawTreeForComp(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    public static void drawTreeForComp(int[][] a, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 1 || visited[i][j] == true) {
            return;
        }
        
        visited[i][j] = true;
        drawTreeForComp(a, i - 1, j, visited);
        drawTreeForComp(a, i, j + 1, visited);
        drawTreeForComp(a, i + 1, j, visited);
        drawTreeForComp(a, i, j - 1, visited);
        
    }
}
