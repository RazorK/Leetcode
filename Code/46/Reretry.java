class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new HashSet<>(), new ArrayList<>(), res);
        return res;
    }

    public void dfs(int [] nums, Set<Integer> visited, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                cur.add(nums[i]);
                dfs(nums, visited, cur, res);
                cur.remove(cur.size()-1);
                visited.remove(i);
            }
        }
    }
}