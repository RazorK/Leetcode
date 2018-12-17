import java.util.Arrays;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int l = nums.length;
        int [][] max = new int [l][l];

        int [] acc = new int[l];
        int sum = 0;
        for(int i=0; i<l; i++) {
            sum += nums[i];
            acc[i] = sum;
        }

        for(int i=0; i<l; i++) {
            for(int j=0; i+j < l; j++) {
                int x = j, y = i+j;
                if(i == 0) {
                    max[x][y] = nums[x];
                } else {
                    max[x][y] = Math.max(nums[x] + getSum(acc, x+1, y) - max[x+1][y]
                        , nums[y] + getSum(acc, x, y-1) - max[x][y-1]);
                }
            }
        }

        return max[0][l-1] >= acc[l-1] - max[0][l-1];
    }

    public int getSum(int [] acc, int x, int y) {
        if(x == 0) return acc[y];
        return acc[y] - acc[x-1];
    }
}