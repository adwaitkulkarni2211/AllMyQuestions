package hashMapsAndHeaps2;
import java.util.*;
public class SnapshotArray {
	int[] arr;
    HashMap<Integer, Integer>[] history;
    int snap_id;

    @SuppressWarnings("unchecked")
	public SnapshotArray(int length) {
        arr = new int[length];
        history = new HashMap[length];
        snap_id = 0;
    }
    
    public void set(int index, int val) {
        arr[index] = val;
        if(history[index] == null) {
            history[index] = new HashMap<>();
        }
        history[index].put(snap_id, val);
    }        
    
    public int snap() {
        snap_id++;
        return snap_id - 1;
    }
    
    public int get(int index, int snap_id) {
        if(history[index] == null) {
            return 0;
        } else if(!history[index].containsKey(snap_id)){
            int temp = snap_id;
            int val = 0;
            while(temp >= 0) {
                if(history[index].containsKey(temp)) {
                    val = history[index].get(temp);
                    break;
                }
                temp--;
            }
            return val;
        } else {
            return history[index].get(snap_id);
        }
    }
}
