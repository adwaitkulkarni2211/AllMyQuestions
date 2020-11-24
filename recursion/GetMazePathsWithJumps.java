package recursion;
import java.util.*;
public class GetMazePathsWithJumps {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        double start = System.currentTimeMillis();
        ArrayList < String > res = getMazePaths(1, 1, n, m);
        System.out.println(res);
        double end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > bres = new ArrayList < > ();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();
        
        //horizontal
        for(int ms = 1; ms <= dc - sc; ms++) {
        	System.out.println("paths in H pre: " + paths + " sr: "+ sr + " sc: "+ sc);
        	ArrayList<String> pathsH = getMazePaths(sr, sc + ms, dr, dc);
            for(String hpaths: pathsH) {
                paths.add("h" + ms + hpaths);
            }
            System.out.println("paths in H post: " + paths + " sr: "+ sr + " sc: "+ sc);
        }
        //vertical
        for(int ms = 1; ms <= dr - sr; ms++) {
        	System.out.println("paths in V pre: " + paths + " sr: "+ sr + " sc: "+ sc);
            ArrayList<String> pathsV = getMazePaths(sr + ms, sc, dr, dc);
            for(String vpaths: pathsV) {
                paths.add("v" + ms + vpaths);
            }
            System.out.println("paths in V post: "+paths + " sr: "+ sr + " sc: "+ sc);
        }
        //diagonal
        for(int ms = 1; ms <= dc - sc && ms <= dr - sr; ms++) {
        	System.out.println("paths in D pre: " + paths + " sr: "+ sr + " sc: "+ sc);
        	ArrayList<String> pathsD = getMazePaths(sr + ms, sc + ms, dr, dc);
            for(String dpaths: pathsD) {
                paths.add("d" + ms + dpaths);
            }
            System.out.println("paths in D post: "+paths + " sr: "+ sr + " sc: "+ sc);
        }
        System.out.println("Final paths: " + paths);
        return paths;
    }
}
