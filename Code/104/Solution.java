class Solution {
    // Given a binary tree, find its maximum depth.
    //
    // The maximum depth is the number of nodes along the longest path from the
    // root node down to the farthest leaf node.

    // by recur
    // first idea, use global variable.
    int max = 0;
    public int maxDepth(TreeNode root) {
        helper(root, 0);
        return max;
    }

    public void helper(TreeNode root, int d) {
        if(root == null) {
            if(d>max) max = d;
            // BUG miss return statement here.
            return;
        }
        helper(root.left, d+1);
        helper(root.right, d+1);
    }
}
