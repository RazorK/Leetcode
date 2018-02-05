import java.util.*;
class Solution {
    // Given a string s, partition s such that every substring of the partition is a palindrome.
    //
    // Return all possible palindrome partitioning of s.
    //
    // For example, given s = "aab",
    // Return
    //
    // [
    //   ["aa","b"],
    //   ["a","a","b"]
    // ]

    // idea: DP with dfs.
    // try DP first.
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
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
        dfs(board, res, sb, new ArrayList<String>(), 0);
        return res;
    }

    public void dfs(boolean [][] board, List<List<String>> res, StringBuilder sb, List<String> cur, int start) {
        if(start >= sb.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        // sb.substring() end exclude
        for(int i= start+1; i<= sb.length(); i++) {
            if(board[start][i-1] != true) continue;
            cur.add(sb.substring(start, i));
            dfs(board, res, sb, cur, i);
            cur.remove(cur.size()-1);
        }
    }
}
