class Solution {
    // Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    //
    // Note:
    //
    // All numbers will be positive integers.
    // The solution set must not contain duplicate combinations.
    // Example 1:
    //
    // Input: k = 3, n = 7
    // Output: [[1,2,4]]
    // Example 2:
    //
    // Input: k = 3, n = 9
    // Output: [[1,2,6], [1,3,5], [2,3,4]]
    
    // dfs
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, k, n, new ArrayList<Integer>(), 0, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, int k, int n, List<Integer> cur, int curSum, int curNum) {
        if(cur.size() == k) {
            if(curSum == n)
                res.add(new ArrayList(cur));
            return;
        }
        for(int i=curNum; i<=10-(k-cur.size()); i++) {
            cur.add(i);
            helper(res, k, n, cur, curSum+i, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
