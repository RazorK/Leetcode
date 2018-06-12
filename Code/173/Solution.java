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

    int ptr;
    List<TreeNode> res;
    public BSTIterator(TreeNode root) {
        res = new ArrayList<>();
        getList(root, res);
        this.ptr = 0;
    }

    public void getList(TreeNode root, List<TreeNode> l) {
        if(root == null) return ;
        getList(root.left, l);
        l.add(root);
        getList(root.right, l);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(ptr >= res.size()) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return res.get(ptr++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
