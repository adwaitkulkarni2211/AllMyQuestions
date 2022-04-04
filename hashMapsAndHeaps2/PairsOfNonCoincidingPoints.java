package hashMapsAndHeaps2;
import java.util.*;
public class PairsOfNonCoincidingPoints {
	static int numOfPairs(int[] X, int[] Y, int n) {
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<List<Integer>, Integer> xy = new HashMap<>();
        
        int count = 0;
        for(int i=0; i<n; i++) {
            if(x.containsKey(X[i])) {
                count += x.get(X[i]);
            }
            if(y.containsKey(Y[i])) {
                count += y.get(Y[i]);
            }
            if(xy.containsKey(Arrays.asList(X[i], Y[i]))) {
                //System.out.println("here");
                count -= xy.get(Arrays.asList(X[i], Y[i])) * 2;
            }
            
            x.put(X[i], x.getOrDefault(X[i], 0) + 1);
            y.put(Y[i], y.getOrDefault(Y[i], 0) + 1);
            xy.put(Arrays.asList(X[i], Y[i]), xy.getOrDefault(Arrays.asList(X[i], Y[i]), 0) + 1);
        }
        
        return count;
    }
}
