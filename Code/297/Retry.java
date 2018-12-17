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
        StringBuilder sb = new StringBuilder();
        seDFS(root, sb);
        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void seDFS(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append('n').append(',');
            return ;
        }
        else sb.append(root.val).append(',');
        seDFS(root.left, sb);
        seDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {
        String [] datas = data.split(",");
        if(datas.length == 0) return null;
        index = 0;
        return deDFS(datas);
    }

    public TreeNode deDFS(String [] datas) {
        String cur = datas[index++];
        if(cur.equals("n")) return null;
        else {
            int curV = Integer.parseInt(cur);
            TreeNode curNode = new TreeNode(curV);
            curNode.left = deDFS(datas);
            curNode.right = deDFS(datas);
            return curNode;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));