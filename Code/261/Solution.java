class Solution {
    public boolean validTree(int n, int[][] edges) {
        // two things to check
        // 1. whether there are loops within the edges
        // 2. all nodes are connected to each other

        // To check 1: use union find
        // To check 2: By following 1, we only need to check wether the number of edges equals n - 1.
        if(n <= 1) return true;
        if(edges.length != n-1) return false;

        int [] next = new int[n];
        for(int i = 0; i< n; i++) {
            next[i] = i;
        }

        for(int [] edge : edges) {
            int x = getEnd(next, edge[0]);
            int y = getEnd(next, edge[1]);
            if(x==y) return false;
            else {
                next[x] = y;
            }
        }

        return true;
    }

    public int getEnd(int [] next, int i) {
        // promise that next will have no loops in it.
        while(next[i]!=i) {
            i = next[i];
        }
        return i;
    }
}