import java.util.*;
class Solution {
    // Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    //
    // Note:
    //
    // The same word in the dictionary may be reused multiple times in the segmentation.
    // You may assume the dictionary does not contain duplicate words.
    // Example 1:
    //
    // Input: s = "leetcode", wordDict = ["leet", "code"]
    // Output: true
    // Explanation: Return true because "leetcode" can be segmented as "leet code".
    // Example 2:
    //
    // Input: s = "applepenapple", wordDict = ["apple", "pen"]
    // Output: true
    // Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    //              Note that you are allowed to reuse a dictionary word.
    // Example 3:
    //
    // Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    // Output: false

    // dfs idea, TLE
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet(wordDict);
        return dfs(s, dic);
    }

    public boolean dfs(String s, Set<String> dic) {
        // i means insert the blank after the ith char
        if(s.equals("")) return true;
        for(int i=0; i<s.length(); i++) {
            String temp = s.substring(0, i+1);
            if(dic.contains(temp)) {
                if(dfs(s.substring(i+1), dic)) return true;
            }
        }
        return false;
    }

    // try DP, passed, so many bugs.
    public static boolean dp(String s, List<String> wordDict) {
        Set<String> dic = new HashSet(wordDict);

        // BUG: firstly try i inclusive, but it's harder.
        //start from 0, end at i(exclusive), is that available
        boolean [] board = new boolean [s.length() + 1];
        Arrays.fill(board, false);

        board[0] = true;
        for(int i=1; i<=s.length(); i++) {
            boolean flag = false;
            for(int j=0; j<i; j++) {

                // BUG: confuse = and ==
                // BUG: confuse substring(j, i) and substring(j+1, i), because define exclusive above
                if(board[j] == true && dic.contains(s.substring(j, i))) {
                    flag = true;
                    break;
                }
            }
            board[i] = flag;
        }

        return board[s.length()];
    }

    public static void main(String [] args) {
        String s = "leetcode";
        List<String> wd = new ArrayList<>();
        wd.add("leet");
        wd.add("code");

        Solution.dp(s, wd);
    }
}
