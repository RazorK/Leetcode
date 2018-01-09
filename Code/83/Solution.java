class Solution {
    // Given a sorted linked list, delete all duplicates such that each element appear only once.
    //
    // For example,
    // Given 1->1->2, return 1->2.
    // Given 1->1->2->3->3, return 1->2->3.

    // just try in place.
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ptr = head;
        ListNode cur = head.next;
        int temp = head.val;
        while(cur!=null) {
            if(cur.val != temp) {
                temp = cur.val;
                ptr.next = cur;
                ptr = ptr.next;
            }
            cur = cur.next;
        }
        ptr.next = null;
        return head;
    }
}
