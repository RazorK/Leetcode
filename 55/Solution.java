class Solution {
    // Given an array of non-negative integers, you are initially positioned at the
    // first index of the array.
    //
    // Each element in the array represents your maximum jump length at that position.
    //
    // Determine if you are able to reach the last index.
    //
    // For example:
    // A = [2,3,1,1,4], return true.
    //
    // A = [3,2,1,0,4], return false.

    // linear idea
    public boolean canJump(int[] nums) {
        int start = 0;
        int max = 0;
        while(true) {
            int temp_max = 0;
            for(int i=start; i<=max; i++) {
                if(nums[i]+i>temp_max) temp_max = nums[i] + i;
            }
            if(temp_max>=nums.length-1) return true;
            if(temp_max<=start) return false;
            start = max;
            max = temp_max;
        }
    }

    // faster, still linear..
    public boolean canJump_faster(int[] nums) {
       if(nums == null)
           return false;
       // idea of divide and conquer, just convert the problem into a sub problem
       int lastPos = nums.length -1;
       for(int i = nums.length - 2; i>=0; i--) {
           if(i + nums[i] >= lastPos) {
               lastPos = i;
           }
       }
       return lastPos == 0;
   }

}
