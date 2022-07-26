package graphs2;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1)
                    maxSize = Math.max(maxSize, getComponentSize(grid, i, j));
            }
        }
        
        return maxSize;
    }
    
    public int getComponentSize(int[][] grid, int row, int col) {
        
        grid[row][col] = 0;
        
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int count = 0;
        for(int i = 0; i < dir.length; i++) {
            int nRow = row + dir[i][0], nCol = col + dir[i][1];
            
            if(nRow < 0 || nRow > grid.length - 1 || nCol < 0 || nCol > grid[0].length - 1 || grid[nRow][nCol] == 0)
                continue;
            count += getComponentSize(grid, nRow, nCol);
        }
        
        return count + 1;
    }
}
