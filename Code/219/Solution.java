class Solution {
    // Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    //
    // Example 1:
    //
    // Input: nums = [1,2,3,1], k = 3
    // Output: true
    // Example 2:
    //
    // Input: nums = [1,0,1,1], k = 1
    // Output: true
    // Example 3:
    //
    // Input: nums = [1,2,3,1,2,3], k = 2
    // Output: false

    // first idea k*n solution
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int left = 0; left<nums.length-1; left ++) {
            int low = Math.min(left+k, nums.length-1);
            for(int i=left+1; i<=low; i++) {
                if(nums[i] == nums[left]) return true;
            }
        }
        return false;
    }

    // HashMap..
}
