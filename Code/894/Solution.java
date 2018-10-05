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
    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> first = new ArrayList<>();
        first.add(new TreeNode(0));
        map.put(1, first);
        return helper(N, map);
    }

    public List<TreeNode> helper(int N, Map<Integer, List<TreeNode>> map) {
        if(N < 0) return null;
        if(map.containsKey(N)) return map.get(N);

        List<TreeNode> res = new ArrayList<>();
        if(N % 2 == 0) return res;

        for(int left=1; left<N; left+=2) {
            int right = N - 1 - left;

            List<TreeNode> leftA = helper(left, map);
            if(leftA == null || leftA.size() == 0) continue;
            List<TreeNode> rightA = helper(right, map);
            if(rightA == null || rightA.size() == 0) continue;

            for(TreeNode ll : leftA) {
                for(TreeNode rr : rightA) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = ll;
                    cur.right = rr;
                    res.add(cur);
                }
            }
        }

        map.put(N, res);
        System.out.println(map.toString());
        return res;
    }
}