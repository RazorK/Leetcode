class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return board;
        dfs(board, x, y);
        return board;
    }

    public void dfs(char [][] board, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        char cur = board[x][y];
        if(cur == 'M') {
            board[x][y] = 'X';
            return;
        } else if(cur == 'E') {
            int num = isDigit(board, x, y);
            if(num != 0) board[x][y] = (char) (num + '0');
            else {
                board[x][y] = 'B';
                int [] ar = new int[] {-1, 0, 1};
                for(int i: ar) {
                    for(int j: ar) {
                        if(i == 0 && j==0) continue;
                        dfs(board, x+i, y+j);
                    }
                }
            }
        }
    }

    public int isDigit(char[][]board, int x, int y) {
        int [] a = new int [] {-1, 0, 1};
        int res = 0;
        for(int i: a) {
            for(int j: a) {
                if(i == 0 && j == 0) continue;
                int m = x + i, n = y + j;
                if(m < 0 || m >= board.length || n < 0 || n >= board[0].length) continue;
                if(board[m][n] == 'M') res++;
            }
        }
        return res;
    }
}