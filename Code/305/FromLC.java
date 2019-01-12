class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        int len = positions.length, blocked = m * n;
        List<Integer> ans = new ArrayList<>();
        boolean[][] grid = new boolean[m][n];
        for(int i = 0; i < len; i++) {
            int r = positions[i][0], c = positions[i][1]; 
            if(isValid(grid, r + 1, c)) uf.union(r * n + c, (r + 1) * n + c);
            if(isValid(grid, r - 1, c)) uf.union(r * n + c, (r - 1) * n + c);
            if(isValid(grid, r, c + 1)) uf.union(r * n + c, r * n + c + 1);
            if(isValid(grid, r, c - 1)) uf.union(r * n + c, r * n + c - 1);
            if(!grid[r][c]) blocked--;
            grid[r][c] = true;
            ans.add(uf.numCmpts() - blocked);
        }
        return ans;
    }
    
    private boolean isValid(boolean[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j];
    }
    
    class UnionFind {
        int n, numofCmpts;
        int[] par;
        UnionFind(int n) {
            this.n = n;
            this.numofCmpts = n;
            par = new int[n];
            for(int i = 0; i < n; i++) par[i] = i;        
        }
        
        public int find(int i) {
            if(par[i] != i) par[i] = find(par[i]);
            return par[i];
        }
        
        public void union(int i, int j) {
            int pari = find(i), parj = find(j);
            if(pari != parj) {
                par[pari] = parj;
                numofCmpts--;
            }
        }
        
        public int numCmpts() {
            return numofCmpts; 
        }
    }    
}