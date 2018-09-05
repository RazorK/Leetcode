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
    // idea search and keep

    // Two situation: 1. p has right subtree, so find the !! MINIMUM of the right subtree.
    // 2. p is the righest note of a subtree, find the first node that turn left in the path.
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null || root == null) return null;
        if(p.right!=null) {
            // fine the minimum in righe subtree
            TreeNode it = p.right;
            while(it.left!= null) it = it.left;
            return it;
        }
        TreeNode pre = null;
        TreeNode it = root;
        while(it!=p) {
            if(it == null) {
                return pre;
            }
            if(it.val < p.val) {
                it = it.right;
            } else {
                pre = it;
                it = it.left;
            }
        }
        return pre;
    }

    // from LC recursive, not straight forward..
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}