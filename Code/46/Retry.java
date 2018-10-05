class Solution {
    // Given a collection of distinct integers, return all possible permutations.
    public List<List<Integer>> permute(int[] nums) {
        //dfs visited
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, res, new int[nums.length], new boolean[nums.length], 0);
        return res;
    }

    public void dfs(int [] nums, List<List<Integer>> res, int [] cur, boolean [] flag, int index) {
        if(index == nums.length) {
            res.add(getList(cur));
        }
        for(int i=0; i<cur.length; i++) {
            if(flag[i] == true) continue;
            cur[i] = nums[index];
            flag[i] = true;
            dfs(nums, res, cur, flag, index+1);
            flag[i] = false;
        }
    }

    public List<Integer> getList(int [] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums) {
            res.add(num);
        }
        return res;
    }
}