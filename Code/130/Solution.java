import java.util.*;
class Solution {
    // Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
    //
    // A region is captured by flipping all 'O's into 'X's in that surrounded region.
    //
    // For example,
    // X X X X
    // X O O X
    // X X O X
    // X O X X
    // After running your function, the board should be:
    //
    // X X X X
    // X X X X
    // X X X X
    // X O X X

    // IDEA dfs to find connection
    // Bug Free! lol
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(boolean [] row: visited) {
            Arrays.fill(row, false);
        }
        for(int i=0; i<board.length; i++) {
            connect(board, visited, i, 0);
            connect(board, visited, i, board[0].length-1);
        }
        for(int i=0; i<board[0].length; i++) {
            connect(board, visited, 0, i);
            connect(board, visited, board.length-1, i);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length-1; j++) {
                if(board[i][j] == 'O' && visited[i][j] == false)
                    board[i][j] = 'X';
            }
        }
    }

    // this function transform all nodes conneted with (row, col) in visited to true.
    public void connect(char[][] board, boolean [][] visited, int row, int col) {
        if(row>=board.length || col>= board[0].length || row<0 || col<0) return;
        if(visited[row][col] == true) return;
        if(board[row][col] != 'O') return;
        visited[row][col] = true;
        connect(board, visited, row+1, col);
        connect(board, visited, row-1, col);
        connect(board, visited, row, col+1);
        connect(board, visited, row, col-1);
    }
}
