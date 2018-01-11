class Solution {
    // Given a linked list and a value x, partition it such that all nodes less
    // than x come before nodes greater than or equal to x.
    //
    // You should preserve the original relative order of the nodes in each of the two partitions.
    //
    // For example,
    // Given 1->4->3->2->5->2 and x = 3,
    // return 1->2->2->4->3->5.

    // first idea not in place and create two ListNode and combine them later.
    public ListNode firstIdea(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode lt = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode ptr = head;
        ListNode lt_ptr = lt;
        ListNode ge_ptr = ge;
        while(ptr!=null) {
            int temp = ptr.val;
            if(temp < x) {
                lt_ptr.next = new ListNode(temp);
                lt_ptr = lt_ptr.next;
            } else {
                ge_ptr.next = new ListNode(temp);
                ge_ptr = ge_ptr.next;
            }
            ptr = ptr.next;
        }
        if(ge.next != null) {
            lt_ptr.next = ge.next;
        }
        return lt.next;
    }

    // try not create O(n) new ListNode
    // time limit exceed??
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode lt = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode ptr = head;
        ListNode lt_ptr = lt;
        ListNode ge_ptr = ge;
        while(ptr!=null) {
            int temp = ptr.val;
            if(temp < x) {
                lt_ptr.next = ptr;
                lt_ptr = lt_ptr.next;
            } else {
                ge_ptr.next = ptr;
                ge_ptr = ge_ptr.next;
            }
            ptr = ptr.next;
        }
        if(ge.next != null) {
            lt_ptr.next = ge.next;
        }
        return lt.next;
    }
}
