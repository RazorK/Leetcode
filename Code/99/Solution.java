import java.util.*;
class Solution {
    // Get the idea from LC, use global variable.
    // NOTE: if not use the O(n) space, we have two problems here.
    //  First: if we don't use list, we have to keep the strange node we find.
    //  Second: we have to consider the situation that the two nodes are adjacent,
    //  so we have to first keep the second when find first, if there is another
    //  strange node, we can just change the second.
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(pre != null) {
            if(first==null) {
                if(root.val < pre.val) {
                    first = pre;
                    second = root;
                }
            } else {
                if(root.val < pre.val) {
                    second = root;
                }
            }
        }
        pre = root;
        inOrder(root.right);
    }
}
