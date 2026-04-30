package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0; i<4; i++) {
            ArrayList<ArrayList<Integer>> nbr = new ArrayList<>();
            ArrayList<Integer> edge1 = new ArrayList<>(Arrays.asList(1, 4));
            nbr.add(edge1);
            adj.add(nbr);
        }

        for(ArrayList<Integer> edge: adj.get(0)) {

        }
    }
}
