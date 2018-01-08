class Solution {
    // Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
    //
    // Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    //
    // Example:
    //
    // Given nums = [1,1,2],
    //
    // Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    // It doesn't matter what you leave beyond the new length.

    // first idea two ptrs.
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow = 1, fast = 1;
        int temp = nums[0];
        while(fast<nums.length) {
            if(nums[fast] == temp) {
                fast++;
                continue;
            } else {
                temp = nums[fast];
                if(slow!=fast) {
                    swap(nums, fast, slow);
                }
                fast++;
                slow++;
            }
        }
        return slow;
    }

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // to minimize the visit of Array
    public int new_removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow = 1, fast = 1;
        int temp = nums[0];
        while(fast<nums.length) {
            if(nums[fast] == temp) {
                fast++;
                continue;
            } else {
                temp = nums[fast];
                if(slow!=fast) {
                    nums[slow] = nums[fast];
                }
                fast++;
                slow++;
            }
        }
        return slow;
    }

    // another idea from leetcode.
    // just check new values and put it to array.
    public int new_idea(int[] nums) {
        if(nums.length<=1) return nums.length;
        int len = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                if(i!= len)
                    nums[len] = nums[i];
                len ++;
            }
        }
        return len;
    }
}
