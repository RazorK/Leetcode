import java.util.*;
class Solution {
    // Given a binary tree, return the level order traversal of its nodes' values.
    // (ie, from left to right, level by level).
    //
    // For example:
    // Given binary tree [3,9,20,null,null,15,7],
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    // return its level order traversal as:
    // [
    //   [3],
    //   [9,20],
    //   [15,7]
    // ]

    // first idea traverse and add level
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(res == null) return res;
        dfs(res, root, 0);
        return res;
    }

    // try pre order first
    public void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }
}
