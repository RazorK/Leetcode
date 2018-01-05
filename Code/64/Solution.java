import java.util.*;
class Solution {
    // Given a m x n grid filled with non-negative numbers, find a path from top
    // left to bottom right which minimizes the sum of all numbers along its path.
    //
    // Note: You can only move either down or right at any point in time.
    //
    // Example 1:
    // [[1,3,1],
    //  [1,5,1],
    //  [4,2,1]]
    // Given the above grid map, return 7. Because the path  minimizes the sum.

    // first idea dfs and dp, try dp first
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int [][] board = new int [rowNum][colNum];

        // because we will not consult the unvisited item
        // so we don't need to init the board.
        for(int i=rowNum-1; i>=0; i--) {
            for(int j=colNum-1; j>=0; j--) {
                if(i==rowNum-1 && j==colNum -1) {
                    board[i][j] = grid[i][j];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if(i!=rowNum - 1){
                    int value = board[i+1][j] + grid[i][j];
                    min = min< value? min:value;
                }
                if(j!=colNum -1){
                    int value = board[i][j+1] + grid[i][j];
                    min = min< value? min:value;
                }
                board[i][j] = min;
            }
        }

        return board[0][0];
    }

    // fast idea.
    public int faster(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int [][] board = new int [rowNum][colNum];
        // just divide the whole process into 4 part, first point, edge and
        // left area.
        board[0][0] = grid[0][0];
        for(int i=1; i<rowNum; i++) {
            board[i][0] = board[i-1][0] + grid[i][0];
        }
        for(int j=1; j<colNum; j++) {
            board[0][j] = board[0][j-1] + grid[0][j];
        }

        for(int i=1; i<rowNum; i++) {
            for(int j=1; j<colNum; j++) {
                board[i][j] = grid[i][j] + Math.min(board[i-1][j], board[i][j-1]);
            }
        }
        return board[rowNum-1][colNum-1];
    }

    // try use only 1D board;
    public static int try1D(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int [] board = new int[colNum];
        Arrays.fill(board, Integer.MAX_VALUE);
        board[0] = grid[0][0];
        for(int i=0; i<rowNum; i++) {
            if(i!= 0)
                board[0] = board[0]+grid[i][0];
            for(int j=1; j<colNum; j++) {
                board[j] = grid[i][j] + Math.min(board[j-1], board[j]);
            }
        }
        return board[colNum-1];
    }
}
