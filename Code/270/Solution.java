class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        double cur = getDiff(root.val, target);
        int left = -1, right = -1;
        double leftValue = Double.MAX_VALUE, rightValue = Double.MAX_VALUE;
        if(root.left != null) {
            left = closestValue(root.left, target);
            leftValue = getDiff(left, target);
        }
        if(root.right != null) {
            right = closestValue(root.right, target);
            rightValue = getDiff(right, target);
        }

        if(leftValue <= cur && leftValue <= rightValue) {
            return left;
        } else if(rightValue <= cur && rightValue <= leftValue)  {
            return right;
        } else {
            return root.val;
        }
    }

    public double getDiff(double a, double b) {
        return Math.abs(a-b);
    }

    // binary search tree... Notice that.
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, root.val);
    }
    
    private int closestValue(TreeNode root, double target, int res) {
        if (root == null) return res;
        if (Math.abs(root.val - target) < Math.abs(res - target)) res = root.val;
        if (root.val < target) res = closestValue(root.right, target, res);
        else res = closestValue(root.left, target, res);
        return res;
    }
}