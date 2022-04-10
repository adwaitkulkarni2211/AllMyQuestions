package greedy;

public class ContainerWithMostWater {
	public int maxArea(int[] heights) {
        int maxArea = 0, i = 0, j = heights.length - 1;
        
        while(i < j) {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            int area = height * width;
            
            maxArea = Math.max(maxArea, area);
            
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            } 
        }
        
        return maxArea;
    }
}
