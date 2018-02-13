import java.util.*;
public class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String x) { val = x; }

    // leetcode toString seems return preOrder traverse result
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(preOrder(this));
        if(sb.charAt(sb.length()-1) == ',')
            sb.deleteCharAt(sb.length()-1);
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
