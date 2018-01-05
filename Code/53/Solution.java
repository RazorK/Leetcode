class Solution {

    // Question :
    // Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    // For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    // the contiguous subarray [4,-1,2,1] has the largest sum = 6.

    // Taught on Algorithm class.
    //  Firstly try the taught method.
    //  Scan for one time, and keep the value which means the max subarray end by the index
    // BUG:
    //  remember to ask whether choose nothing is also a subarray.
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;

        // in this problem, choose nothing is not subarray, so we have to
        // start from MIN_VALUE
        int max = Integer.MIN_VALUE;
        int max_end = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(max_end<=0) {
                max_end = nums[i];
            } else {
                max_end = nums[i] + max_end;
            }
            if(max_end > max) max = max_end;
        }
        return max;
    }
}
