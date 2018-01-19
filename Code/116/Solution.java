public class Solution {
    // Given a binary tree
    //
    //     struct TreeLinkNode {
    //       TreeLinkNode *left;
    //       TreeLinkNode *right;
    //       TreeLinkNode *next;
    //     }
    // Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    //
    // Initially, all next pointers are set to NULL.
    //
    // Note:
    //
    // You may only use constant extra space.
    // You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    // For example,
    // Given the following perfect binary tree,
    //          1
    //        /  \
    //       2    3
    //      / \  / \
    //     4  5  6  7
    // After calling your function, the tree should look like:
    //          1 -> NULL
    //        /  \
    //       2 -> 3 -> NULL
    //      / \  / \
    //     4->5->6->7 -> NULL

    // my idea: recursion, the recursion is of two functions :
    //  1. if the childs are leaf, connect them.
    //  2. get the right leaf of left child and left leaf of right child.
    // BUG the idea above is wrong, there are some links are not contains, eg. 2 -> 3.

    // new idea, traverse, use space to remember.
    public void connect(TreeLinkNode root) {
        recursion(root, new ArrayList<TreeLinkNode>(), 0);
    }
    public void recursion(TreeLinkNode root, List<TreeLinkNode> space, int level) {
        if(root == null) return;
        if(space.size()-1 < level) {
            space.add(root);
        }
        else {
            if(space.get(level) != null) {
                space.get(level).next = root;
            }
            space.set(level, root);
        }
        recursion(root.left, space, level + 1);
        recursion(root.right, space, level + 1);
    }

    // try constant space
    // get idea from LC
    // NOTE: recursive idea, MAKE USE OF NEXT ptr we have..
    public void fromLC(TreeLinkNode root) {
        if(root == null) return;
        // preOrder
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next!=null) {
                root.right.next = root.next.left;
            }
        }
        fromLC(root.left);
        fromLC(root.right);
    }
}
