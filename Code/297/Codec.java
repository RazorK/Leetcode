import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        res.deleteCharAt(0);
        return res.toString();
    }

    public void dfs(TreeNode root, StringBuilder res) {
        res.append(',');
        if(root != null) {
            res.append(root.val);
            dfs(root.left, res);
            dfs(root.right, res);
        } else {
            res.append('N');
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String [] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        decodeDfs(root, nodes, 1);
        return root;
    }

    public int decodeDfs(TreeNode root, String [] nodes, int start) {
        if(start >= nodes.length) return nodes.length;

        // left
        String leftStr = nodes[start++];
        int rightStart;
        if(leftStr.equals("N")) {
            rightStart = start;
        } else {
            TreeNode left =  new TreeNode(Integer.parseInt(leftStr));
            rightStart =  decodeDfs(left, nodes, start);
            root.left = left;
        }

        // right
        String rightStr = nodes[rightStart++];
        int finish;
        if(rightStr.equals("N")) {
            finish = rightStart;
        } else {
            TreeNode right =  new TreeNode(Integer.parseInt(rightStr));
            finish =  decodeDfs(right, nodes, rightStart);
            root.right = right;
        }

        return finish;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));