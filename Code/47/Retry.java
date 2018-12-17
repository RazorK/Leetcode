
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean [] v = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), v);
        return res;
    }

    public void dfs(int [] nums, List<List<Integer>> res, List<Integer> cur, boolean [] visited) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(i!= 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            if(!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                dfs(nums, res, cur, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}