public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    // leetcode toString seems return preOrder traverse result
    public String toString() {
        String sb = new StringBuilder();
        sb.append('[');
        sb.append(preOrder(this));
        if(sb.charAt(sb.length()-1) == ',')
            sb.remove(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }
    public static String preOrder(TreeNode tree) {
        if(tree == null) return "null,";
        StringBuilder sb = new StringBuilder();
        sb.append(tree.val);
        sb.append(',');
        sb.append(preOrder(tree.left));
        sb.append(preOrder(tree.right));
        return sb.toString();
    }
}
