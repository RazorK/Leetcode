public class GetFromLC {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {

        inOrderTraversal(root);

        if (firstElement != null && secondElement != null) {
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }
    }

    private void inOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);

        if (firstElement == null && (prev == null || prev.val >= root.val)) {
            firstElement = prev;
        }

        if (firstElement != null && prev.val >= root.val) {
            secondElement = root;
        }

        prev = root;

        inOrderTraversal(root.right);
    }
}
