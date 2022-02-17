package stackImplementation;

public class Client {
	public static void main(String[] args) throws Exception{
		stack st = new stack();
        for (int i = 1; i <= 5; i++)
            st.push(i * 10);
        try {
        	st.push(60);
        } catch(Exception e) {
        	System.out.println(e);
        }

        while (st.size() != 0)
            System.out.print(st.pop() + " ");
	}
}
