class Solution {
    // Reverse a linked list from position m to n. Do it in-place and in one-pass.
    //
    // For example:
    // Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    //
    // return 1->4->3->2->5->NULL.
    //
    // Note:
    // Given m, n satisfy the following condition:
    // 1 ≤ m ≤ n ≤ length of list.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        int ctr = 1;
        ListNode in_head = head;
        ListNode start = null;
        while(ctr < m) {
            start = in_head;
            in_head = in_head.next;
            ctr++;
        }
        ListNode end = in_head;
        ListNode ptr = in_head;
        while(ctr<=n) {
            ListNode temp = ptr.next;
            ptr.next = in_head;
            in_head = ptr;

            ptr = temp;
            ctr++;
        }
        end.next = ptr;
        if(start == null) return in_head;
        start.next = in_head;
        return head;
    }

    // new idea from lc, just limit the number of loop
    public ListNode tryLimit(ListNode head, int m, int n) {
        if(m == n) return head;
        for(int i=1; i<m; i++) {

        }
    }
}
