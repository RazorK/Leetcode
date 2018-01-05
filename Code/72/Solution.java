class Solution {
    // Given two words word1 and word2, find the minimum number of steps required
    // to convert word1 to word2. (each operation is counted as 1 step.)
    //
    // You have the following 3 operations permitted on a word:
    //
    // a) Insert a character
    // b) Delete a character
    // c) Replace a character

    // no idea..
    // insipired to use dp.
    // still can't find the transform relation...

    // just copy the explanation from discuss here
    // --------------------START------------------------
    // Let following be the function definition :-
    //
    // f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
    //
    // Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
    //
    // f(i, j) = f(i - 1, j - 1)
    //
    // Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
    //
    // f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
    //
    // f(i, j - 1) represents insert operation
    // f(i - 1, j) represents delete operation
    // f(i - 1, j - 1) represents replace operation
    // Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.
    //
    // Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.
    //
    // Above equations become the recursive definitions for DP.
    //
    // Base Case:
    //
    // f(0, k) = f(k, 0) = k
    // --------------------END------------------------

    // my question :
    // QUESTION  why the (i, j) solution must come from one of (i-1, j), (i-1, j-1), (i, j-1)??
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == 0 || l2 == 0) return l1 + l2;
        int [][] board = new int [l1+1][l2+1];

        // BUG here miss the equal comparison
        for(int i=0; i<=l1; i++)  {
            board[i][0] = i;
        }
        for(int i=0; i<=l2; i++) {
            board[0][i] = i;
        }
        for(int i = 0; i<l1; i++) {
            for(int j=0; j<l2; j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    board[i+1][j+1] = board[i][j];
                } else {
                    board[i+1][j+1] = Math.min(board[i][j+1], Math.min(board[i+1][j], board[i][j])) +1;
                }
            }
        }
        return board[l1][l2];
    }
}
