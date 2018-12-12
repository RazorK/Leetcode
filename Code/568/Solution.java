class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = days.length, K = days[0].length;
        // maintain a board 
        int [][] board = new int [K][N];

        // init
        for(int i=0; i<N; i++) {
            if(flights[0][i] == 1)
                board[0][i] = days[i][0];
            else board[0][i] = Integer.MIN_VALUE;
        }

        // proceed
        for(int i=1; i<K; i++) {
            for(int j=0; j<N; j++) {
                //determine board[i][j]
                int max = -1;
                for(int k=0; k<N; k++) {
                    if(flights[k][j] == 1 || k == j) {
                        max = Math.max(max, board[i-1][k] + days[j][i]);
                    }
                }
                board[i][j] = max;
            }
        }

        Arrays.deepToString(board);
        // find max
        int max = -1;
        for(int i=0; i<N; i++) {
            max = Math.max(max, board[K-1][i]);
        }
        return max;
    }
}