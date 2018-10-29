class Solution {
    // straightforward solution: 4 direction scan O(m*n);
    // second idea dp
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int [][][] board = new int[M.length][M[0].length][4];
        
        int max = 0;
        // init
        for(int i=0; i<M.length; i++) {
            for(int j=0; j<M[0].length; j++) {
                if(M[i][j] == 1) {
                    board[i][j][0] = j>=1 ? board[i][j-1][0] + 1 : 1;
                    board[i][j][1] = i>=1 && j>=1 ? board[i-1][j-1][1] + 1 : 1;
                    board[i][j][2] = i>=1 ? board[i-1][j][2] + 1 : 1;
                    board[i][j][3] = i>=1 && j<M[0].length-1 ? board[i-1][j+1][3] + 1 : 1;
                    for(int k = 0; k<4; k++) max = Math.max(max, board[i][j][k]);
                }
            }
        }
        return max;
    }
}