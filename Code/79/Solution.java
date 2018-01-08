import java.util.*;
class Solution {
    // Given a 2D board and a word, find if the word exists in the grid.
    //
    // The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    //
    // For example,
    // Given board =
    //
    // [
    //   ['A','B','C','E'],
    //   ['S','F','C','S'],
    //   ['A','D','E','E']
    // ]
    // word = "ABCCED", -> returns true,
    // word = "SEE", -> returns true,
    // word = "ABCB", -> returns false.

    // first idea dfs.
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 || board[0].length == 0) return false;
        char [] wordArray = word.toCharArray();
        boolean [][] resource = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                for(int z=0; z<board.length; z++) {
                    Arrays.fill(resource[z], true);
                }
                if(dfs(board, wordArray, 0, i, j, resource))
                    return true;
            }
        }
        return false;
    }

    // BUG we can not go back, so we have to add a direction to remember the coming direction
    // BUG the direction is also not worked, because we can not just avoid reuse by only using the direction.
    //  eg 3 * 3 of 'a'  and 10*'a' as input.
    public static boolean dfs(char[][] board, char [] word, int start, int i, int j, boolean [][] resource){
        // BUG here is a corner case,  the case is the string is already over, but we can not proceed to the deeper space
        // eg [['a']], "a"
        // so here we can not judge like this.
        //if(start == word.length) return true;

        // BUG here we don't know whether i j is overflow.
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word[start] != board[i][j]) {
            return false;
        }
        else if(start == word.length - 1) return true;
        resource[i][j] = false;

        // BUG when backward, we also have to reset the resource..
        if(i!=0 && resource[i-1][j]) {
            if(dfs(board, word, start+1, i-1, j, resource))
                return true;
        }
        if(i!=board.length-1 && resource[i+1][j])
            if(dfs(board,word, start+1, i+1, j, resource))
                return true;
        if(j!=0 && resource[i][j-1])
            if(dfs(board, word, start+1, i, j-1, resource))
                return true;
        if(j!=board[0].length-1 && resource[i][j+1])
            if(dfs(board, word, start+1, i, j+1, resource))
                return true;

        // Debugged here.
        resource[i][j] = true;
        return false;
    }
}
