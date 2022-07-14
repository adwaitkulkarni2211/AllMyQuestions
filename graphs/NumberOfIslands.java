package graphs;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != '0') {
                    dfs(grid, dir, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int[][] dir, int row, int col) {
        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return;
        }
        
        grid[row][col] = '0';
        
        for(int i = 0; i < dir.length; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];
            
            dfs(grid, dir, nRow, nCol);
        }
    }
}
