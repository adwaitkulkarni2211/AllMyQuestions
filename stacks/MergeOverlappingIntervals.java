package stacks;
import java.io.*;
import java.util.*;

public class MergeOverlappingIntervals {
	public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] a) {
        // merge overlapping intervals and print in increasing order 
        //of start time
        Stack < Pair > merge = new Stack < > ();
        Pair pairs[] = new Pair[a.length];
        for (int i = 0; i < a.length; i++) {
            pairs[i] = new Pair(a[i][0], a[i][1]);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                merge.push(pairs[i]);
            } else {
                if (pairs[i].start <= merge.peek().end) {
                    merge.peek().end = Math.max(pairs[i].end, merge.peek().end);
                } else {
                    merge.push(pairs[i]);
                }
            }
        }

        Stack < Pair > res = new Stack < > ();
        while (merge.size() != 0) {
            res.push(merge.pop());
        }
        while (res.size() != 0) {
            Pair p = res.pop();
            System.out.println(p.start + " " + p.end);
        }

    }


    public static class Pair implements Comparable < Pair > {
        int start,
        end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair other) {
            //this > other return +ve val
            //this < other return -ve val
            //this = other return 0
            if (this.start != other.start) {
                return this.start - other.start;
            } else {
                //if start time is equal then sort using the end time
                return this.end - other.end;
            }
        }

    }
}
