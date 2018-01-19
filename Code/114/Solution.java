class Solution {
    // Given a binary tree, flatten it to a linked list in-place.
    //
    // For example,
    // Given
    //
    //          1
    //         / \
    //        2   5
    //       / \   \
    //      3   4   6
    // The flattened tree should look like:
    //    1
    //     \
    //      2
    //       \
    //        3
    //         \
    //          4
    //           \
    //            5
    //             \
    //              6

    // can not think of a in place soluton, my idea is traverse, add to list and reconstruct
    // O(n) space.
    public void firstTry(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        for(int i = 1; i < list.size(); i++) {
            list.get(i-1).left = null;
            list.get(i-1).right = list.get(i);
        }
    }

    public void traverse(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    // try use constant space
    // NOTE recursive idea
    // flatten(root) = node -> flatten(root.left) -> flatten(root.right)
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode ptr = root.left;
        if(ptr == null) {
            flatten(root.right);
            return;
        }
        flatten(root.left);
        while(ptr.right!=null) ptr = ptr.right;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        flatten(right)
        ptr.right = right;
    }
}
