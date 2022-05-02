package searching;
import java.util.*;

public class CountNumberOfReacanglesContainingEachPoint {
	class Solution {
	    public int[] countRectangles(int[][] rectangles, int[][] points) {
	        @SuppressWarnings("unchecked")
			List<Integer>[] heights = new List[101];
	        
	        for(int i=0; i<rectangles.length; i++) {
	            int ht = rectangles[i][1];
	            int wd = rectangles[i][0];
	            
	            if(heights[ht] == null) {
	                heights[ht] = new ArrayList<>();
	            }
	            
	            heights[ht].add(wd);
	        }
	        
	        for(int i=0; i<101; i++) {
	            if(heights[i] != null) {
	                Collections.sort(heights[i]);
	            }
	        }
	        
	        int[] ans = new int[points.length];
	        
	        for(int i=0; i<points.length; i++) {
	            int x = points[i][0], y = points[i][1];
	            int sum = 0;
	            
	            for(int j = y; j < 101; j++) {
	                if(heights[j] == null) {
	                    continue;
	                }
	                sum += heights[j].size() - lowerBound(heights[j], x);
	            }
	            
	            ans[i] = sum;
	        }
	        
	        return ans;
	    }
	    
	    private int lowerBound(List<Integer> arr, int key) {
	        int idx = Collections.binarySearch(arr, key);
	        
	        if(idx < 0) {
	            return Math.abs(idx) - 1;
	        } else {
	            int i = idx - 1;
	            while(i >= 0 && arr.get(i) == arr.get(idx)) {
	                i--;
	            }
	            return i + 1;
	        }
	    }
	}
}
