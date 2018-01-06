class Solution {
    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    //
    // Integers in each row are sorted from left to right.
    // The first integer of each row is greater than the last integer of the previous row.
    // For example,
    //
    // Consider the following matrix:
    //
    // [
    //   [1,   3,  5,  7],
    //   [10, 11, 16, 20],
    //   [23, 30, 34, 50]
    // ]
    // Given target = 3, return true.

    // First Idea, just binary search twice.
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0, right = matrix.length - 1;
        int start = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] > target){
                right = mid -1;
            } else {
                start = mid;
                if(mid + 1 == matrix.length || matrix[mid + 1][0] > target)
                    break;
                left = mid + 1;
            }
        }

        // binary for existance
        left = 0; right = matrix[0].length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(matrix[start][mid] == target) return true;
            if(matrix[start][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // another idea, just use binary search once, and the problem is handle the order
    // get from leetcode
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            // NOTE here is the idea how to get the number by the index.
            int number = matrix[mid / column][mid % column];
            
            if(number == target){
                return true;
            }else if(number > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;

    }
}
