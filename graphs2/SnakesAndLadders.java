package graphs2;
import java.util.*;
public class SnakesAndLadders {
	class Solution {
	    class Pair1 {
	        int row, col;
	        Pair1(int row, int col) {
	            this.row = row;
	            this.col = col;
	        }
	    }
	    class Pair2 {
	        int cell, steps;
	        Pair2(int cell, int steps) {
	            this.cell = cell;
	            this.steps = steps;
	        }
	    }
	    private Pair1 getRowCol(int cell, int n)  {
	        int row = cell / n;
	        if(cell % n == 0)
	            row--;
	        
	        int col;
	        if(row % 2 == 0)
	            col = (cell % n == 0) ? n - 1 : (cell % n) - 1;
	        else
	            col = (cell % n == 0) ? 0 : n - (cell % n);
	        
	        row = (n - 1) - row;
	        
	        return new Pair1(row, col);
	        
	    }
	    
	    private int bfs(int[][] board, int n) {
	        Queue<Pair2> q = new ArrayDeque<>();
	        Pair1 start = getRowCol(1, n);
	        if(board[start.row][start.col] != -1) 
	            q.add(new Pair2(board[start.row][start.col], 0));
	        else
	            q.add(new Pair2(1, 0));
	        
	        boolean[][] visited = new boolean[n][n];
	        
	        int ans = (int)1e9;
	        while(!q.isEmpty()) {
	            Pair2 rem = q.remove();
	            
	            if(rem.cell == n * n) {
	                ans = Math.min(ans, rem.steps);
	                continue;
	            }
	            
	            Pair1 p = getRowCol(rem.cell, n);
	            if(visited[p.row][p.col])
	                continue;
	            visited[p.row][p.col] = true;
	            
	            for(int i = 1; i <= 6; i++) {
	                if(rem.cell + i > n * n)
	                    break;
	                Pair1 next = getRowCol(rem.cell + i, n);
	                
	                if(board[next.row][next.col] != -1)
	                    q.add(new Pair2(board[next.row][next.col], rem.steps + 1));
	                else
	                    q.add(new Pair2(rem.cell + i, rem.steps + 1));
	            }
	        }
	        
	        return (ans == (int)1e9) ? -1 : ans;
	    }
	    
	    public int snakesAndLadders(int[][] board) {
	        int n = board.length;        
	        return bfs(board, n);
	    }
	}

}
