import java.util.*;
class Solution {
    // Given a binary tree, return the inorder traversal of its nodes' values.
    //
    // For example:
    // Given binary tree [1,null,2,3],
    //    1
    //     \
    //      2
    //     /
    //    3
    // return [1,3,2].
    //
    // Note: Recursive solution is trivial, could you do it iteratively?

    // first do it by recursive
    public List<Integer> byRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root, res);
        return res;
    }

    public void recur(TreeNode root, List<Integer> res) {
        if(root == null) return;
        recur(root.left, res);
        res.add(root.val);
        recur(root.right, res);
    }

    // try to do it by iteraton
    // NOTE idea here:
    //  use the stack to store the node to be process(of same property: left processed,
    //  need to add it self and then process right)
    public List<Integer> inorderTraversal(TreeNode root) {
        // first try use stack.
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode ptr = root;
        while(ptr!=null || !st.empty()) {
            if(ptr!=null) {
                st.push(ptr);
                ptr = ptr.left;
                continue;
            }
            // stack
            ptr = st.pop();
            res.add(ptr.val);
            ptr = ptr.right;
        }
        return res;
    }
}
