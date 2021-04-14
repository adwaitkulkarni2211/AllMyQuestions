package queues2;
import java.util.*;
public class InterleaveFirstHalfWithSecondHalf {
	
	private static void solve(Queue<Integer> q) {
		Stack<Integer> st = new Stack<>();
		int half = q.size() / 2;
		System.out.println("st: " + st);
		System.out.println("q: " + q);
		for(int i=0; i<half; i++) {
			st.push(q.remove());
		}
		System.out.println("st: " + st);
		System.out.println("q: " + q);
		while(st.size() > 0) {
			q.add(st.pop());
		}
		System.out.println("st: " + st);
		System.out.println("q: " + q);
		for(int i=0; i<half; i++) {
			q.add(q.remove());
		}
		System.out.println("st: " + st);
		System.out.println("q: " + q);
		for(int i=0; i<half; i++) {
			st.push(q.remove());
		}
		System.out.println("st: " + st);
		System.out.println("q: " + q);
		while(st.size() > 0) {
			q.add(st.pop());
			q.add(q.remove());
		}
		System.out.println("st: " + st);
		System.out.println("q: " + q);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=10; i++) {
			q.add(i);
		}
		//System.out.println(q);
		solve(q);
		//System.out.println(q);
	}

}
