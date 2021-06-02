package recursionAndBacktracking;
import java.io.*;
//Queen chooses
public class QueensCombinations2 {
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int row,int col){
        if(qpsf == tq) {
            for(int i=0; i<chess.length; i++) {
                for(int j=0; j<chess[i].length; j++) {
                    if(chess[i][j] == true) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int j = col + 1; j<chess.length; j++) {
            if(chess[row][j] == false) {
                chess[row][j] = true;
                queensCombinations(qpsf + 1, tq, chess, row, j);
                chess[row][j] = false;
            }
        }
        
        for(int i = row + 1; i<chess.length; i++) {
            for(int j=0; j<chess[i].length; j++) {
                
                if(chess[i][j] == false) {
                    chess[i][j] = true;
                    queensCombinations(qpsf + 1, tq, chess, i, j);
                    chess[i][j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
        
    }
}
