import java.util.*;
class Solution {
    // According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
    //
    // Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
    //
    // Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    // Any live cell with two or three live neighbors lives on to the next generation.
    // Any live cell with more than three live neighbors dies, as if by over-population..
    // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    // Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
    //
    // Example:
    //
    // Input:
    // [
    //   [0,1,0],
    //   [0,0,1],
    //   [1,1,1],
    //   [0,0,0]
    // ]
    // Output:
    // [
    //   [0,0,0],
    //   [1,0,1],
    //   [0,1,1],
    //   [0,1,0]
    // ]
    // Follow up:
    //
    // Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    // In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        int [][] tempBoard = new int[m][n];
        for(int i=0; i<m; i++) {
            tempBoard[i] = Arrays.copyOf(board[i], n);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(tempBoard[i][j] == 0) {
                    if(getNum(tempBoard, i, j) == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    int cur = getNum(tempBoard, i, j);
                    if(cur<2 || cur>3) board[i][j] = 0;
                    else board[i][j] = 1;
                }
            }
        }
    }

    public int getNum(int [][] board, int x, int y) {
        int[] list = new int[] {-1, 0, 1};
        int count = 0;
        for(int i : list) {
            for(int j: list ) {
                if(i==0 && j==0) continue;
                int newX = x+i, newY = y+j;
                if(newX<0 || newX >= board.length || newY<0 || newY >= board[0].length) continue;
                if(board[newX][newY] == 1) count++;
            }
        }
        return count;
    }

    //TODO: inplace?
}
