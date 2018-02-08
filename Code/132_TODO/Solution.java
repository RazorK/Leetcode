class Solution {
    // try the solution of 131 first
    // TLE

    // try other idea.
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int l = s.length();
        boolean [][] board = new boolean [l][l];
        StringBuilder sb = new StringBuilder(s);
        // generate board n^2 complexity
        for(int i=0; i<l; i++) board[i][i] = true;
        for(int i=0; i<l-1; i++) {
            if(sb.charAt(i) == sb.charAt(i+1))
                board[i][i+1] = true;
        }
        for(int j=2; j<l; j++) {
            for(int i=0; i<l-j; i++) {
                boolean temp = false;
                // BUG here I use = in the first appearance of ==, it turns out pass the complier!
                if(board[i+1][i+j-1] == true && sb.charAt(i) == sb.charAt(i+j))
                    temp = true;
                board[i][i+j] = temp;
            }
        }
    }
}
