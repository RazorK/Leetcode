class Solution {
    // Given a binary tree, determine if it is a valid binary search tree (BST).
    //
    // Assume a BST is defined as follows:
    //
    // The left subtree of a node contains only nodes with keys less than the node's key.
    // The right subtree of a node contains only nodes with keys greater than the node's key.
    // Both the left and right subtrees must also be binary search trees.
    // Example 1:
    //     2
    //    / \
    //   1   3
    // Binary tree [2,1,3], return true.
    // Example 2:
    //     1
    //    / \
    //   2   3
    // Binary tree [1,2,3], return false.

    //dfs recursion
    //BUG: Still the binary search tree bug
    // the children of right node also needs to follow the restriction.
    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }

    public boolean dfs(TreeNode root, long leftLimit, long rightLimit) {
        if(root == null) return true;
        // BUG here we should handle min_value and max_value problem
        // still the Solution are all use the type with larger capacity...
        if(root.val <= leftLimit || root.val >= rightLimit) return false;
        return dfs(root.left, leftLimit, root.val) && dfs(root.right, root.val, rightLimit);
    }
}
