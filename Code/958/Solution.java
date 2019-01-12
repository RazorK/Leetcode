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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        // idea bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int length = 1;
        while(!q.isEmpty()) {
            if(length != Math.pow(2, level)) break;
            boolean end = false;
            for(int i=0; i<length; i++) {
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right != null) return false;
                if(cur.right == null) return checkLastLine(q);
                q.add(cur.left);
                q.add(cur.right);
            }
            level++;
            length = q.size();
        }
        return true;
    }

    public boolean checkLastLine(Queue<TreeNode> q) {
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left != null || cur.right != null) return false;
        }
        return true;
    }
}