import java.util.*;
class Solution {
    // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //
    // For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    //
    //     1
    //    / \
    //   2   2
    //  / \ / \
    // 3  4 4  3
    // But the following [1,2,2,null,3,null,3] is not:
    //     1
    //    / \
    //   2   2
    //    \   \
    //    3    3
    // Note:
    // Bonus points if you could solve it both recursively and iteratively.

    // try recusion first
    public boolean byRecur(TreeNode root) {
        if(root == null) return true;
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    // try iteratively
    // first idea in order traverse
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        Stack<TreeNode> leftSt = new Stack<>();
        Stack<TreeNode> rightSt = new Stack<>();

        // traverse leftChildren
        // BUG 1 or here rather than and..
        while(left != null || leftSt.size()!=0) {
            if(left != null) {
                if(right == null) return false;
                leftSt.push(left);
                left = left.left;
                rightSt.push(right);
                right = right.right;
                continue;
            }
            if(right != null) return false;
            left = leftSt.pop();
            right = rightSt.pop();
            if(left.val != right.val) return false;
            left = left.right;
            right = right.left;
        }
        // BUG forget last right check..
        if(right != null) return false;
        return true;
    }
}
