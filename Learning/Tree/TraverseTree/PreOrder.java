import java.util.*;
public class PreOrder {
    public static List<Integer> main(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    public static void dfs(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
