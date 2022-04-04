package hashMapsAndHeaps2;
import java.util.*;

public class TheSkylineProblem {
	class Pair implements Comparable<Pair>{
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Pair o) {
            if(this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> coordinates = new ArrayList<>();
        
        //form the coordinates list
        for(int[] building: buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            
            Pair start = new Pair(left, -height);
            Pair end = new Pair(right, height);
            
            coordinates.add(start);
            coordinates.add(end);
        }
        
        //sort it based on the x coordinate
        Collections.sort(coordinates);
        display(coordinates);
        
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int currMaxHeight = 0;
        
        for(Pair point: coordinates) {
            int x = point.x;
            int y = point.y;
            
            if(y < 0) {
                pq.add(-y);
            } else {
                pq.remove(y);
            }
            
            if(currMaxHeight != pq.peek()) {
                List<Integer> changePoint = new ArrayList<>();
                changePoint.add(x);
                changePoint.add(pq.peek());
                
                ans.add(changePoint);
                
                currMaxHeight = pq.peek();
            }
        }
        
        return ans;        
    }
    
    private void display(List<Pair> list) {
        for(Pair l: list) {
            System.out.println("[" + l.x + "," + l.y + "]");
        }
    }
}
