package stacks2;

public class KStacksInAnArray {

	public static class KStacks {
		int k;
		int[] arr;
		int[] top;
		int[] next;
		int free;
		
		public KStacks(int k) {
			this.k = k;
			arr = new int[15];
			top = new int[k];
			for(int i=0; i<top.length; i++) {
				top[i] = -1;
			}
			next = new int[arr.length];
			for(int i=0; i<next.length - 1; i++) {
				next[i] = i + 1;
			}
			next[next.length - 1] = -1;	//last element will have no next element
			free = 0;
		}
		
		void push(int val, int sn) {
			if(free == -1) {
				System.out.println("stacks are full");
				return;
			}
			
			//store the free value in i;
			int i = free;
			
			//update index of free slot to index of next free slot
			free = next[i];
			
			//update next of stack and then top of stack for sn
			next[i] = top[sn];
			top[sn] = i;
			
			//put the value in the array;
			arr[i] = val;
		}
		
		int pop(int sn) {
			if(top[sn] == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			
			//find index of top element for stack sn
			int i = top[sn];
			
			//decrement top of stack to its next element
			top[sn] = next[i];
			
			//attach the previous top to the beginning of the free list
			next[i] = free;
			free = i;
			
			//return the popped element
			return arr[i];
		}
	}
	
	public static void main(String[] args) {
		
	}

}
