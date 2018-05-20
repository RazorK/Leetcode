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

    // Given a binary tree, return the postorder traversal of its nodes' values.
    //
    // Example:
    //
    // Input: [1,null,2,3]
    //    1
    //     \
    //      2
    //     /
    //    3
    //
    // Output: [3,2,1]
    // Follow up: Recursive solution is trivial, could you do it iteratively?

    // try iteratively
    // great idea from discussion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            if(tmp == null) continue;
            l.add(0, tmp.val);
            st.push(tmp.left);
            st.push(tmp.right);
        }
        return l;
    }

    public List<Integer> recursively(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    public void dfs(TreeNode root, List<Integer> l) {
        if(root == null) return;
        dfs(root.left, l);
        dfs(root.right, l);
        l.add(root.val);
    }
}
