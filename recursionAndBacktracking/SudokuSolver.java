package recursionAndBacktracking;

public class SudokuSolver {
	char[][] ans;
    public void solveSudoku(char[][] board) {
        ans = new char[board.length][board[0].length];
        backtrack(board, 0, 0);
        for(int i=0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
    
    public void backtrack(char[][] board, int row, int col) {
        if(row == board.length) {
            for(int i=0; i<board.length; i++) {
                for(int j = 0; j<board[i].length; j++) {
                    ans[i][j] = board[i][j];
                }
            }
            
            return;
        }
        int nr = 0, nc = 0;
        if(col == board.length - 1) {
            nr = row + 1;
            nc = 0;
        } else {
            nr = row;
            nc = col + 1;
        }
        
        if(board[row][col] != '.') {
            backtrack(board, nr, nc);
        } else {
            for(char i = '1'; i <= '9'; i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = i;
                    backtrack(board, nr, nc);
                    board[row][col] = '.';
                }
            }            
        }
    }
    
    public boolean isValid(char[][] a, int row, int col, int k) {
        //row
        for(int i=0; i<a[0].length; i++) {
            if(a[row][i] == k) {
                return false;
            }
        }
        //col
        for(int i=0; i<a.length; i++) {
            if(a[i][col] == k) {
                return false;
            }
        }
        //box
        int stRow = (row / 3) * 3;
        int stCol = (col / 3) * 3;
        for(int i = stRow; i < stRow + 3; i++) {
            for(int j = stCol; j < stCol + 3; j++) {
                if(a[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
