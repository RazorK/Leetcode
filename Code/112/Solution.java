class Solution {
    // Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    //
    // For example:
    // Given the below binary tree and sum = 22,
    //               5
    //              / \
    //             4   8
    //            /   / \
    //           11  13  4
    //          /  \      \
    //         7    2      1
    // return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    boolean target = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        // BUG here  we should ask if root == null && sum == 0, what should be the result?
        // From LC, the result should be false;
        if(root == null) return false;
        dfs(root, 0, sum);
        return target;
    }

    public void dfs(TreeNode root, int cur, int tar) {
        cur += root.val;
        if(root.left == null && root.right == null) {
            if(cur == tar) target = true;
        }
        if(root.left!=null) dfs(root.left, cur, tar);
        if(root.right!=null) dfs(root.right, cur, tar);
    }
}
