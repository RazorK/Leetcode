class Solution {
    public String minWindow(String S, String T) {
        if(S == null || S.length() == 0) return "";
        if(T == null || T.length() == 0) return "";
        int m = S.length(), n = T.length();
        int [][] board = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(board[i], -1);
        // b[m][n] have value t, means S.substring(t, m+1) have subsequence T.substring(n+1);
        for(int i=0; i<m; i++) {
            if(S.charAt(i) == T.charAt(0)) board[0][i] = i;
            else if(i!=0 && board[0][i-1] != -1) board[0][i] = board[0][i-1];
        }

        for(int i=1; i<n; i++) {
            for(int j = i + 1; j<m; j++) {
                if(board[i-1][j-1] != -1 && S.charAt(j) == T.charAt(i)) {
                    board[i][j] = board[i-1][j-1];
                } else if(board[i][j-1]!=-1) {
                    board[i][j] = board[i][j-1];
                } 
            }
        }
        System.out.println(Arrays.deepToString(board));
        // find min
        int min = Integer.MAX_VALUE;
        int[] store = null;
        for(int i=0; i<m; i++) {
            int cur = board[n-1][i];
            if(cur!=-1 && i-cur < min)  {
                min = i-cur;
                store = new int[] {cur, i};
            }
        }
        if(store == null) return "";
        return S.substring(store[0], store[1] + 1);
    }
}