import java.util.*;
// NOTE: BFS can not be implemented by recursion
// NOTE: the main idea for bfs is QUEUE.
class BFS{
    public static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            res.add(temp.val);
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        return res;
    }
}
