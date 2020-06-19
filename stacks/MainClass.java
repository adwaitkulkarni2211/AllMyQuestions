package stacks;

public class MainClass {

	public static void main(String[] args) {
		StackWithLL<Integer> stack = new StackWithLL<>();
		stack.push(32);
		stack.push(74);
		stack.push(98);
		int peeked = stack.peek();
		System.out.println(peeked);
		int popped = stack.pop();
		System.out.println(popped);
		System.out.println(stack.peek());
	}

}
