package queues2;
import java.util.*;
public class FirstNegativeIntegerInEveryWindowOfSizeK {
	
	public long[] printFirstNegativeInteger(long a[], int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<k; i++) {
            if(a[i] < 0) {
                q.add(i);
            }
        }
        long[] ans = new long[n - k + 1];
        for(int i=k; i<n; i++) {
            if(q.size() > 0) {
                ans[i-k] = a[q.peek()];
            } else {
                ans[i-k] = 0;
            }
            if(q.size() > 0 && q.peek() < i - k + 1) {
                q.remove();
            }
            if(a[i] < 0) {
                q.add(i);
            }
        }
        if(q.size() > 0) {
            ans[ans.length - 1] = a[q.remove()];
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
