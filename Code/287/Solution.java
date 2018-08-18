class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) return nums[i];
            }
        }
        return 0;
    }


    // inspired by LC, the same as find loop in linkedlist
    public int LC(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
