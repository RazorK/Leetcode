import java.util.*;
class Solution {
    // Given a m x n matrix, if an element is 0, set its entire row and column
    // to 0. Do it in place.

    // already checked the answer
    // NOTE: main idea is to make use of useless space
    // NOTE: the first row and first col must save for the last to process
    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0|| matrix[0].length ==0) return;
        // NOTE: here we should notice the first row and column.
        boolean f_row = false, f_col = false;
        int conserve = matrix[0][0];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    if(i==0) f_row = true;
                    if(j==0) f_col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        matrix[0][0] = conserve;
        //System.out.println(Arrays.deepToString(matrix));
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == 0)
                setLineZero(matrix, i, true);
        }
        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0)
                setLineZero(matrix, j, false);
        }
        // BUG: f_row and f_col must leave for the last to process
        if(f_row) setLineZero(matrix, 0, true);
        if(f_col) setLineZero(matrix,0, false);
    }

    public static void setLineZero(int[][] matrix, int index, boolean row) {
        //System.out.println(Arrays.deepToString(matrix));
        int l = row? matrix[0].length : matrix.length;
        for(int i=0; i<l; i++) {
            if(row) {
                matrix[index][i] = 0;
            } else {
                matrix[i][index] = 0;
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
    }
}
