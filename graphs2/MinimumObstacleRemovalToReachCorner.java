package graphs2;
import java.util.*;
public class MinimumObstacleRemovalToReachCorner {
	class Pair implements Comparable<Pair>{
        int row, col, obsRemoved;
        Pair(int row, int col, int obsRemoved) {
            this.row = row;
            this.col = col;
            this.obsRemoved = obsRemoved;
        }
        public int compareTo(Pair o) {
            return this.obsRemoved - o.obsRemoved;
        }
    }
    
    private int bfs(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0, 0));
        
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pair rem = q.remove();
            //System.out.println("row: " + rem.row + " col: " + rem.col + " removed: " + rem.obsRemoved);
            
            if(rem.row == n - 1 && rem.col == m - 1) {
                min = Math.min(min, rem.obsRemoved);
                continue;
            }
            
            if(grid[rem.row][rem.col] == -1)
                continue;
            grid[rem.row][rem.col] = -1;
            
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int i = 0; i < dir.length; i++) {
                int nRow = rem.row + dir[i][0], nCol = rem.col + dir[i][1];
                
                if(nRow < 0 || nRow > n - 1 || nCol < 0 || nCol > m - 1 || grid[nRow][nCol] == -1)
                    continue;
                
                int obsRemoved = rem.obsRemoved;
                if(grid[nRow][nCol] == 1)
                    obsRemoved++;
                
                q.add(new Pair(nRow, nCol, obsRemoved));
            }
        }
        
        return min;
    }
    public int minimumObstacles(int[][] grid) {
        return bfs(grid);
    }
}
