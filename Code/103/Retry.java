/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Retry {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 1;
        boolean forward = true;
        List<Integer> inner = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(forward) {
                inner.add(cur.val);
            } else {
                inner.add(0, cur.val);
            }

            if(cur.left != null) queue.add(cur.left);
            if(cur.right!= null) queue.add(cur.right);
            if(--length == 0) {
                length = queue.size();
                forward = !forward;
                res.add(inner);
                inner = new ArrayList<>();
            }
        }

        return res;
    }
}
