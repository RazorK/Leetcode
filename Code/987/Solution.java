import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        // compose the result
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(Map.Entry<Integer,TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, List<Integer>> nextData = entry.getValue();
            List<Integer> nextRes = new ArrayList<>();
            for(List<Integer> nn : nextData.values()) {
                Collections.sort(nn);
                nextRes.addAll(nn);
            }
            res.add(nextRes);
        }
        return res;
    }

    public void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        TreeMap<Integer, List<Integer>> curX = map.computeIfAbsent(x, (key) -> new TreeMap<Integer, List<Integer>>());
        curX.computeIfAbsent(y, (key) -> new ArrayList<Integer>()).add(root.val);
        if(root.left != null) dfs(root.left, x-1, y+1, map);
        if(root.right != null) dfs(root.right, x+1, y+1, map);
    }
}