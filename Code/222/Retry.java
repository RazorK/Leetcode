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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int h = countHeight(root);
        int left = (int)Math.pow(2, h-1), right = (int)Math.pow(2, h) - 1;

        while(left <= right) {
            int mid = left + (right - left ) /2;
            if(check(root, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(check(root, left, h)) return left;
        return left - 1;
    }

    public int countHeight(TreeNode root) {
        int h = 1;
        while(root.left != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    public boolean check(TreeNode root, int index, int h) {
        if(index > Math.pow(2, h) - 1) return false;
        boolean [] lefts = new boolean[h];
        for(int i=h-1;i>=0; i--) {
            if(index %2 == 0) lefts[i] = true;
            else lefts[i] = false;
            index = index/2;
        }

        for(int i=1; i<h; i++) {
            root = lefts[i] ? root.left : root.right;
        }
        return root != null;
    }
}