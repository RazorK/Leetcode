import java.util.*;

class Solution {
    // The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    //
    // Given an integer n, return all distinct solutions to the n-queens puzzle.
    //
    // Each solution contains a distinct board configuration of the n-queens' placement,
    // where 'Q' and '.' both indicate a queen and an empty space respectively.
    //
    // For example,
    // There exist two distinct solutions to the 4-queens puzzle:
    //
    // [
    //  [".Q..",  // Solution 1
    //   "...Q",
    //   "Q...",
    //   "..Q."],
    //
    //  ["..Q.",  // Solution 2
    //   "Q...",
    //   "...Q",
    //   ".Q.."]
    // ]

    // First idea: DFS, use char array to implement
    // Still Time Limit Exceed.
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result  = new ArrayList<>();
        if(n==0) return result;

        // init List
        char [][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        dfsHelper(board, 0, n, result, 0, 0);

        // BUG: miss return statement
        return result;
    }

    public static void dfsHelper(char [][] board, int n, int target, List<List<String>> result, int row, int col) {
        if(n==target) {
            List<String> t_result = new ArrayList<>();
            for(int i=0; i< target; i++) {
                String temp = getStr(board[i]);
                t_result.add(temp);
            }
            result.add(t_result);
            return;
        }
        for(int i=row; i< target; i++) {
            for(int j = 0; j < target; j++) {
                // BUG: cannot add equal to col here
                if(i==row&&j<col) continue;
                if(board[i][j] == '0' || board[i][j] == 'Q')
                    continue;

                // BUG: no clone funtion?
                // NOTE && BUG: here we should use deep copy rather than shallow copy of List
                //List<List<Character>> temp = deepCopy(list, target);
                char [][] temp = new char[target][target];

                // BUG: deep copy here.
                //System.arraycopy(board, 0, temp, 0, target);
                deepCopy(board, temp, target);

                // BUG: forget to add  inclined flags
                // BUG: forget to check whether the point is valid or not
                // BUG: duplicate problem
                for(int x = 0; x<target; x++) {
                    if(temp[i][x] == 'Q') continue;
                    temp[i][x] = '0';
                    if(temp[x][j] == 'Q') continue;
                    temp[x][j] = '0';
                }
                // add inclined flags
                for(int z = 0; z<4; z++) {
                    int x = i, y = j;
                    while(true) {
                        // x++, y--; x--, y--; x++, y++; x--, y++;
                        x = z%2==0? x+1: x-1;
                        y = z/2==1? y+1: y-1;
                        if(x>=target||y>=target|| x<0 || y<0) break;
                        if(temp[x][y] == 'Q') continue;
                        temp[x][y] = '0';
                    }
                }
                temp[i][j] = 'Q';
                dfsHelper(temp, n+1, target, result, i, j);
            }
        }
    }

    public static String getStr(char [] board) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++) {
            char c = board[i];
            if(c=='0') sb.append('.');
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void deepCopy(char [][] board1, char [][] board2, int target) {
        for(int i=0; i<target; i++) {
            System.arraycopy(board1[i], 0, board2[i], 0, target);
        }
    }
}
