class Solution {

    // first idea: try the same method as the first problem
    // keep two max, seems need to run three times the first solution

    // after viewing the answers, it seems two times are enough...
    // 0 to nums.length -2 , 1 to nums.length-1
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int choice1 = nums[0] + helper(nums, 2, nums.length-2);
        int choice2 = nums[nums.length-1] + helper(nums, 1, nums.length-3);
        int choice3 = helper(nums, 1, nums.length-2);
        return Math.max(Math.max(choice1, choice2), Math.max(choice2, choice3));
    }

    public int helper(int[] nums, int start, int end) {
        if(nums == null || end < start) return 0;
        int withCurMax = 0, withoutCurMax = 0;
        for(int i=start; i<=end; i++) {
            int num = nums[i];
            int newWith, newWithout;
            newWithout = Math.max(withCurMax, withoutCurMax);
            newWith = withoutCurMax + num;
            withCurMax = newWith;
            withoutCurMax = newWithout;
        }
        return Math.max(withCurMax, withoutCurMax);
    }
}
