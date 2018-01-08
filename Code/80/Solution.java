class Solution {
    // Follow up for "Remove Duplicates":
    // What if duplicates are allowed at most twice?
    //
    // For example,
    // Given sorted array nums = [1,1,1,2,2,3],
    //
    // Your function should return length = 5, with the first five elements of nums
    // being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int len = 1, counter = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                counter ++;
                if(counter<=1)  {
                    nums[len] = nums[i];
                    len++;
                }
            } else {
                counter = 0;
                // BUG forget to add to array here...
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
