import java.util.*;

class Solution {
    // Given inorder and postorder traversal of a tree, construct the binary tree.
    //
    // Note:
    // You may assume that duplicates do not exist in the tree.

    // same idea as the previous
    // NOTE in which track to solve this,
    //  firstly notice to solve this by dp.
    //  then, in postorder, the last one item is the root. NOTE start from the defination of postorder.

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> in = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            in.put(inorder[i], i);
        }
        //BUG forget -1 here, which is caused by not fully understand the meaning of the parameter.
        return buildTree(in, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTree(HashMap<Integer, Integer> in, int is, int ie, int [] postorder, int ps, int pe) {
        if(ie-is != pe-ps) return null;
        if(ie < is) return null;
        int head = postorder[pe];
        int mid = in.get(head);
        TreeNode root = new TreeNode(head);
        root.left = buildTree(in, is, mid-1, postorder, ps, ps+mid-1-is);

        // BUG forget to end from pe-1 here..
        root.right = buildTree(in, mid+1, ie, postorder, pe-ie+mid, pe-1);
        return root;
    }
}
