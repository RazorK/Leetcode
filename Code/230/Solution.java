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
    // Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    //
    // Note:
    // You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    //
    // Example 1:
    //
    // Input: root = [3,1,4,null,2], k = 1
    //    3
    //   / \
    //  1   4
    //   \
    //    2
    // Output: 1
    // Example 2:
    //
    // Input: root = [5,3,6,2,4,null,null,1], k = 3
    //        5
    //       / \
    //      3   6
    //     / \
    //    2   4
    //   /
    //  1
    // Output: 3
    // Follow up:
    // What if the BST is modified (insert/delete operations) often and you need to
    //     find the kth smallest frequently? How would you optimize the kthSmallest routine?

    // first idea: dfs
    int target;
    public int kthSmallest(TreeNode root, int k) {
        target = 0;
        if(root == null) return target;

        // QUESTION, find nothing?
        int left = helper(root.left, k, 0);
        if(left >= k) return target;
        if(left +1 == k) return root.val;
        helper(root.right, k, left+1);
        return target;
    }

    // key idea: helper return the total number of scanned after scanning the whole subtree
    public int helper(TreeNode root, int k, int cur) {
        if(root == null) return cur;

        // already found
        if(cur>=k) return cur;

        int leftNum = helper(root.left, k, cur);
        cur++;
        if(cur == k) {
            target = root.val;
            return cur;
        }

        return helper(root.right, k, cur);
    }
}
