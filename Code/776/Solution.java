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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode leftDummy = new TreeNode(0);
        TreeNode rightDummy = new TreeNode(1);
        
        TreeNode [] res = {leftDummy, rightDummy};
        recur(res, root, V);
        res[0] = leftDummy.right;
        res[1] = rightDummy.left;
        return res;
    }
    
    public void recur(TreeNode [] res, TreeNode cur, int tar) {
        if(cur == null) return;
        TreeNode leftC = cur.left;
        TreeNode rightC = cur.right;

        if(cur.val <= tar) {
            res[0].right = cur;
            cur.right = null;
            res[0] = cur;
            recur(res, rightC, tar);
        } else {
            res[1].left = cur;
            cur.left = null;
            res[1] = cur;
            recur(res, leftC, tar);
        }
    }
}