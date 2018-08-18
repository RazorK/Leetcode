class Solution {
    // Given a 2D binary matrix filled with 0's and 1's, find the largest square
    // containing only 1's and return its area.
    //
    // Example:
    //
    // Input:
    //
    // 1 0 1 0 0
    // 1 0 1 1 1
    // 1 1 1 1 1
    // 1 0 0 1 0
    //
    // Output: 4

    // first idea: encounter 1, expand and mark, else continue, wrong
    // second try: dp, 2d array, and regard each cell as the bottom-right corner of square
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int [][] board = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == '1') {
                board[i][0] = 1;
                max = 1;
            }
        }
        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[0][j] == '1') {
                board[0][j] =1;
                max = 1;
            }
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    int cur = 1  + Math.min(Math.min(board[i-1][j-1], board[i-1][j]), Math.min(board[i-1][j], board[i][j-1]));
                    max = Math.max(max, cur);
                    board[i][j] = cur;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        return max*max;
    }
}
