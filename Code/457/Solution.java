class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int pre = 0;
        while(true) {
            int cur = Math.abs(nums[pre] % nums.length);
            if(cur == pre) return false;
            else {
                if(nums[cur] == 0) return true;
                nums[pre] = 0;
                pre = nums[cur];
            }
        }
    }
}