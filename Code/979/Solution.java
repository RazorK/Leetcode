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

    int num;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        num = 0;
        dfs(root);
        return num;
    }

    // return [# of node, # of coins]
    public int [] dfs(TreeNode root) {
        if(root == null) return new int[] {0, 0};

        int [] left = dfs(root.left);
        int [] right = dfs(root.right);

        num += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
        return new int[] {left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}