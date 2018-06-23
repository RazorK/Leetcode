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
    // Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
    //
    // Example:
    //
    // Input: [1,2,3,null,5,null,4]
    // Output: [1, 3, 4]
    // Explanation:
    //
    //    1            <---
    //  /   \
    // 2     3         <---
    //  \     \
    //   5     4       <---

    // First Idea BFS.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int length = 1;

        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);

            if(--length == 0)  {
                res.add(cur.val);
                length = q.size();
            }
        }
        return res;
    }

    // this solution is trickier. Make use of the relation between the depth value and
    // the result length. And recursive with right first.
    public List<Integer> fast(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getRightView(root, 0, result);
        return result;
    }

    public void getRightView(TreeNode root, int currentDepth, List<Integer> result){
        if(root==null)
            return;
        if(currentDepth == result.size()){
            result.add(root.val);
        }
        getRightView(root.right, currentDepth + 1, result);
        getRightView(root.left, currentDepth + 1, result);
    }
}
