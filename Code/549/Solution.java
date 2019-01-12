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
    // MISTAKE consecutive but not increasing..
    int res;
    public int longestConsecutive(TreeNode root) {
        // first idea two pass, but fromLC find that one pass is enough
        res = 0;
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if(root == null) return new int[] {0, 0};
        int [] left = dfs(root.left);
        int [] right = dfs(root.right);

        // find result candidate
        int cur = 1;
        if(root.left != null && root.val == root.left.val+1) cur += left[0];
        if(root.right != null && root.val == root.right.val-1) cur += right[1];
        this.res = Math.max(this.res, cur);

        cur = 1;
        if(root.left != null && root.val == root.left.val-1) cur += left[1];
        if(root.right != null && root.val == root.right.val+1) cur += right[0];
        this.res = Math.max(this.res, cur);

        // return value
        int down = 1, up = 1;
        if(root.left != null) {
            if(root.val == root.left.val+1) {
                down = Math.max(down, 1 + left[0]);
            } else if(root.val == root.left.val-1) {
                up = Math.max(up, 1 + left[1]);
            }
        }

        if(root.right != null) {
            if(root.val == root.right.val+1) {
                down = Math.max(down, 1 + right[0]);
            } else if(root.val == root.right.val-1) {
                up = Math.max(up, 1 + right[1]);
            }
        }

        return new int [] {down, up};
    }
}