class Solution {
    // first idea n^2
    // BUG 1: not correct if we count the row and col and multiple by 2, because it is not convex

    // second try traverse each cell, and judge the contribution of that cell to perimeter
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    res += 4;
                    if(i != 0 && grid[i-1][j] == 1) res--;
                    if(i != grid.length-1 && grid[i+1][j] == 1) res--;
                    if(j != 0 && grid[i][j-1] == 1) res--;
                    if(j!= grid[0].length-1 && grid[i][j+1] == 1) res--;
                }
            }
        }
        return res;
    }
} 