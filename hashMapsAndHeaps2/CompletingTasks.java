package hashMapsAndHeaps2;
import java.util.*;

public class CompletingTasks {
	class Tasks {
		ArrayList<Integer> tanya, manya;
		
		Tasks() {
			tanya = new ArrayList<>();
			manya = new ArrayList<>();
		}
	}
	
	Tasks findTasks(int[] arr, int m, int n) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        
        Tasks ans = new Tasks();
        
        for(int i=1; i<=n; i++) {
            if(!set.contains(i)) {
                if(ans.tanya.size() == ans.manya.size()) {
                    ans.tanya.add(i);
                } else {
                    ans.manya.add(i);
                }
            }
        }
        
        return ans;
    }
}
