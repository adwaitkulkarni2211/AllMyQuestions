package queues2;
import java.util.*;
public class ReverseAQueueUsingRecursion {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=8; i>=1; i--) {
			q.add(i);
		}
		System.out.println(q);
		
		System.out.println(rev(q));
	}
	
	public static Queue<Integer> rev(Queue<Integer> q){
        solve(q);
        return q;
    }
    
    private static void solve(Queue<Integer> q) {
        if(q.size() == 0) {
            return;
        }
        int rem = q.remove();
        solve(q);
        q.add(rem);
    }

}
