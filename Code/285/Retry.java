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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return dfs(root, p, null);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode pre) {
        if(root == p && p.right!=null)  return leftMost(p.right);
        if(root == p && p.right == null) return pre;
        if(root.val > p) {
            return dfs(root.left, p, root);
        } else {
            return dfs(root.right, p, pre);
        }
    }

    public TreeNode leftMost(TreeNode cur) {
        while(cur.left!= null) {
            cur = cur.left;
        }
        return cur;
    }
}