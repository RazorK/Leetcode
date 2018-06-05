import java.util.*;
class Solution {
    // Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
    //
    // Note:
    //
    // The same word in the dictionary may be reused multiple times in the segmentation.
    // You may assume the dictionary does not contain duplicate words.
    // Example 1:
    //
    // Input:
    // s = "catsanddog"
    // wordDict = ["cat", "cats", "and", "sand", "dog"]
    // Output:
    // [
    //   "cats and dog",
    //   "cat sand dog"
    // ]
    // Example 2:
    //
    // Input:
    // s = "pineapplepenapple"
    // wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
    // Output:
    // [
    //   "pine apple pen apple",
    //   "pineapple pen apple",
    //   "pine applepen apple"
    // ]
    // Explanation: Note that you are allowed to reuse a dictionary word.
    // Example 3:
    //
    // Input:
    // s = "catsandog"
    // wordDict = ["cats", "dog", "sand", "and", "cat"]
    // Output:
    // []

    // try same idea as the previous problem, DP, but keep all the possible strings.
    // TLE..
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>(wordDict);
        // board[i] include all the string we find from s[0] to s[i](exclusive)
        List<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
        ArrayList<String> ept = new ArrayList<String>();
        ept.add("");
        board.add(ept);
        for(int i=1; i<=s.length(); i++) {
            ArrayList<String> toBeAdd = new ArrayList<String>();
            // substring(j, i)
            for(int j=0; j<i; j++) {
                if(!dic.contains(s.substring(j, i))) continue;
                List<String> pre = board.get(j);
                for(String x : pre) {
                    String blank = j==0? "":" ";
                    toBeAdd.add(x + blank + s.substring(j, i));
                }
            }
            board.add(toBeAdd);
        }
        return board.get(board.size()-1);
    }

    public static void main(String [] args) {
    }
}
