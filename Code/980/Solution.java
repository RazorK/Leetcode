class Solution {
    int res;
    public int uniquePathsIII(int[][] grid) {
        // dfs
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int [] start = null, end = null;
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) start = new int[] {i, j};
                if(grid[i][j] == 2) end = new int[] {i, j};
                if(grid[i][j] == 0) count ++;
            }
        }

        res = 0;
        dfs(grid, start[0], start[1], end, 0, count+1);
        return res;
    }

    public void dfs(int [][] grid, int i, int j, int [] end, int cur, int tar) {
        if(i < 0 || i >= grid.length || j<0 || j>=grid[0].length) return;

        if(i == end[0] && j == end[1]) {
            res += cur == tar ? 1 : 0;
            return;
        }

        if(grid[i][j] == -1) return;

        grid[i][j] = -1;
        int [] shifted = new int [] { -1, 0, 1, 0, -1};
        for(int k=0; k<4; k++) {
            dfs(grid, shifted[k] + i, shifted[k+1] + j, end, cur+1, tar);
        }
        grid[i][j] = 0;
    }
}