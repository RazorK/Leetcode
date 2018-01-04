class Solution {
    // Follow up for "Unique Paths":
    //
    // Now consider if some obstacles are added to the grids. How many unique paths
    // would there be?
    //
    // An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    //
    // For example,
    // There is one obstacle in the middle of a 3x3 grid as illustrated below.
    //
    // [
    //   [0,0,0],
    //   [0,1,0],
    //   [0,0,0]
    // ]
    // The total number of unique paths is 2.
    //
    // Note: m and n will be at most 100.

    // first idea dfs && recursion
    // time limit exceed ...
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        // BUG forget to check whether the starting point or the ending is 0 or 1..
        if(obstacleGrid[0][0] == 1) return 0;
        int [][] memory = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int [] row : memory) {
            Arrays.fill(row, -1);
        }
        return memory_dfs(obstacleGrid, 0, 0, memory);
    }

    public int dfs(int [][] board, int x, int y) {
        // BUG
        if(x == board.length - 1 && y == board[0].length -1) {
            if(board[x][y] == 1) return 0;
            return 1;
        }
        int result = 0;
        if(x!= board.length -1 && board[x+1][y] != 1)
            result += dfs(board, x+1, y);
        if(y!= board[0].length-1 && board[x][y+1]!=1)
            result += dfs(board, x, y+1);
        return result;
    }

    // inspired by jeff, use stored dfs
    public int memory_dfs(int [][] board, int x, int y, int [][] memory) {
        if(memory[x][y]!=-1) return memory[x][y];
        if(x == board.length - 1 && y == board[0].length -1) {
            if(board[x][y] == 1) return 0;
            return 1;
        }
        int result = 0;
        if(x!= board.length -1 && board[x+1][y] != 1)
            result += memory_dfs(board, x+1, y, memory);
        if(y!= board[0].length-1 && board[x][y+1]!=1)
            result += memory_dfs(board, x, y+1, memory);
        memory[x][y] = result;
        return result;
    }

    // try to think out a dp Solution
    // dp seems don't need recursion here
    public int dp(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        // BUG forget to check whether the starting point or the ending is 0 or 1..
        int l = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[l-1][w-1] == 1) return 0;
        int [][] memory = new int[l][w];
        for(int [] row : memory) {
            Arrays.fill(row, -1);
        }
        memory[l-1][w-1] = 1;
        for(int i = l-1; i>=0; i--) {
            for(int j = w-1; j>=0; j--) {
                if(i==l-1&&j==w-1) continue;
                int result = 0;
                if(i!=l-1&&obstacleGrid[i+1][j] != 1)
                    result += memory[i+1][j];
                if(j!=w-1&&obstacleGrid[i][j+1] != 1)
                    result += memory[i][j+1];
                memory[i][j] = result;
            }
        }
        return memory[0][0];
    }
}
