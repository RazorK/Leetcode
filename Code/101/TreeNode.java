import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

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

    // String 2 Tree from LC
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
