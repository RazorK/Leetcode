class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int res = -1;

        for(int i = 0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int cur = dfs(grid, i, j);
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    public int dfs(int [][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        res += dfs(grid, i-1, j);
        res += dfs(grid, i+1, j);
        res += dfs(grid, i, j+1);
        res += dfs(grid, i, j-1);
        return res;
    }
}