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
    // Given a complete binary tree, count the number of nodes.
    //
    // Note:
    //
    // Definition of a complete binary tree from Wikipedia:
    // In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    //
    // Example:
    //
    // Input:
    //     1
    //    / \
    //   2   3
    //  / \  /
    // 4  5 6
    //
    // Output: 6

    // first idea:
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int h = 0;
        TreeNode it = root;
        while(it != null) {
            it = it.left;
            h++;
        }

        if(h == 1) return 1;
        int left = (int)Math.pow(2, h-1);
        int right = (int)Math.pow(2, h) - 1;
        if(checkValid(root, right, h)) return right;

        while(left < right) {
            int mid = (left + right) /2;
            if(checkValid(root, mid, h)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    public boolean checkValid(TreeNode root, int x, int h) {
        for(int i=h-2; i>=0; i--) {
            root = x >> i ^ 1 == 1 ? root.right : root.left;
        }
        if(root == null) return false;
        return true;
    }

    // better idea
    // recursive: left child and right child
}
