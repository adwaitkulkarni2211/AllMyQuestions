package recursionAndBacktracking;

public class PathWithMaxGold {
	public int getMaximumGold(int[][] grid) {
        maxGold = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(visited[i][j] == false && grid[i][j] != 0) {
                    dfs(grid, i, j, visited, 0);
                }
            }
        }
        return maxGold;
    }
    int maxGold;
    
    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int total) {
        if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] == 0 || visited[row][col] == true) {
            maxGold = Math.max(maxGold, total);
            return;
        }
        
        visited[row][col] = true;
        total += grid[row][col];
        
        dfs(grid, row - 1, col, visited, total);
        dfs(grid, row, col - 1, visited, total);
        dfs(grid, row + 1, col, visited, total);
        dfs(grid, row, col + 1, visited, total);
        
        total -= grid[row][col];
        visited[row][col] = false;
    }
}
