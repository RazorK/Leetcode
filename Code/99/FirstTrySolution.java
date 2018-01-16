class FirstTrySolution {
    // Two elements of a binary search tree (BST) are swapped by mistake.
    //
    // Recover the tree without changing its structure.
    //
    // Note:
    // A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

    // first try O(n) solution..
    // give up
    // Get idea from LC
    // NOTE: firstly, it's hard to find the two value in tree, so the idea is to transform it into a problem
    //  of array by inorder traverse, which should get a sorted array from BST.

    // NOTE: when we get a sorted array, it's easier to find the two swapped nodes, just the first strange node and the last strange node.
    // first try O(n) space
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrder(root, list);
        int first = 0, second = 0;
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i).val > list.get(i+1).val) {
                first = i;
                break;
            }
        }
        for(int i=list.size()-1; i>=1; i--) {
            if(list.get(i).val < list.get(i-1).val) {
                second = i;
                break;
            }
        }

        // NOTE: to exchange two nodes, don't need to change the structure at all, just change the value..
        int temp = list.get(first).val;
        list.get(first).val = list.get(second).val;
        list.get(second).val = temp;
    }

    public void inOrder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
