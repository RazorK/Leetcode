class Solution {
    // Given a binary tree, return the zigzag level order traversal of its nodes'
    // values. (ie, from left to right, then right to left for the next level and alternate between).
    //
    // For example:
    // Given binary tree [3,9,20,null,null,15,7],
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    // return its zigzag level order traversal as:
    // [
    //   [3],
    //   [20,9],
    //   [15,7]
    // ]

    // first idea generate and reverse
    public List<List<Integer>> byReverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(res == null) return res;
        dfs(res, root, 0);
        for(int i=0; i<res.size(); i++) {
            if(i%2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }

    // try not use reverse
    // NOTE: just change the adding position based on the odevity of the level
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(res == null) return res;
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        if(level % 2 == 1) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
