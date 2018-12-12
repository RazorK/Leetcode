class Solution {
    public String minWindow(String S, String T) {
        // first idea dfs
        // dp solution: the board[i][j] contains a integer, stands for the length of the prefix subsequences of T from S[i] to S[j];
        if(S == null || S.length() == 0) return "";
        if(T == null || T.length() == 0) return "";
        if(T.length() == 1 && S.contains(T)) return T;
        int len = S.length();
        int [][] board = new int[len][len];
        // init
        for(int i=0; i<len; i++) {
            if(S.charAt(i) == T.charAt(0)) board[i][i] = 1;
        }

        int min = Integer.MAX_VALUE;
        int [] store = null;
        // expand
        for(int i=1; i<len; i++) {
            for(int j=0; i+j<len; j++) {
                int x = j;
                int y = i + j;
                int tar = board[x][y-1];
                if(tar >= T.length() || S.charAt(y) != T.charAt(tar)) {
                    board[x][y] = tar;
                } else {
                    board[x][y] = tar + 1;
                    if(tar + 1 == T.length() && y-x < min) {
                        min = y-x;
                        store = new int[] {x, y};
                    }
                }
            }
        }
        if(store == null) return "";
        return S.substring(store[0], store[1]+1);
    }
}