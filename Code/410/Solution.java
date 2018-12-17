    class Solution {
        public int splitArray(int[] nums, int m) {
            int [][] board = new int [m][nums.length];

            // try accu
            int [] acc = new int [nums.length];
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                sum += nums[i];
                acc[i] = sum;
            }

            // initialize the board
            sum = 0;
            for(int i=0; i<nums.length; i++) {
                sum += nums[i];
                board[0][i] = sum;
            }

            for(int i=1; i<m; i++) {
                for(int j=i; j<nums.length; j++) {
                    int min = Integer.MAX_VALUE;
                    for(int k = i-1; k<j; k++) {
                        min = Math.min(min, Math.max(board[i-1][k], acc[j] - acc[k]));
                    }
                    board[i][j] = min;
                }
            }

            return board[m-1][nums.length-1];
        }
    } 