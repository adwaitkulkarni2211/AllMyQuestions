package recursionAndBacktracking;
import java.util.*;
public class RatInAMaze {
	public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        ans = new ArrayList<>();
        dfs(m, visited, "", 0, 0);
        Collections.sort(ans);
        return ans;
    }
    
    static ArrayList<String> ans;
    
    private static void dfs(int[][] matrix, boolean[][] visited, String psf, int row, int col) {
        if(row < 0 || col < 0 || row == matrix.length || col == matrix[0].length ||
            visited[row][col] == true || matrix[row][col] == 0) {
                return;
        }
        
        if(row == matrix.length - 1 && col == matrix.length - 1) {
            ans.add(psf);
        }
        
        visited[row][col] = true;
        
        dfs(matrix, visited, psf + "U", row - 1, col);
        dfs(matrix, visited, psf + "L", row, col - 1);
        dfs(matrix, visited, psf + "D", row + 1, col);
        dfs(matrix, visited, psf + "R", row, col + 1);
        
        visited[row][col] = false;
    }
}
