class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // union find
        DSU dsu = new DSU(edges.length+1);
        for(int [] e : edges) {
            int p = e[0], c = e[1];
            if(dsu.findParent(p) == dsu.findParent(c)) return e;
            dsu.union(c, p);
        }
        return null;
    }

    public class DSU {
        int [] p;
        public DSU (int n) {
            p = new int[n];
            for(int i=0; i<n; i++) p[i] = i;
        }

        public int findParent(int i) {
            while(p[i] != i) i = p[i];
            return i;
        }

        public void union(int l, int r) {
            int lp = findParent(l);
            int rp = findParent(r);
            if(lp != rp) p[lp] = rp;
        }
    }
}