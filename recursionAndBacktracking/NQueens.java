package recursionAndBacktracking;
import java.util.*;
public class NQueens {
	static List<List<String>> res;
    static public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] chess = new int[n][n];
        solve(chess, 0, new ArrayList<>());
        return res;
    }
    
    static public void solve(int[][] chess, int row, List<String> ways) {
        if(row == chess.length) {
            List<String> temp = new ArrayList<>(ways);
            res.add(temp);
            ways = new ArrayList<>();
            return;
        }
        
        for(int i=0; i<chess.length; i++) {
            if(chess[row][i] == 0 && isSafe(chess, row, i)) {
                chess[row][i] = 1;
                String asf = "";
                for(int j=0; j < i; j++) {
                    asf += "*\t";
                }
                asf += "Q\t";
                for(int j=i+1; j<chess.length; j++) {
                    asf += "*\t";
                }
                ways.add(asf);
                solve(chess, row + 1, ways);
                chess[row][i] = 0;
                ways.remove(ways.size() - 1);
            }
        }
    }
    
    static public boolean isSafe(int[][] chess, int row, int col) {
        //column
        for(int i = row - 1; i>=0; i--) {
            if(chess[i][col] == 1) {
                return false;
            }
        }
        //left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        //right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<chess[0].length; i--, j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	sc.close();
		List<List<String>> ans = solveNQueens(n);
		
		//printing
		int count = 0;
		for(List<String> row: ans) {
			System.out.println("\n");
			for(String str: row) {
				System.out.println(str);
			}
			count++;
		}
		System.out.println(count);
	}
}
