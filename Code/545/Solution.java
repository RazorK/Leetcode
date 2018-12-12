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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }

        List<Integer> zuo = new ArrayList<>();
        boolean zz = zuobang(root, zuo);

        List<Integer> you = new ArrayList<>();
        boolean yy = youbang(root, you);
        
        List<Integer> ye = new ArrayList<>();
        yezi(root, ye);

        you.remove(you.size()-1);

        if(zz) ye.remove(0);
        if(yy) ye.remove(ye.size()-1);

        zuo.addAll(ye);
        zuo.addAll(you);
        return zuo;
    }

    public boolean zuobang(TreeNode root, List<Integer> res) {
        if(root.left == null) {
            res.add(root.val);
            return false;
        } else {
            res.add(root.val);
            zuobanghelper(root.left, res);
            return true;
        }
    }

    public void zuobanghelper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        if(root.left == null && root.right == null) {
            return;
        }
        if(root.left != null && root.right != null) {
            zuobanghelper(root.left, res);
            return;
        }
        zuobanghelper((root.left == null ? root.right : root.left), res);
    }

    public boolean youbang(TreeNode root, List<Integer> res) {
        if(root.right == null) {
            res.add(root.val);
            return false;
        } else {
            res.add(root.val);
            youbanghelper(root.right, res);
            Collections.reverse(res);
            return true;
        }
    }

    public void youbanghelper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        if(root.left == null && root.right == null) {
            return;
        }
        if(root.left != null && root.right != null) {
            youbanghelper(root.right, res);
            return;
        }
        youbanghelper(root.left == null ? root.right : root.left, res);
    }

    public void yezi(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);
        }
        yezi(root.left, res);
        yezi(root.right, res);
    }
}