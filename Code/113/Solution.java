import java.util.*;

class Solution {
    // Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    //
    // For example:
    // Given the below binary tree and sum = 22,
    //               5
    //              / \
    //             4   8
    //            /   / \
    //           11  13  4
    //          /  \    / \
    //         7    2  5   1
    // return
    // [
    //    [5,4,11,2],
    //    [5,8,4,5]
    // ]
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=  new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, sum, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(TreeNode root, int cur, int tar, List<Integer> curList, List<List<Integer>> res) {
        curList.add(root.val);
        cur+=root.val;
        if(root.left == null && root.right == null) {
            if(cur == tar) {
                // BUG forget to clone here..
                res.add(new ArrayList<Integer>(curList));
            }
        }
        if(root.left!=null) dfs(root.left, cur, tar, curList, res);
        if(root.right!=null) dfs(root.right, cur, tar, curList, res);
        curList.remove(curList.size()-1);
    }


    // get the idea from LC.
    // NOTE here it only passes one Integer sum(tar - cur) in the recursion, rather than in my solution cur + tar.
    //  which may save some resources.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, result, list);
        return result;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list){
        list.add(node.val);
        sum = sum - node.val;
        if(node.left == null && node.right == null && sum == 0){
            result.add(new ArrayList<>(list));
        }
        if(node.left != null){
            dfs(node.left, sum , result, list);
        }
        if(node.right != null){
            dfs(node.right, sum, result, list);
        }
        sum = sum + node.val;
        list.remove(list.size() - 1);
    }
}
