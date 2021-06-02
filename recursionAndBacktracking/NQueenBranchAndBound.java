package recursionAndBacktracking;
import java.util.*;
public class NQueenBranchAndBound {
	boolean diag1[];
    boolean diag2[];
    boolean column[];
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        column = new boolean[n];
        diag1 = new boolean[(2*n)-1];
        diag2 = new boolean[(2*n)-1];
        res = new ArrayList<>();
        nqbnb(chess, 0);
        return res;
    }
    
    private void nqbnb(boolean[][] chess, int row) {
        if(row == chess.length) {
            List<String> sol = new ArrayList<>();
            for(int i=0; i<chess.length; i++) {
                String ans = "";
                for(int j=0; j<chess.length; j++) {
                    if(chess[i][j] == true) {
                        ans += "Q";
                    } else {
                        ans += ".";
                    }
                }
                sol.add(ans);
            }
            res.add(sol);
            return;
        }
        
        for(int col=0; col<chess.length; col++) {
            if(isSafe(chess, row, col)) {
                diag1[row + col] = true;
                diag2[row - col + chess.length - 1] = true;
                column[col] = true;
                chess[row][col] = true;
                
                nqbnb(chess, row + 1);
                
                column[col] = false;
                diag2[row - col + chess.length - 1] = false;
                diag1[row + col] = false;
                chess[row][col] = false;
            }
        }
    }
    
    private boolean isSafe(boolean chess[][], int row, int col) {
        if(column[col] == true) {
            return false;
        }
        if(diag1[row + col] == true) {
            return false;
        }
        if(diag2[row - col + chess.length - 1] == true) {
            return false;
        }
        return true;
    }
}
