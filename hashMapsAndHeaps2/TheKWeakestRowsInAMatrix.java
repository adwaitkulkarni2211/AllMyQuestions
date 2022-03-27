package hashMapsAndHeaps2;
import java.util.*;
public class TheKWeakestRowsInAMatrix {
	public class Pair implements Comparable<Pair>{
        int row, oneCount;
        Pair(int row, int count) {
            this.row = row;
            this.oneCount = count;
        }
        
        public int compareTo(Pair o) {
            if(this.oneCount == o.oneCount) {
                return this.row - o.row;
            } else {
                return this.oneCount - o.oneCount;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<mat.length; i++) {
            int oneCount = 0;
            
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    oneCount++;
                } else {
                    break;
                }
            }
            
            pq.add(new Pair(i, oneCount));
        }
        
        //System.out.println(pq);
        
        int[] ans = new int[k];
        
        for(int i=0; i<k; i++) {
            ans[i] = pq.remove().row;
        }
        
        return ans;
    }
}
