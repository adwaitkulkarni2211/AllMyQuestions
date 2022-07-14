package graphs2;
import java.util.*;

public class KnightsProbabilityInChessBoard {
	class Solution {
	    public double knightProbability(int n, int k, int row, int col) {
	        int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	        Double[][][] dp = new Double[n][n][k + 1];
	        
	        double count = dfs(n, k, row, col, dir, dp);
	        bfs(n, k, row, col, dir);
	        double totMoves = Math.pow(8, k);
	        double probability = count / totMoves;
	        
	        return probability;
	    }
	    
	    private double dfs(int n, int k, int row, int col, int[][] dir, Double[][][] dp) {
	        if(k == 0) {
	            return 1;
	        }
	        
	        if(dp[row][col][k] != null) {
	            return dp[row][col][k];
	        }
	        
	        double count = 0;
	        for(int i = 0; i < dir.length; i++) {
	            int nRow = row + dir[i][0], nCol = col + dir[i][1];

	            if(nRow < 0 || nRow > n - 1 || nCol < 0 || nCol > n - 1)
	                continue;

	            count += dfs(n, k - 1, nRow, nCol, dir, dp);
	        }
	        
	        return dp[row][col][k] = count;
	    }
	    
	    class Pair {
	        int row, col, steps;
	        
	        Pair(int row, int col, int steps) {
	            this.row = row;
	            this.col = col;
	            this.steps = steps;
	        }
	    }
	    
	    private double bfs(int n, int k, int row, int col, int[][] dir) {
	        Queue<Pair> q = new ArrayDeque<>();
	        q.add(new Pair(row, col, 0));
	        
	        double count = 0;
	        while(!q.isEmpty()) {
	            Pair rem = q.remove();
	            
	            if(rem.steps == k) {
	                count++;
	                continue;
	            }
	            
	            for(int i = 0; i < dir.length; i++) {
	                int nRow = rem.row + dir[i][0], nCol = rem.col + dir[i][1];
	                
	                if(nRow < 0 || nRow > n - 1 || nCol < 0 || nCol > n - 1)
	                    continue;
	                
	                q.add(new Pair(nRow, nCol, rem.steps + 1));
	            }
	        }
	        
	        return count;
	    }
	}
}
