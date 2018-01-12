import java.util.*;
class Solution {
    // Given a collection of integers that might contain duplicates, nums, return
    // all possible subsets (the power set).
    //
    // Note: The solution set must not contain duplicate subsets.
    //
    // For example,
    // If nums = [1,2,2], a solution is:
    //
    // [
    //   [2],
    //   [1],
    //   [1,2,2],
    //   [2,2],
    //   [1,2],
    //   []
    // ]

    // The main problem is to avoid duplicates.
    // first idea use dp.
    // idea:
    //  basic: subset(n) = subset(n-1) + convert(nums[n], subset(n-1))
    // if the nums[n] = nums[n-1], only add nums[n] to the list nums[n-1] added.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        List<List<Integer>> pre = new ArrayList<>();
        result.add(empty);
        boolean flag = false;
        for(int i=0; i<nums.length; i++){
            if(i!=0 && nums[i] == nums[i-1]) {
                int l = pre.size();
                for(int j=0; j<l; j++) {
                    List<Integer> temp = new ArrayList(pre.get(j));
                    temp.add(nums[i]);
                    pre.add(temp);
                    result.add(temp);
                }
                pre.subList(0, l).clear();
                // BUG here we also have to track pre.
                // pre.clear();
            } else {
                // BUG forget to add clear here..
                pre.clear();
                if(i!=nums.length-1 && nums[i]==nums[i+1]) flag = true;
                else flag = false;
                for(int j=result.size()-1; j>=0; j--) {
                    List<Integer> temp = new ArrayList(result.get(j));
                    temp.add(nums[i]);
                    if(flag) pre.add(temp);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    // Get from leetcode.
    // great because simple. But not easy enough to think of or remember I think...
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> list, ArrayList<Integer> temlist, int[] nums, int pos){
        list.add(new ArrayList<Integer>(temlist));
        for (int i = pos; i < nums.length; i++){
            // NOTE here is what make the function works
            // why this work?
            //  Firstly, if there are no duplicates the function works. DFS idea.
            //  the duplicate problems are processed when i == pos.
            if (i > 0 && i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            temlist.add(nums[i]);
            helper(list,  temlist , nums, i + 1);
            temlist.remove(temlist.size() - 1);
        }
    }
}
