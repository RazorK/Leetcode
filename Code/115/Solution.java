class Solution {
    // Given a string S and a string T, count the number of distinct subsequences of S which equals T.
    //
    // A subsequence of a string is a new string which is formed from the original
    // string by deleting some (can be none) of the characters without disturbing the
    // relative positions of the remaining characters. (ie, "ACE" is a subsequence of
    // "ABCDE" while "AEC" is not).
    //
    // Here is an example:
    // S = "rabbbit", T = "rabbit"
    //
    // Return 3.

    // first try recursion, maybe dp later.
    // TLE
    public int firstTry(String s, String t) {
        //if(s.length() < t.length()) return false;
        char[] sList = s.toCharArray();
        char[] tList = t.toCharArray();
        return numDistinct(sList, tList, 0, 0);
    }

    public int numDistinct(char[] s, char[] t, int ss, int ts) {
        // BUG here I make mistake with the boundary cases.
        // when t exceeds the boundary, we should count it as valid.
        // BUG here we also have to put the t case before s case, because when happen at the same time, it should also be valid.
        if(ts>=t.length) return 1;
        if(ss>=s.length) return 0;

        // this line is actually useless
        //if(ss == s.length -1 && ts == t.length -1 && s[ss] == t[ts]) return 1;
        int res = 0;
        if(s[ss] == t[ts]) res+= numDistinct(s, t, ss+1, ts+1);
        res += numDistinct(s,t,ss+1, ts);
        return res;
    }

    // Try dp here. just translate the idea into dp.
    // passed.
    // the space can be simplified to O(t) from O(s*t)
    // NOTE: the key idea for this problem is
    //  1. think up to use dp to solve the problem.
    //  2. boundary cases.
    //  3. recursive relation.
    public int numDistinct(String s, String t) {
        char[] sList = s.toCharArray();
        char[] tList = t.toCharArray();
        int lt = t.length(), ls = s.length();
        int [][] board = new int [lt+1][ls+1];
        for(int i=0; i<lt+1; i++) board[i][ls] = 0;
        for(int i=0; i<ls+1; i++) board[lt][i] = 1;
        for(int i=ls-1; i>=0; i--) {
            for(int j= lt-1; j>=0; j--) {
                int temp = 0;
                if(sList[i] == tList[j]) temp += board[j+1][i+1];
                temp += board[j][i+1];
                board[j][i] = temp;
            }
        }
        return board[0][0];
    }
}
