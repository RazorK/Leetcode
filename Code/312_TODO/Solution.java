class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int [][] board = new int[len][len];

        for(int i=0; i<len;i++) {
            board[i][i] = nums[i];
        }

        for(int i=1; i<len; i++) {
            for(int j=0; i + j < len; j++) {
                // set each value in the board
                int x = i + j;
                int y = j;
                // traverse the window
                int max = Integer.MIN_VALUE;
                for(int k=x; k<=y ;k++) {
                    int can = 0;
                    if(k == x) {
                        can = 
                    }
                }
            }
        }
    }
}