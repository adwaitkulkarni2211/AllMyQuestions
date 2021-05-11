package graphs2;
import java.util.*;
public class FloodFillUsingBFS_Leetcode733 {
	class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        int origColor = image[sr][sc];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr, sc));
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            image[rem.row][rem.col] = newColor;
            
            if(rem.row + 1 < image.length && image[rem.row+1][rem.col] != newColor && image[rem.row+1][rem.col] == origColor) {
                q.add(new Pair(rem.row + 1, rem.col));
            }
            
            if(rem.row - 1 >= 0 && image[rem.row-1][rem.col] != newColor && image[rem.row-1][rem.col] == origColor) {
                q.add(new Pair(rem.row - 1, rem.col));
            }
            
            if(rem.col + 1 < image[0].length && image[rem.row][rem.col+1] != newColor && image[rem.row][rem.col+1] == origColor) {
                q.add(new Pair(rem.row, rem.col+1));
            }
            
            if(rem.col - 1 >= 0 && image[rem.row][rem.col-1] != newColor && image[rem.row][rem.col-1] == origColor) {
                q.add(new Pair(rem.row, rem.col-1));
            }
        }
        
        return image;
    }
}
