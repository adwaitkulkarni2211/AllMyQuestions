package recursionAndBacktracking;
import java.util.*;

public class UniquePaths3 {
	public int uniquePathsIII(int[][] grid) {
        int[] startPoint = findStart(grid);
        
        //System.out.println("start row: " + startPoint[0] + " start col: " + startPoint[1] + " emptyBoxes: " + startPoint[2]);
        
        HashSet<Integer> visited = new HashSet<>();
        
        return solve(grid, startPoint[0], startPoint[1], startPoint[2], visited);
    }
    
    private int solve(int[][] grid, int row, int col, int emptyBoxes, HashSet<Integer> visited) {
        if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[row].length - 1 || visited.contains(row * grid[0].length + col) || grid[row][col] == -1) {
            //System.out.println("1st if, idx: (" + row + "," + col + ")" + " visited: " + visited);
            return 0;
        }
        
        
        if(grid[row][col] == 2 && visited.size() < emptyBoxes - 1) {
            //System.out.println("2nd if, idx: (" + row + "," + col + ")" + " visited: " + visited + " grid[row][col]: " + grid[row][col]);
            return 0;
        } else if(grid[row][col] == 2 && visited.size() == emptyBoxes - 1) {
            //System.out.println("3rd if, idx: (" + row + "," + col + ")" + " visited: " + visited + " grid[row][col]: " + grid[row][col]);
            return 1;
        }
        
        visited.add(row * grid[0].length + col);
        //System.out.println("before calls, idx: (" + row + "," + col + ")" + " visited: " + visited + " grid[row][col]: " + grid[row][col]);
        int up = solve(grid, row - 1, col, emptyBoxes, visited);
        int down = solve(grid, row + 1, col, emptyBoxes, visited);
        int left = solve(grid, row, col - 1, emptyBoxes, visited);
        int right = solve(grid, row, col + 1, emptyBoxes, visited);
        visited.remove(row * grid[0].length + col);
        //System.out.println("after calls, idx: (" + row + "," + col + ")" + " visited: " + visited + " grid[row][col]: " + grid[row][col]);
        //System.out.println("up: " + up + " down: " + down + "");
        
        return up + down + left + right;
    }
    
    private int[] findStart(int[][] grid) {
        int[] ans = new int[3];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    ans[0] = i;
                    ans[1] = j;
                }
                if(grid[i][j] != -1) {
                    ans[2]++;
                }
            }
        }
        return ans;
    }
}
