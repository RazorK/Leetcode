class Solution {
    // Given a 2D board and a list of words from the dictionary, find all words in the board.
    //
    // Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
    //
    // Example:
    //
    // Input:
    // words = ["oath","pea","eat","rain"] and board =
    // [
    //   ['o','a','a','n'],
    //   ['e','t','a','e'],
    //   ['i','h','k','r'],
    //   ['i','f','l','v']
    // ]
    //
    // Output: ["eat","oath"]
    // Note:
    // You may assume that all inputs are consist of lowercase letters a-z.

    // first idea straight forward
    // BUG 1: what if words have duplicates
    // BUG 2: can not use the same char in board
    // TLE
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if(board == null || board.length == 0 || board[0].length == 0) return new ArrayList(res);
        if(words == null || words.length == 0) return new ArrayList(res);

        for(String word: words) {
            boolean flag = false;
            for(int i=0; (!flag) && i<board.length; i++) {
                for(int j=0; (!flag) && j<board[0].length; j++) {
                    if(findWord(board, word, i, j)) {
                        flag = true;
                        if(!res.contains(word)) {
                            res.add(word);
                        }
                    }
                }
            }
        }

        return new ArrayList(res);
    }

    public boolean findWord(char [][] board, String word, int x, int y) {
        if(word.equals("")) return true;
        if(x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if(board[x][y] != word.charAt(0)) return false;
        char mem = board[x][y];
        board[x][y] = '0';
        int [] pres = new int [] {-1, 1};
        for(int pre : pres) {
            if(findWord(board, word.substring(1), x+pre, y) ||
                findWord(board, word.substring(1), x, y+pre) ) {
                board[x][y] = mem;
                return true;
            }
        }

        board[x][y] = mem;
        return false;
    }

    // from LC, we can build a trie based on words. then dfs all the board?
}
