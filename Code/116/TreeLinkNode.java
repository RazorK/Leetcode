import java.util.*;
public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(int x) { val = x; }

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
    public static String preOrder(TreeLinkNode tree) {
        if(tree == null) return "null,";
        StringBuilder sb = new StringBuilder();
        sb.append(tree.val);
        sb.append(',');
        sb.append(preOrder(tree.left));
        sb.append(preOrder(tree.right));
        return sb.toString();
    }

    // String 2 Tree from LC
    public static TreeLinkNode stringToTreeLinkNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeLinkNode root = new TreeLinkNode(Integer.parseInt(item));
        Queue<TreeLinkNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeLinkNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeLinkNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeLinkNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
