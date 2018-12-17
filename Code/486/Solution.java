class Solution {
    // min max recursive
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length-1, 0, 0, true);
    }

    public boolean dfs(int [] nums, int left, int right, int p1, int p2, boolean f) {
        if(left == right) {
            if(f) return p1 + nums[left] >= p2; else return p1 + nums[left] > p2;
        }

        return !dfs(nums, left + 1, right, p2, p1+nums[left], !f) || !dfs(nums, left, right - 1, p2, p1+nums[right], !f);
    }
}