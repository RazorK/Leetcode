/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Reverse a singly linked list.
    //
    // Example:
    //
    // Input: 1->2->3->4->5->NULL
    // Output: 5->4->3->2->1->NULL
    // Follow up:
    //
    // A linked list can be reversed either iteratively or recursively. Could you implement both?

    // directly try iteratively
    public ListNode iteratively(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode res = head;
        ListNode it = head.next;
        res.next = null;
        while(it != null) {
            ListNode nextIt = it.next;
            it.next = res;
            res = it;
            it = nextIt;
        }

        return res;
    }

    // recursive may to go over all the list each recursive ?
    // get from LC, same idea of iteratively, but not that easy, not recommend.
    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
