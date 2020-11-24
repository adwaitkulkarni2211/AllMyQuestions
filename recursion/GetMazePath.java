package recursion;
import java.util.*;
public class GetMazePath {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        ArrayList<String> res = getMazePaths(1,1,n,m);
        System.out.println(res);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        } else if(sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> pathH = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> pathV = getMazePaths(sr + 1, sc, dr, dc);
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String path: pathH) {
            paths.add("h"+ path);
            //System.out.println("paths in pathsH: "+ paths + " sr:" + sr + " sc:" + sc + "\n");
        }
        for(String path: pathV) {
            paths.add("v"+ path);
            //System.out.println("paths in pathsV: "+ paths + " sr:" + sr + " sc:" + sc + "\n");
        }
        return paths;
    }
}
