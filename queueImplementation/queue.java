package queueImplementation;

public class queue {
	// class variables
    private int[] arr;
    private int sizeOfArray = 0;
    private int sizeOfQueue = 0;
    private int front = -1;
    private int back = -1;
    
    // constructor
    public queue() {
        this.initilize(5);
    }

    public queue(int size) {
        this.initilize(size);
    }

    public void initilize(int size) {
        this.arr = new int[size];
        this.sizeOfArray = size;
        this.sizeOfQueue = 0;
        this.front = -1;
        this.back = -1;
    }
    
    // exceptions
    private void queueIsFullException() throws Exception {
        if (this.sizeOfArray == this.sizeOfQueue)
            throw new Exception("queueIsFull");
    }

    private void queueIsEmptyException() throws Exception {
        if (this.sizeOfQueue == 0)
            throw new Exception("queueIsEmpty");
    }
    
    // basic
    public boolean isEmpty() {
        return this.sizeOfQueue == 0;
    }

    public int size() {
        return this.sizeOfQueue;
    }
    
    // functions
    public void push(int val) throws Exception {
        queueIsFullException();
        if(sizeOfQueue == 0) {
        	this.front = 0;
        }
        this.back++;
        this.arr[this.back] = val;
        this.sizeOfQueue++;
    }

    public int pop() throws Exception {
        queueIsEmptyException();
        int val = this.peek();
        this.front++;
        this.sizeOfQueue--;

        return val;
    }

    public int peek() throws Exception {
        queueIsEmptyException();
        return this.arr[this.front];
    }
}
