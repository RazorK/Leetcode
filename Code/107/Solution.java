import java.util.*;
class Solution {
    // Given a binary tree, return the bottom-up level order traversal of its nodes' values.
    // (ie, from left to right, level by level from leaf to root).
    //
    // For example:
    // Given binary tree [3,9,20,null,null,15,7],
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    // return its bottom-up level order traversal as:
    // [
    //   [15,7],
    //   [9,20],
    //   [3]
    // ]

    // first idea just add in the up-bottom level and reverse
    public List<List<Integer>> byReverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        if(level>= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }

    // try not use reverse
    // this is hard, and not directly, bacause firstly it's hard to get the deepest level, so it's hard to find the correct list to insert.
}
