class Solution {
    // You are climbing a stair case. It takes n steps to reach to the top.
    //
    // Each time you can either climb 1 or 2 steps. In how many distinct ways can
    // you climb to the top?
    //
    // Note: Given n will be a positive integer.
    //
    //
    // Example 1:
    //
    // Input: 2
    // Output:  2
    // Explanation:  There are two ways to climb to the top.
    //
    // 1. 1 step + 1 step
    // 2. 2 steps
    // Example 2:
    //
    // Input: 3
    // Output:  3
    // Explanation:  There are three ways to climb to the top.
    //
    // 1. 1 step + 1 step + 1 step
    // 2. 1 step + 2 steps
    // 3. 2 steps + 1 step

    // DP may solve this, just try.
    public int climbStairs(int n) {
        if(n<=3) return n;
        int [] board = new int[n];
        board[0] = 1;
        board[1] = 2;
        for(int i=2; i<n; i++) {
            board[i] = board[i-1] + board[i-2];
        }
        return board[n-1];
    }

    // still we can simplify the dp solution.
    // we don't really need such a big board
    // didn't make result any quicker
    // maybe because the faster results are just eariler version of problem.
    // but why keep these results.
    public int simplifyDP(int n) {
        if(n<=3) return n;
        int pre1 = 1, pre2 = 2;
        int result = 0;
        for(int i = 2; i<n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    // still the problem can be solved by dfs
    // time limit exceed...
    public int dfs(int n) {
        if(n<=3) return n;
        return dfs(n-2) + dfs(n-1);
    }
}
