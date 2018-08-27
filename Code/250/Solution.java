/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Given a binary tree, count the number of uni-value subtrees.

    // A Uni-value subtree means all nodes of the subtree have the same value.
    
    // Example :
    
    // Input:  root = [5,1,5,5,5,null,5]
    
    //               5
    //              / \
    //             1   5
    //            / \   \
    //           5   5   5
    
    // Output: 4


    public int countUnivalSubtrees(TreeNode root) {
        return dfsHelper(root, new boolean[1]);
    }

    public int dfsHelper(TreeNode root, boolean [] flag) {
        if(root == null) {
            flag[0] = true;
            return 0;
        } else if(root.left == null && root.right == null) {
            flag[0] = true;
            return 1;
        }

        boolean [] leftFlag = new boolean[1];
        boolean [] rightFlag = new boolean[1];
        int left = dfsHelper(root.left, leftFlag);
        int right = dfsHelper(root.right, rightFlag);

        if(leftFlag[0] && rightFlag[0] &&
        (root.left == null || root.left.val == root.val) &&
        (root.right == null || root.right.val == root.val)
        ) {
            flag[0] = true;
            return left + right + 1;
        } else {
            flag[0] = false;
            return left + right;
        }
    }
}