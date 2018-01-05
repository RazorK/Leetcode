class Solution {
    // Given an integer n, generate a square matrix filled with elements from 1
    // to n2 in spiral order.
    //
    // For example,
    // Given n = 3,
    //
    // You should return the following matrix:
    // [
    //  [ 1, 2, 3 ],
    //  [ 8, 9, 4 ],
    //  [ 7, 6, 5 ]
    // ]
    public int[][] generateMatrix(int n) {
        if(n==0) return new int[0][0];
        int [][] board = new int[n][n];
        int start = 0, end = n-1;
        int counter = 1;
        while(start <= end) {
            if(start == end) {
                board[start][start] = counter;
                break;
            }
            for(int i = start; i<end; i++)
                board[start][i] = counter++;
            for(int i = start; i<end; i++)
                board[i][end] = counter++;
            for(int i = end; i>start; i--)
                board[end][i] = counter++;
            for(int i = end; i>start; i--)
                board[i][start] = counter++;
            start ++;
            end --;
        }
        return board;
    }
}
