package heap;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static void heapSort(MaxHeap maxHeap) throws Exception{
        int size = maxHeap.size();
        ArrayList<Integer> sortedArr = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int rem = maxHeap.remove();
            sortedArr.add(rem);
        }

        System.out.println("Sorted: " + sortedArr);

        for(int num: sortedArr) {
            maxHeap.add(num);
        }
    }
    public static void main(String[] args) throws Exception{
        MaxHeap maxHeap = new MaxHeap();
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            maxHeap.add(random.nextInt(1, 100));
        }
        System.out.println("Heap: " + maxHeap.display());
        heapSort(maxHeap);
    }
}
