import java.util.*;
class Solution {
    // Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
    //
    // For example,
    // Given:
    // s1 = "aabcc",
    // s2 = "dbbca",
    //
    // When s3 = "aadbbcbcac", return true.
    // When s3 = "aadbbbaccc", return false.

    // first idea dfs.
    // TLE..
    public boolean firstTry(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);

        if(s1.length()!=0 && s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1)))
            return true;
        if(s2.length()!=0 && s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)))
            return true;
        return false;
    }

    // may cause from the string manipulate, try char array.
    // still TLE :(
    public boolean charProcess(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        return dfs(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    public boolean dfs(char [] s1, int ss1, char[] s2, int ss2, char[] s3, int ss3) {
        if(s3.length != s1.length + s2.length) return false;
        // BUG forget add true stop
        if(ss1 == s1.length && ss2 == s2.length && ss3 == s3.length) return true;
        if(ss1 <= s1.length - 1 && s1[ss1] == s3[ss3] && dfs(s1, ss1 + 1, s2, ss2, s3, ss3 + 1)) {
            return true;
        }
        if(ss2 <= s2.length - 1 && s2[ss2] == s3[ss3] && dfs(s1, ss1, s2, ss2 + 1, s3, ss3 + 1))
            return true;
        return false;
    }

    // try not use recursion
    // DP idea.
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        char [] s1l = s1.toCharArray();
        char [] s2l = s2.toCharArray();
        char [] s3l = s3.toCharArray();
        int rows = s1.length() + 1, cols = s2.length() + 1;
        boolean [][] board = new boolean[rows][cols];
        board[0][0] = true;
        for(int i=1; i<rows; i++) {
            board[i][0] = board[i-1][0] && (s1l[i-1] == s3l[i-1]);
        }
        for(int i=1; i<cols; i++) {
            board[0][i] = board[0][i-1] && (s2l[i-1] == s3l[i-1]);
        }
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                boolean temp = false;
                if(board[i-1][j] && s1l[i-1] == s3l[i+j-1])
                    temp = true;
                if(board[i][j-1] && s2l[j-1] == s3l[i+j-1])
                    temp = true;
                board[i][j] = temp;
            }
        }
        return board[rows-1][cols-1];
    }


}
