public class Solution {
    // Follow up for problem "Populating Next Right Pointers in Each Node".
    //
    // What if the given tree could be any binary tree? Would your previous solution still work?
    //
    // Note:
    //
    // You may only use constant extra space.
    // For example,
    // Given the following binary tree,
    //          1
    //        /  \
    //       2    3
    //      / \    \
    //     4   5    7
    // After calling your function, the tree should look like:
    //          1 -> NULL
    //        /  \
    //       2 -> 3 -> NULL
    //      / \    \
    //     4-> 5 -> 7 -> NULL

    // first try the O(logN) space idea
    public void connect(TreeLinkNode root) {
        connect(root, 0, new ArrayList<TreeLinkNode>());
    }

    public void connect(TreeLinkNode root, int level, List<TreeLinkNode> list) {
        if(root == null) return;
        // preorder
        if(list.size()-1<level) {
            list.add(root);
        } else {
            if(list.get(level) != null) {
                list.get(level).next = root;
            }
            list.set(level, root);
        }
        connect(root.left, level+1, list);
        connect(root.right, level +1, list);
    }

    // constant space
    // get idea from LC
    // also make use of the next
    public void fromLC(TreeLinkNode root) {
        TreeLinkNode dummyHead=new TreeLinkNode(0);
        TreeLinkNode travel = dummyHead;
        while(root!=null){
            if(root.left!=null){
                travel.next=root.left;
                travel=travel.next;
            }
            if(root.right!=null){
                travel.next=root.right;
                travel=travel.next;
            }
            root=root.next;
            if(root==null){
                travel=dummyHead;
                root=dummyHead.next;
                dummyHead.next=null;
            }
        }
    }

}
