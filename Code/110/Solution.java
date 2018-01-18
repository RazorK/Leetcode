import java.util.*;

class Solution {
    // Given a binary tree, determine if it is height-balanced.
    //
    // For this problem, a height-balanced binary tree is defined as a binary tree
    // in which the depth of the two subtrees of every node never differ by more than 1.

    // BUG make a mistake in understanding the problem.
    // NOTE not all path, just the depth of two subtrees. Still not sure the meaning of depth,
    //  try to do it as the meaning of maximum depth
    public boolean isBalanced(TreeNode root) {
        return getDepth(root, 0, new int[1]);
    }

    // this seems require return two values in recursion, so I try to use depth array here.
    public boolean getDepth(TreeNode root, int level, int [] depth) {
        if(root == null) {
            depth[0] = Math.max(depth[0], level);
            return true;
        }
        int [] input = new int[1];
        boolean left = getDepth(root.left, level, input);
        int leftd = input[0];
        input[0] = 0;
        boolean right = getDepth(root.right, level, input);
        int rightd = input[0];
        // BUG forget to return the depth.
        depth[0] = Math.max(leftd, rightd) + 1;
        return left && right && (leftd - rightd) >= -1 && (leftd -rightd) <=1;
    }

    // NOTE idea from LC
    // use -1 as default replace the boolean result above, so we don't need to pass
    // two values for each recursion.
    public boolean ideaFromLC(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
}
