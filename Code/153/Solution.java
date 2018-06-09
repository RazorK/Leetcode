class Solution {
    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    //
    // (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
    //
    // Find the minimum element.
    //
    // You may assume no duplicate exists in the array.
    //
    // Example 1:
    //
    // Input: [3,4,5,1,2]
    // Output: 1
    // Example 2:
    //
    // Input: [4,5,6,7,0,1,2]
    // Output: 0

    // binary search, it's easy to judge whether we exceed the minimum
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int x = helper(nums, 0, nums.length-1);
        return x == -1? nums[0] : nums[x];
    }

    public int helper(int [] nums, int start, int end) {
        if(end <= start) return start;
        if(end == start + 1) {
            if(nums[end] > nums[start]) return -1;
            else return end;
        }
        int mid = start + (end - start)/2;
        if(nums[start] > nums[mid]) {
            return helper(nums, start, mid);
        } else {
            return helper(nums, mid, end);
        }
    }
}
