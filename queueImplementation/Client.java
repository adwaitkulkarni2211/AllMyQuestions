package queueImplementation;

public class Client {
	public static void main(String[] args) throws Exception{
		queue q = new queue();
		
		for(int i=1; i<=5; i++) {
			q.push(i * 10);
		}
		
		//q.push(60);
		
		while(q.size() > 0) {
			System.out.print(q.pop() + " ");
		}
	}
}
