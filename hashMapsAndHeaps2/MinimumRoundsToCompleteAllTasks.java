package hashMapsAndHeaps2;
import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {
	public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        
        int count = 0;
        
        for(int key: map.keySet()) {
            int freq = map.get(key);

            if(freq == 1) {
                //System.out.println(key);
                return -1;
            }

            if(freq % 3 == 1) {
                count += ((freq - 4) / 3) + 2;
            } else if(freq % 3 == 2) {
                count += (freq / 3) + 1;
            } else {
                count += freq / 3;
            }
        }
        
        return count;
    }
}
