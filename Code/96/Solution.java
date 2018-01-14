class Solution {
    // Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
    //
    // For example,
    // Given n = 3, there are a total of 5 unique BST's.
    //
    //    1         3     3      2      1
    //     \       /     /      / \      \
    //      3     2     1      1   3      2
    //     /     /       \                 \
    //    2     1         2                 3

    // still dp.
    // NOTE: the idea of recursion by start and end is the key idea to Solve this problem!
    public int numTrees(int n) {
        if(n<1) return 0;
        int [][] board = new int [n+2][n+2];
        for(int i=0; i<board.length; i++) {
            Arrays.fill(board[i], -1);
        }
        return dfs(1,n, board);
    }

    public int dfs(int start, int end, int [][] board) {
        if(board[start][end]!= -1) return board[start][end];
        int res = 0;
        if(start >= end) {
            res = 1;
            board[start][end] = res;
            return res;
        }

        for(int i=start; i<=end; i++) {
            res += dfs(start, i-1, board) * dfs(i+1, end, board);
        }
        board[start][end] = res;
        return res;
    }
}
