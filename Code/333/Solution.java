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
    // BUG: use a integer as the recursive result is not good enough
    // I want to use -1 means that the subtree is not a bst, but I have to capture the 
    // max number of nodes in the descendant, which can be a conflict

    // NOTE: be careful when you want to use a variable that has multiple means

    // BUG2: when verify a BST, recusion verification should based on a range.

    public class Node {
        boolean isBST;
        int largestBSTNum;
        int upper;
        int lower;
        public Node(boolean i, int l, int u, int ll) {
            isBST = i;
            largestBSTNum = l;
            upper = u;
            lower = ll;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Node res = countTree(root);
        return res.largestBSTNum;
    }
    
    // -1 stand for not bst, 0 stand for null
    public Node countTree(TreeNode root) {
        if(root == null) return new Node(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(root.left == null && root.right == null) return new Node(true, 1, root.val, root.val);
        
        Node left = countTree(root.left);
        Node right = countTree(root.right);

        boolean fit = (left.isBST && root.val > left.upper) && (right.isBST && root.val < right.lower);

        if(!left.isBST && !right.isBST) return new Node(false, Math.max(left.largestBSTNum, right.largestBSTNum), 0, 0);
        if(left.isBST && right.isBST) {
            if(fit) return new Node(true, left.largestBSTNum + right.largestBSTNum + 1, Math.max(right.upper, root.val), Math.min(left.lower, root.val));
            else return new Node(false, Math.max(left.largestBSTNum, right.largestBSTNum), 0, 0);
        }
        return new Node(false, Math.max(left.largestBSTNum, right.largestBSTNum), 0, 0);
    }
}