import java.util.*;
class Solution {
    // Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
    //
    // For example, given the following matrix:
    //
    // 1 0 1 0 0
    // 1 0 1 1 1
    // 1 1 1 1 1
    // 1 0 0 1 0
    // Return 6.

    // first idea try dp.
    // board catch the height and width of the max rectangle ending at this point
    // worst case n^3.
    // temp give up
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int [][][] board = new int[h][w][2];
        int count = 0;
        // init
        for(int i=0; i<h; i++) {
            if(matrix[i][0] == '1'){
                setHW(board, i, 0, 1, ++count);
            } else {
                count = 0;
                setHW(board, i, 0, 0, count);
            }
        }
        count = 0;
        for(int i=0; i<w; i++) {
            if(matrix[0][i] == '1') {
                setHW(board, 0, i, ++count, 1);
            } else {
                count = 0;
                setHW(board, 0, i, count, 0);
            }
        }
        System.out.println(Arrays.deepToString(board));
        // expand board
        for(int i=1; i<h; i++) {
            for(int j=1; j<w; j++) {
                if(matrix[i][j] == '0')
                    setHW(board, i, j, 0, 0);
                else {
                    setHW(board, i, j, Math.min(board[i-1][j][0], board[i-1][j-1][0])+1, Math.min(board[i][j-1][1], board[i-1][j-1][1])+1);
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
        int max = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                max = Math.max(max, board[i][j][0] *board[i][j][1]);
            }
        }
        return max;
    }

    void setHW(int [][][] board, int i, int j, int w, int h) {
        board[i][j][0] = w;
        board[i][j][1] = h;
    }
}
