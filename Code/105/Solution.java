import java.util.*;

class Solution {
    // Given preorder and inorder traversal of a tree, construct the binary tree.
    //
    // Note:
    // You may assume that duplicates do not exist in the tree.

    // try directly finish by stack or ptrs, failed.
    // dp seems useful.
    // NOTE idea is this: the first element in preorder is the root, find the root in the inorder,
    //  then the left part in inorder is left inorder, right is right inorder. for preorder, just the same
    //  number of elements as left preorder and right preorder.
    // NOTE key note from LC
    //  pre: [root][left][right];
    //  in: [left][root][right];

    // worst case O(n^2)
    public TreeNode dptry(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int [] preorder, int ps, int pe, int [] inorder, int is, int ie) {
        if(pe - ps != ie - is) return null;
        if(pe<ps || ie<is) return null;
        if(pe == ps) return new TreeNode(preorder[pe]);
        int head = preorder[ps];
        TreeNode root = new TreeNode(head);
        int ptr = 0;
        for(int i=is; i<=ie; i++) {
            if(inorder[i] == head) ptr = i;
        }
        root.left = helper(preorder, ps + 1, ps+ptr-is, inorder, is, ptr-1);
        root.right = helper(preorder, ps+ptr-is+1, pe, inorder, ptr+1, ie);
        return root;
    }

    // Great idea to use HashMap replace inorder, which can save a lot of search time.
    public TreeNode tryHashMap(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> in = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, in, 0, inorder.length-1);
    }

    public TreeNode helper(int [] preorder, int ps, int pe, HashMap<Integer, Integer> inorder, int is, int ie) {
        if(pe - ps != ie - is) return null;
        if(pe<ps || ie<is) return null;
        if(pe == ps) return new TreeNode(preorder[pe]);
        int head = preorder[ps];
        TreeNode root = new TreeNode(head);
        int ptr = inorder.get(head);
        root.left = helper(preorder, ps + 1, ps+ptr-is, inorder, is, ptr-1);
        root.right = helper(preorder, ps+ptr-is+1, pe, inorder, ptr+1, ie);
        return root;
    }

    // the above passed but not the fastest
    // fastest from LC
    // TODO I don't understand this..
    // But this is very hard to think of or remember..
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return buildTree(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
        //pre: [root][left][right];
        //in: [left][root][right];
        //target is the root
        if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        //preorder, advance the index by 1 sice we already finish the root;
        preIndex[0]++;
        root.left = buildTree(preorder, inorder, preIndex, inIndex, root.val);
        //after finishing left subtree, we can advance the index by 1
        inIndex[0]++;
        root.right = buildTree(preorder, inorder, preIndex, inIndex, target);
        return root;
    }
}
