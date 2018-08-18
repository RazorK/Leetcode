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
    TreeNode firstAppear;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        if(firstAppear == null) return root;
        return firstAppear;
    }

    public boolean [] helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new boolean []{false, false};
        boolean [] left = helper(root.left, p, q);
        boolean [] right = helper(root.right, p, q);
        boolean [] res = new boolean [2];
        res[0] = left[0] || right[0] || root.val == p.val;
        res[1] = left[1] || right[1] || root.val == q.val;
        System.out.println(root.val + Arrays.toString(res));
        if(firstAppear == null && res[0] == true && res[1] == true) firstAppear = root;
        return res;
    }
}
