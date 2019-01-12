import java.util.*;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        // board to store the length of incresing sequence start from this cell
        int [][] board = new int [m][n];
        int res = -1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int cur = dfs(matrix, board, i, j);
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    public int dfs(int [][] matrix, int [][] board, int i, int j) {
        if(i< 0 || i>= matrix.length || j<0 || j>= matrix[0].length) return 0;
        if(board[i][j] != 0) return board[i][j];

        int cur = 0;
        int [] shifted = new int [] {-1, 0, 1, 0, -1};
        for(int k=0; k<4; k++) {
            int newI = i + shifted[k], newJ = j + shifted[k+1];
            if( newI >= 0 && newI<matrix.length && newJ>=0 && newJ<matrix[0].length &&
                matrix[i][j] < matrix[newI][newJ]) {
                cur = Math.max(cur, dfs(matrix, board, newI, newJ));
            }
        }
        board[i][j] = cur+1;
        return cur+1;
    }
}