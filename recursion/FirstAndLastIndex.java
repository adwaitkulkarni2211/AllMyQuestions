package recursion;
import java.util.*;
public class FirstAndLastIndex {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        sc.close();
        int first = firstIndex(a, 0, x);
        System.out.println(first);
        int last = lastIndex(a, 0, x);
        System.out.println(last);
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if(idx == arr.length) {
            return -1; 
        }
        if(arr[idx] == x){
            return idx;
        } else {
            int first = firstIndex(arr, idx + 1, x);
            return first;
        }
    }
    public static int lastIndex(int[] arr, int idx, int x) {
        if(idx == arr.length) {
            return -1; 
        }
        int last = lastIndex(arr, idx + 1, x);
        if(last == -1) {
            if(arr[idx] == x) {
               // System.out.println("inside if last: "+last+" index: "+ idx);
                return idx;
            }
            //System.out.println("last: "+last+" index: "+ idx);
        }
        //System.out.println("outside if last: "+last+" index: "+ idx);
        return last;
    }
}
