class Solution {

    static int max = 1000000000 + 7;
    public int numMusicPlaylists(int N, int L, int K) {
        // idea from LC. dp, the key is what does the dp value means.
        // the value board[l][n] means how many playlists are these that the playlists are of length l and contains n unique songs.
        // this is really hard to think of, the idea is that this value can be populated in this problem and at the same time can answer the question we asked.

        long [][] board = new long[L+1][N+1];
        board[1][1] = N;
        for(int l=2; l<=L; l++) {
            for(int n=1; n<=N; n++) {
                long cur = board[l-1][n] * Math.max(0, n-K);
                if(n > 1) cur += board[l-1][n-1] * (N - n + 1);
                board[l][n] = cur % max;
            }
        }

        return (int)board[L][N];
    }
}