import java.util.*;

public class InOrder {
    // In order traverse of tree by dfs or recursion
    public static List<Integer>  dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(root, res);
        return res;
    }

    public static void dfsHelper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        dfsHelper(root.left, list);
        list.add(root.val);
        dfsHelper(root.right, list);
    }

    // In order traverse of tree by stack
    public static List<Integer> byStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        // NOTE: Here, we use a stack to store the TreeNode whose left child is under
        //  processing and the TreeNode itself and it's right child needs to be processed.
        Stack<TreeNode> st = new Stack<>();

        TreeNode ptr = root;
        while(ptr != null && st.size() != 0) {
            // NOTE: the key here is to start at thinking of whether the ptr is null
            //  BUG: I made a mistake to think of whether ptr.left == null, which may cause nullptr error.
            if(ptr != null) {
                st.push(ptr);
                ptr = ptr.left;
                continue;
            }
            ptr = st.pop();
            rea.add(ptr.val);
            ptr = ptr.right;
        }
        return res;
    }

    // In order Morris Traverse
    // NOTE link:http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

    // NOTE The idea of this is inspired by the use of stack. The usage of stack, is after we handle the a left child of a node,
    //  we need to use the stack to track the parent of the node we have.

    //  So, the problem is, after we handle a subTree, how can we get it's parent.
    //  The Main idea is to use the child of leaf node, which is null, to store the TreeNode which it should go back.

    //  But if we add the link, a cycle will appear, and when we find the parent node again, we need to eliminate the link so the cycle
    //  is also eliminated

    // TODO: implement morrris in java
    public static List<Integer> byMorris(TreeNode root) {


    }
}
