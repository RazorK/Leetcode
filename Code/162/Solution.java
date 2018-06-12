class Solution {
    // A peak element is an element that is greater than its neighbors.
    //
    // Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
    //
    // The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
    //
    // You may imagine that nums[-1] = nums[n] = -∞.
    //
    // Example 1:
    //
    // Input: nums = [1,2,3,1]
    // Output: 2
    // Explanation: 3 is a peak element and your function should return the index number 2.
    // Example 2:
    //
    // Input: nums = [1,2,1,3,5,6,4]
    // Output: 1 or 5
    // Explanation: Your function can return either index number 1 where the peak element is 2,
    //              or index number 5 where the peak element is 6.
    // Note:
    //
    // Your solution should be in logarithmic complexity.

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;

        return helper(nums, 0, nums.length-1);

    }

    public int helper(int [] nums, int left, int right) {
        if(left > right) return -1;
        if(left == right) {
            if(left-1<0 || nums[left] > nums[left-1] )
                if(left + 1>=nums.length || nums[left] > nums[left + 1])
                    return left;
            return -1;
        }
        int mid = left + (right - left)/2;
        int start = mid-1, end = mid+1;

        if(start < 0 || nums[start] < nums[mid]) {
            // 3 5
            if(end>=nums.length || nums[end] < nums[mid]) {
                //3 5 3
                return mid;
            } else {
                // 3 5 7
                return helper(nums, mid + 1, right);
            }
        } else {
            // 5 3
            if(end>=nums.length || nums[end] < nums[mid]) {
                // 5 3 1
                return helper(nums, left, mid-1);
            } else {
                int x = helper(nums, left, mid -1), y = helper(nums, mid+1, right);
                if(x!=-1) return x;
                if(y!=-1) return y;
                return -1;
            }
        }
    }

    public int fromLC(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) return mid;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
