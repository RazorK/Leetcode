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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode newR = findRoot(root, L, R);
        trimTree(newR.left, L, R, newR);
        trimTree(newR.right, L, R, newR);
        return newR;
    }

    public TreeNode findRoot(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val >= L && root.val <= R) return root;
        if(root.val < L) return findRoot(root.right, L, R);
        if(root.val > R) return findRoot(root.left, L, R);
        return null;
    }

    public void trimTree(TreeNode root, int L, int R, TreeNode pa) {
        if(root == null) return;
        if(root.val >= L && root.val <= R) {
            trimTree(root.left, L, R, root);
            trimTree(root.right, L, R, root);
            return;
        }

        if(root.val < L) {
            pa.left = root.right;
            trimTree(root.right, L, R, pa);
        } else {
            pa.right = root.left;
            trimTree(root.left, L, R, pa);
        }
    }
}