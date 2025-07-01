package heap;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> arr;

    MaxHeap() {
        arr = new ArrayList<>();
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public void add(int num) {
        arr.add(num);
        upheap(arr.size() - 1);
    }

    private void upheap(int idx) {
        if(idx == 0)
            return;

        int parentIdx = getParent(idx);
        if(arr.get(parentIdx) <= arr.get(idx)) {
            swap(parentIdx, idx);
            upheap(parentIdx);
        }
    }

    public int remove() throws Exception {
        if(arr.isEmpty())
            throw new Exception("Removing from an empty heap!");

        int top = arr.getFirst();
        int last = arr.removeLast();
        //it's possible that heap only has one element. When last is removed in the above line the array will be empty.
        if(!arr.isEmpty()) {
            arr.set(0, last);
            downheap(0);
        }

        return top;
    }

    private void downheap(int idx) {
        if(idx > arr.size() - 1)
            return;

        int min = idx;
        int leftIdx = getLeftChild(idx);
        int rightIdx = getRightChild(idx);

        if(leftIdx < arr.size() && arr.get(leftIdx) > arr.get(min))
            min = leftIdx;
        if(rightIdx < arr.size() && arr.get(rightIdx) > arr.get(min))
            min = rightIdx;

        // if min == idx, it means there's no need to swap. Both left and right children are lesser than current node
        if(min != idx) {
            swap(idx, min);
            downheap(min);
        }

    }

    public String display() {
        return arr + "";
    }

    public int size() {
        return arr.size();
    }
}
