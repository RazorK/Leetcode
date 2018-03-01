import java.util.*;
class Solution {
    // Given a string containing just the characters '(' and ')', find the length
    // of the longest valid (well-formed) parentheses substring.
    //
    // For "(()", the longest valid parentheses substring is "()", which has length = 2.
    //
    // Another example is ")()())", where the longest valid parentheses substring is "()()",
    // which has length = 4.

    // first idea: dp find (()) model, then gather togather.
    // BUG abandoned for case (()())
    public int longestValidParentheses(String s) {
        if(s.length()<=1) return 0;
        int n = s.length();
        char [] array = s.toCharArray();
        boolean [][] board = new boolean [n][n];
        for(int i=0;i<n; i++) Arrays.fill(board[i], false);

        for(int i=0; i<n-1; i++) {
            if(array[i] == '(' && array[i+1] == ')')
                board[i][i+1] = true;
        }

        for(int i=2; i<n; i++) {
            for(int j=0; j+i<n; j++) {
                if(array[j] == '(' && array[i+j] == ')' && board[j+1][i+j-1] == true)
                    board[j][i+j] = true;
            }
        }
        //System.out.println(Arrays.deepToString(board));

        int [] max = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=i; j--) {
                if(board[i][j]) {
                    max[i] = j;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(max));

        int max_result = 0;
        int start = 0;
        int temp = 0;
        int end = 0;
        while(start<n) {
            if(max[start] == 0){
                start++;
                continue;
            }
            if(start != end + 1) temp = 0;
            temp += max[start]-start+1;
            max_result = Math.max(temp, max_result);
            end = max[start];
            start = end+1;
        }
        return max_result;
    }
}
