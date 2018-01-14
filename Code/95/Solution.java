import java.util.*;
class Solution {
    // Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
    //
    // For example,
    // Given n = 3, your program should return all 5 unique BST's shown below.
    //
    //    1         3     3      2      1
    //     \       /     /      / \      \
    //      3     2     1      1   3      2
    //     /     /       \                 \
    //    2     1         2                 3

    // first idea from leetcode, just dfs by range
    public List<TreeNode> generateTrees(int n) {
        // forget 0 corner here.
        if(n==0) return new ArrayList<TreeNode>();
        if(n==1) {
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(1));
            return res;
        }
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        TreeNode leftStart = new TreeNode(start);
        res.addAll(single(leftStart, dfs(start + 1, end), false));
        TreeNode rightEnd = new TreeNode(end);
        res.addAll(single(rightEnd, dfs(start, end-1), true));
        for(int i=start+1; i<=end-1; i++) {
            TreeNode head = new TreeNode(i);
            // BUG here confuse i-1 i+1 with i.
            List<TreeNode> leftList = dfs(start, i-1);
            List<TreeNode> rightList = dfs(i+1, end);
            res.addAll(combine(head, leftList, rightList));
        }
        return res;
    }

    public List<TreeNode> combine(TreeNode head, List<TreeNode> leftList, List<TreeNode> rightList) {
        List<TreeNode> res = new ArrayList<>();
        for(int i=0; i<leftList.size(); i++) {
            for(int j=0; j<rightList.size(); j++) {
                TreeNode temp = new TreeNode(head.val);
                temp.left = leftList.get(i);
                temp.right = rightList.get(j);
                res.add(temp);
            }
        }
        return res;
    }

    public List<TreeNode> single(TreeNode head, List<TreeNode> list, boolean left) {
        List<TreeNode> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            TreeNode temp = new TreeNode(head.val);
            if(left) temp.left = list.get(i);
            else temp.right = list.get(i);
            res.add(temp);
        }
        return res;
    }
}
