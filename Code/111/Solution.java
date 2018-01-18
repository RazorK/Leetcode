class Solution {
    // Given a binary tree, find its minimum depth.
    //
    // The minimum depth is the number of nodes along the shortest path from the
    // root node down to the nearest leaf node.

    // BUG: as usually, I try the recursion, but we have to change a little in this problem.
    //  We have to view this problem carefully.
    //  If one node have only one child, then the other branch will make our answer wrong.
    //  So we have to stop the recursion once we get a leaf node.

    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        minDepth(root, 1);
        return min;
    }
    public void minDepth(TreeNode root, int level) {
        if(root.left == null && root.right == null) {
            min = Math.min(min, level);
        }
        //BUG forget to check the null that input to the next recursion.
        if(root.left!=null)
            minDepth(root.left, level+1);
        if(root.right!=null)
            minDepth(root.right, level+1);
    }
}
