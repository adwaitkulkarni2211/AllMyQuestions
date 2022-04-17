package arraysAndStrings;
import java.util.*;

public class Shift2DGrid {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k %= grid[0].length * grid.length;
        
        //convert to 1d and rotate by k
        reverse(0, grid.length * grid[0].length - k - 1, grid);
        reverse(grid.length * grid[0].length - k, grid.length * grid[0].length - 1, grid);
        reverse(0, grid.length * grid[0].length - 1, grid);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<grid[0].length; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        
        return ans;
    }
    
    private void reverse(int cell1, int cell2, int[][] grid) {
        while(cell1 < cell2) {
            int row1 = cell1 / grid[0].length;
            int col1 = cell1 % grid[0].length;
            
            int row2 = cell2 / grid[0].length;
            int col2 = cell2 % grid[0].length;
            
            //swap
            int temp = grid[row1][col1];
            grid[row1][col1] = grid[row2][col2];
            grid[row2][col2] = temp;
            
            cell1++;
            cell2--;
        }
    }
}
