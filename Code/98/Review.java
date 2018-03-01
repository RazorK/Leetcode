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

    // recursive
    // Still the BUG. have to pass the max value and min value along the way.
    public boolean isValidBST(TreeNode root) {
        return validateRange(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean validateRange(TreeNode root, int max, int min) {
        if(root == null) return true;
        if(root.val<min || root.val > max) return false;
        return validateRange(root.left, root.val-1, min) && validateRange(root.right, max, root.val+1);
    }
}
