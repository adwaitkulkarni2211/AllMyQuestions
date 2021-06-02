package recursionAndBacktracking;
import java.io.*;
//Box chooses
public class QueensCombinations {
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
            }
            
            return;
        }
        
        int nr = -1, nc = -1;
        String yasf = "", nasf = "";
        if(col == tq - 1) {
            nc = 0;
            nr = row + 1;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        } else {
            nc = col + 1;
            nr = row;
            yasf = asf + "q";
            nasf = asf + "-";
        }
        
        queensCombinations(qpsf + 1, tq, nr, nc, yasf);
        queensCombinations(qpsf, tq, nr, nc, nasf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
