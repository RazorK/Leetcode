import java.util.Arrays;

class Solution {
    // not considering complexity first. As 9*9 is a constant-complexity input
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char [][] board) {
        // BUG1 forget to check whether finished here
        if(checkFinish(board)) return true;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') continue;
                for(int t=1; t<=9; t++) {
                    if(check(board, i, j, t)) {
                        //System.out.println(i+ "," + j);
                        board[i][j] = (char)(t + '0');
                        if(solve(board)) return true;
                        board[i][j] = '.';
                    }
                }
                // BUG2 should return false here, rather than outer loop
                return false;
            }
        }
        return false;
    }

    public static boolean check(char [][] board, int x, int y, int num) {
        if(board[x][y] != '.') return false;
        int x_s = start(x), y_s = start(y);
        for(int i = 0; i<9; i++) {
            if(num == board[i][y] - '0') return false;
            if(num == board[x][i] - '0') return false;
            if(num == board[x_s + i/3][y_s + i%3] - '0') return false;
        }
        return true;
    }

    public static boolean checkFinish(char [][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') return false;
            }
        }
        return true;
    }

    public static int start(int x) { return x - x%3; }

    public static void main(String [] args) {
        char [][] in = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(in);
        System.out.println(Arrays.deepToString(in));
    }
}