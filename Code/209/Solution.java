class Solution {
    // Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
    //
    // Example:
    //
    // Input: s = 7, nums = [2,3,1,2,4,3]
    // Output: 2
    // Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    // Follow up:
    // If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

    // first idea two ptrs
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        while(end != nums.length-1 || sum>=s) {
            if(sum >= s) {
                min = Math.min(end-start+1, min);
                sum -= nums[start++];
            } else {
                sum += nums[++end];
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}
