package graphs2;
import java.util.*;
public class M_ColoringProblem {
	public static boolean graphColoring(List<Integer>[] g, int[] color, int nan, int m) {
        Arrays.fill(color, -1);
        
        return dfs(g, color, 0, m);
    }
    
    private static boolean dfs(List<Integer>[] g, int[] color, int src, int m) {
        
        if(src == g.length) {
            // for(int i=0; i<color.length; i++) {
            //     System.out.println("node: " + i + " color: " + color[i]);
            // }
            return true;
        }
        
        for(int c=1; c<=m; c++) {
            if(isSafe(g, color, src, c)) {
                color[src] = c;
                if(dfs(g, color, src + 1, m)) {
                    return true;
                }
                color[src] = -1;
            }
        }
        return false;
    }
    
    private static boolean isSafe(List<Integer>[] g, int[] color, int src, int c) {
        
        for(int nbr: g[src]) {
            if(color[nbr] != -1 && color[nbr] == c) {
                return false;
            }
        }
        return true;
    }
}
