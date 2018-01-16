import java.util.*;
class Solution {
    // Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
    //
    // Example:
    //
    // Input: "babad"
    //
    // Output: "bab"
    //
    // Note: "aba" is also a valid answer.
    // Example:
    //
    // Input: "cbbd"
    //
    // Output: "bb"

    // first idea dp. very slow.
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;

        char [] array = s.toCharArray();
        int l = s.length();
        boolean [][] board = new boolean[l][l];
        for(int i=0; i<l; i++) {
            Arrays.fill(board[i], false);
        }
        for(int i=0; i<l; i++) {
            board[i][i] = true;
        }
        for(int i=0; i<l-1; i++) {
            board[i][i+1] = array[i] == array[i+1];
        }
        for(int i=2; i<l; i++) {
            for(int j=0; i+j<l; j++) {
                board[j][i+j] = board[j+1][i+j-1] && array[j] == array[i+j];
            }
        }

        // get the longest
        int max = 0;
        int start = 0, end = 0;
        for(int i = l-1; i>=0; i--) {
            for(int j=0; i+j<l; j++) {
                if(board[j][i+j]) {
                    if(i>max) {
                        max = i;
                        start = j;
                        end = i+j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
