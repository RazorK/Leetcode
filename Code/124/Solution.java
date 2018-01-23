class Solution {
    // Given a binary tree, find the maximum path sum.
    //
    // For this problem, a path is defined as any sequence of nodes from some starting
    // node to any node in the tree along the parent-child connections. The path must
    // contain at least one node and does not need to go through the root.
    //
    // For example:
    // Given the below binary tree,
    //
    //        1
    //       / \
    //      2   3
    // Return 6.

    // QUESTION: can the treenode contains negtive numbers?
    // assume yes.

    // copy a tree, which remember the longest path from the node to leaf.
    // seems encountered this on Algorithm course.
    // BUG the problem points out that the path have at least one node...
    public int maxPathSum(TreeNode root) {
        TreeNode newroot = copyTree(root);
        calSinglePath(newroot, root);
        int [] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        traverse(newroot, root, max);
        return max[0];
    }

    public void traverse(TreeNode root, TreeNode ori ,int [] max) {
        if(root == null) return;
        int left = 0, right = 0;
        if(root.left != null) left = (root.left.val>0? root.left.val:0);
        if(root.right != null) right = (root.right.val>0? root.right.val:0);
        int res = ori.val + left + right;
        max[0] = Math.max(max[0], res);
        traverse(root.left, ori.left, max);
        traverse(root.right, ori.right, max);
    }

    public void calSinglePath(TreeNode path, TreeNode ori) {
        if(path == null) return;
        calSinglePath(path.left, ori.left);
        calSinglePath(path.right, ori.right);
        int res = ori.val;
        int left = 0, right = 0;
        if(path.left!=null) left = path.left.val;
        if(path.right!=null) right = path.right.val;
        int max = Math.max(left, right);
        path.val = res + (max > 0? max:0);
    }

    public static TreeNode copyTree(TreeNode root) {
        if(root == null) return null;
        TreeNode newroot = new TreeNode(root.val);
        newroot.left = copyTree(root.left);
        newroot.right = copyTree(root.right);
        return newroot;
    }

    // get the solution from LC
    // very concise
    // don't need the newroot I copied before, it uses the return value and global values
    //  to make the solution very easy, but still same idea.
    int res = Integer.MIN_VALUE;
    public int fromLC(TreeNode root) {
        helper(root);
        return res;
    }

    // the value return from helper is the max single path.
    public int helper(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
