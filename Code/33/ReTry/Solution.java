class Solution {
    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    //
    // (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    //
    // You are given a target value to search. If found in the array return its index, otherwise return -1.
    //
    // You may assume no duplicate exists in the array.

    // first try linear
    public int linear(int[] nums, int target) {
        for(int i=0; i< nums.length; i++) {
            if(target == nums[i]) return i;
        }
        return -1;
    }

    // try binary
    // get from leetcode..
    // NOTE based on the property that at most one break will be in the range,
    //  and if there is a break, the left part will always larger than the right part.
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            // to avoid problem, the idea here is we must decrese the range.
            // NOTE to solve this problem in log time, start from judge nums[mid] and nums[right]
            //  not sure why to think this way, but it works.
            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if(nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
