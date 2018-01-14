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

    // try recursion first.
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n==0) return res;

        List<Integer> nodes = new ArrayList<>();
        for(int i=1; i<=n; i++)
            nodes.add(i);

        for(int i=0; i<nodes.size(); i++) {
            int temp = nodes.get(i);
            nodes.remove(i);
            TreeNode head = new TreeNode(temp);
            recur(nodes, res, head, head, 1, n);
            nodes.add(i, temp);
        }
        return res;
    }

    // try recur
    public void recur(List<Integer> nodesLeft, List<TreeNode> res, TreeNode head, TreeNode parent, int leftMax, int rightMax) {
        if(nodesLeft.size() == 0) {
            res.add(copyTree(head));
            return;
        }

        int p_value = parent.val;
        // BUG forget empty left
        for(int i=0; i<nodesLeft.size(); i++) {
            int in_temp = nodesLeft.get(i);
            if(in_temp<leftMax || in_temp>rightMax) {
                continue;
            }
            nodesLeft.remove(i);
            TreeNode right = new TreeNode(in_temp);
            parent.right = right;
            recur(nodesLeft, res, head, right, Math.min(leftMax, in_temp), rightMax);
            nodesLeft.add(i, in_temp);
        }

        // left
        for(int i=0; i<nodesLeft.size(); i++) {
            int temp = nodesLeft.get(i);
            // BUG here we should not just continue, because we also need the right processing
            boolean flag = false;

            // BUG forget empty left
            if(temp<=p_value && temp >= leftMax && temp<=rightMax)  {
                flag = true;
                nodesLeft.remove(i);
                TreeNode left = new TreeNode(temp);
                parent.left = left;
                recur(nodesLeft, res, head, left, leftMax, Math.min(rightMax, temp));
            } else {
                if(i!=0) break;
            }
            //right
            for(int j = i; j<nodesLeft.size(); j++) {
                int in_temp = nodesLeft.get(j);
                if(in_temp<leftMax || in_temp>rightMax) {
                    continue;
                }
                if(in_temp<p_value) {
                    continue;
                }
                nodesLeft.remove(j);
                TreeNode right = new TreeNode(in_temp);
                parent.right = right;
                recur(nodesLeft, res, head, right, Math.min(leftMax, in_temp), rightMax);
                nodesLeft.add(j, in_temp);
            }
            if(flag) {
                nodesLeft.add(i, temp);
            }
        }
    }

    // recur copy.
    public TreeNode copyTree(TreeNode head) {
        if(head == null) return null;
        TreeNode res = new TreeNode(head.val);
        res.left = copyTree(head.left);
        res.right = copyTree(head.right);
        return res;
    }
}
