package hashMapsAndHeaps2;
import java.util.*;

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
        List<List<Integer>> prefixSum = new ArrayList<>();
        
        for(int i=0; i<wall.size(); i++) {
            List<Integer> psRow = new ArrayList<>();
            prefixSum.add(psRow);
            List<Integer> wallRow = wall.get(i);
            for(int j=0; j<wallRow.size(); j++) {
                if(j == 0) {
                    psRow.add(wallRow.get(0));
                } else {
                    psRow.add(psRow.get(j-1) + wallRow.get(j));
                }
            }
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(List<Integer> psRow: prefixSum) {
            for(int i=0; i<psRow.size() - 1; i++) {
                int val = psRow.get(i);
                map.put(val, map.getOrDefault(val, 0) + 1);
                max = Math.max(max, map.get(val));
            }
        }
        
        return wall.size() - max;
    }
}
