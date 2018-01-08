class Solution {
    // Given a set of distinct integers, nums, return all possible subsets (the power set).
    //
    // Note: The solution set must not contain duplicate subsets.
    //
    // For example,
    // If nums = [1,2,3], a solution is:
    //
    // [
    //   [3],
    //   [1],
    //   [2],
    //   [1,2,3],
    //   [1,3],
    //   [2,3],
    //   [1,2],
    //   []
    // ]

    // QUESTION can nums have duplicate numbers?

    // assume answer is no.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<=nums.length; i++) {
            insert(i, result, nums);
        }
        return result;
    }

    // get all the lists of size k and insert them into result.
    public void insert(int k, List<List<Integer>> result, int[] nums) {
        if(k == 0) {
            result.add(new ArrayList<Integer>());
            return;
        }
        dfs(result, new ArrayList<Integer>(), nums, 0, k);
    }

    public void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, int start, int left) {
        if(left == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            dfs(result, current, nums, i+1, left - 1);
            current.remove(current.size()-1);
        }
    }


    // without using dfs.
    // dp idea.
    // s(nums) = s(nums - 1) + s((nums-1).add(1))
    // get from leetcode
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (nums == null || nums.length == 0) return res;
      res.add(new ArrayList());
      int len  =  nums.length;
      for (int i = 0; i < len; i++){
          int size  =  res.size();
          for (int j = 0; j < size; j++){
              ArrayList<Integer>  temp  = new ArrayList<Integer>(res.get(j));
              temp.add(nums[i]);
              res.add(temp);
          }
      }
      return res;
  }
}
