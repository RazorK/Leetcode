class Solution {
    // Given a 2d grid map of '1's (land) and '0's (water), count the number of
    // islands. An island is surrounded by water and is formed by connecting adjacent
    // lands horizontally or vertically. You may assume all four edges of the grid are
    // all surrounded by water.
    //
    // Example 1:
    //
    // Input:
    // 11110
    // 11010
    // 11000
    // 00000
    //
    // Output: 1
    // Example 2:
    //
    // Input:
    // 11000
    // 11000
    // 00100
    // 00011
    //
    // Output: 3

    // First Idea, traverse, once encountered a 1, mark all the land and res++. skip the marked place when traverse
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    spread(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void spread(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j] == '1') {
            grid[i][j] = 'x';
            spread(grid, i-1, j);
            spread(grid, i, j-1);
            spread(grid, i+1, j);
            spread(grid, i, j+1);
        }
    }
}
