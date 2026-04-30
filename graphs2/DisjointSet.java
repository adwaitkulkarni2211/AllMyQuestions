package graphs2;

import java.util.Arrays;

public class DisjointSet {
    int n;
        int[] parent;
        int[] rank;
        int[] size;

        DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
        }
        int getN() {
            return this.n;
        }
        int[] getParent() {
            return this.parent;
        }
        int[] getRank() {
            return this.rank;
        }
        int[] getSize() {
            return this.size;
        }

        int find(int u) {
            if(parent[u] == -1) return u;
            return parent[u] = find(parent[u]);
        }

        void union(int u, int v) {
            int absrU = find(u);
            int absrV = find(v);
            if(absrU == absrV) return;

            if(rank[absrU] < rank[absrV]) {
                parent[absrU] = absrV;
            } else if(rank[absrU] > rank[absrV]) {
                parent[absrV] = absrU;
            } else {
                parent[absrV] = absrU;
                rank[absrU]++;
            }
        }

        void unionBySize(int u, int v) {
            int absrU = find(u);
            int absrV = find(v);
            if(absrU == absrV) return;

            if(size[absrU] < size[absrV]) {
                parent[absrU] = absrV;
                size[absrV] += size[absrU];
            } else {
                parent[absrV] = absrU;
                size[absrU] += size[absrV];
            }
        }
}
