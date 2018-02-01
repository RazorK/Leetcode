class Solution {
    // Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    //
    // An example is the root-to-leaf path 1->2->3 which represents the number 123.
    //
    // Find the total sum of all root-to-leaf numbers.
    //
    // For example,
    //
    //     1
    //    / \
    //   2   3
    // The root-to-leaf path 1->2 represents the number 12.
    // The root-to-leaf path 1->3 represents the number 13.
    //
    // Return the sum = 12 + 13 = 25.

    // traverse with num
    int sum = 0;
    public int firstTry(TreeNode root) {
        if(root == null) return sum;

        // BUG here should input root.val
        // need to make it clear that what's the meaning of the variable
        // the cur in the traverse already include the root.val
        traverse(root, root.val);
        return sum;
    }

    public void traverse(TreeNode root, int cur) {
        if(root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if(root.left != null)
            traverse(root.left, cur*10 + root.left.val);
        if(root.right != null)
            traverse(root.right, cur*10 + root.right.val);
    }

    // Get IDEA from LC
    // can we not use global variable?
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return secondTraverse(root, root.val);
    }

    // root can't be null, cur include root.val
    public int secondTraverse(TreeNode root, int cur) {
        if(root.left == null && root.right == null)
            // BUG: return value error,
            return cur;
        int sum = 0;
        if(root.left != null) sum += secondTraverse(root.left, cur*10 + root.left.val);
        if(root.right != null) sum += secondTraverse(root.right, cur*10 + root.right.val);
        return sum;
    }

}
