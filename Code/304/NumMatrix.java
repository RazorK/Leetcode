class NumMatrix {

    int [][] board;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        board = new int [m][n];
        for(int i=0; i<m; i++) {
            int acc = 0;
            for(int j=0; j<n; j++) {
                acc += matrix[i][j];
                if(i == 0) {
                    board[i][j] = acc;
                } else board[i][j] = board[i-1][j] + acc;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(board == null || row1 < 0 || row1 >= board.length
            || col1 < 0 || col1 >= board[0].length
            || row2 < 0 || row2 >= board.length 
            || col2 < 0 || col2 >= board[0].length) return 0;
        
        int res = board[row2][col2];
        if(row1 != 0) res -= board[row1-1][col2];
        if(col1 != 0) res -= board[row2][col1-1];
        if(row1 != 0 && col1 != 0) res += board[row1-1][col1-1];
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */