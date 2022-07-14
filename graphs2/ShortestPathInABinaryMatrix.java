package graphs2;
import java.util.*;
public class ShortestPathInABinaryMatrix {
	class Pair {
        int row, col, steps;
        Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 1));
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(grid[rem.row][rem.col] == 1) {
                continue;
            }
            grid[rem.row][rem.col] = 1;
            
            if(rem.row == grid.length - 1 && rem.col == grid[0].length - 1) {
                return rem.steps;
            }
            
            for(int i = 0; i < dir.length; i++) {
                int r = rem.row + dir[i][0];
                int c = rem.col + dir[i][1];
                
                if(!(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == 1)) {
                    q.add(new Pair(r, c, rem.steps + 1));    
                }
            }
        }
        return -1;
    }
}
