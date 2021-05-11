package graphs2;
import java.util.*;
public class MinimumStepsByKnight {
	class Pair {
        int row, col, steps;
        Pair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(knightPos[0] - 1, knightPos[1] - 1, 1));
        int[][] chess = new int[n][n];
        if(knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
            return 0;
        }
        chess[knightPos[0] - 1][knightPos[1] - 1] = 1;
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.row - 2 >= 0 && rem.col + 1 < n && chess[rem.row - 2][rem.col + 1] == 0) {
                if(rem.row - 2 == targetPos[0] - 1 && rem.col + 1 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row - 2, rem.col + 1, rem.steps + 1));
                chess[rem.row - 2][rem.col + 1] = rem.steps + 1;
            }
            if(rem.row - 1 >= 0 && rem.col + 2 < n && chess[rem.row - 1][rem.col + 2] == 0) {
                if(rem.row - 1 == targetPos[0] - 1 && rem.col + 2 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row - 1, rem.col + 2, rem.steps + 1));
                chess[rem.row - 1][rem.col + 2] = rem.steps + 1;
            }
            if(rem.row + 1 < n && rem.col + 2 < n && chess[rem.row + 1][rem.col + 2] == 0) {
                if(rem.row + 1 == targetPos[0] - 1 && rem.col + 2 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row + 1, rem.col + 2, rem.steps + 1));
                chess[rem.row + 1][rem.col + 2] = rem.steps + 1;
            }
            if(rem.row + 2 < n && rem.col + 1 < n && chess[rem.row + 2][rem.col + 1] == 0) {
                if(rem.row + 2 == targetPos[0] - 1 && rem.col + 1 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row + 2, rem.col + 1, rem.steps + 1));
                chess[rem.row + 2][rem.col + 1] = rem.steps + 1;
            }
            if(rem.row + 2 < n && rem.col - 1 >= 0 && chess[rem.row + 2][rem.col - 1] == 0) {
                if(rem.row + 2 == targetPos[0] - 1 && rem.col - 1 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row + 2, rem.col - 1, rem.steps + 1));
                chess[rem.row + 2][rem.col - 1] = rem.steps + 1;
            }
            if(rem.row + 1 < n && rem.col - 2 >= 0 && chess[rem.row + 1][rem.col - 2] == 0) {
                if(rem.row + 1 == targetPos[0] - 1 && rem.col - 2 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row + 1, rem.col - 2, rem.steps + 1));
                chess[rem.row + 1][rem.col - 2] = rem.steps + 1;
            }
            if(rem.row - 1 >= 0 && rem.col - 2 >= 0 && chess[rem.row - 1][rem.col - 2] == 0) {
                if(rem.row - 1 == targetPos[0] - 1 && rem.col - 2 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row - 1, rem.col - 2, rem.steps + 1));
                chess[rem.row - 1][rem.col - 2] = rem.steps + 1;
            }
            if(rem.row - 2 >= 0 && rem.col - 1 >= 0 && chess[rem.row - 2][rem.col - 1] == 0) {
                if(rem.row - 2 == targetPos[0] - 1 && rem.col - 1 == targetPos[1] - 1) {
                    return rem.steps;
                }
                q.add(new Pair(rem.row - 2, rem.col - 1, rem.steps + 1));
                chess[rem.row - 2][rem.col - 1] = rem.steps + 1;
            }
        }
        
        return 0;
    }
}
