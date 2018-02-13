import java.util.*;
public class ET {
    // firstly only consider string list
    public static TreeNode stringToTree(String [] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("+",1);
        map.put("-",1);
        map.put("*",2);
        map.put("/",2);
        if(strs.length == 0) return null;
        TreeNode root = new TreeNode(strs[0]);
        for(int i=1; i<strs.length; i++) {
            String cur = strs[i];
            if(i==1)  {
                TreeNode temp = new TreeNode(cur);
                temp.left = root;
                root = temp;
                continue;
            }
            if(!map.containsKey(cur)) {
                putNum(root, cur);
                continue;
            }
            // map containsKey:
            if(map.get(cur)>map.get(root.val)) {
                putOp(root, cur, map);
                continue;
            } else {
                TreeNode temp = new TreeNode(cur);
                temp.left = root;
                root = temp;
                continue;
            }
        }
        return root;
    }

    public static void putNum(TreeNode root, String cur) {
        if(root == null) return;
        while(root.right!=null) {
            root = root.right;
        }
        root.right = new TreeNode(cur);
    }

    public static void putOp(TreeNode root, String cur, HashMap<String, Integer> map) {
        if(root == null) return;
        while(!(!map.containsKey(root.right.val) || map.get(root.right.val) < map.get(cur))) {
            root = root.right;
        }
        TreeNode temp = new TreeNode(cur);
        temp.left = root.right;
        root.right = temp;
    }

    public static int treeToAnswer(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return Integer.parseInt(root.val);
        if(root.val.equals("+")) return treeToAnswer(root.left) + treeToAnswer(root.right);
        else if(root.val.equals("-")) return treeToAnswer(root.left) - treeToAnswer(root.right);
        else if(root.val.equals("*")) return treeToAnswer(root.left) * treeToAnswer(root.right);
        else if(root.val.equals("/")) return treeToAnswer(root.left) / treeToAnswer(root.right);
        return 0;
    }
}
