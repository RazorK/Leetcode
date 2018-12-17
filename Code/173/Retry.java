/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    // requirement O(1) time and O(h) memory
    Stack<TreeNode> st;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        if(root == null) return;
        while(root.left!= null) {
            st.push(root);
            root = root.left;
        }
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = cur.val;
        if(cur.right != null) {
            cur = cur.right;
            while(cur.left != null) {
                st.push(cur);
                cur = cur.left;
            }
        } else {
            cur = null;
            if(!st.isEmpty()) cur = st.pop();
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */