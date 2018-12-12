class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        // try my idea: for each hit, recalculate the whole grid.
        // TLE
        // count
        int count = 0;
        for(int [] row : grid) {
            for (int cur : row) {
                if(cur == 1) count++;
            }
        }

        int[] res = new int[hits.length];
        for(int i=0; i<hits.length; i++) {
            int x = hits[i][0], y = hits[i][1];
            if(grid[x][y] == 0) {
                res[i] = 0;
                continue;
            }

            grid[x][y] = 0;
            int after = countAfterHit(grid);
            res[i] = count - after - 1;
            count = after;
        }
        return res;
    }

    public int countAfterHit(int [][] grid) {
        int count = 0;

        for(int i=0; i<grid.length; i++) {
            // handle current line
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2 || (i==0 && grid[i][j] == 1)) {
                    count ++;
                    grid[i][j] = 1;
                    scanNextLine(grid, i, j);
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return count;
    }

    public void scanNextLine(int [][] grid, int i, int j) {
        if(i+1 >= grid.length || grid[i+1][j] == 0) return;
        grid[i+1][j] = 2;
        int leftPtr = j-1;
        while(leftPtr>=0 && grid[i+1][leftPtr] == 1) {
            grid[i+1][leftPtr--] = 2;
        }
        int rightPtr = j+1;
        while(rightPtr< grid[0].length && grid[i+1][rightPtr] == 1) {
            grid[i+1][rightPtr++] = 2;
        }
    }
}