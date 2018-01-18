class Solution {
    // Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    //
    // For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    //
    //
    // Example:
    //
    // Given the sorted linked list: [-10,-3,0,5,9],
    //
    // One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
    //
    //       0
    //      / \
    //    -3   9
    //    /   /
    //  -10  5

    // basic idea O(n) space..
    public TreeNode firstTry(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list, 0, list.size()-1);
    }

    public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if(start>end) return null;
        if(start == end) return new TreeNode(nums.get(start));
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }

    // get idea from LC, faster and slower ptrs.
    // still O(n) time and O(1) space.
    // also DC
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head, ahead = null;
        while(fast!=null && fast.next!=null) {
            ahead = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow the mid.
        TreeNode root = new TreeNode(slow.val);
        // cut
        if(ahead != null) {
            ahead.next = null;
            root.left = sortedListToBST(head);
        } else {
            root.left = null;
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }


    // NOTE use global ptr to both use in recursion and scan from left to right.
    private ListNode current;

    private int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    // NOTE mimic the in order traverse of tree here.
    //  this function should generate a Tree which start at current and of size size.
    private TreeNode sortedListToBSTHelper(int size){
        if (size <= 0){
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        // NOTE after the left recursion, the current should point at the place after the left tree.
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - size / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        current = head;
        int size = getSize(head);
        return sortedListToBSTHelper(size);
    }
}
