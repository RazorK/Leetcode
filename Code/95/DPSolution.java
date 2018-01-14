import java.util.*;
class DPSolution {
    // here I want to try DP, with rememebering the result
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        if(n==1) {
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(1));
            return res;
        }
        // 1 to n
        List<TreeNode> [][] board = (ArrayList<TreeNode> [][])new ArrayList[n+1][n+1];
        return dfs(1, n, board);
    }

    public List<TreeNode> dfs(int start, int end, List<TreeNode> [][] board) {
        if(board[start][end] != null) return board[start][end];

        List<TreeNode> res = new ArrayList<>();
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        TreeNode leftStart = new TreeNode(start);
        res.addAll(single(leftStart, dfs(start + 1, end, board), false));
        TreeNode rightEnd = new TreeNode(end);
        res.addAll(single(rightEnd, dfs(start, end-1, board), true));
        for(int i=start+1; i<=end-1; i++) {
            TreeNode head = new TreeNode(i);
            // BUG here confuse i-1 i+1 with i.
            List<TreeNode> leftList = dfs(start, i-1, board);
            List<TreeNode> rightList = dfs(i+1, end, board);
            res.addAll(combine(head, leftList, rightList));
        }

        board[start][end] = res;
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
