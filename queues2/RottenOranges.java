package queues2;
import java.util.*;
public class RottenOranges {
	
	class Pair {
        int row, col, time;
        
        Pair(int row, int col, int time) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
	
	public int orangesRotting(int[][] grid) {
        Queue<Pair> mq = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    mq.add(new Pair(i, j, 0));
                }
            }
        }
        
        int count = 0; 
        
        while(mq.size() > 0) {
            Pair rem = mq.remove();
            
            rot(grid, rem, mq);
            
            count = Math.max(count, rem.time);
        }
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count = -1;
                    break;
                }
            }
        }
        return count;
    }
	
	private void rot(int[][] grid, Pair rem, Queue<Pair> q) {
        
        if(rem.row + 1 < grid.length && grid[rem.row + 1][rem.col] == 1) {
            grid[rem.row + 1][rem.col] = 2;
            q.add(new Pair(rem.row + 1, rem.col, rem.time + 1));
        }
        
        if(rem.row - 1 >= 0 && grid[rem.row - 1][rem.col] == 1) {
            grid[rem.row - 1][rem.col] = 2;
            q.add(new Pair(rem.row - 1, rem.col, rem.time + 1));
        }
        
        if(rem.col + 1 < grid[0].length && grid[rem.row][rem.col + 1] == 1) {
            grid[rem.row][rem.col + 1] = 2;
            q.add(new Pair(rem.row, rem.col + 1, rem.time + 1));
        }
        
        if(rem.col - 1 >= 0 && grid[rem.row][rem.col - 1] == 1) {
            grid[rem.row][rem.col - 1] = 2;
            q.add(new Pair(rem.row, rem.col - 1, rem.time + 1));
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
