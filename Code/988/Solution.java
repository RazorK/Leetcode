import java.util.*;

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
    public String smallestFromLeaf(TreeNode root) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        if(root == null) return "";

        dfs(root, pq, new StringBuilder());
        if(root.left == null && root.right == null) return pq.poll();
        while(pq.peek().length() == 1) {
            pq.poll();
        }
        return pq.peek();
    }

    public void dfs(TreeNode root, PriorityQueue<String> pq, StringBuilder sb) {
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null) {
            pq.add(new StringBuilder(sb.toString()).reverse().toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(root.left != null) dfs(root.left, pq, sb);
        if(root.right != null) dfs(root.right, pq, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}