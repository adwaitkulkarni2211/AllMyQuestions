package recursionAndBacktracking;
import java.io.*;
public class QNQueensPermutaions {
	public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        //vertical
        for(int i=0; i<chess.length; i++) {
            if(chess[i][col] != 0) {
                return false;
            }
        }
        //horizontal
        for(int j=0; j<chess.length; j++) {
            if(chess[row][j] != 0) {
                return false;
            }
        }
        //left diag upper
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        //left diag lower
        for(int i=row+1, j=col+1; i<chess.length && j<chess.length; i++,j++) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        //right diag upper
        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--,j++) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        //right diag lower
        for(int i=row+1, j=col-1; i<chess.length && j>=0; i++,j--) {
            if(chess[i][j] != 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq) {
            for(int i=0; i<chess.length; i++) {
                for(int j=0; j<chess[i].length; j++) {
                    if(chess[i][j] != 0) {
                        System.out.print("q" + chess[i][j] + "\t");
                    } else {
                        System.out.print("-" + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int cell=0; cell<chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;
            
            if(chess[row][col] == 0 && IsQueenSafe(chess, row, col) == true) {
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
