package graphs2;
import java.util.*;
public class SnakesAndLadders {
	class Pair implements Comparable<Pair>{
        int val, row, col, steps, lb, ub, dir;
        Pair(int val, int row, int col, int steps, int lb, int ub, int dir) {
            this.val = val;
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.lb = lb;
            this.ub = ub;
            this.dir = dir;
        }
        
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public int snakesAndLadders(int[][] board) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, board.length - 1, 0, 0, 1, board.length, 1));
        boolean[][] visited = new boolean[board.length][board.length];
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            visited[rem.row][rem.col] = true;
            
            if (rem.val == Math.pow(board.length, 2)) {
                return rem.steps;
            }
            
            for(int i=1; i<=6; i++) {
                int newVal = rem.val + i;
                if(newVal > Math.pow(board.length, 2)) {
                    continue;
                }
                Pair box = findBox(board, newVal, rem.steps + 1);
                //if a snake or ladder is found, add the pos where we end up bc of the s/l
                if(board[box.row][box.col] == -1) {
                    if(visited[box.row][box.col] == false)
                        q.add(box);
                } else {
                    Pair travel = findBox(board, board[box.row][box.col], rem.steps + 1);
                    if(visited[travel.row][travel.col] == false) {
                        q.add(travel);    
                    }
                }  
            }
        }
        return -1;
    }
    public Pair findBox(int[][] board, int val, int steps) {
        int lb = 1, ub = board.length;
        int i = board.length - 1;
        boolean firstLevel = (board.length - 1) % 2 == 0;
        while(true) {
            if(val >= lb && val <= ub) {
                break;
            } else {
                int nlb = ub + 1;
                int nub = ub + board.length;

                ub = nub;
                lb = nlb;
                i--;
            }
        }
        int dir = 0;
        //if board.length - 1 is even, then dir will be +ve when i is even, else -ve
        //if board.length - 1 is odd, then dir will be +ve when i is odd, else -ve
        if(firstLevel == true) {
            if(i % 2 == 0) {
                dir = 1;
            } else {
                dir = -1;
            }
        } else {
            if(i % 2 != 0) {
                dir = 1;
            } else {
                dir = -1;
            }
        }
        int j;
        if(dir == 1) {
            j = 0;
        } else {
            j = board.length - 1;
        }
        
        for(int k=0; k<board.length; k++) {
            if(dir == 1) {
                if(lb + j == val) {
                    break;
                }
                j++;
            } else {
                if(ub - j == val) {
                    break;
                }
                j--;
            }
        }
        
        Pair box = new Pair(val, i, j, steps, lb, ub, dir);
        
        return box;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
